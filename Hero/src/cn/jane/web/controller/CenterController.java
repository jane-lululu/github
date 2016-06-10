package cn.jane.web.controller;

import java.io.IOException;
//import java.io.PrintWriter;
//import java.lang.reflect.InvocationTargetException;
//import java.util.Date;


import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
//import org.apache.commons.beanutils.ConvertUtils;













import cn.jane.domain.All;
import cn.jane.domain.ApplyWork;
import cn.jane.domain.Evalution;
import cn.jane.domain.Person;
import cn.jane.domain.User;
import cn.jane.exception.UsernameExistException;
import cn.jane.service.ApplyService;
import cn.jane.service.EvalutionService;
import cn.jane.service.UserService;
import cn.jane.service.impl.ApplyServiceImp;
import cn.jane.service.impl.EvalutionServiceImpl;
import cn.jane.service.impl.UserServiceImpl;
import cn.jane.util.WebFormBeanUtils;
import cn.jane.web.formbean.LoginFormBean;
import cn.jane.web.formbean.RegistFormBean;

@SuppressWarnings("serial")
public class CenterController extends HttpServlet {
	private EvalutionService e = new EvalutionServiceImpl();
	private ApplyService a = new ApplyServiceImp();
	private UserService s = new UserServiceImpl();
	private String encoding = "UTF-8";
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding(encoding);
		String operation = (String) request.getParameter("operation");
		response.setContentType("text/html;charset=UTF-8");
		if("register".equals(operation)){
			register(request,response);
		}else if("login".equals(operation)){
			login(request,response);
		}
	}

	
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String result = "";
		LoginFormBean formBean = null;
		formBean = WebFormBeanUtils.fillFormBean(request, LoginFormBean.class);
			if(!formBean.validate()){
				request.setAttribute("formBean", formBean);
				result = "/login.jsp";
			}else {
				User user = new User();
				String type = request.getParameter("typeSelect");
				if(type.equals("java")){
					formBean.setType(-1);
				}else if(type.equals("php")){
					formBean.setType(0);
				}else if(type.equals("Web")){
					formBean.setType(1);
				}
				String duty = request.getParameter("duty");
				if(duty.equals("组长")){
					formBean.setDuty(false);//0代表组长；
				}else if(duty.equals("组员")){
					formBean.setDuty(true);
				}
				user = s.login(formBean.getUsername(), formBean.getPassword(),formBean.getType(),formBean.isDuty());
				if(user == null){
					request.setAttribute("formBean", "formBean");
					request.setAttribute("message", "错误的用户名或密码或者身份选择有错，请认真核对后输入<meta http-equiv='Refresh' content='1';URL="+request.getContextPath()+"/servlet/LoginServlet>");
					result = "/message.jsp";
				}
				else {
					//登陆成功
					request.getSession().setAttribute("user", user);
					if(a.findLastAcontent(user.getType(), false)!=null){
						ApplyWork applywork = a.findLastAcontent(user.getType(),false);
						String acontent = applywork.getAcontent()+"";
						request.getSession().setAttribute("acontent", acontent);//注意：这里日过刚开始组长没有发布内容会有一个空指针异常；
						if(e.findAllEvalution(applywork.getAid())!=null){
							List<Evalution> evalution = e.findAllEvalution(applywork.getAid());
							Iterator<Evalution> it = evalution.iterator();
							Map<Evalution,String> map = new HashMap<Evalution,String>();
							while(it.hasNext()){
								Evalution ev = it.next();
								String s = e.findDevalution(ev.getEid());
								map.put(ev, s);
							}
							request.getSession().setAttribute("map", map);
					/*	if(e.find(applywork.getAid())!=null){
							List<All> list = e.find(applywork.getAid());
							request.getSession().setAttribute("list", list);
						}*/
						}
						
					}
					
					if(user.isDuty()){
						List<Person> personall = e.findOnePerson(user.getUsername(), user.getType());
						request.getSession().setAttribute("person", personall);
						response.setHeader("Refresh", "1;URL="+request.getContextPath()+"/member.jsp");
						request.setAttribute("message","登录成功");
					}else if(!user.isDuty()){
						List<String> nameAll = s.findAllNickName(user.getType(), true);
						request.getSession().setAttribute("nameAll", nameAll);
						List<Person> personAll = e.findAllPerson(user.getType(), true);
						request.getSession().setAttribute("personAll", personAll);
						response.setHeader("Refresh", "1;URL="+request.getContextPath()+"/leader.jsp");
						request.setAttribute("message","登录成功");
					}
					result = "/message.jsp";
				}
			}
		request.getRequestDispatcher(result).forward(request, response);
	
	}
	private void register(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String result = "";
		RegistFormBean formBean = null;
		try{//结果页面的URL地址；
		//获取用户输入的数据；
		formBean = WebFormBeanUtils.fillFormBean(request, RegistFormBean.class);
		//封装；验证：UserFormBean(与表单的输入域完全对应，完全验证功能)
		if(!formBean.validate()){
			//验证不通过：数据回显；还要提示具体的错误信息
			request.setAttribute("formBean", formBean);
			result = "/register.jsp";
		}else{
			//吧FormBean中的数据转移要User中，填充模型
			User user = new User();
			String type = request.getParameter("typeSelect");
			if(type.equals("java")){
				formBean.setType(-1);
			}else if(type.equals("php")){
				formBean.setType(0);
			}else if(type.equals("Web")){
				formBean.setType(1);
			}
			String duty = request.getParameter("duty");
			if(duty.equals("组长")){
				formBean.setDuty(false);//0代表组长；
			}else if(duty.equals("组员")){
				formBean.setDuty(true);
			}
			BeanUtils.copyProperties(user, formBean);
			//遍历formBean中的所有属性；找User中的所有的同名属性，user.setUsername(formBean.getUsername())
			s.regist(user);
			request.setAttribute("message","保存成功<a href='"+request.getContextPath()+"'>主页</a>");
			result = "/message.jsp";
		}
		}catch(UsernameExistException e1){
			formBean.getErrors().put("username", "该用户名已经被其他用户注册，请重新输入");
			request.setAttribute("formBean", formBean);
			result = "/register.jsp";
		}catch(Exception e){
			request.setAttribute("message", "对不起，服务器繁忙，请稍后再试！");
			result = "/message.jsp";
		}
		request.getRequestDispatcher(result).forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
