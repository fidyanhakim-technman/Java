import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
public class ConcurrentHashMapExample {
    public static void main(String args[]) {

        ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();

        concurrentHashMap.put("A", 1);
        concurrentHashMap.put("B", 2);
        concurrentHashMap.put("A", 1);

        System.out.println("Map size: " + concurrentHashMap.size());

        System.out.println(concurrentHashMap.get("A"));

        concurrentHashMap.remove("B");
        System.out.println("Map size: " + concurrentHashMap.size());

        System.out.println(concurrentHashMap);

        concurrentHashMap.putIfAbsent("A",2);  
        
        // We cant replace 23 with 2
        concurrentHashMap.replace("A",23,2);
        System.out.println(concurrentHashMap);
        
        concurrentHashMap.put("AB",292);

        Iterator<ConcurrentHashMap.Entry<String,Integer>>itr=concurrentHashMap.entrySet().iterator();

        while(itr.hasNext()){
            System.out.println("Key: "+itr.next().getKey()+" Value: "+itr.next().getValue());

        }
    }
}
