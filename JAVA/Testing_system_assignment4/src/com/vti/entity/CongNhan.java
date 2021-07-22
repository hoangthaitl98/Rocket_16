package com.vti.entity;

public class CongNhan extends CanBo{
    private int bac;

    public CongNhan() {
    }

    public CongNhan(String hoTen, int tuoi, CanBo.gioiTinh sex, String diaChi, int bac) {
        super(hoTen, tuoi, sex, diaChi);
        this.bac = bac;
    }

    public int getBac() {
        return bac;
    }

    public void setBac(int bac) {
        this.bac = bac;
    }
}
