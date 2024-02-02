import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class EmployeeData {
    
    public static class Employee{
        private String name;
        private int age;
        private String gender;
        private String DepartmentName;
        private int salary;
        private LocalDate joining;
        public Employee(String name,int age,String gender,String department,int Salary,LocalDate joiningDate)
        {
            this.name=name;
            this.age=age;
            this.gender=gender;
            this.DepartmentName=department;
            this.salary=Salary;
            this.joining=joiningDate;
        }
        public String getName(){
            return this.name;
        }
        public String getGender(){
            return this.gender;
        }

        public String getDept(){
            return this.DepartmentName;
        }
        public Integer getAge(){
            return this.age;
        }
        public Integer getSalary(){
            return this.salary;
        }
        public LocalDate getJoiningDate(){
            return this.joining;
        }
    }
    public static class organization{
        private List<Employee>EmployeeData;

        public organization(List<Employee>emp)
        {
            this.EmployeeData=emp;
        }

        public void countOfMaleFemale()
        {
            System.out.println("Female Employees Count: "+EmployeeData.stream().filter(e->e.getGender()=="Female").count()+"\n");
            System.out.println("Female Employees Count: "+EmployeeData.stream().filter(e->e.getGender()=="Male").count());
        }

        public void AllDepartments(){
            
            Set<String>s=EmployeeData.stream().map(e->e.getDept()).collect(Collectors.toSet());

            System.out.println("\nList Of All Departments: "+s);
        }

        public void AverageAge(){
            double averageSum1=EmployeeData.stream().filter(e->e.getGender()=="Male").mapToInt(Employee::getAge).average().orElse(0);
            System.out.println("\nAverage Age of Male Employees: "+averageSum1);

            double averageSum2=EmployeeData.stream().filter(e->e.getGender()!="Male").mapToInt(Employee::getAge).average().orElse(0);
            System.out.println("\nAverage Age of Femle Employees: "+averageSum2);
        }

        public void HighestPaidEmployee(){

            int maxi=0;
            for(Employee e:EmployeeData)
            {   
                maxi=Math.max(maxi,e.getSalary());
            }
            System.out.println("\nHighest Paid Employee in Organisation is: "+maxi);
        }

        public void JoinedAfter2015(){
            for(Employee e:EmployeeData)
            {
                if(e.getJoiningDate().isAfter(LocalDate.of(2015,1,1)))
                {
                    System.out.println(e.getName());
                }
            }
        }

        public void DepartmentWiseCount(){
            Map<String,Long>DeptMap=EmployeeData.stream().collect(Collectors.groupingBy(Employee::getDept,Collectors.counting()));

            System.out.println("\nNumber of Employees In Each Department: \n"+DeptMap+"\n");
        }

        public void AverageSalaryEachDepartment(){
            Map<String,Double>SalaryMap=EmployeeData.stream().collect(
                Collectors.groupingBy(Employee::getDept,Collectors.averagingDouble(Employee::getSalary)));
            SalaryMap.forEach((e,j)->System.out.println("Dept Name: "+e+" Average Salary: "+j));
        }

        public void MostExpriencedEmp(){
            System.out.println("\nMost Exprienced Employee in Organisation: "+EmployeeData.stream().min(Comparator.comparing(Employee::getJoiningDate)).orElse(null).getName());
        }

        public void YoungestMaleEmp(){
            System.out.println("\nYoungest Male Employee in Organisation: "+EmployeeData.stream().filter(e->e.getGender()=="Male").min(Comparator.comparing(Employee::getAge)).orElse(null).getName());
        }

        public void AverageAndWholeSalary(){
            System.out.println("\nWhole Salary of Organisation: "+EmployeeData.stream().mapToDouble(Employee::getSalary).sum());
            System.out.println("\nAverage Salary of Organisation: "+EmployeeData.stream().mapToDouble(Employee::getSalary).sum()/EmployeeData.size());

        }
    }
    public static void main(String[] args)
    {
         List<Employee> employeesData = new ArrayList<>();
         employeesData.add(new Employee("Fidyan", 20, "Male", "IT",1000000, LocalDate.of(2024, 1, 3)));
         employeesData.add(new Employee("Het", 21, "Male", "IT",950000, LocalDate.of(2020, 6, 10)));
         employeesData.add(new Employee("Utsav", 35, "Male", "IT",55000, LocalDate.of(2019, 2, 5)));
         employeesData.add(new Employee("Aanchal", 25, "Female", "Finance",45000, LocalDate.of(2019, 5, 15)));
         employeesData.add(new Employee("Dev", 40, "Male", "Finance",55000, LocalDate.of(2020, 10, 5)));

         organization org=new organization(employeesData);
        
         org.countOfMaleFemale();

         org.AllDepartments();

         org.AverageAge();

         org.HighestPaidEmployee();

         org.JoinedAfter2015();

         org.DepartmentWiseCount();

         org.AverageSalaryEachDepartment();

         org.MostExpriencedEmp();

         org.YoungestMaleEmp();

         org.AverageAndWholeSalary();
    }
}
