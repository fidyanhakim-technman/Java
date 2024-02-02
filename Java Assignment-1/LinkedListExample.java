import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String args[]){
        LinkedList<String> LL=new LinkedList<>();
        LL.add("Item1");
        LL.add("Item2");
        LL.add("Item3");
        LL.addLast("Item4");
        LL.addFirst("Item5");
        LL.add(2,"Item6");
        System.out.println("Linked List: "+LL);

        LL.remove("Item1");
        LL.remove(1);
        System.out.println("Linked List: "+LL);

        // Iteration in LL
        for(String s:LL)
        {
            System.out.println(s);
        }
    }    
}
