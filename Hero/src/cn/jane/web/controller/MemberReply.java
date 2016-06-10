package cn.jane.web.controller;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.jane.domain.ApplyWork;
import cn.jane.domain.Evalution;
import cn.jane.domain.User;
import cn.jane.service.ApplyService;
import cn.jane.service.EvalutionService;
import cn.jane.service.impl.ApplyServiceImp;
import cn.jane.service.impl.EvalutionServiceImpl;
import cn.jane.util.WebFormBeanUtils;
import cn.jane.web.formbean.EvalutionFormBean;

@SuppressWarnings("serial")
public class MemberReply extends HttpServlet {

	private EvalutionService a = new EvalutionServiceImpl();
	private String encoding = "UTF-8";
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding(encoding);
		response.setContentType("text/html;charset = UTF-8");
		memberReply(request,response);
	}

	
	private void memberReply(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String result = "";
		EvalutionFormBean formBean = null;
		//EvalutionService ev = new EvalutionServiceImpl();
		ApplyService ap = new ApplyServiceImp();
		try{
			formBean = WebFormBeanUtils.fillFormBean(request, EvalutionFormBean.class);
			User user = (User)request.getSession().getAttribute("user");
			String eecontent = formBean.getEcontent();
			request.getSession().setAttribute("eecontent", eecontent);
			String username = user.getUsername();
			String enickname = user.getNickname();
			int type = user.getType();
			ApplyWork aa = ap.findLastAcontent(type, false);
			//List<Evalution> e = ev.findAllEvalution(aa.getAid());
			boolean duty = user.isDuty();
			Evalution evalution = new Evalution();
			formBean.setEid(UUID.randomUUID().toString());
			formBean.setAid(aa.getAid());
			formBean.setUsername(username);
			formBean.setEnickname(enickname);
			formBean.setType(type);
			formBean.setDuty(duty);
			BeanUtils.copyProperties(evalution, formBean);
		//	System.out.println(evalution);
			a.addEvalution(evalution);
			request.getSession().setAttribute("evalution", evalution);
			response.setHeader("Refresh", "1;URL="+request.getContextPath()+"/member.jsp");
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
