package com.sist.data;

import java.util.List;

public class ReserveMain {
	public static void main(String[] args) {
//		String s=getRand();
//		System.out.println(s);
		
		ReserveDAO dao=new ReserveDAO();
//		for (int i=1; i<=31; i++) {
//			String s=getRand();
//			dao.reserveDay(i, s);
//		}
		
		/*
		 * 	1	1,2,8,10,12
			2	2,3,4,5,7,8,10,13
			3	2,3,4,5,10,12,14
			4	2,3,8,10,12,14
			5	1,2,4,5,8,10,12
			6	1,6,8,9,12,13
			7	2,3,4,6,9,11
			8	4,7,10,11,13
			9	1,2,3,11,12,13
			10	1,2,3,6,10,11
			11	5,9,10,11,12,13,14
			12	2,3,6,7,9,10,11,14
			13	1,3,5,6,7,11
			14	2,3,4,6,7,10,11
			15	1,2,6,12,14
			16	2,3,4,7,11,14
			17	1,2,3,4,6,7,8,11
			18	2,6,7,8,10,14
			19	3,4,5,7,8
			20	2,3,6,8,10,11,12,14
			21	1,4,6,7,9,11,13,14
			22	1,2,6,7,8,9,10,12
			23	1,2,5,6,10,11,12
			24	2,6,8,10,11,12,13
			25	1,6,7,8,9,10,13
			26	1,5,6,8,12,13,14
			27	2,4,5,10,11,12,13
			28	1,3,5,7,13,14
			29	2,3,4,6,8,9,10,11
			30	1,3,4,5,11,13,14
			31	1,2,4,6,9,11,13,14
		 */
		
		List<Integer> list=dao.foodGetFno();
		for (int fno:list) {
			String s=getRand();
			dao.reserveDays(fno, s);
		}
		System.out.println("저장 완료");
	}
	
	public static String getRand() {
		String result="";
//		int[] rand=new int[(int)(Math.random()*4)+5];	// 5개 이상
		int[] rand=new int[(int)(Math.random()*6)+10];	
		int su=0;
		boolean bCheck=false;
		for (int i=0; i<rand.length; i++) {
			bCheck=true;
			while(bCheck) {		// 중복없는 난수
//				su=(int)(Math.random()*14)+1;	// 0~13
				su=(int)(Math.random()*31)+1;	
				bCheck=false;
				for (int j=0; j<i; j++) {
					if (rand[j]==su) {	// 중복일 경우
						bCheck=true;
						break;
					}
				}
			}
			rand[i] = su;
//			result+=su+",";
		}
		
		// 정렬
		for (int i=0; i<rand.length-1; i++) {
			for (int j=i+1; j<rand.length; j++) {
				if (rand[i]>rand[j]) {
					int temp=rand[i];
					rand[i]=rand[j];
					rand[j]=temp;
				}
			}
		}
		
		for (int i=0; i<rand.length; i++) {
			result+=rand[i]+",";
		}

		result=result.substring(0,result.lastIndexOf(","));
		
		return result;
	}
}
