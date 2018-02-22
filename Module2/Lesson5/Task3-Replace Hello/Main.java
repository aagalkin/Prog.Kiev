import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args){
        try {
            replace("C://1.txt", "Hello", "1234");
        }
        catch (IOException e){
            e.getMessage();
        }
    }

    private static void replace(String path, String from, String to) throws IOException{
        if (new File(path).exists()) {
            ArrayList<String> list = new ArrayList<>();

            try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
                while (reader.ready()) {
                    list.add(reader.readLine());
                }
            }

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).contains(from)) {
                    StringBuilder builder = new StringBuilder(list.get(i));
                    Pattern p = Pattern.compile(from);
                    Matcher m = p.matcher(builder);

                    while (m.find()) {
                        builder.replace(m.start(), m.end(), to);
                    }
                    list.set(i, builder.toString());
                }
                System.out.println(list.get(i));
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))){
                for (String s : list){
                    writer.write(s);
                    writer.newLine();
                }
            }
        }
        else {
            throw new FileNotFoundException("File is not exist!");
        }
    }
}
