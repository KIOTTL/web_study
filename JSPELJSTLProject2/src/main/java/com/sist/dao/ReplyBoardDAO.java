package com.sist.dao;

import java.util.*;	// List
import java.sql.*;	// Connection, Statement, ResultSet
import javax.sql.*;	// DataSource
import javax.naming.*;	// Context

public class ReplyBoardDAO {
	private Connection conn;
	private PreparedStatement ps;
	
	// 객체 주소 가져오기 (Connection => 톰캣에 의해 미리 10개 생성되어 있음 => POOL(java://comp/env)에 저장되어 있음)
	// 객체명 => jdbc/oracle
	public void getConnection() {
		try {
			Context init = new InitialContext();	// JNDI
			Context c = (Context)init.lookup("java://comp/env");
			DataSource ds = (DataSource)c.lookup("jdbc/oracle");
			conn=ds.getConnection();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	// 반환 => 다음 사용자가 재사용
	public void disConnection() {
		try {
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		} catch(Exception ex) {}
	}
	
	// <%= %> => &lt;%값 %&gt; ==> ${}
	public List<ReplyBoardVO> boardListData(int page) {
		List<ReplyBoardVO> list = new ArrayList<ReplyBoardVO>();
		try {
			getConnection();
			// TO_CHAR(regdate, 'YYYY-MM-DD') => DATE_FORMAT(regdate, '%Y-%m-%d')
			String sql = "SELECT no, subject, name, TO_CHAR(regdate, 'YYYY-MM-DD'), hit, group_tab, num "
					+"FROM (SELECT no, subject, name, regdate, hit, group_tab, rownum as num "
					+"FROM (SELECT no, subject, name, regdate, hit, group_tab "
					+"FROM replyBoard ORDER BY group_id DESC, group_step ASC)) "
					+"WHERE num BETWEEN ? AND ?";
			ps=conn.prepareStatement(sql);
			int rowSize=10;
			int start=(rowSize*page)-(rowSize-1);
			int end=rowSize*page;
			
			ps.setInt(1, start);
			ps.setInt(2, end);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				ReplyBoardVO vo = new ReplyBoardVO();
				vo.setNo(rs.getInt(1));
				vo.setSubject(rs.getString(2));
				vo.setName(rs.getString(3));
				vo.setDbday(rs.getString(4));
				vo.setHit(rs.getInt(5));
				vo.setGroup_tab(rs.getInt(6));
				
				list.add(vo);
			}
			rs.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			disConnection();
		}
		
		return list;
	}
	
	public int boardRowCount() {
		int count=0;
		try {
			getConnection();
			String sql = "SELECT COUNT(*) FROM replyBoard";
			ps=conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			count=rs.getInt(1);
			rs.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			disConnection();
		}
		
		return count;
	}
	
	// JDBC => autoCommit => 오류 (rollback)
	public void boardInsert(ReplyBoardVO vo) {
		try {
			getConnection();
			String sql = "INSERT INTO replyBoard(no,name,subject,content,pwd,group_id)"
					+"VALUES((SELECT NVL(MAX(no)+1,1) FROM replyBoard),?,?,?,?, "
					+"(SELECT NVL(MAX(group_id)+1,1) FROM replyBoard))";
			ps=conn.prepareStatement(sql);
			ps.setString(1, vo.getName());
			ps.setString(2, vo.getSubject());
			ps.setString(3, vo.getContent());
			ps.setString(4, vo.getPwd());
			
			// SQL문장 실행 요청
			ps.executeUpdate();
			
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			disConnection();
		}
	}
	
	// 답변하기
	public void replyInsert(int pno, ReplyBoardVO vo) {
		try {
			getConnection();
			conn.setAutoCommit(false);	// 이거 보면 트랜잭션 생각
			
			// 상위 글의 정보 (gi, gt, gs) => SELECT
			String sql="SELECT group_id, group_step, group_tab "
					+"FROM replyBoard "
					+"WHERE no=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, pno);
			ResultSet rs=ps.executeQuery();
			rs.next();
			int gi=rs.getInt(1);
			int gs=rs.getInt(2);
			int gt=rs.getInt(3);
			rs.close();
			
			// gs의 순서 변경 => UPDATE ==> 답변 핵심 쿼리
			/*
			 *				gi   gs   gt
			 *	AAA			1     0    0
			 *	 =>BBB		1	  1	   1
			 *      =>CCC 	1	  2    2
			 *        =>DD  1     3    3
			 *   =>KKK      1     1    1
			 *   
			 *   AAA		1	  0	   0
			 *    =>KKK     1     1    1
			 *    =>BBB     1     2    1
			 *      =>CCC   1     3    2
			 *        =>DD  1     4    3
			 *   
			 *   ---> 정렬하면 KKK가 위로 올라가게 됨 => B,C,D의 gs를 1씩 올리고 KKK를 제일 위로 올림(A와 gi가 같고 gs가 더 큰 것들)
			 */
			sql="UPDATE replyBoard SET "
					+"group_step=group_step+1 "
					+"WHERE group_id=? AND group_step>?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, gi);
			ps.setInt(2, gs);
			ps.executeUpdate();
			
			// 실제 저장 => INSERT
			sql="INSERT INTO replyBoard(no,name,subject,content,pwd,group_id,group_step,group_tab,root) "
					+"VALUES((SELECT NVL(MAX(no)+1,1) FROM replyBoard),?,?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, vo.getName());
			ps.setString(2, vo.getSubject());
			ps.setString(3, vo.getContent());
			ps.setString(4, vo.getPwd());
			ps.setInt(5, gi);
			ps.setInt(6, gs+1);
			ps.setInt(7, gt+1);
			ps.setInt(8, pno);
			ps.executeUpdate();
			
			// depth 변경 => UPDATE
			sql="UPDATE replyBoard SET "
					+"depth=depth+1 "
					+"WHERE no=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, pno);
			ps.executeUpdate();
			
			// ====================== 일괄처리 => 트랜잭션
			conn.commit();
		} catch(Exception ex) {
			try {
				conn.rollback();	// 위에서 하나라도 잘못했을시 롤백
			} catch(Exception e) {}
			ex.printStackTrace();
		} finally {
			try {
				conn.setAutoCommit(true);
			} catch(Exception ex) {}
			disConnection();
		}
	}
	
	// 상세보기
	public ReplyBoardVO boardDetailData(int no) {
		ReplyBoardVO vo=new ReplyBoardVO();
		try {
			getConnection();
			String sql = "UPDATE replyBoard SET "
					+"hit=hit+1 "
					+"WHERE no=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, no);
			ps.executeUpdate();	// 조회수 증가
			
			sql="SELECT no, name, subject, content, regdate, hit, pwd "
					+"FROM replyBoard "
					+"WHERE no=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, no);
			ResultSet rs = ps.executeQuery();
			rs.next();
			vo.setNo(rs.getInt(1));
			vo.setName(rs.getString(2));
			vo.setSubject(rs.getString(3));
			vo.setContent(rs.getString(4));
			vo.setRegdate(rs.getDate(5));
			vo.setHit(rs.getInt(6));
			vo.setPwd(rs.getString(7));
			rs.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			disConnection();
		}
		
		return vo;
	}
	
	
	public ReplyBoardVO boardUpdateData(int no) {
		ReplyBoardVO vo=new ReplyBoardVO();
		try {
			getConnection();
			String sql="SELECT no, name, subject, content "
					+"FROM replyBoard "
					+"WHERE no=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, no);
			ResultSet rs = ps.executeQuery();
			rs.next();
			vo.setNo(rs.getInt(1));
			vo.setName(rs.getString(2));
			vo.setSubject(rs.getString(3));
			vo.setContent(rs.getString(4));
			rs.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			disConnection();
		}
		
		return vo;
	}
	
	// 수정하기
	public boolean boardUpdate(ReplyBoardVO vo) {
		boolean bCheck=false;
		try {
			getConnection();
			String sql="SELECT pwd FROM replyBoard "
					+"WHERE no=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, vo.getNo());
			ResultSet rs=ps.executeQuery();
			rs.next();
			String db_pwd=rs.getString(1);
			rs.close();
			if(db_pwd.equals(vo.getPwd())) {
				// 비밀번호 맞으면 수정
				bCheck=true;
				// 수정
				sql="UPDATE replyBoard SET "
						+"name=?, subject=?, content=? "
						+"WHERE no=?";
				ps=conn.prepareStatement(sql);
				ps.setString(1, vo.getName());
				ps.setString(2, vo.getSubject());
				ps.setString(3, vo.getContent());
				ps.setInt(4, vo.getNo());
				ps.executeUpdate();
			} else {
				bCheck=false;
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			disConnection();
		}
		
		return bCheck;
	}
	
	// 삭제하기
	public String boardDelete(int no, String pwd) {
		String result="";
		try {
			getConnection();
			conn.setAutoCommit(false);
			
			// 비밀번호
			String sql="SELECT pwd FROM replyBoard "
					+"WHERE no=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, no);
			ResultSet rs=ps.executeQuery();
			rs.next();
			String db_pwd=rs.getString(1);
			rs.close();
			if(db_pwd.equals(pwd)) {
				// 비밀번호 맞으면 삭제
				result="yes";
				// 삭제할 수 있는 게시물인지 확인 (답변 없는 게시물=>depth가 0인 게시물)
				sql="SELECT root, depth FROM replyBoard "
						+"WHERE no=?";
				ps=conn.prepareStatement(sql);
				ps.setInt(1, no);
				rs=ps.executeQuery();
				rs.next();
				int root=rs.getInt(1);
				int depth=rs.getInt(2);
				rs.close();
				
				if(depth>0) {	// 답변이 존재하는 상태
					sql="UPDATE replyBoard SET "
							+"subject='관지라가 삭제한 게시물입니다', "
							+"content='관리자가 삭제한 게시물입니다' "
							+"WHERE no=?";
					ps=conn.prepareStatement(sql);
					ps.setInt(1, no);
					ps.executeUpdate();
				} else {	// 답변이 없는 상태
					sql="DELETE FROM replyBoard "
							+"WHERE no=?";
					ps=conn.prepareStatement(sql);
					ps.setInt(1, no);
					ps.executeUpdate();
				}
				
				sql="UPDATE replyBoard SET "
						+"depth=depth-1 "
						+"WHERE no=?";
				ps=conn.prepareStatement(sql);
				ps.setInt(1, root);
				ps.executeUpdate();
				
			} else {
				result="no";
			}
			
			conn.commit();
		} catch(Exception ex) {
			ex.printStackTrace();
			try {
				conn.rollback();
			} catch(Exception e) {}
		} finally {
			try {
				conn.setAutoCommit(true);
			} catch(Exception ex) {}
			disConnection();
		}
		
		return result;
	}
	
	
	
	
	
	
	
}
