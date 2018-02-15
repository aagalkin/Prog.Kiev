

public class Main {



    public static void main(String[] args) {
        drawRectangle(10, 5);
    }

    private static void drawRectangle(int width, int height){
        String LT = "\u250F";//Left Top angle
        String LB = "\u2517";//Left Bottom angle
        String RT = "\u2513";//Right Top angle
        String RB = "\u251B";//Right Bottom angle
        String hLine = "\u2501" + "\u2501";//Horizontal line
        String vLine = "\u2503";//Vertical line
        String space = " ";

        StringBuilder sb = new StringBuilder();
        sb.append(LT);
        sb.append(" ");
        for (int i = 0; i < width; i++){
            sb.append(hLine);
            sb.append(" ");
        }
        sb.append(RT);
        sb.append("\n");
        for (int i = 0; i < height; i++) {
            sb.append(vLine);
            sb.append("\n");
        }
        sb.append(LB);
        sb.append(" ");
        for (int i = 0; i < width; i++){
            sb.append(hLine);
            sb.append(" ");
        }
        sb.append(RB);
        System.out.println(sb.toString());
    }
}
