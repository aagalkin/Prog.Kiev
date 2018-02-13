public class Circle extends Rectangle{
    private double radius;

    public Circle(double radius){
        this.radius = radius;
    }

    @Override
    public double getSquare() {
        return Math.PI * Math.pow(radius, 2);
    }
}
