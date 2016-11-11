package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by User on 10.11.2016.
 */
public class AddHataServlet extends HttpServlet {
    DbProperties db = new DbProperties();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        Выгребли параметры
        String rayon = req.getParameter("rayon");
        String adress = req.getParameter("adress");
        int rooms = Integer.parseInt(req.getParameter("rooms"));
        int area = Integer.parseInt(req.getParameter("area"));
        int price = Integer.parseInt(req.getParameter("price"));
        System.out.println("TUTA edit_id="+req.getParameter("edit_id"));
        try {
            Connection con = DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPwd());

            if (req.getParameter("edit_id")!=null)
            {
                int id = Integer.parseInt(req.getParameter("edit_id"));
//                Редактируем запись
                PreparedStatement pr = con.prepareStatement("UPDATE hata SET rooms=?, area=?,adress=?,price=?, rayon=? WHERE id=?");
                pr.setInt(1, rooms);
                pr.setInt(2, area);
                pr.setString(3, adress);
                pr.setInt(4,price);
                pr.setString(5, rayon);
                pr.setInt(6,id);

                pr.execute();
                System.out.println("Well done UPDATE");

                req.setAttribute("pr","1");
                resp.sendRedirect("/all");


            }
            else
            {
//                Добавляем новую запись
                PreparedStatement pr = con.prepareStatement("INSERT INTO hata (rooms, area,adress,price, rayon) VALUE (?,?,?,?,?)");

                pr.setInt(1, rooms);
                pr.setInt(2, area);
                pr.setString(3, adress);
                pr.setInt(4,price);
                pr.setString(5, rayon);

                pr.execute();
                System.out.println("Well done NEW");

                req.setAttribute("pr","1");
                resp.sendRedirect("/all");

            }


//            req.getRequestDispatcher("/all").forward(req,resp);
            return;


        } catch (SQLException e) {

            req.getRequestDispatcher("/all").forward(req,resp);
        }


    }
}
