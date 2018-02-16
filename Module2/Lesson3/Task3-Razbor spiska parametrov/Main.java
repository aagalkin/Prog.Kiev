import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        try {
            someMethod("param1=value1&param2=value2&param3=value3");
        }
        catch (Exception e){
            System.out.println("Переданная строка не соответствует нужному формату!");
        }

    }

    private static void someMethod(String s) throws Exception{
        Map<String, String> pare = new HashMap<>();

        for (String str : s.split("&")) {
            if (!str.matches("[A-Za-z0-9]+=[A-Za-z0-9]+")) {
                throw new Exception();
            }
        }
        ArrayList<String> KV = new ArrayList<>();
        for (String st : s.split(("&"))){
            for (String str : st.split("=")){
                KV.add(str);
            }
        }
        for (int i = 0, j = 1; i < KV.size(); i+=2, j+=2){
            pare.put(KV.get(i), KV.get(j));
        }
        System.out.println(pare);
    }
}
