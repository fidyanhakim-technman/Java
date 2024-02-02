import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String args[])
    {
        HashMap<String,Integer> map=new HashMap<>();
        map.put("Fidyan",20);
        map.put("Het",21);
        map.put("Utsav",22);

        System.out.println("Size of map: "+map.size());

        System.out.println("map: "+map);
        System.out.println(map.get("Dwi1j"));
        System.out.println("map:"+map);

        for(Map.Entry<String,Integer>e: map.entrySet()){
                System.out.println("Key: "+e.getKey()+" Value:"+e.getValue());
        }

    }
}
