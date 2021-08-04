package com.vti.backend;

import com.vti.entity.SinhVien;
import com.vti.entity.Student;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Exercise1 {
    static Scanner input = new Scanner(System.in);

    public void question3(Set<SinhVien> sinhVienSet) {
        SinhVien sinhVien1 = new SinhVien(1, "Nguyen Van A");
        SinhVien sinhVien2 = new SinhVien(2, "Nguyen Van B");
        SinhVien sinhVien3 = new SinhVien(3, "Nguyen Van C");
        SinhVien sinhVien4 = new SinhVien(4, "Nguyen Van D");
        sinhVienSet.add(sinhVien1);
        sinhVienSet.add(sinhVien2);
        sinhVienSet.add(sinhVien3);
        sinhVienSet.add(sinhVien4);

        Object[] sv = sinhVienSet.toArray();

        Iterator<SinhVien> sinhVienIterator = sinhVienSet.iterator();

        //in so phan tu
        System.out.println("So phan tu cua set: " + sinhVienSet.size());

        //Lay phan tu thu 4
        for (int i = 0; i < 2; i++) {
            sinhVienIterator.next();
        }
        System.out.println("Phan tu thu 4: " + sinhVienIterator.next().toString());

        //In phan tu dau va cuoi
        System.out.println("Phan tu dau: " + sv[0].toString());
        System.out.println("Phan tu cuoi: " + sv[3].toString());

        for (int i = 0; i < sinhVienSet.size(); i++) {
            System.out.println(sv[i].toString());
        }

        //Tim kiem theo id
        searchById(sinhVienSet);
        input.nextLine();
        //Tim kiem theo ten
        searchByName(sinhVienSet);

        //Delete theo id
        deleteById(sinhVienSet);
    }

    public void searchById(Set<SinhVien> sinhVienSet) {
        System.out.print("Nhap id can tim: ");
        int idSearch = input.nextInt();
        Iterator<SinhVien> sinhVienIterator = sinhVienSet.iterator();
        for (int i = 0; i < sinhVienSet.size(); i++) {
            SinhVien temp = sinhVienIterator.next();
            if (temp.getId() == idSearch) {
                System.out.println("Tim thay");
            }
        }
    }

    public void searchByName(Set<SinhVien> sinhVienSet) {
        System.out.print("Nhap ten can tim: ");
        String nameSearch = input.nextLine();
        Iterator<SinhVien> sinhVienIterator = sinhVienSet.iterator();
        for (int i = 0; i < sinhVienSet.size(); i++) {
            if (sinhVienIterator.next().getName().equalsIgnoreCase(nameSearch)) {
                System.out.println("Tim thay");
            }
        }
    }

    public void deleteById(Set<SinhVien> sinhVienSet){
        System.out.print("Nhap id muon xoa: ");
        int idDelete = input.nextInt();
        Iterator<SinhVien> sinhVienIterator = sinhVienSet.iterator();
        for (int i = 0; i < sinhVienSet.size(); i++) {
            SinhVien temp = sinhVienIterator.next();
            if (temp.getId() == idDelete){
                temp.setName(null);
            }
        }
    }
}
