package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;

/**
 * Created by User on 11.11.2016.
 */
public class FilterServlet extends HttpServlet {
    DbProperties db = new DbProperties();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String rOption = req.getParameter("r_option");
        String aOption = req.getParameter("a_option");
        String pOption = req.getParameter("p_option");

        if ((rOption==null)&&(aOption==null)&&(pOption==null))
        {
//            Чтото не так с паравметрами
        }

        String strRoom = req.getParameter("rooms");
        String strArea = req.getParameter("area");
        String strPrice = req.getParameter("price");

        String roomReq="";
        String areaReq="";
        String priceReq="";
        String param = "SELECT * FROM hata";


        boolean checkReqDate=false;

        if (!rOption.equals("all"))
        {
//            roomReq = rOption;
            try{
                int rooms= Integer.parseInt(req.getParameter("rooms"));

                //  Формируем строку запроса
                if (param.endsWith("hata")) param+=" WHERE ";
                    else param+=" AND ";
                param+="rooms"+rOption+rooms;

            } catch (NumberFormatException e)
                {

                    req.setAttribute("roomsErr","has-error");
                    checkReqDate=true;
            }


        }

        if (!aOption.equals("all"))
        {
//            areaReq= aOption;
            try{
                int area= Integer.parseInt(req.getParameter("area"));

                //  Формируем строку запроса
                if (param.endsWith("hata")) param+=" WHERE ";
                    else param+=" AND ";
                param+="area"+aOption+area;

            } catch (NumberFormatException e)
            {

                req.setAttribute("areaErr","has-error");
                checkReqDate=true;
            }
        }

        if (!pOption.equals("all"))
        {
//            priceReq = pOption;
            try{
                int price= Integer.parseInt(req.getParameter("price"));

                //  Формируем строку запроса
                if (param.endsWith("hata")) param+=" WHERE ";
                    else param+=" AND ";
                param+="price"+pOption+price;
            } catch (NumberFormatException e)
            {

                req.setAttribute("priceErr","has-error");
                checkReqDate=true;
            }
        }


//        Проверяем нет ли ошибочныйх полей
        if (checkReqDate)
        {
//            Есть ошибка запихиваем параметры ошибок и на вьюшку
            req.setAttribute("rooms",req.getParameter("rooms"));
            req.setAttribute("area",req.getParameter("area"));
            req.setAttribute("price",req.getParameter("price"));


            req.getRequestDispatcher("/filter.jsp").forward(req,resp);
        }

//         param = "SELECT * FROM hata WHERE rooms"+roomz+((roomr!=null)?roomr:"")+rooms;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPwd());

            System.out.println(param);
            PreparedStatement ps = con.prepareStatement(param);

            ResultSet rs = ps.executeQuery();
            ArrayList<Hata> list = new ArrayList<Hata>();
            while (rs.next())
            {
                Hata hata = new Hata(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getInt(5), rs.getString(6));
                list.add(hata);
//
            }

            req.setAttribute("list",list);

            req.getRequestDispatcher("/all.jsp").forward(req,resp);




        } catch (SQLException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
