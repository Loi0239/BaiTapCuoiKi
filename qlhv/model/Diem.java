package qlhv.model;

import java.io.Serializable;

public class Diem implements Serializable{
	private String Ma_Hoc_Vien;
	private String Ma_Khoa_Hoc;
	private float Diem;
	private String Ket_Qua;
	public String getMa_Hoc_Vien() {
		return Ma_Hoc_Vien;
	}
	public void setMa_Hoc_Vien(String ma_Hoc_Vien) {
		Ma_Hoc_Vien = ma_Hoc_Vien;
	}
	public String getMa_Khoa_Hoc() {
		return Ma_Khoa_Hoc;
	}
	public void setMa_Khoa_Hoc(String ma_Khoa_Hoc) {
		Ma_Khoa_Hoc = ma_Khoa_Hoc;
	}
	public float getDiem() {
		return Diem;
	}
	public void setDiem(float diem) {
		Diem = diem;
	}
	public String getKet_Qua() {
		return Ket_Qua;
	}
	public void setKet_Qua(String ket_Qua) {
		Ket_Qua = ket_Qua;
	}
}
