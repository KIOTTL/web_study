package com.sist.controller;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*; 
import com.sist.model.*;

@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	List<String> clsList=new ArrayList<String>();
	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		clsList.add("com.sist.model.FoodModel");
	}

	/*
	 * 	http://localhost:8080/JSPMVCProject5/food/category.do
	 * 	----------------------------------------------------- URL
	 * 						  JSPMVCProject5/food/category.do
	 * 						  ------------------------------- URI
	 * 						  JSPMVCProject5
	 * 						  -------------- ContextPath
	 */
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			// 사용자가 요청한 URL 읽어오기 => .do
			String uri=request.getRequestURI();	// /JSPMVCProject5/food/category.do
			System.out.println("uri_1 : "+uri);
			uri=uri.substring(request.getContextPath().length()+1);	// food/category.do
			System.out.println("uri_2 : "+uri);
			
			for (String cls:clsList) {
				Class clsName=Class.forName(cls);
				if (clsName.isAnnotationPresent(Controller.class)==false)
					continue;	// @Controller 없으면 제외
				Object obj=clsName.getDeclaredConstructor().newInstance();
				
				// 메서드 찾기
				Method[] methods=clsName.getDeclaredMethods();
				for (Method m:methods) {
					RequestMapping rm=m.getAnnotation(RequestMapping.class);
					if (uri.equals(rm.value())) {
						String jsp=(String)m.invoke(obj, request);
						RequestDispatcher rd=request.getRequestDispatcher(jsp);
						rd.forward(request, response);
						
						return;
					}
				}
			}
		} catch(Exception ex) {}
	}

}
