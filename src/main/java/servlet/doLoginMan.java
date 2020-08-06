package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import service.ManService;
import util.BaseServlet;
import vo.Man;



@WebServlet("/doLoginBack")
public class doLoginMan extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private static final ManService bs =new ManService();
   
	
	
	
	public void SearchManByName(HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		
		String manName = new String(request.getParameter("man_name").getBytes("ISO-8859-1"), "UTF-8");
		System.out.println(manName);
	    String passwd =new String(request.getParameter("man_Password").getBytes("ISO-8859-1"), "UTF-8");
		  Man man=bs.SearchManByName(manName);
		
		 // System.out.println(bs.SearchManByName(manName).getPassword());
		  if(passwd.equals(man.getPassword())){
			  
			  HttpSession session = request.getSession();
				session.setAttribute("manName",man.getmName());
				
				request.getRequestDispatcher("indexT.jsp").forward(request, response); 
			  
		  }else {
			 
			  request.getRequestDispatcher("error.jsp").forward(request, response);
			  
		}
	
		
	
		
	}
	

}
