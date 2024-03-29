package com.sist.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.model.MovieModel;

@WebServlet("*.do")
// http://localhost:8080/JSPMovieMVCProject/movie/list.do
public class Controller extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri=request.getRequestURI();	//JSPMovieMVCProject/movie/list.do
		// list.jsp => list.do
		uri=uri.substring(request.getContextPath().length()+1);	// movie/list.do
		
		String jsp="";
		MovieModel model=new MovieModel();
		if (uri.equals("movie/list.do")) {
			model.movie_list(request, response);
			
			jsp="../movie/list.jsp";
			
			RequestDispatcher rd=request.getRequestDispatcher(jsp);
			rd.forward(request, response);	// forward와 sendRedirect 같이 사용x
			
		} else if(uri.equals("movie/detail_before.do")) {
			model.movie_detail_before(request, response);
		} else if(uri.equals("movie/detail.do")) {
			model.movie_detail(request, response);
			
			jsp="../movie/detail.jsp";
			
			RequestDispatcher rd=request.getRequestDispatcher(jsp);
			rd.forward(request, response);
		}
		
	}

}
