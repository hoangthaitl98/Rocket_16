package com.vti.frontend;

import java.util.List;
import java.util.Scanner;

import com.vti.entity.Department;
import com.vti.repository.DepartmentRepository;

import javax.sound.midi.Soundbank;

public class DemoCRUDHibernate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choose = menu();
        switch (choose) {
            case 1:
                showAllDepartmet();
                break;
            case 2:
                System.out.print("Nhap id: ");
                short idFind = scanner.nextByte();
                showDepartmentById(idFind);
                break;
            case 3:
                System.out.print("Nhap ten phong ban: ");
                String nameFind = scanner.nextLine();
                showDepartmentByName(nameFind);
                break;
            case 4:
                System.out.println("Nhap id: ");
                short idAdd = scanner.nextByte();
                scanner.nextLine();
                System.out.print("Nhap ten: ");
                String nameAdd = scanner.nextLine();
                createDept(idAdd, nameAdd);
                break;
            default:
                break;
        }
    }

    private static void showAllDepartmet() {
        System.out.println("Danh sách phòng ban trên hệ thống");
        DepartmentRepository depRepository = new DepartmentRepository();
        List<Department> listDep = depRepository.getAllDepartment();
        for (Department department : listDep) {

            System.out.println("ID: " + department.getId() + " Name: " +

                    department.getName());
        }
    }

    private static void showDepartmentById(short id){
        DepartmentRepository departmentRepository = new DepartmentRepository();
        System.out.println("Name: " + departmentRepository.getDepartmentById(id).getId() +
                " Name: " + departmentRepository.getDepartmentById(id).getName());
    }

    private static void showDepartmentByName(String name){
        DepartmentRepository departmentRepository = new DepartmentRepository();
        System.out.println("id: " + departmentRepository.getDepartmentByName(name).getId() +
                " Name: " + departmentRepository.getDepartmentByName(name).getName());
    }

    private static void createDept(short id, String name){
        Department department = new Department();
        department.setName(name);
        department.setId(id);
        DepartmentRepository departmentRepository = new DepartmentRepository();
        departmentRepository.createDepartment(department);
    }

    @SuppressWarnings("resource")
    private static int menu() {
        while (true) {
            System.out.println("CHương trình quản lý phòng ban..");
            System.out.println("Mời bạn nhập vào chức năng muốn sử dụng");
            System.out.println("1. Lấy danh sách tất cả các phòng ban trên hệ thống");
            System.out.println("2. Tìm phòng ban theo ID");
            System.out.println("3. Tìm phòng ban theo Name");
            System.out.println("4. Tạo mới 1 phòng");
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