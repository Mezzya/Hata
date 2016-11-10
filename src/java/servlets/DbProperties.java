package servlets;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by andre on 11/9/2016.
 */
public class DbProperties {

    private String url;
    private String user;
    private String pwd;

    public DbProperties() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("db.properties");

        Properties properties = new Properties();

        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

        url=properties.getProperty("db.url");
        user=properties.getProperty("db.user");
        pwd=properties.getProperty("db.password");

    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPwd() {
        return pwd;
    }
}
