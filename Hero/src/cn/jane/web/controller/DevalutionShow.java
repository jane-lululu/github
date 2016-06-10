package cn.jane.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.jane.service.EvalutionService;
import cn.jane.service.impl.EvalutionServiceImpl;

@SuppressWarnings("serial")
public class DevalutionShow extends HttpServlet {
	private EvalutionService a = new EvalutionServiceImpl();
	private String encoding = "UTF-8";
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding(encoding);
		response.setContentType("text/html;charset = UTF-8");
		String eid =  (String) request.getSession().getAttribute("eeid");
		System.out.println(eid);
		String dcontent = a.findDevalution(eid);
		System.out.println(dcontent);
		request.setAttribute("ddcontent", dcontent);
		request.getRequestDispatcher("/leader.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	
	}

}
