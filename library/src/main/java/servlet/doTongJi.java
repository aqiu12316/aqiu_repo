package servlet;

import dao.TongJiDao;
import service.AcService;
import util.BaseServlet;
import vo.Ac;
import vo.LendBuyTJ;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/doTongJi")
public class doTongJi extends BaseServlet{
	
	private static final long serialVersionUID = 1L;
	private static final AcService bs =new AcService();
	
	
	public void TongJiInfo(HttpServletRequest request,HttpServletResponse response)throws Exception{
	    int lendtj[] ={0,0,0,0,0,0,0,0,0,0,0,0};
        List<LendBuyTJ> list = TongJiDao.GetLendTJInfo();
        for(LendBuyTJ ltj:list){
            if(ltj.getMonth().equals("01")){
                lendtj[0] = Integer.parseInt(ltj.getCount());
            }
            if(ltj.getMonth().equals("02")){
                lendtj[1] = Integer.parseInt(ltj.getCount());
            }
            if(ltj.getMonth().equals("03")){
                lendtj[2] = Integer.parseInt(ltj.getCount());
            }
            if(ltj.getMonth().equals("04")){
                lendtj[3] = Integer.parseInt(ltj.getCount());
            }
            if(ltj.getMonth().equals("05")){
                lendtj[4] = Integer.parseInt(ltj.getCount());
            }
            if(ltj.getMonth().equals("06")){
                lendtj[5] = Integer.parseInt(ltj.getCount());
            }
            if(ltj.getMonth().equals("07")){
                lendtj[6] = Integer.parseInt(ltj.getCount());
            }
            if(ltj.getMonth().equals("08")){
                lendtj[7] = Integer.parseInt(ltj.getCount());
            }
            if(ltj.getMonth().equals("09")){
                lendtj[8] = Integer.parseInt(ltj.getCount());
            }
            if(ltj.getMonth().equals("10")){
                lendtj[9] = Integer.parseInt(ltj.getCount());
            }
            if(ltj.getMonth().equals("11")){
                lendtj[10] = Integer.parseInt(ltj.getCount());
            }
            if(ltj.getMonth().equals("12")){
                lendtj[11] = Integer.parseInt(ltj.getCount());
            }
        }
        String lendtj_str = "[";
        for(int i:lendtj){
            lendtj_str+=i+",";
        }
        lendtj_str = lendtj_str.substring(0,lendtj_str.length()-1)+"]";


        int buytj[] ={0,0,0,0,0,0,0,0,0,0,0,0};
        List<LendBuyTJ> list1 = TongJiDao.GetBuyTJInfo();
        for(LendBuyTJ ltj:list1){
            if(ltj.getMonth().equals("01")){
                buytj[0] = Integer.parseInt(ltj.getCount());
            }
            if(ltj.getMonth().equals("02")){
                buytj[1] = Integer.parseInt(ltj.getCount());
            }
            if(ltj.getMonth().equals("03")){
                buytj[2] = Integer.parseInt(ltj.getCount());
            }
            if(ltj.getMonth().equals("04")){
                buytj[3] = Integer.parseInt(ltj.getCount());
            }
            if(ltj.getMonth().equals("05")){
                buytj[4] = Integer.parseInt(ltj.getCount());
            }
            if(ltj.getMonth().equals("06")){
                buytj[5] = Integer.parseInt(ltj.getCount());
            }
            if(ltj.getMonth().equals("07")){
                buytj[6] = Integer.parseInt(ltj.getCount());
            }
            if(ltj.getMonth().equals("08")){
                buytj[7] = Integer.parseInt(ltj.getCount());
            }
            if(ltj.getMonth().equals("09")){
                buytj[8] = Integer.parseInt(ltj.getCount());
            }
            if(ltj.getMonth().equals("10")){
                buytj[9] = Integer.parseInt(ltj.getCount());
            }
            if(ltj.getMonth().equals("11")){
                buytj[10] = Integer.parseInt(ltj.getCount());
            }
            if(ltj.getMonth().equals("12")){
                buytj[11] = Integer.parseInt(ltj.getCount());
            }
        }
        String buytj_str = "[";
        for(int i:buytj){
            buytj_str+=i+",";
        }
        buytj_str = buytj_str.substring(0,buytj_str.length()-1)+"]";

        request.setAttribute("lend_tj",lendtj_str);
        request.setAttribute("buy_tj", buytj_str);
        //----------------------------------------------------------------------------------------------
        int lendtj1[] ={0,0,0,0,0,0,0,0,0,0,0,0};
        List<LendBuyTJ> list11 = TongJiDao.GetLendTJInfo();
        for(LendBuyTJ ltj:list11){
            if(ltj.getMonth().equals("01")){
                lendtj1[0] = Integer.parseInt(ltj.getTotal_price());
            }
            if(ltj.getMonth().equals("02")){
                lendtj1[1] = Integer.parseInt(ltj.getTotal_price());
            }
            if(ltj.getMonth().equals("03")){
                lendtj1[2] = Integer.parseInt(ltj.getTotal_price());
            }
            if(ltj.getMonth().equals("04")){
                lendtj1[3] = Integer.parseInt(ltj.getTotal_price());
            }
            if(ltj.getMonth().equals("05")){
                lendtj1[4] = Integer.parseInt(ltj.getTotal_price());
            }
            if(ltj.getMonth().equals("06")){
                lendtj1[5] = Integer.parseInt(ltj.getTotal_price());
            }
            if(ltj.getMonth().equals("07")){
                lendtj1[6] = Integer.parseInt(ltj.getTotal_price());
            }
            if(ltj.getMonth().equals("08")){
                lendtj1[7] = Integer.parseInt(ltj.getTotal_price());
            }
            if(ltj.getMonth().equals("09")){
                lendtj1[8] = Integer.parseInt(ltj.getTotal_price());
            }
            if(ltj.getMonth().equals("10")){
                lendtj1[9] = Integer.parseInt(ltj.getTotal_price());
            }
            if(ltj.getMonth().equals("11")){
                lendtj1[10] = Integer.parseInt(ltj.getTotal_price());
            }
            if(ltj.getMonth().equals("12")){
                lendtj1[11] = Integer.parseInt(ltj.getTotal_price());
            }
        }
        String lendtj_str1 = "[";
        for(int i:lendtj1){
            lendtj_str1+=i+",";
        }
        lendtj_str1 = lendtj_str1.substring(0,lendtj_str1.length()-1)+"]";


        int buytj1[] ={0,0,0,0,0,0,0,0,0,0,0,0};
        List<LendBuyTJ> list12 = TongJiDao.GetBuyTJInfo();
        for(LendBuyTJ ltj:list12){
            if(ltj.getMonth().equals("01")){
                buytj1[0] = Integer.parseInt(ltj.getTotal_price());
            }
            if(ltj.getMonth().equals("02")){
                buytj1[1] = Integer.parseInt(ltj.getTotal_price());
            }
            if(ltj.getMonth().equals("03")){
                buytj1[2] = Integer.parseInt(ltj.getTotal_price());
            }
            if(ltj.getMonth().equals("04")){
                buytj1[3] = Integer.parseInt(ltj.getTotal_price());
            }
            if(ltj.getMonth().equals("05")){
                buytj1[4] = Integer.parseInt(ltj.getTotal_price());
            }
            if(ltj.getMonth().equals("06")){
                buytj1[5] = Integer.parseInt(ltj.getTotal_price());
            }
            if(ltj.getMonth().equals("07")){
                buytj1[6] = Integer.parseInt(ltj.getTotal_price());
            }
            if(ltj.getMonth().equals("08")){
                buytj1[7] = Integer.parseInt(ltj.getTotal_price());
            }
            if(ltj.getMonth().equals("09")){
                buytj1[8] = Integer.parseInt(ltj.getTotal_price());
            }
            if(ltj.getMonth().equals("10")){
                buytj1[9] = Integer.parseInt(ltj.getTotal_price());
            }
            if(ltj.getMonth().equals("11")){
                buytj1[10] = Integer.parseInt(ltj.getTotal_price());
            }
            if(ltj.getMonth().equals("12")){
                buytj1[11] = Integer.parseInt(ltj.getTotal_price());
            }
        }
        String buytj_str1 = "[";
        for(int i:buytj1){
            buytj_str1+=i+",";
        }
        buytj_str1 = buytj_str1.substring(0,buytj_str1.length()-1)+"]";

        request.setAttribute("lend_tj1",lendtj_str1);
        request.setAttribute("buy_tj1", buytj_str1);

           request.getRequestDispatcher("tj.jsp").forward(request, response);
	}

}
