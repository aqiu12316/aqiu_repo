package servlet;

import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AcService;
import service.CollService;
import util.BaseServlet;
import vo.Ac;
import vo.Coll;
@WebServlet("/doAcMan")
public class doAcMan  extends BaseServlet{
	
	private static final long serialVersionUID = 1L;
	private static final AcService bs =new AcService();
	
	
public void AddAcInfo(HttpServletRequest request,HttpServletResponse response)throws Exception{
        
        String acName = new String(request.getParameter("ac_name").getBytes("ISO-8859-1"), "UTF-8");
        String acDesc = new String(request.getParameter("ac_desc").getBytes("ISO-8859-1"), "UTF-8");
        String acCon = new String(request.getParameter("ac_con").getBytes("ISO-8859-1"), "UTF-8");
        String acPubMan = new String(request.getParameter("ac_pub_man").getBytes("ISO-8859-1"), "UTF-8");
        String acTime = new String(request.getParameter("ac_time").getBytes("ISO-8859-1"), "UTF-8");
       
        
       
        
      Ac ac = new  Ac();
        ac.setAcName(acName);
        ac.setAcDesc(acDesc);
        ac.setAcCon(acCon);
        ac.setAcPubMan(acPubMan);
        ac.setAcTime(acTime);
  
        if(bs.AddAcInfo(ac)){
     	   GetAllAcInfo(request, response);
     	   
        }else{
     	   
     	   request.getRequestDispatcher("error.jsp").forward(request, response);
        }
        
         



}
public void GetAllAcInfo(HttpServletRequest request,HttpServletResponse response) throws Exception{
	 
    ArrayList<Ac> acList  = bs.GetAllAcInfo();

       request.setAttribute("acList", acList);
		
		request.getRequestDispatcher("AlreadyPubActivity.jsp").forward(request, response); 


}

	
public void DeleteAcInfo(HttpServletRequest request,HttpServletResponse response)throws Exception{
    String acId= request.getParameter("id");
     
    if(bs.DeleteAcInfo(acId)){
    	
  	  request.getRequestDispatcher("AlreadyPubActivity.jsp").forward(request, response); 
  	  
    }else{
  	   
  	   request.getRequestDispatcher("error.jsp").forward(request, response);
     }
     

}

}
