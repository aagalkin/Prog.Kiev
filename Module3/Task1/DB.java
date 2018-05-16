import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DB {
    private static final String URL = "jdbc:mysql://localhost/hw?autoReconnect=true&useSSL=false";
    private static final String DBUser = "root";
    private static final String DBpassword = "1234";
    private static final String driver = "com.mysql.jdbc.Driver";
    public static List<Flat> getByArea(String area){
        List<Flat> list = new ArrayList<>();
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(URL, DBUser, DBpassword)){
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM flats WHERE area = ?");
            preparedStatement.setString(1, area);
            ResultSet set = preparedStatement.executeQuery();
            while (set.next()){
                String ar = set.getString("area");
                String ad = set.getString("address");
                double sq = set.getDouble("square");
                int rm = set.getInt("rooms");
                double pr = set.getDouble("price");

                list.add(new Flat(ar, ad, sq, rm, pr));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static List<Flat> getByAddress(String address){
        List<Flat> list = new ArrayList<>();
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(URL, DBUser, DBpassword)){
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM flats WHERE address = ?");
            preparedStatement.setString(1, address);
            ResultSet set = preparedStatement.executeQuery();
            while (set.next()){
                String ar = set.getString("area");
                String ad = set.getString("address");
                double sq = set.getDouble("square");
                int rm = set.getInt("rooms");
                double pr = set.getDouble("price");

                list.add(new Flat(ar, ad, sq, rm, pr));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static List<Flat> getBySquare(double squareFrom, double squareTo){
        List<Flat> list = new ArrayList<>();
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(URL, DBUser, DBpassword)){
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM flats WHERE square BETWEEN ? AND ?");
            preparedStatement.setDouble(1, squareFrom);
            preparedStatement.setDouble(2, squareTo);
            ResultSet set = preparedStatement.executeQuery();
            while (set.next()){
                String ar = set.getString("area");
                String ad = set.getString("address");
                double sq = set.getDouble("square");
                int rm = set.getInt("rooms");
                double pr = set.getDouble("price");

                list.add(new Flat(ar, ad, sq, rm, pr));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static List<Flat> getByPrice(double priceFrom, double priceTo){
        List<Flat> list = new ArrayList<>();
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(URL, DBUser, DBpassword)){
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM flats WHERE price BETWEEN ? AND ?");
            preparedStatement.setDouble(1, priceFrom);
            preparedStatement.setDouble(2, priceTo);
            ResultSet set = preparedStatement.executeQuery();
            while (set.next()){
                String ar = set.getString("area");
                String ad = set.getString("address");
                double sq = set.getDouble("square");
                int rm = set.getInt("rooms");
                double pr = set.getDouble("price");

                list.add(new Flat(ar, ad, sq, rm, pr));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static List<Flat> getByRooms(int roomsFrom, int roomsTo){
        List<Flat> list = new ArrayList<>();
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(URL, DBUser, DBpassword)){
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM flats WHERE square BETWEEN ? AND ?");
            preparedStatement.setInt(1, roomsFrom);
            preparedStatement.setInt(2, roomsTo);
            ResultSet set = preparedStatement.executeQuery();
            while (set.next()){
                String ar = set.getString("area");
                String ad = set.getString("address");
                double sq = set.getDouble("square");
                int rm = set.getInt("rooms");
                double pr = set.getDouble("price");

                list.add(new Flat(ar, ad, sq, rm, pr));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static boolean add(Flat flat){
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(URL, DBUser, DBpassword)){
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO flats (area, address, square, rooms, price) VALUES (?,?,?,?,?)");
            preparedStatement.setString(1, flat.getArea());
            preparedStatement.setString(2, flat.getAddress());
            preparedStatement.setDouble(3, flat.getSquare());
            preparedStatement.setInt(4, flat.getRooms());
            preparedStatement.setDouble(5, flat.getPrice());
            return preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
