package com.sist.controller;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/*
 * 	어노테이션 : 구분자, 인덱스 --> if문
 * 	@Rentention => 메모리 유지 기간
 * 				   CLASS
 * 				   SOURCE
 * 				   -------- 컴파일 후 바로 메모리 해제
 *            	   RUNTIME
 *            	   -------- 프로그램 종료시까지 메모리 유지
 * 	@Target => 구분자
 * 			    TYPE : 클래스 구분자
 * 			    METHOD : 메서드 구분자
 * 				PARAMETER : 매개변수 구분자
 * 				CONSTRUCTOR : 생성자 구분자
 * 				FIELD : 멤버변수 구분자
 * 
 * 			@ ==> 클래스
 * 			public class ClassName {
 * 				@ ==> 멤버변수
 * 				private A a;
 * 		
 * 				@ ==> 메서드
 * 				public void display(){}
 * 
 * 				public void aaa(@ ==> 매개변수 ){}
 * 
 * 				@ ==> 생성자
 * 				public ClassName()
 * 			}
 * 
 * 			어노테이션은 항상 위 또는 왼쪽
 */	

@Retention(RUNTIME)
@Target(TYPE)
public @interface Controller {

}
