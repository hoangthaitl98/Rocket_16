package com.vti.entity;

public class KySu extends CanBo{
    private String nganh;

    public KySu() {
    }

    public KySu(String hoTen, int tuoi, gioiTinh sex, String diaChi, String nganh) {
        super(hoTen, tuoi, sex, diaChi);
        this.nganh = nganh;
    }

    public String getNganh() {
        return nganh;
    }

    public void setNganh(String nganh) {
        this.nganh = nganh;
    }
}
