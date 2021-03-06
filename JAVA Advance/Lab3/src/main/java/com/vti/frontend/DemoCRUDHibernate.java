package com.vti.frontend;

import java.util.List;
import java.util.Scanner;

import com.vti.entity.Department;
import com.vti.repository.DepartmentRepository;

public class DemoCRUDHibernate {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            int choose = menu();
            switch (choose) {
                case 1:
                    showAllDepartmet();
                    break;
                case 2:
                    System.out.println("Nhập vào ID của phòng ban");
                    short id = scanner.nextShort();
                    showDepartmentByID(id);
                    break;
                case 3:
                    System.out.println("Nhập vào tên phòng ban cần tìm kiếm");
                    String nameDep = scanner.nextLine();
                    showDepartmentByName(nameDep);
                    break;
                case 4:
                    System.out.println("Tạo mới phòng ban");
                    System.out.println("Nhập tên phòng cần tạo:");
                    String nameDepCreate = scanner.nextLine();
                    Department dep = new Department();
                    dep.setName(nameDepCreate);
                    createDep(dep);
                    showAllDepartmet();
                    break;
                default:
                    System.out.println("Nhập lại:");
                    break;
            }
        }
    }

    private static void createDep(Department dep) {
        DepartmentRepository depRepository = new DepartmentRepository();
        depRepository.createDepartment(dep);
    }

    private static void showDepartmentByName(String nameDep) {
        DepartmentRepository depRepository = new DepartmentRepository();
        Department depByName = depRepository.getDepartmentByName(nameDep);
        if (depByName == null) {
            System.out.println("Không có phòng ban này trên hệ thống");
        } else {
            String leftAlignFormat = "| %-5s | %-25s |%n";
            System.out.format("+-------+---------------------------+%n");
            System.out.format("| ID | Name |%n");
            System.out.format("+-------+---------------------------+%n");
            System.out.format(leftAlignFormat, depByName.getId(), depByName.getName());
        }
    }

    private static void showDepartmentByID(Short id) {
        DepartmentRepository depRepository = new DepartmentRepository();
        Department dep = depRepository.getDepartmentById(id);
        String leftAlignFormat = "| %-5s | %-25s |%n";
        System.out.format("+-------+---------------------------+%n");
        System.out.format("| ID | Name |%n");
        System.out.format("+-------+---------------------------+%n");
        System.out.format(leftAlignFormat, dep.getId(), dep.getName());
    }

    private static void showAllDepartmet() {
        System.out.println("Danh sách phòng ban trên hệ thống");
        DepartmentRepository depRepository = new DepartmentRepository();
        List<Department> listDep = depRepository.getAllDepartment();
        String leftAlignFormat = "| %-5s | %-25s |%n";
        System.out.format("+-------+---------------------------+%n");
        System.out.format("| ID | Name |%n");
        System.out.format("+-------+---------------------------+%n");
        for (Department department : listDep) {
            System.out.format(leftAlignFormat, department.getId(),
                    department.getName());
        }
    }

    @SuppressWarnings("resource")
    private static int menu() {
        while (true) {
            System.out.println("------MỜI BẠN CHỌN CHỨC NĂNG------");
            String leftAlignFormat = "| %-72s |%n";
            System.out.format("+-------------------------------------------------------------------------- + %n");
            System.out.format("| Choose please |%n");
            System.out.format("+------------------------------------------------------------------------- - + %n");
            System.out.format(leftAlignFormat, "1. Lấy danh sách tất cả các phòng ban trên hệ thống");
            System.out.format(leftAlignFormat, "2. Tìm phòng ban theo ID");
            System.out.format(leftAlignFormat, "3. Tìm phòng ban theo Name");
            System.out.format(leftAlignFormat, "4. Tạo mới 1 phòng");
            System.out.format("+-------------------------------------------------------------------------- + %n");
            Scanner sc = new Scanner(System.in);
            if (sc.hasNextInt()) {
                int i = sc.nextInt();
                if ((i == 1) || (i == 2) || (i == 3) || (i == 4)) {
                    return i;
                } else {
                    System.out.println("Nhập lại");
                }
            } else {
                System.out.println("Nhập lại");
            }
        }
    }
}
