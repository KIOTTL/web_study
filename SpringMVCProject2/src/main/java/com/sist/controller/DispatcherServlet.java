package com.sist.controller;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/*
 * 	자바 / HTML(태그형 프로그램(JSTL) 사용)
 * 
 * 	MVC
 * 	Model : 데이터 관리, 요청 처리 후 request,session에 전송값 담아 줌
 * 			~Model(조립기), ~DAO(데이터베이스 연결), ~VO(데이터 모음)		==> 자바 (재사용, 확장)
 * 	View : 기능 없음 (Front:JavaScript) => 데이터를 받아서 화면 출력 => JSTL/EL => jsp
 * 	Controller : Model, View 연결하는 역할
 * 				 요청 받기, 결과 보내기, 화면 이동
 * 
 * 	사용자 요청(.do) ==> Controller ==> 처리할 Model 찾기 <==> DAO 연결
 * 											|  ===>  request, session에 값 담기(request.setAttribute(), session.setAttribute())
 * 									    Controller
 * 											|
 * 										 JSP 찾기
 * 											|
 * 								JSP로 request,session 전송
 * 											|
 * 										 화면 출력
 * 
 * 	===> 파일 공개 (JSP) / 비공개 (화면 출력 아니고 기능) => 서블릿
 * 		 Controller : 프레임워크 (Spring, Struts)
 * 		 ==> 포털 (다음, 네이버)
 * 		 ==> 프레임워크 vs 라이브러리
 * 			   (레고)     (완제품)
 * 
 * 	MVC : Controller를 URL 주소로 찾기
 */

@WebServlet("*.do")	// test, 회사명, ...
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<String> packList=new ArrayList<String>();	// XML => 패키지 저장
	private List<String> clsList=new ArrayList<String>();	// 클래스 모으기
	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		try {
			// 현재 프로젝트의 경로
			URL url=this.getClass().getClassLoader().getResource(".");
			File file=new File(url.toURI());
			System.out.println(file.getPath());	// C:\webDev\webStudy\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\SpringMVCProject\WEB-INF\classes
			String path=file.getPath();
			path=path.replace("\\", File.separator);
			path=path.substring(0,path.lastIndexOf(File.separator));
			System.out.println(path);	// C:\webDev\webStudy\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\SpringMVCProject\WEB-INF
			
			// XML 파싱
			/*
			 * 	JAXP : DOM / SAX(MyBatis, Spring)
			 * 		   DOM => 메모리에 트리형태로 저장 후 처리
			 * 		   SAX => 한 줄씩 태그의 값 읽어오기(read only)
			 * 		   => XML
			 * 			  데이터 저장 위치 => <태그>데이터</태그>
			 * 							  <태그 속성="데이터">
			 * 		   => XML은 사용자 정의 태그(속성이나, 태그 추가 불가) => 태그, 속성 외우기
			 * 		      MyBatis, Spring 자체에서 제작 후 지원
			 * 	JAXB : 빅데이터(클래스 변수 -- 태그명) ==> 1.8까지 지원
			 */
			DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
			DocumentBuilder db=dbf.newDocumentBuilder();
			Document doc=db.parse(new File(path+File.separator+"application.xml"));
			Element root=doc.getDocumentElement();
			System.out.println(root.getTagName());	// beans
			
			NodeList list=root.getElementsByTagName("component-scan");
			for (int i=0; i<list.getLength(); i++) {
				Element cs=(Element)list.item(i);
				String value=cs.getAttribute("base-package");
				packList.add(value);
			}
			
			// 출력
			for (String s:packList) {
				System.out.println(s);	// com.sist.model
				path=path.substring(0,path.lastIndexOf(File.separator));
				System.out.println(path);	// C:\webDev\webStudy\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\SpringMVCProject
				String ss=path+File.separator+"WEB-INF"+File.separator+"classes"+File.separator+s.replace(".", File.separator);
				System.out.println(ss);	// InsertModel.class  ListModel.class  UpdateModel.class
				File dir=new File(ss);
				File[] files=dir.listFiles();
				for (File f:files) {
					System.out.println(f.getName());
					String sss=s+"."+f.getName().substring(0,f.getName().lastIndexOf("."));
					// com.sist.model.ListModel
					// --------------s 
					System.out.println(sss);
					clsList.add(sss);
				}
			}
			// Controller ==> Model 찾기
			
		} catch(Exception ex) {}
	}

	// Model 등록
	// Model 찾아서 요청 수행 => JSP 찾기 => request, session 전송
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			// 사용자 URL http://localhost:8080/SpringMVCProject/main/main.do (URL)
			// @RequestMapping("main/main.do")
			String uri=request.getRequestURI();	// /SpringMVCProject/main/main.do
			uri=uri.substring(request.getContextPath().length()+1);	// main/main.do
			// Model클래스 찾기
			for (String strCls:clsList) {
				Class clsName=Class.forName(strCls);	// 등록된 클래스 정보 읽기
				if (clsName.isAnnotationPresent(Controller.class)==false)
					continue;	// 클래스 위 @Controller 유무 확인 => 없으면 continue
				// 메모리 할당
				Object obj=clsName.getDeclaredConstructor().newInstance();
				
				// 요청 처리 ==> 메서드
				Method[] methods=clsName.getDeclaredMethods();	// Model클래스에 선언된 모든 메서드 읽기
				for (Method m:methods) {
					RequestMapping rm=m.getAnnotation(RequestMapping.class); // 메서드 위에 있는 어노테이션 확인
					if (uri.equals(rm.value())) {	// 처리 메서드 찾아서 수행
						String jsp=(String)m.invoke(obj, request, response);	// 메서드 호출
						// 메서드명은 마음대로 사용 가능
						/*
						 * 	Model 메서드
						 * 	@RequestMapping("uri")
						 * 	public String main_main(HttpServletReqeust request, HttpServletResponse response) {
						 * 		return "출력할 JSP";
						 * 
						 * 		request ==> 요청값 받기 => 처리 => setAttribute()
						 * 		response ==> Cookie, 파일 업로드 (응답)
						 * 	}
						 */
						
						// 이동방식 ==> sendRedirect(기존에 만들어진 파일로 이동(재호출)), forward (화면 출력)
						//				=> request 초기화							=> request 전송
						if (jsp.startsWith("redirect")) {
							// return "redirect:../main/main.do"
							response .sendRedirect(jsp.substring(jsp.indexOf(":")+1));	// ../main/main.do
						} else {
							// return "../main/main.jsp"
							RequestDispatcher rd=request.getRequestDispatcher(jsp);
							rd.forward(request, response);
						}
						return;
					}
				}
			}
			
		} catch(Exception ex) {}
	}

}



















