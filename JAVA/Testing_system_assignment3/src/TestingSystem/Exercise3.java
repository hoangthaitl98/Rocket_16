package TestingSystem;

public class Exercise3 {
    public static void main(String[] args) {
        question1();
        System.out.println();
        question2();
        System.out.println();
        question3();
    }

    public static void question1(){
        Integer luong = new Integer(5000);
        int salary = luong;
        System.out.printf("luong: %.2f", (float)salary);
    }

    public static void question2(){
        String temp = "1234567";
        System.out.println(Integer.valueOf(temp));
    }

    public static void question3(){
        Integer temp = new Integer("1234567");
        int newNum = Integer.valueOf(temp);
        System.out.println(newNum);
    }
}
