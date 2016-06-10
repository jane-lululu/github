package cn.jane.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.jane.domain.Person;

@SuppressWarnings("serial")
public class History extends HttpServlet {
	private String encoding = "UTF-8";
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding(encoding);
		response.setContentType("text/html;charset=UTF-8");
		@SuppressWarnings("unchecked")
		List<Person> personAll=(List<Person>) request.getSession().getAttribute("personAll");
		List<Person> person = new ArrayList<Person>();
	//	System.out.println("ยน๊ฯ");
		Iterator<Person> it = personAll.iterator();
		//String s = request.getParameter("name").getBytes(("ISO-8859-1"),"GBK");
		String name=new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
		/*System.out.println(name);
		while(it.hasNext()){
			System.out.println(it.next());
		}*/
		
		while(it.hasNext()){
				//System.out.println(((Person)it.next()).getEnickname());
			Person p =it.next();
				if(p.getEnickname().equals(name)){
				 person.add(p);
				}
			}
		/*Iterator<Person> it1 = person.iterator();
		while(it1.hasNext()){
			System.out.println("ยน๊ฯ");
			System.out.println(it1.next());
		}*/
		request.getSession().setAttribute("person", person);
		request.getRequestDispatcher("/history.jsp").forward(request, response);
}
	
	

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
