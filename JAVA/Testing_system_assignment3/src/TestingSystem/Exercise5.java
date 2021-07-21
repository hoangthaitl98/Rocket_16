package TestingSystem;

import java.util.Arrays;

public class Exercise5 {
    public static void main(String[] args) {
        Department[] departments = new Department[5];
        for (int i = 0 ; i < 5; i++){
            departments[i] = new Department();
        }
        departments[0].name = "Phong e";
        departments[1].name = "Phong a";
        departments[2].name = "Phong d";
        departments[3].name = "Phong b";
        departments[4].name = "Phong c";
        departments[0].id = 1;
        departments[1].id = 2;
        departments[2].id = 3;
        departments[3].id = 4;
        departments[4].id = 5;
        //question1(departments);
        //question2(departments);
        //question3(departments);
        //question4(departments);
        //question5(departments);
        question6(departments);
    }

    public static void question1(Department[] department) {
        System.out.println(department[0].toString());
    }

    public static void question2(Department[] department) {
        for (int i = 0; i < department.length; i++){
            System.out.println(department[i].toString());
        }
    }

    public static void question3(Department[] department){
        System.out.println(department[0].hashCode());
    }

    public static void question4(Department[] department){
        if (department[0].name == "Phong A"){
            System.out.println("Day la phong A");
        }
        else
            System.out.println("Day thi deo");
    }

    public static void question5(Department[] department){
        int check = department[0].compareTo(department[1]);
        if (check == 1)
            System.out.println("2 phong bang nhau");
        else
            System.out.println("2 phong ko bang nhau");
    }

    public static void question6(Department[]  department){
        //sort
        for (int i = 0; i < department.length; i++){
            for (int j = 0; j <department.length - 1; j++){
                if (department[i].name.compareToIgnoreCase(department[j].name) < 0){
                    Department temp = department[i];
                    department[i] = department[j];
                    department[j] = temp;
                }
            }
        }
        for (int i = 0; i < department.length; i++){
            System.out.println(department[i].name);
        }
    }

    public static void question7(Department[] departments){

    }
}
