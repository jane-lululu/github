package cn.jane.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.jane.domain.Person;

public class PersonalHistory extends HttpServlet {
	//private String encoding = "UTF-8";
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*request.setCharacterEncoding(encoding);
		response.setContentType("text/html;charset=UTF-8");
		@SuppressWarnings("unchecked")
		List<Person> persona=(List<Person>) request.getSession().getAttribute("personall");*/
		request.getRequestDispatcher("/history.jsp").forward(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
