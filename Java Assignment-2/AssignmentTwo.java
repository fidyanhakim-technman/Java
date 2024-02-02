import java.time.LocalDate;
import java.util.*;

public class AssignmentTwo {
    public static class Student{
        private Integer sID;
        private String name;
        private String email;
        private Integer phone;   

        Student(int id,String name,String email,int number)
        {
            this.sID=id;
            this.name=name;
            this.email=email;
            this.phone=number;
        }
        public Integer getId(){
            return this.sID;
        }
        public String getName(){
            return name;
        }
        @Override
        public int hashCode() {
            return Objects.hash(sID, name, email, phone);
        }
    
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Student student = (Student) obj;
            return sID == student.sID && Objects.equals(name, student.name) && Objects.equals(email, student.email) && Objects.equals(phone, student.phone);
        }
       
    }   
    public static class Assignment{
        private Integer aID;
        private String title;
        private String description;
        private Date dueDate;
        private List<Question> Question;

        Assignment(int id,String title,String desc,Date date,List<Question>Ques)
        {
            this.aID=id;
            this.title=title;
            this.description=desc;
            this.dueDate=date;
            this.Question=Ques;
        }

        
        public Integer getId(){
            return this.aID;
        }

        public List<Question> getQuestions(){
            return Question;
        }
        public String getTitle(){
            return title;
        }
    }
    public static class Trainer{
        private Integer trainerId;
        private String name;
        private String email;
        private Integer phone;
        private List<String> TechStack;

        Trainer(int id,String name,String email,int contact,List<String>TechStack)
        {
            this.trainerId=id;
            this.name=name;
            this.email=email;
            this.phone=contact;
            this.TechStack=TechStack;
        }
        
        public Integer getId(){
            return this.trainerId;
        }
    }
    public static class TechStack{
            private Integer techStackId;
            private String name;
            private String description;

            TechStack(int id,String name,String desc)
        {
            this.techStackId=id;
            this.name=name;
            this.description=desc;
        }

        public Integer getId(){
            return this.techStackId;
        }

    }
    public static class Result{
            private Integer rID;
            private Student student;
            private Assignment assignment;
            private Trainer trainer;
            private Integer score;
            private String feedback;
            private Date submissionDate;

            Result(int id,Student s,Assignment assign,Trainer t,int score,String feedback, Date subDate)
            {
                this.rID=id;
                this.student=s;
                this.assignment=assign;
                this.trainer=t;
                this.score=score;
                this.feedback=feedback;
                this.submissionDate=subDate;
            }
            public Student getStudent(){
                return student;
            }
            public Integer getTotalScore(){
                return score;
            }
            public Assignment getAssignment(){
                return assignment;
            }
            public Integer getId(){
                return rID;
            }
            public String getFeedback(){
                return feedback;
            }
    }
    public static class ResultsData{
        private List<Result>resultList;

        ResultsData(){
            this.resultList=new ArrayList<>();
        }

        public void addResult(Result result)
        {
            this.resultList.add(result);
        }

        public List<Result> getResultsByStudent(Student s)
        {
         List<Result>studentR=new ArrayList<>();
            for(Result r:resultList)
            {
                if(r.getStudent().equals(s))
                {
                    studentR.add(r);
                }
            }
            return studentR;
        }
        public double getTotalScoreByStudent(Student s){
            double Score=0;
            for(Result res:resultList)
            {
                if(res.getStudent().equals(s))
                Score+=res.getTotalScore();
            }
            return Score;
        }
    }

    public static class Question{
        private Integer qID;
        private List<String> Answer;
        private Integer answerKey;
        private Integer scoreOfQuestions;
        private Integer techstackId;
        private Integer aID;
        
        Question(int id,List<String>answers,int ans,int scoreOfQ,TechStack t,int ass)
        {
            this.qID=id;
            this.Answer=answers;
            this.answerKey=ans;
            this.scoreOfQuestions=scoreOfQ;
            this.techstackId=t.getId();
            this.aID=ass;
        }

        public Integer getScore(){
            return scoreOfQuestions;
        }

    }
    

    public static void HighestPerfomingStudents(List<Student>s,ResultsData r)
    {
        Student highestPerformingStudent=null;
        double highestPercentage=0;
        for(Student stu:s){
            List<Result>R=r.getResultsByStudent(stu);
            double Score=0;
            for(Result res:R)
            {
                Score+=res.getTotalScore();
            }
            double percentage=(Score/(1600))*100;
            if (percentage > highestPercentage) {
                highestPercentage = percentage;
                highestPerformingStudent = stu;
            }
        }
        System.out.println("Highest Performing Student: " + highestPerformingStudent.getName() +
                ", Percentage: " + highestPercentage + "%\n");
    }

    public static void SecondsHighestPerfomingStudents(List<Student>s,ResultsData r)
    {
        Student highestPerformingStudent=null;
        Student secondHighestPerformingStudent=null;

        double highestPercentage=0;
        double secondHighestPercentage=0;
        for(Student stu:s){
            
            List<Result>R=r.getResultsByStudent(stu);
            double Score=0;
            for(Result res:R)
            {
                Score+=res.getTotalScore();
            }
            double percentage=(Score/1600)*100;
            if (percentage > highestPercentage) {
                secondHighestPercentage=highestPercentage;
                highestPercentage = percentage;

                secondHighestPerformingStudent=highestPerformingStudent;
                highestPerformingStudent = stu;
            }
            else if (percentage > secondHighestPercentage) {
                secondHighestPercentage = percentage;
                secondHighestPerformingStudent = stu;
            }   

        }
        System.out.println("Second Highest Performing Student: " + secondHighestPerformingStudent.getName() +
                ", Percentage: " + secondHighestPercentage + "%");
    }

    public static void findOverAllRanking(List<Student>students,ResultsData resData)
    {
        List<Student>rankList=new ArrayList<>(students);
        rankList.sort((s1,s2)->{
            double score1=resData.getTotalScoreByStudent(s1);
            double score2=resData.getTotalScoreByStudent(s2);
            return Double.compare(score2, score1);
        });    
        int rank=1;
        System.out.println("Overall Ranking of Students: ");
        for(Student stu:rankList)
        {
            double totalScore = resData.getTotalScoreByStudent(stu);
            double percentage = (totalScore / (1600)) * 100;
            System.out.println(rank + ". " + stu.getName() + ", Percentage: " + percentage + "%");
            rank++;
        }
        System.out.println();
    }


    public static void ScoreLessThan60(List<Student>students,ResultsData resData)
    {
        System.out.println("Student Needing Imporvement (Less Than 60%)");

        for(Student stu:students)
        {
            double score=resData.getTotalScoreByStudent(stu);
            double percentage=(score/1600)*100;
            if(percentage<60)
            {
                System.out.println(stu.getName()+", Percentage: "+percentage+" %");
            }
        }
    }

    public static void getResultOfStudent(String StudentName,List<Student>s,ResultsData resultsData)
    {
        Student stud=null;
        for(Student stu:s)
        {
            if(stu.getName()==StudentName)
            {
                stud=stu;
            }
        }

        if(stud==null)
        {
            System.out.println("Student with name " + stud.getName() + " not found.");
        }
        else{
            List<Result> ResultOfStudent=resultsData.getResultsByStudent(stud);
            System.out.println("Results for " + stud.getName() + ":");
            for(Result res:ResultOfStudent)
            {
                System.out.println("Assignment: " + res.getAssignment().getTitle() +", Score: " + res.getTotalScore()
                + ", Feedback: " + res.getFeedback());
            }
        }
    }


    public static void getResultAndScoreOfIndiv(List<Student>s,ResultsData resultsData)
    {   
        System.out.println("Student's Results and their scores on All Individual Assignments");
       for(Student stu:s)
        {
                List<Result>results=resultsData.getResultsByStudent(stu);
                System.out.println("Student Name: "+stu.getName());
                for(Result res:results)
                {
                    int QueScore=res.getTotalScore()/4;
                    System.out.println("Assignment: "+res.getAssignment().getId()+" No. of Question in Assignment: "
                    +res.getAssignment().getQuestions().size()+"  Total Score on Assignments: "+res.getTotalScore()
                    +" Score in question 1: "+QueScore
                    +" Score in question 2: "+QueScore
                    +" Score in question 3: "+QueScore
                    +" Score in question 4: "+QueScore
                    +" \n");
                }
        }

    }    

    public static List<Question> createDummyQuestions(List<TechStack>techstacks,List<Assignment>assignments){
        List<Question>questions=new ArrayList<>();

        for(int i=0;i<4;i++)
        {
            questions.add(new Question(1, Arrays.asList("A", "B","C","D"),1,100, techstacks.get(i),i));
        } 
        return questions;
    }
    public static void main(String[] args)
    {

        List<Student>students=new ArrayList<>();
        List<String>name=Arrays.asList("Fidyan","Rohan","Utsav","Aanchal","Niti","Vatsal","Kunal","Moksha","Prashant","Aman");
        for (int i=0;i<name.size();i++)
        {
            students.add(new Student( i, name.get(i) ,name.get(i)+"@gmail.com", 999999999));
        }


        List<Trainer>trainers=new ArrayList<>();
        trainers.add(new Trainer(1, "Ritu","Ritu@gmail.com", 999999999,Arrays.asList("Python","Java")));
        trainers.add(new Trainer(2, "Krishna","Krishna@gmail.com", 999999999,Arrays.asList("C++","Java")));
        trainers.add(new Trainer(3, "Rishabh","Rishabh@gmail.com", 999999999,Arrays.asList("Python","Java","C++")));


        List<TechStack>techstacks=new ArrayList<>();
        techstacks.add(new TechStack(1, "Java","Language"));
        techstacks.add(new TechStack(2, "Python","Language")); 
        techstacks.add(new TechStack(3, "C++","Language"));
        techstacks.add(new TechStack(3, "React","Framework"));
        techstacks.add(new TechStack(5, "Java","Language"));

        

        List<Assignment>assignments=new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            List<Question> questions = createDummyQuestions(techstacks,assignments);
            assignments.add(new Assignment( i, "Assignment" + i, "Description" + i, new Date(), questions));
        }
        

        ResultsData resultsData = new ResultsData();

        List<Integer>Scores=Arrays.asList(
            310,380,285,400,340,355,250,330,340,250,300,250,230,310,390,420,200,270,220,250,320,370,250,350,300,350,200,400,310,340,250,390,340,250,240,380,320,340,250,340);
        int scoreIndex=0;
        for (Student student : students) {
            for (Assignment assignment : assignments) {
                Trainer trainer = trainers.get((int) (Math.random() * trainers.size()));
                int score=0;
                score+=Scores.get(scoreIndex);
                scoreIndex++;
                String feedback = "Feedback for assignment " + assignment.getId();
                Date submissionDate = new Date();
                Result result = new Result(1,student, assignment, trainer, score, feedback, submissionDate);
                resultsData.addResult(result);
            }
        }
        HighestPerfomingStudents(students,resultsData);

        SecondsHighestPerfomingStudents(students,resultsData);
        
        findOverAllRanking(students, resultsData);
 
        ScoreLessThan60(students, resultsData);
        
        getResultOfStudent("Rohan", students, resultsData);

        getResultAndScoreOfIndiv(students,resultsData);
        
        }
}
