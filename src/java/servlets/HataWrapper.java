package servlets;
import java.util.ArrayList;

/**
 * Created by andre on 11/10/2016.
 */
public class HataWrapper {
    private ArrayList<Hata> hatas = new ArrayList<Hata>();

    public HataWrapper() {
    }

    public ArrayList<Hata> getHatas() {
        return hatas;
    }

    public void setHatas(ArrayList<Hata> hatas) {
        this.hatas = hatas;
    }
}
