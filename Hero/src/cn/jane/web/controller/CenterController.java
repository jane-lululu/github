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
				if(duty.equals("�鳤")){
					formBean.setDuty(false);//0�����鳤��
				}else if(duty.equals("��Ա")){
					formBean.setDuty(true);
				}
				user = s.login(formBean.getUsername(), formBean.getPassword(),formBean.getType(),formBean.isDuty());
				if(user == null){
					request.setAttribute("formBean", "formBean");
					request.setAttribute("message", "������û���������������ѡ���д�������˶Ժ�����<meta http-equiv='Refresh' content='1';URL="+request.getContextPath()+"/servlet/LoginServlet>");
					result = "/message.jsp";
				}
				else {
					//��½�ɹ�
					request.getSession().setAttribute("user", user);
					if(a.findLastAcontent(user.getType(), false)!=null){
						ApplyWork applywork = a.findLastAcontent(user.getType(),false);
						String acontent = applywork.getAcontent()+"";
						request.getSession().setAttribute("acontent", acontent);//ע�⣺�����չ��տ�ʼ�鳤û�з������ݻ���һ����ָ���쳣��
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
						request.setAttribute("message","��¼�ɹ�");
					}else if(!user.isDuty()){
						List<String> nameAll = s.findAllNickName(user.getType(), true);
						request.getSession().setAttribute("nameAll", nameAll);
						List<Person> personAll = e.findAllPerson(user.getType(), true);
						request.getSession().setAttribute("personAll", personAll);
						response.setHeader("Refresh", "1;URL="+request.getContextPath()+"/leader.jsp");
						request.setAttribute("message","��¼�ɹ�");
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
		try{//���ҳ���URL��ַ��
		//��ȡ�û���������ݣ�
		formBean = WebFormBeanUtils.fillFormBean(request, RegistFormBean.class);
		//��װ����֤��UserFormBean(�������������ȫ��Ӧ����ȫ��֤����)
		if(!formBean.validate()){
			//��֤��ͨ�������ݻ��ԣ���Ҫ��ʾ����Ĵ�����Ϣ
			request.setAttribute("formBean", formBean);
			result = "/register.jsp";
		}else{
			//��FormBean�е�����ת��ҪUser�У����ģ��
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
			if(duty.equals("�鳤")){
				formBean.setDuty(false);//0�����鳤��
			}else if(duty.equals("��Ա")){
				formBean.setDuty(true);
			}
			BeanUtils.copyProperties(user, formBean);
			//����formBean�е��������ԣ���User�е����е�ͬ�����ԣ�user.setUsername(formBean.getUsername())
			s.regist(user);
			request.setAttribute("message","����ɹ�<a href='"+request.getContextPath()+"'>��ҳ</a>");
			result = "/message.jsp";
		}
		}catch(UsernameExistException e1){
			formBean.getErrors().put("username", "���û����Ѿ��������û�ע�ᣬ����������");
			request.setAttribute("formBean", formBean);
			result = "/register.jsp";
		}catch(Exception e){
			request.setAttribute("message", "�Բ��𣬷�������æ�����Ժ����ԣ�");
			result = "/message.jsp";
		}
		request.getRequestDispatcher(result).forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
