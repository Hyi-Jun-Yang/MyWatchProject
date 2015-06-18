package project.com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	
	private static final String[] SPATH_LIST={
		"/m_select.do","/c_select.do","/manager.do","/en_select.do",
		"/p_select.do","/p_insert.do","/e_insert.do","/e_select.do"
	};
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String sPath = request.getServletPath();
		HttpSession session = request.getSession();
		String login_id=(String)session.getAttribute("user_id");
		for (int i = 0; i < SPATH_LIST.length; i++) {
			if(sPath.compareTo(SPATH_LIST[i])==0){
				if(login_id==null||login_id.compareTo("admin")!=0){
					response.sendRedirect("index.do");
					return false;
				}
			}
		}
		return true;
	}
}
