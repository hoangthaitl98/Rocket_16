package com.vti.entity;

public class CanBo {
    private String hoTen;
    private int tuoi;
    private gioiTinh sex;
    public enum gioiTinh{
        nam, nu, khac
    }
    private String diaChi;

    public CanBo() {
    }

    public CanBo(String hoTen, int tuoi, gioiTinh sex, String diaChi) {
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        this.sex = sex;
        this.diaChi = diaChi;
    }

    public gioiTinh getSex() {
        return sex;
    }

    public void setSex(gioiTinh sex) {
        this.sex = sex;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Override
    public String toString() {
        return "CanBo{" +
                "hoTen='" + hoTen + '\'' +
                ", tuoi=" + tuoi +
                ", sex=" + sex +
                ", diaChi='" + diaChi + '\'' +
                '}';
    }
}
