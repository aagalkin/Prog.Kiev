public class Main {

    public static void main(String[] args) {
        Triangle triangle = new Triangle(12.5, 4, 11.6);
        System.out.println(triangle.getSquare());

        Rectangle rectangle = new Rectangle(10, 5);
        System.out.println(rectangle.getSquare());

        Circle circle = new Circle(5);
        System.out.println(circle.getSquare());
    }
}
