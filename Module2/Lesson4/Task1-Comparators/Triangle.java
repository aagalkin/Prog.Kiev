public class Triangle extends Figures {
    private double a;
    private double b;
    private double c;

    public Triangle() {

    }

    public Triangle(double a, double b, double c) {
        name = "Triangle";
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double getSquare() {
        return getHeight() * (a / 2);
    }

    private double getHeight() {
        double p = 0.5 * (a + b + c);
        return 2 * Math.sqrt(p * (p - a) * (p - b) * (p - c)) / a;
    }
}