import java.util.Map;
import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String args[]) {
        Map<Integer, String> tM = new TreeMap<>();

        tM.put(1, "Fidyan");
        tM.put(2, "Het");
        tM.put(3, "Utsav");

        System.out.println(tM.get(1));

        for (int i : tM.keySet()) {
            System.out.println(i + " " + tM.get(i));
        }

    }
}
