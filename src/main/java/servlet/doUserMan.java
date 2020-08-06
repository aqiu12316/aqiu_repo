package servlet;

import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ManService;
import service.UserService;
import util.BaseServlet;
import vo.Man;
import vo.User;

@WebServlet("/doUserMan")
public class doUserMan extends BaseServlet{
	private static final long serialVersionUID = 1L;
	private static final UserService bs =new UserService();
	
public void GetAllUserInfo(HttpServletRequest request,HttpServletResponse response) throws Exception{
		 
	          ArrayList<User> userList  = bs.GetAllUserInfo();
	        
	         request.setAttribute("userList", userList);
				
				request.getRequestDispatcher("userMan.jsp").forward(request, response); 
		
		
	}
	
public void UpdateUserById(HttpServletRequest request,HttpServletResponse response)throws Exception{
	          
	           String userId = new String(request.getParameter("man_id").getBytes("ISO-8859-1"), "UTF-8");
	           String userName = new String(request.getParameter("man_name").getBytes("ISO-8859-1"), "UTF-8");
	           String gender = new String(request.getParameter("man_gender").getBytes("ISO-8859-1"), "UTF-8");
	           String phone = new String(request.getParameter("man_phone").getBytes("ISO-8859-1"), "UTF-8");
	           String email = new String(request.getParameter("man_email").getBytes("ISO-8859-1"), "UTF-8");
	           String address = new String(request.getParameter("man_address").getBytes("ISO-8859-1"), "UTF-8");
	           String passwd = new String(request.getParameter("man_passwd").getBytes("ISO-8859-1"), "UTF-8");
	           
	           
	           System.out.println(gender+"++++++++++++++++++++");
	           
	           User user = new User();
	           
	           user.setUserId(userId);
	           user.setUserName(userName);
	           user.setGender(gender);
	           user.setPhone(phone);
	           user.setEmail(email);
	           user.setAddress(address);
	           user.setPasswd(passwd);
	           if(bs.UpdateUserById(user)){
	        	   request.getRequestDispatcher("userMan.jsp").forward(request, response);
	        	   
	           }else{
	        	   
	        	   request.getRequestDispatcher("error.jsp").forward(request, response);
	           }
	           
	            
	
	
	
}

public void GetUserInfo(HttpServletRequest request,HttpServletResponse response)throws Exception{
	           String userId= request.getParameter("id");
	            User user = new User();
	            user=bs.GetUserInfo(userId);
	            
                request.setAttribute("updateUser", user);
				
				request.getRequestDispatcher("UpdateUser.jsp").forward(request, response); 
	
	
}

public void DeleteUserInfo(HttpServletRequest request,HttpServletResponse response)throws Exception{
	              String userId= request.getParameter("id");
	               
	              if(bs.DeleteUserInfo(userId)){
	            	  request.getRequestDispatcher("userMan.jsp").forward(request, response); 
	            	  
	              }else{
		        	   
		        	   request.getRequestDispatcher("error.jsp").forward(request, response);
		           }
		           
	
}
	
}
