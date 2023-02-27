package qlhv.model;

import java.io.Serializable;
import java.sql.*;

public class HocVien implements Serializable {
	private String Ma_Hoc_Vien;
	private String Ho_Ten;
	private Date Ngay_Sinh;
	private String So_Dien_Thoai;
	private String Dia_Chi;
	private String Ma_Lop_Hoc;
	private boolean Gioi_Tinh;
	private boolean Tinh_trang;
	public String getMa_Hoc_Vien() {
		return Ma_Hoc_Vien;
	}
	public void setMa_Hoc_Vien(String ma_Hoc_Vien) {
		Ma_Hoc_Vien = ma_Hoc_Vien;
	}
	public String getHo_Ten() {
		return Ho_Ten;
	}
	public void setHo_Ten(String ho_Ten) {
		Ho_Ten = ho_Ten;
	}
	public Date getNgay_Sinh() {
		return Ngay_Sinh;
	}
	public void setNgay_Sinh(Date ngay_Sinh) {
		Ngay_Sinh = ngay_Sinh;
	}
	public String getSo_Dien_Thoai() {
		return So_Dien_Thoai;
	}
	public void setSo_Dien_Thoai(String so_Dien_Thoai) {
		So_Dien_Thoai = so_Dien_Thoai;
	}
	public String getDia_Chi() {
		return Dia_Chi;
	}
	public void setDia_Chi(String dia_Chi) {
		Dia_Chi = dia_Chi;	
	}
	public String getMa_Lop_Hoc() {
		return Ma_Lop_Hoc;
	}
	public void setMa_Lop_Hoc(String ma_Lop_Hoc) {
		Ma_Lop_Hoc = ma_Lop_Hoc;
	}
	public boolean isGioi_Tinh() {
		return Gioi_Tinh;
	}
	public void setGioi_Tinh(boolean gioi_Tinh) {
		Gioi_Tinh = gioi_Tinh;
	}
	public boolean isTinh_trang() {
		return Tinh_trang;
	}
	public void setTinh_trang(boolean tinh_trang) {
		Tinh_trang = tinh_trang;
	}
	
}
