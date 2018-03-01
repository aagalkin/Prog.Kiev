public class SomeThread extends Thread{
    private Matrix matrix;
    private int n;

    public SomeThread(Matrix matrix, int n){
        this.matrix = matrix;
        this.n = n;
    }

    @Override
    public void run() {
        matrix.calculateMultiThread(n);
    }
}