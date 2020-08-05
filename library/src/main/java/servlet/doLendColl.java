package servlet;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CollService;
import service.LendCollService;
import util.BaseServlet;
import vo.Ac;
import vo.Coll;
import vo.lendColl;

@WebServlet("/doLendColl")
public class doLendColl extends BaseServlet{
	private static final long serialVersionUID = 1L;
	private static final LendCollService bs =new LendCollService();
	
	
	public void GetAllLendCollInfo(HttpServletRequest request,HttpServletResponse response) throws Exception{
		 
	    ArrayList<lendColl> lendCollList  = bs.GetAllLendCollInfo();
   if(lendCollList.size()==0){
	   request.getRequestDispatcher("index.jsp").forward(request, response); 
   }else{
	   request.setAttribute("lendCollList", lendCollList);
		
		request.getRequestDispatcher("index.jsp").forward(request, response); 

   }
	      

	}
	
	
	public void GetAllPassCollInfo(HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		 
	    ArrayList<lendColl> lendPassCollList  = bs.GetAllPassCollInfo();
	    
	    if(lendPassCollList.size()==0){
	    	request.getRequestDispatcher("PassExamineColl.jsp").forward(request, response); 
	    }else {
	    	 request.setAttribute("lendPassCollList", lendPassCollList);
				
				request.getRequestDispatcher("PassExamineColl.jsp").forward(request, response); 
		}

	      


	}
	
	public void GetAllNoPassCollInfo(HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		 
	    ArrayList<lendColl> lendNoPassCollList  = bs.GetAllNoPassCollInfo();
  if (lendNoPassCollList.size()==0) {
		request.getRequestDispatcher("NoPassExamineColl.jsp").forward(request, response); 
} else {
	  request.setAttribute("lendNoPassCollList", lendNoPassCollList);
		
		request.getRequestDispatcher("NoPassExamineColl.jsp").forward(request, response); 
}
	     


	}
	
	
	
	public void manPassCollUpdate(HttpServletRequest request,HttpServletResponse response) throws Exception{
				 
		 String LendCollId = new String(request.getParameter("id").getBytes("ISO-8859-1"), "UTF-8");

	        if(bs.manPassCollUpdate(LendCollId)){
	        	GetAllLendCollInfo(request, response);
	     	   
	        }else{
	     	   
	     	   request.getRequestDispatcher("error.jsp").forward(request, response);
	        }
	        

	}
	
	
	
	public void manPassCollNoUpdate(HttpServletRequest request,HttpServletResponse response) throws Exception{
		 
		 String LendCollId = new String(request.getParameter("id").getBytes("ISO-8859-1"), "UTF-8");

	        if(bs.manPassCollNoUpdate(LendCollId)){
	        	GetAllLendCollInfo(request, response);
	     	   
	        }else{
	     	   
	     	   request.getRequestDispatcher("error.jsp").forward(request, response);
	        }
	        

	}
	
	
	
	public void manPassCollDelete(HttpServletRequest request,HttpServletResponse response)throws Exception{
		String LendCollId = new String(request.getParameter("id").getBytes("ISO-8859-1"), "UTF-8");
         
        if(bs.manPassCollDelete(LendCollId)){
        	GetAllLendCollInfo(request, response);
      	  
        }else{
      	   
      	   request.getRequestDispatcher("error.jsp").forward(request, response);
         }
         

}


	
	
}
