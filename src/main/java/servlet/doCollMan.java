package servlet;

import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CollService;
import service.UserService;
import util.BaseServlet;
import vo.Coll;
import vo.User;

@WebServlet("/doCollMan")
public class doCollMan extends BaseServlet{
	private static final long serialVersionUID = 1L;
	private static final CollService bs =new CollService();
	
	
	public void AddCollInfo(HttpServletRequest request,HttpServletResponse response)throws Exception{
        String path="images/";
        String collId = new String(request.getParameter("coll_id").getBytes("ISO-8859-1"), "UTF-8");
        String collName = new String(request.getParameter("coll_name").getBytes("ISO-8859-1"), "UTF-8");
        String image = new String(request.getParameter("image").getBytes("ISO-8859-1"), "UTF-8");
        String imagePath=path+image;
        
        //增加了String type = new String(request.getParameter("type").getBytes("ISO-8859-1"), "UTF-8");
        String type = new String(request.getParameter("type").getBytes("ISO-8859-1"), "UTF-8");
        String description = new String(request.getParameter("description").getBytes("ISO-8859-1"), "UTF-8");
        String dynasty = new String(request.getParameter("dynasty").getBytes("ISO-8859-1"), "UTF-8");
        String address = new String(request.getParameter("address").getBytes("ISO-8859-1"), "UTF-8");
        String inTime = new String(request.getParameter("in_time").getBytes("ISO-8859-1"), "UTF-8");
        String status = new String(request.getParameter("status").getBytes("ISO-8859-1"), "UTF-8");
        String idRepair = new String(request.getParameter("idRepair").getBytes("ISO-8859-1"), "UTF-8");
        
       
        
       Coll coll =new Coll();
        
        coll.setCollId(collId);
        coll.setCollName(collName);
        coll.setImage(imagePath);
        coll.setDescription(description);
        coll.setDynasty(dynasty);
        //增加了coll.setType(type);
        coll.setType(type);
        coll.setAddress(address);
        coll.setInTime(inTime);
        coll.setStatus(status);
        coll.setIdrepair(idRepair);
        if(bs.AddCollInfo(coll)){
     	   request.getRequestDispatcher("CollMan.jsp").forward(request, response);
     	   
        }else{
     	   
     	   request.getRequestDispatcher("error.jsp").forward(request, response);
        }

}
	
	public void GetAllCollInfo(HttpServletRequest request,HttpServletResponse response) throws Exception{
		 
          ArrayList<Coll> collList  = bs.GetAllCollInfo();
      
          request.setAttribute("collList", collList);
			
			request.getRequestDispatcher("CollMan.jsp").forward(request, response); 
	
	
}
	
	public void GetCollInfo(HttpServletRequest request,HttpServletResponse response)throws Exception{
        String collId= request.getParameter("id");
         Coll coll = new Coll();
         coll=bs.GetCollInfo(collId);
         
         request.setAttribute("updateColl", coll);
			
			request.getRequestDispatcher("UpdateColl.jsp").forward(request, response); 


}
	
	public void UpdateCollById(HttpServletRequest request,HttpServletResponse response)throws Exception{
        
        String collId = new String(request.getParameter("coll_id").getBytes("ISO-8859-1"), "UTF-8");
        String collName = new String(request.getParameter("coll_name").getBytes("ISO-8859-1"), "UTF-8");
        String description = new String(request.getParameter("coll_desc").getBytes("ISO-8859-1"), "UTF-8");
        String dynasty = new String(request.getParameter("coll_dyna").getBytes("ISO-8859-1"), "UTF-8");
        String address = new String(request.getParameter("coll_addr").getBytes("ISO-8859-1"), "UTF-8");
        String inTime = new String(request.getParameter("coll_inTime").getBytes("ISO-8859-1"), "UTF-8");
        String status = new String(request.getParameter("coll_status").getBytes("ISO-8859-1"), "UTF-8");
        String idrepa = new String(request.getParameter("coll_idrepa").getBytes("ISO-8859-1"), "UTF-8");
        
        System.out.println(inTime+"++++++++++++++++++++");
        
       Coll coll = new Coll();
        
       coll.setCollId(collId);
       coll.setCollName(collName);
       coll.setDescription(description);
       coll.setDynasty(dynasty);
       coll.setAddress(address);
       coll.setInTime(inTime);
       coll.setStatus(status);
       coll.setIdrepair(idrepa);
        if(bs.UpdateCollById(coll)){
     	   request.getRequestDispatcher("CollMan.jsp").forward(request, response);
     	   
        }else{
     	   
     	   request.getRequestDispatcher("error.jsp").forward(request, response);
        }
        
         



}
	
	public void DeleteCollInfo(HttpServletRequest request,HttpServletResponse response)throws Exception{
        String collId= request.getParameter("id");
         
        if(bs.DeleteCollInfo(collId)){
      	  request.getRequestDispatcher("CollMan.jsp").forward(request, response); 
      	  
        }else{
      	   
      	   request.getRequestDispatcher("error.jsp").forward(request, response);
         }
         

}

	
	
	
	
}
