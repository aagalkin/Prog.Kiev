public class Flat {
    private String area;
    private String address;
    private double square;
    private int rooms;
    private double price;
    Flat(String area, String address, double square, int rooms, double price){
        this.area = area;
        this.address = address;
        this.square = square;
        this.rooms = rooms;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Flat{" +
                "area='" + area + '\'' +
                ", address='" + address + '\'' +
                ", square=" + square +
                ", rooms=" + rooms +
                ", price=" + price +
                '}';
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
