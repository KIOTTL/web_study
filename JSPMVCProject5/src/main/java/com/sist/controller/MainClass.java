package com.sist.controller;

import java.lang.reflect.Method;
import java.util.*;

class Model {
	@RequestMapping("list.do")
	public void aaa() {
		System.out.println("게시물 목록");
	}
	@RequestMapping("find.do")
	public void bbb() {
		System.out.println("게시물 찾기");
	}
	@RequestMapping("insert.do")
	public void ccc() {
		System.out.println("게시물 추가");
	}
}


public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.print("URL : ");
		String url=scan.next();	// list.do
		
		try {
			// new Model()
			Class clsName=Class.forName("com.sist.controller.Model");	// 클래스 정보 읽기
			Object obj=clsName.getDeclaredConstructor().newInstance();
			
			// 선언된 메서드
			Method[] methods=clsName.getDeclaredMethods();
			for (Method m:methods) {
				System.out.println(m.getName());
				RequestMapping rm=m.getAnnotation(RequestMapping.class);
				if(url.equals(rm.value())) {
					m.invoke(obj, null);
				}
			}
			
		} catch(Exception ex) {}
	}

}
