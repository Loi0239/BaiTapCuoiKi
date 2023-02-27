package qlhv.bean;

public class LopHocBean {
	private String TenLopHoc;
	private int SoLuongLopHoc;
	
	public LopHocBean() {
	}
	public LopHocBean(String tenLopHoc, int soLuongLopHoc) {
		TenLopHoc = tenLopHoc;
		SoLuongLopHoc = soLuongLopHoc;
	}

	public String getTenLopHoc() {
		return TenLopHoc;
	}
	public void setTenLopHoc(String tenLopHoc) {
		TenLopHoc = tenLopHoc;
	}
	public int getSoLuongLopHoc() {
		return SoLuongLopHoc;
	}
	public void setSoLuongLopHoc(int soLuongLopHoc) {
		SoLuongLopHoc = soLuongLopHoc;
	}
}
