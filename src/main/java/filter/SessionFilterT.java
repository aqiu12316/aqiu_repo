package filter;/*package filter;

import javax.servlet.annotation.WebFilter;


import java.io.IOException;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 @WebFilter("/")            过滤器设置代码格式utf-8,并显示当前执行的jsp
public class SessionFilterT implements Filter {




	private String loginStrs ="/Library/BackLogin.jsp,/Library/SessionNull.jsp,/Library/doLoginBack";
	public void destroy() {
		System.out.println("doLoginFilter销毁");
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hRequest = (HttpServletRequest) request;
		HttpServletResponse hResponse = (HttpServletResponse)response;
		String path = hRequest.getRequestURI();
		
		HttpSession session = hRequest.getSession();
		String manName=(String) session.getAttribute("manName");
		
		
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf8");
		response.setContentType("text/html;charset=UTF-8");
		System.out.println(path);
		if(manName!=null||isLogin(path)){
			System.out.println("doLoginFilter执行前");
			chain.doFilter(request, response);
			System.out.println("doLoginFilter执行后");	
		}else{
			hResponse.sendRedirect("SessionNull.jsp");
		}
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("doLoginFilter初始化");
	}
	public boolean isLogin(String path){
		String[] loginPaths = loginStrs.split(",");
		for(String loginPath : loginPaths){
			if(loginPath.equals(path)){
				return true;

			}
		}
		return false;
		
	}

	

}*/