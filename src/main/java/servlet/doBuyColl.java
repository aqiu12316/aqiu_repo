package servlet;

import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BuyCollService;
import service.LendCollService;
import util.BaseServlet;
import vo.buyColl;
import vo.lendColl;
@WebServlet("/doBuyColl")
public class doBuyColl extends BaseServlet{
	private static final long serialVersionUID = 1L;
	private static final BuyCollService bs =new BuyCollService();
	
	public void GetAllBuyCollInfo(HttpServletRequest request,HttpServletResponse response) throws Exception{
		 
	    ArrayList<buyColl> buyCollList  = bs.GetAllBuyCollInfo();

	       request.setAttribute("buyCollList", buyCollList);
			
			request.getRequestDispatcher("buyCollExamine.jsp").forward(request, response); 


	}
	public void manBuyPassCollUpdate(HttpServletRequest request,HttpServletResponse response) throws Exception{
		 
		 String BuyCollId = request.getParameter("id");

	        if(bs.manBuyPassCollUpdate(BuyCollId)){
	        	GetAllBuyCollInfo(request, response);
	     	   
	        }else{
	     	   
	     	   request.getRequestDispatcher("error.jsp").forward(request, response);
	        }
	        

	}
	
	
	
	public void manBuyPassCollNoUpdate(HttpServletRequest request,HttpServletResponse response) throws Exception{
		 
		 String BuyCollId = request.getParameter("id");

	        if(bs.manBuyPassCollNoUpdate(BuyCollId)){
	        	GetAllBuyCollInfo(request, response);
	     	   
	        }else{
	     	   
	     	   request.getRequestDispatcher("error.jsp").forward(request, response);
	        }
	        

	}
	
	public void GetAllBuyPassCollInfo(HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		 
	    ArrayList<buyColl> buyPassCollList  = bs.GetAllBuyPassCollInfo();
	    if(buyPassCollList.size()==0){
	    	request.getRequestDispatcher("BuyPassExamine.jsp").forward(request, response); 
	    	
	    }else {
	    	request.setAttribute("buyPassCollList", buyPassCollList);
			
			 request.getRequestDispatcher("BuyPassExamine.jsp").forward(request, response); 
		
		}
	    
	 
              
			
		

	       


	}
	
	public void GetAllBuyNoPassCollInfo(HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		 
	    ArrayList<buyColl> buyNoPassCollList  = bs.GetAllBuyNoPassCollInfo();
         
	    
	    if(buyNoPassCollList.size()==0){
	    	
	    	request.getRequestDispatcher("BuyNoPassExamine.jsp").forward(request, response); 
	    }else{
               request.setAttribute("buyNoPassCollList", buyNoPassCollList);
			
			request.getRequestDispatcher("BuyNoPassExamine.jsp").forward(request, response); 
	    }
	       


	}
	
	

}
