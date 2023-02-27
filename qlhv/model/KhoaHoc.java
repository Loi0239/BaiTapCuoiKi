package qlhv.model;

import java.io.Serializable;
import java.sql.*;

public class KhoaHoc implements Serializable{
	private String Ma_Khoa_Hoc;
	private String Ten_Khoa_Hoc;
	private String Mo_Ta;
	private Date Ngay_Bat_Dau;
	private Date Ngay_Ket_Thuc;
	private boolean Tinh_Trang;
	public String getMa_Khoa_Hoc() {
		return Ma_Khoa_Hoc;
	}
	public void setMa_Khoa_Hoc(String ma_Khoa_Hoc) {
		Ma_Khoa_Hoc = ma_Khoa_Hoc;
	}
	public String getTen_Khoa_Hoc() {
		return Ten_Khoa_Hoc;
	}
	public void setTen_Khoa_Hoc(String ten_Khoa_Hoc) {
		Ten_Khoa_Hoc = ten_Khoa_Hoc;
	}
	public String getMo_Ta() {
		return Mo_Ta;
	}
	public void setMo_Ta(String mo_Ta) {
		Mo_Ta = mo_Ta;
	}
	public Date getNgay_Bat_Dau() {
		return Ngay_Bat_Dau;
	}
	public void setNgay_Bat_Dau(Date ngay_Bat_Dau) {
		Ngay_Bat_Dau = ngay_Bat_Dau;
	}
	public Date getNgay_Ket_Thuc() {
		return Ngay_Ket_Thuc;
	}
	public void setNgay_Ket_Thuc(Date ngay_Ket_Thuc) {
		Ngay_Ket_Thuc = ngay_Ket_Thuc;
	}
	public boolean isTinh_Trang() {
		return Tinh_Trang;
	}
	public void setTinh_Trang(boolean tinh_Trang) {
		Tinh_Trang = tinh_Trang;
	}
}
