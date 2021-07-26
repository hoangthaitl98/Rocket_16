package com.vti.frontend;

import com.vti.entity.HinhVuong;

public class MySquare {
    public static void main(String[] args) {
        HinhVuong hinhVuong = new HinhVuong(10);
        System.out.println("Chu vi: " + hinhVuong.tinhChuVi());
        System.out.println("Dien tich: " + hinhVuong.tinhDienTich());
    }
}
