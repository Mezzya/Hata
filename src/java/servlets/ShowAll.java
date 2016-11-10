package servlets;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by andre on 11/9/2016.
 */
public class ShowAll extends HttpServlet {
    DbProperties dbp = new DbProperties();
    HataWrapper hataWrapper = new HataWrapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(dbp.getUrl(),dbp.getUser(),dbp.getPwd());

            String param = req.getParameter("pr");
            int par;
            try {
                par = Integer.parseInt(param);
            } catch (NumberFormatException e)
            {
                par=1;
            }

            if (par==1)
            {
                PreparedStatement ps = con.prepareStatement("SELECT * FROM hata");
                ResultSet rs = ps.executeQuery();
                ArrayList<Hata> list = new ArrayList<Hata>();
                while (rs.next())
                {
                    Hata hata = new Hata(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getInt(5), rs.getString(6));
                    hataWrapper.getHatas().add(hata);
                    list.add(hata);
                    System.out.println(hata);
                }

                String strEdit = req.getParameter("edit");
                if (strEdit!=null){
                    Integer edit = Integer.parseInt(strEdit);
                    req.setAttribute("edit",strEdit);
                }

                req.setAttribute("list",list);

                req.setAttribute("hatas",hataWrapper);

                req.getRequestDispatcher("/all.jsp").forward(req,resp);
                return;

            }
            if (par==2)
            {
                req.getRequestDispatcher("/index.jsp").forward(req,resp);
                return;
            }




        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

}
