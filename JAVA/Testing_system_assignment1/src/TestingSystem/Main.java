package TestingSystem;

public class Main {
    public static void main(String[] args) {
        // Account
        Account account1 = new Account(1,"nguyenvana@gmail.com", "nguyenvana", "Nguyen Van A",
                1, 1, "01/01/2021");
        Account account2 = new Account(2,"nguyenvanb@gmail.com", "nguyenvanb", "Nguyen Van B",
                1, 1, "01/01/2021");
        Account account3 = new Account(3,"nguyenvanc@gmail.com", "nguyenvanc", "Nguyen Van C",
                1, 1, "01/01/2021");

        // Answer
        Answer answer1 = new Answer(1, "Tra loi 1", 1, true);
        Answer answer2 = new Answer(2, "Tra loi 2", 2, true);
        Answer answer3 = new Answer(3, "Tra loi 3", 3, true);

        // CategoryQuestion
        CategoryQuestion categoryQuestion1 = new CategoryQuestion(1, "Java");
        CategoryQuestion categoryQuestion2 = new CategoryQuestion(2, "SQL");
        CategoryQuestion categoryQuestion3 = new CategoryQuestion(3, "c++");

        // Department
        Department department1 = new Department(1, "Phong Sale");
        Department department2 = new Department(2, "Phong Marketing");
        Department department3 = new Department(3, "Phong Nhan su");

        //Exam
        Exam exam1 = new Exam(1, "VTIQ001", "JAVA",60, 1, 1, "01/01/2021");
        Exam exam2 = new Exam(2, "VTIQ002", "SQL",60, 1, 1, "02/01/2021");
        Exam exam3 = new Exam(3, "VTIQ003", "C#",60, 1, 1, "03/01/2021");

        //ExamQuestion
        ExamQuestion examQuestion1 = new ExamQuestion(1, 1);
        ExamQuestion examQuestion2 = new ExamQuestion(2, 2);
        ExamQuestion examQuestion3 = new ExamQuestion(3, 3);

        //Group
        Group group1 = new Group(1, "Nhom1", 1, "01/01/2021");
        Group group2 = new Group(2, "Nhom2", 2, "02/01/2021");
        Group group3 = new Group(3, "Nhom3", 3, "03/01/2021");

        //GroupAccount
        GroupAccount groupAccount1 = new GroupAccount(1,1, "01/01/2021");
        GroupAccount groupAccount2 = new GroupAccount(2,2, "02/01/2021");
        GroupAccount groupAccount3 = new GroupAccount(3,3, "03/01/2021");

        //Position
        Position position1 = new Position(1, PositionName.dev);
        Position position2 = new Position(2, PositionName.test);
        Position position3 = new Position(3, PositionName.pm);

        //Question
        Question question1 = new Question(1, "cau hoi JAVA", 1, 1, 1, "01/01/2021");
        Question question2 = new Question(2, "cau hoi SQL", 2, 2, 2, "02/01/2021");
        Question question3 = new Question(3, "cau hoi C#", 3, 3, 3, "03/01/2021");

        //TypeQuestion
        TypeQuestion typeQuestion1 = new TypeQuestion(1, "essay");
        TypeQuestion typeQuestion2 = new TypeQuestion(2, "muliple-choice");
    }
}
