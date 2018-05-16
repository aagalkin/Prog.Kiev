import com.google.gson.Gson;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DB {
    private static final String URL = "jdbc:mysql://localhost/hw?autoReconnect=true&useSSL=false";
    private static final String DBUser = "root";
    private static final String DBpassword = "1234";
    private static final String driver = "com.mysql.jdbc.Driver";

    public static boolean addClient(Client client){
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(URL, DBUser, DBpassword)){
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO clients (name, surname, phone, email) VALUES (?,?,?,?)");
            preparedStatement.setString(1, client.getName());
            preparedStatement.setString(2, client.getSurname());
            preparedStatement.setInt(3, client.getPhone());
            preparedStatement.setString(4, client.getEmail());
            return preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static boolean addProduct(Product product){
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(URL, DBUser, DBpassword)){
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO products (name, price) VALUES (?,?)");
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            return preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static Client getClient(int id){
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(URL, DBUser, DBpassword)){
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM clients WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet set = preparedStatement.executeQuery();
            while (set.next()){
                String name = set.getString("name");
                String surname = set.getString("surname");
                int phone = set.getInt("phone");
                String email = set.getString("email");
                return new Client(name, surname, phone, email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static Product getProduct(int id){
        List<Product> list = new ArrayList<>();
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(URL, DBUser, DBpassword)){
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM products WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet set = preparedStatement.executeQuery();
            while (set.next()){
                String name = set.getString("name");
                double price = set.getDouble("price");
                return new Product(name, price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static boolean addOrder(int clientId, int... productsId){
        List<Product> products = new ArrayList<>();
        double totalPrice = 0;
        for (int productId : productsId) {
            Product product = getProduct(productId);
            totalPrice += product.getPrice();
            products.add(product);
        }
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Gson gson = new Gson();
        String strProducts = gson.toJson(products);

        try (Connection connection = DriverManager.getConnection(URL, DBUser, DBpassword)){
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO orders (client, products, totalprice) VALUES (?,?,?)");
            preparedStatement.setInt(1, clientId);
            preparedStatement.setString(2, strProducts);
            preparedStatement.setDouble(3, totalPrice);
            return preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static List<Order> getOrdersByClient(int clientId){
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Client client = getClient(clientId);

        List<Order> orders = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, DBUser, DBpassword)){
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM orders WHERE client = ?");
            preparedStatement.setInt(1, clientId);
            ResultSet set = preparedStatement.executeQuery();
            Gson gson = new Gson();
            while (set.next()){
                int id = set.getInt("id");
                List<Product> products = gson.fromJson(set.getString("products"), List.class);
                orders.add(new Order(id, client, products));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orders;
    }
}
