package com.vti.frontend;

import com.vti.backend.Exercise1;
import com.vti.entity.SinhVien;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Program {
    public static void main(String[] args) {
        Set<SinhVien> sinhVienSet = new LinkedHashSet<SinhVien>();
        Exercise1 exercise1 = new Exercise1();
        exercise1.question3(sinhVienSet);
    }
}
