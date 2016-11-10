package servlets;
/**
 * Created by andre on 11/10/2016.
 */
public class Hata {
    private int id;
    private int rooms;
    private int area;
    private String adress;
    private int price;
    private String rayon;

    public Hata(int id, int rooms, int area, String adress, int price, String rayon) {
        this.id = id;
        this.rooms = rooms;
        this.area = area;
        this.adress = adress;
        this.rayon = rayon;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getRayon() {
        return rayon;
    }

    public void setRayon(String rayon) {
        this.rayon = rayon;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Hata{" +
                "id=" + id +
                ", rooms=" + rooms +
                ", area=" + area +
                ", adress='" + adress + '\'' +
                ", price=" + price +
                ", rayon='" + rayon + '\'' +
                '}';
    }
}
