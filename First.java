public class First {
    public static class HashAndEqual{
        public HashAndEqual()
        {
            System.out.println("HashAndEqual");
        }
    }

    public static class Person{
        public void eat(){
            System.out.println("Person is eating");   
        }
    }

    public static class Developer extends Person{
            public void code(){
                System.out.println("Developer do coding");
            }
    }

    public static class Engine{
        public void start(){
            System.out.println("Engine Starting");
        }
    }

    public static class Car{
        Engine eng;

        Car(Engine engine)
        {
            this.eng=engine;
        }

        public void start(){
            eng.start();
            System.out.println("Car is moving");
        }
    }
    
        enum Day{
            SUNDAY,MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY
        }

        record Animal(String type,int age)
        {
        }

    public static void main(String[] args)
    {

        HashAndEqual o1=new HashAndEqual();
        HashAndEqual o2=o1;
        HashAndEqual o3=new HashAndEqual();
        System.out.println(o1.equals(o2)); 
        System.out.println(o1.equals(o3)); 

        System.out.println(o1.hashCode()); 
        System.out.println(o2.hashCode()); 

        int age=18;
        if(age>18)
        {
            System.out.println("You are eligible for license");
        }
        else if(age==18)
        {
            System.out.println("You are also eligible for license");
        }
        else
        {
            System.out.println("You are not eligible for license");
        }
        int deptNo=2;
        switch (deptNo) {
            case 1:
                System.out.println("Marketing Department");
                break;
            case 2:
            System.out.println("Engineering Department");
                break;
            default:
            System.out.println("Staff Members");
                break;
        }

        System.out.println("10's Table");
        for(int i=1;i<=10;i++)
        {
            System.out.printf("%d x %d = %d \n",10,i,10*i);
        }

        int i=1;
        while(i<=10)
        {
            System.out.printf("%d x %d = %d \n",10,i,10*i);
            i++;
        }       

        boolean Flag=false;
        do{
            System.out.println("While Loop");
        }while(Flag==true);

        
        Developer dev=new Developer();
        dev.eat();
        dev.code();

        Engine carEngine=new Engine();
        Car car=new Car(carEngine);
        car.start();

        Day toDay=Day.SUNDAY;
        System.out.println("today is: "+toDay);

        Animal Dog = new Animal("Dog", 25);
        System.out.println(Dog);   

        
    }

}