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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        Выгребли параметры
        String rayon = req.getParameter("rayon");
        String adress = req.getParameter("adress");
        int rooms = Integer.parseInt(req.getParameter("rooms"));
        int area = Integer.parseInt(req.getParameter("area"));
        int price = Integer.parseInt(req.getParameter("price"));

        try {
            Connection con = DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPwd());

            PreparedStatement pr = con.prepareStatement("INSERT INTO hata (rooms, area,adress,price, rayon) VALUE (?,?,?,?,?)");

            pr.setInt(1, rooms);
            pr.setInt(2, area);
            pr.setString(3, adress);
            pr.setInt(4,price);
            pr.setString(5, rayon);

            pr.execute();
            System.out.println("Well done commander");
            req.setAttribute("pr","1");
            req.getRequestDispatcher("/all").forward(req,resp);
            return;


        } catch (SQLException e) {

            req.getRequestDispatcher("/all").forward(req,resp);
        }


    }
}
