import java.util.Iterator;
import java.util.PriorityQueue;


public class PriorityQueueExample {
    
    public static void main(String[] args)
    {

        PriorityQueue<Integer>pQueue=new PriorityQueue<>();
        
        pQueue.add(10);
        pQueue.add(20);
        pQueue.add(30);

        System.out.println(pQueue.peek());
        System.out.println(pQueue.poll());
        System.out.println(pQueue.peek());
        for(int i:pQueue)
        {
            System.out.println(i);
        }

        PriorityQueue<String> pq = new PriorityQueue<>();
 
        pq.add("A");
        pq.add("B");
        pq.add("C");
 
        Iterator iterator = pq.iterator();
 
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }


    }
}
