package cn.jane.web.controller;

import java.io.IOException;
import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import cn.jane.domain.ApplyWork;
import cn.jane.domain.User;
import cn.jane.service.ApplyService;
import cn.jane.service.impl.ApplyServiceImp;
import cn.jane.util.WebFormBeanUtils;
import cn.jane.web.formbean.ApplyFormBean;
@SuppressWarnings("serial")
public class LeaderApply extends HttpServlet {
	private ApplyService a = new ApplyServiceImp();
	private String encoding = "UTF-8";
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding(encoding);
		response.setContentType("text/html;charset = UTF-8");
		apply(request,response);
	}
	private void apply(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String result = "";
		ApplyFormBean formBean = null;
		try{
		formBean = WebFormBeanUtils.fillFormBean(request, ApplyFormBean.class);
		if(!formBean.validate()){
			request.setAttribute("formBean", formBean);
			result = "/leader.jsp";
		}else{
			User user = (User) request.getSession().getAttribute("user");
			String aacontent = formBean.getAcontent();
			request.getSession().setAttribute("aacontent", aacontent);
			String username = user.getUsername();
			int type = user.getType();
			boolean duty = user.isDuty();
			ApplyWork applywork = new ApplyWork();
			//Timestamp now = new Timestamp(System.currentTimeMilions);
			//Timestamp now = new Timestamp(System.currentTimeMillis());
			//Date currDate = Calendar.getInstance().getTime();
			java.util.Date date = new java.util.Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String adate = sdf.format(date);
			
			
		//	ConvertUtils.register(new DateLocaleConverter(), Date.class);
			
			
			formBean.setAdate(adate);
			formBean.setAid(UUID.randomUUID().toString());
			formBean.setUsername(username);
			formBean.setType(type);
			formBean.setDuty(duty);
			BeanUtils.copyProperties(applywork, formBean);
			a.addApply(applywork);
			//request.setAttribute("message", "保存成功！<a href = '"+request.getContextPath()+"/leaderApplyTopic.jsp'>继续提问</a>&nbsp;&nbsp;&nbsp;<a href = '"+request.getContextPath()+"/servlet/JavaLeader'>返回主页</a>");
			response.setHeader("Refresh", "1;URL="+request.getContextPath()+"/leader.jsp");
			request.setAttribute("message","保存成功");
			result = "/message.jsp";
			//request.getRequestDispatcher(result).forward(request, response);
			/*
			ApplyWork applywork = new ApplyWork();
			formBean.setType(-1);
			formBean.setDuty(false);
			BeanUtils.copyProperties(applywork, formBean);
			a.addApply(applywork);
			request.setAttribute("message", "保存成功！<a href = '"+request.getContextPath()+"/leaderApplyTopic.jsp'>继续提问</a>&nbsp;&nbsp;&nbsp;<a href = '"+request.getContextPath()+"/servlet/JavaLeader'>返回主页</a>");
			result = "/message.jsp";*/
			}
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
