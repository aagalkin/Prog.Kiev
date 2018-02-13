public class Rectangle extends Triangle {
    private double x;
    private double y;

    public Rectangle(){

    }

    public Rectangle(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public double getSquare() {
        return x * y;
    }
}
