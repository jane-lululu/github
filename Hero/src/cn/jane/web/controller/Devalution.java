package cn.jane.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.jane.domain.ApplyWork;
import cn.jane.domain.LeaderEvalution;
import cn.jane.domain.User;
import cn.jane.service.ApplyService;
import cn.jane.service.EvalutionService;
import cn.jane.service.impl.ApplyServiceImp;
import cn.jane.service.impl.EvalutionServiceImpl;
import cn.jane.util.WebFormBeanUtils;
import cn.jane.web.formbean.DevalutionFormBean;

@SuppressWarnings("serial")
public class Devalution extends HttpServlet {
	private EvalutionService a = new EvalutionServiceImpl();
	private String encoding = "UTF-8";
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding(encoding);
		response.setContentType("text/html;charset = UTF-8");
		LeadeReply(request,response);
	}

	
	private void LeadeReply(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String result = "";
		DevalutionFormBean formBean = null;
		try{
			formBean = WebFormBeanUtils.fillFormBean(request, DevalutionFormBean.class);
			
			//EvalutionService ev = new EvalutionServiceImpl();
			ApplyService ap = new ApplyServiceImp();
			//List<Evalution> e = ev.findAllEvalution(s.getAid());
			
			User user = (User)request.getSession().getAttribute("user");
			String dcontent = formBean.getDcontent();
			request.getSession().setAttribute("dcontent", dcontent);
			String username = user.getUsername();//这段有时候会出现空指针异常；
			int type = user.getType();
			ApplyWork s = ap.findLastAcontent(type, false);
			
			
			String eid = request.getParameter("eid");
			request.getSession().setAttribute("eeid", eid);
			//PrintWriter o = response.getWriter();
			System.out.println(eid);
			
			boolean duty = user.isDuty();
			LeaderEvalution devalution = new LeaderEvalution();
			formBean.setLid(UUID.randomUUID().toString());
			formBean.setAid(s.getAid());
			formBean.setEid(eid);
			formBean.setUsername(username);
			formBean.setType(type);
			formBean.setDuty(duty);
			formBean.setIsfinished(true);
			BeanUtils.copyProperties(devalution, formBean);
			a.addDevalution(devalution);
		//	response.setHeader("Refresh", "1;URL="+request.getContextPath()+"/leader.jsp");
			response.setHeader("Refresh","1;URL="+request.getContextPath()+"/servlet/DevalutionShow");
			request.setAttribute("message","保存成功");
			result = "/message.jsp";
		}catch(Exception e){
			request.setAttribute("message", "对不起，服务器繁忙，请稍后再试!");
			result = "/message.jsp";
		}
	
		request.getRequestDispatcher(result).forward(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	
	}

}
