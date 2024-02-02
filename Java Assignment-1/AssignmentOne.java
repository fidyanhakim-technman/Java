import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AssignmentOne {
    
    public static Character findFirstNonRepeated(String s)
    {
          char ans=s.chars().mapToObj(i->Character.toLowerCase((char)i))
          .collect(Collectors.groupingBy(Function.identity(), 
          LinkedHashMap::new, Collectors.counting()))
          .entrySet()
        .stream().filter(e->e.getValue()==1)
        .findFirst().orElseThrow().getKey();

        return ans;
    }

    public static Character findFirstRepeated(String s)
    {
          char ans=s.chars().mapToObj(i->Character.toLowerCase((char)i))
          .collect(Collectors.groupingBy(Function.identity(), 
          LinkedHashMap::new, Collectors.counting()))
          .entrySet()
        .stream().filter(e->e.getValue()>1)
        .findFirst().orElseThrow().getKey();

        return ans;
    }


   public static void main(String args[])
    {

        List<String>DummyList=Arrays.asList("Java","Python","C++");

        Map<Integer, String> dummyMap = new HashMap<>();
        dummyMap.put(1, "One");
        dummyMap.put(2, "Two");
        dummyMap.put(3, "Three");
        dummyMap.put(4, "Four");
        dummyMap.put(5, "Five");

        
        
        Set<Integer> dummySet = new HashSet<>();
        dummySet.add(10);
        dummySet.add(20);
        dummySet.add(30);
        dummySet.add(40);
        dummySet.add(50);

        // System.out.println(DummyList+"  "+dummyMap+"  "+dummySet);

        // Scanner in=new Scanner(System.in);
        // String str1=in.nextLine();
        String str1="Fidubhai";

        System.out.println("String: "+str1);
        
        System.out.println("First Non Repeated Char: "+findFirstNonRepeated(str1));
        
        System.out.println("First Repeated Char: "+findFirstRepeated(str1));
        
        List<Integer>listOfInt=Arrays.asList(5,4,3,2,1);
        
        List<Integer>sortedLL=listOfInt.stream().sorted().collect(Collectors.toList());
        System.out.println("\nSorted List of Integers: \n"+sortedLL);

        Stream<String> s1=Stream.of("Abc","Def");
        Stream<String> s2=Stream.of("Ghi","Jkl");

        Stream.concat(s1, s2).forEach(e -> System.out.print(e+'\t'));

        Map<String,Integer>listToConvertMap=DummyList.stream().collect(Collectors.toMap(String::new, String::length));
        System.out.println(listToConvertMap);

        List<String>listOfWords=Arrays.asList("Hello","World","Hello","Java");

        Map<String,Long>countOfWords=listOfWords.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        
        System.out.println("Count of words in String\n\n"+countOfWords);

        ArrayList<String>listOfCar=new ArrayList<String>();
        listOfCar.add("car1");
        listOfCar.add("car2");
        listOfCar.add("car3");
        listOfCar.add("car4");
        listOfCar.add("car1");
       
        Map<String,Long>countOfCar=listOfCar.stream().collect(Collectors.groupingBy(String::toString,Collectors.counting()))
        .entrySet().stream().filter(e->e.getValue()>1).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));    
              
        System.out.println("\n"+countOfCar);

        int[] arr={1,2,3,4,5,6,7,8,9,10};

        int maxi=arr[0];
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]>maxi)
            {
                maxi=arr[i];
            }
        }
        System.out.println("Maximum Element in Array is: "+maxi);

        String s="abcabcabcdabcdddd";
        
        System.out.println("Count of Each Character in String: "+s+"\n");
        s.chars().mapToObj(c->Character.toLowerCase((char)c)).collect(Collectors.groupingBy(c->c,Collectors.counting())).forEach((c,n)->
        System.out.println(c+" : "+n));;

    }
}
