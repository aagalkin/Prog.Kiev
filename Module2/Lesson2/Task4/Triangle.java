public class Triangle extends Figure {
    private double a;
    private double b;
    private double c;

    public Triangle(){

    }

    public Triangle(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double getSquare(){
        return getHeight(a, b, c) * (a / 2);
    }

    public double getHeight(double a, double b, double c){
        double p = 0.5*(a + b + c);
        return 2 * Math.sqrt(p * (p - a) * (p - b) * (p - c))/a;
    }
}
