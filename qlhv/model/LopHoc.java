package qlhv.model;

import java.io.Serializable;
import java.sql.*;

public class LopHoc implements Serializable{
	private String Ma_Lop_Hoc;
	private String Ten_Lop_Hoc;
	private String Ma_Khoa_Hoc;
	private String Hoc_Phi;
	private boolean Tinh_Trang;
	public String getMa_Lop_Hoc() {
		return Ma_Lop_Hoc;
	}
	public void setMa_Lop_Hoc(String ma_Lop_Hoc) {
		Ma_Lop_Hoc = ma_Lop_Hoc;
	}
	public String getTen_Lop_Hoc() {
		return Ten_Lop_Hoc;
	}
	public void setTen_Lop_Hoc(String ten_Lop_Hoc) {
		Ten_Lop_Hoc = ten_Lop_Hoc;
	}
	public String getMa_Khoa_Hoc() {
		return Ma_Khoa_Hoc;
	}
	public void setMa_Khoa_Hoc(String ma_Khoa_Hoc) {
		Ma_Khoa_Hoc = ma_Khoa_Hoc;
	}
	public String getHoc_Phi() {
		return Hoc_Phi;
	}
	public void setHoc_Phi(String hoc_Phi) {
		Hoc_Phi = hoc_Phi;
	}
	public boolean isTinh_Trang() {
		return Tinh_Trang;
	}
	public void setTinh_Trang(boolean tinh_Trang) {
		Tinh_Trang = tinh_Trang;
	}
}
