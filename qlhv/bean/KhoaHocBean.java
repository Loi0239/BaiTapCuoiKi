package qlhv.bean;

import java.util.Date;

public class KhoaHocBean {
	private String MaKhoaHoc;
	private Date NgayBatDau;
	private Date NgayKetThuc;
	
	public KhoaHocBean() {
	}
	public KhoaHocBean(String tenKhoaHoc, Date ngayBatDau, Date ngayKetThuc) {
		MaKhoaHoc = tenKhoaHoc;
		NgayBatDau = ngayBatDau;
		NgayKetThuc = ngayKetThuc;
	}
	
	public String getMaKhoaHoc() {
		return MaKhoaHoc;
	}
	public void setMaKhoaHoc(String maKhoaHoc) {
		MaKhoaHoc = maKhoaHoc;
	}
	public Date getNgayBatDau() {
		return NgayBatDau;
	}
	public void setNgayBatDau(Date ngayBatDau) {
		NgayBatDau = ngayBatDau;
	}
	public Date getNgayKetThuc() {
		return NgayKetThuc;
	}
	public void setNgayKetThuc(Date ngayKetThuc) {
		NgayKetThuc = ngayKetThuc;
	}
	
}
