public class Circle extends Figures{
    private double radius;

    public Circle(double radius){
        name = "Circle";
        this.radius = radius;
    }

    @Override
    public double getSquare() {
        return Math.PI * Math.pow(radius, 2);
    }
}