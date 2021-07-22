package com.vti.entity;

public class NhanVien extends CanBo{
    private String congViec;

    public NhanVien() {
    }

    public NhanVien(String hoTen, int tuoi, gioiTinh sex, String diaChi) {
        super(hoTen, tuoi, sex, diaChi);
    }

    public String getCongViec() {
        return congViec;
    }

    public void setCongViec(String congViec) {
        this.congViec = congViec;
    }
}
