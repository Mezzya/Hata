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
public class DellHataServlet extends HttpServlet {
    DbProperties db = new DbProperties();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String stId = req.getParameter("id");
        int id = Integer.parseInt(stId);

        try {
            Connection con = DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPwd());

            PreparedStatement ps = con.prepareStatement("DELETE FROM hata WHERE id="+id);
            ps.execute();

            req.getRequestDispatcher("/all").forward(req,resp);
            return;

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
