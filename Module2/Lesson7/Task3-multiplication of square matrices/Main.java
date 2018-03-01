
public class Main {

    public static void main(String[] args) throws InterruptedException {
        int[][] m1 = {{1, 2, 3},
                      {2, 3, 4},
                      {2, 3, 2}};

        int[][] m2 = {{3, 2, 1},
                      {2, 1, 4},
                      {2, 4, 1}};

        Matrix matrix = new Matrix(m1, m2);
        long time = System.currentTimeMillis();
        for (int i = 0; i < 3; i++) {
            new SomeThread(matrix, i).start();
        }
        int sleepTime = 1000;
        Thread.sleep(sleepTime);
        matrix.printResult();
        System.out.println("Time with multiThreading: " + (System.currentTimeMillis() - time - sleepTime) + "ms");
        time = System.currentTimeMillis();
        matrix.calculateSingleThread();
        matrix.printResult();
        System.out.println("Time with one thread: " + (System.currentTimeMillis() - time + "ms"));
    }
}
