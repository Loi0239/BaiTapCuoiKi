package qlhv.dao;

import java.sql.*;
import java.sql.Date;
import java.util.*;
import lib.connect;
import qlhv.model.HocVien;

public class HocVienDAOImpl implements HocVienDAO{

	@Override
	public List<HocVien> getList() throws SQLException {
		Connection conn = DBConnect.getConnec();
		String sql = "SELECT * FROM qlhv.hoc_vien;";
		List<HocVien> list = new ArrayList<>();
		PreparedStatement PrSta = conn.prepareCall(sql);
		ResultSet rs = PrSta.executeQuery();
		while (rs.next()) {
			HocVien hocvien = new HocVien();
			hocvien.setMa_Hoc_Vien(rs.getString("Mã_HV"));
			hocvien.setHo_Ten(rs.getString("Họ_Tên"));
			hocvien.setNgay_Sinh(rs.getDate("Ngày_Sinh"));
			hocvien.setGioi_Tinh(rs.getBoolean("Giới_Tính"));
			hocvien.setSo_Dien_Thoai(rs.getString("SĐT"));
			hocvien.setDia_Chi(rs.getString("Địa_Chỉ"));
			hocvien.setMa_Lop_Hoc(rs.getString("Mã_Lớp"));
			hocvien.setTinh_trang(rs.getBoolean("Tình_Trạng"));
			list.add(hocvien);
		}
		PrSta.close();
		rs.close();
		conn.close();
		return list;
	}

	@Override
	public boolean create(HocVien hocVien) throws SQLException {
		String sql = "INSERT INTO qlhv.hoc_vien(Mã_HV, Họ_Tên, Ngày_Sinh, Giới_Tính, SĐT, Địa_Chỉ, Mã_Lớp, Tình_Trạng) VALUES(?, ?, ?, ? , ?, ?, ?, ?)";
		try(
				Connection conn = new DBConnect().getConnec();
				PreparedStatement pre = conn.prepareStatement(sql);
			){
			pre.setString(1, hocVien.getMa_Hoc_Vien());
			pre.setString(2, hocVien.getHo_Ten());
			pre.setDate(3, hocVien.getNgay_Sinh());
			pre.setBoolean(4, hocVien.isGioi_Tinh());
			pre.setString(5, hocVien.getSo_Dien_Thoai());
			pre.setString(6, hocVien.getDia_Chi());
			pre.setString(7, hocVien.getMa_Lop_Hoc());
			pre.setBoolean(8, hocVien.isTinh_trang());
			
			return pre.executeUpdate() > 0;
		}
	}
	
	@Override
	public boolean delete(String MaHV) throws SQLException {
		String sql = "DELETE FROM qlhv.hoc_vien WHERE Mã_HV = ?";
		try(
				Connection conn = new DBConnect().getConnec();
				PreparedStatement pre = conn.prepareStatement(sql);
			){
			pre.setString(1, MaHV);
			
			return pre.executeUpdate() > 0;
		}
	}
	
	@Override
	public boolean update(HocVien hocVien) throws SQLException {
		String sql = "UPDATE qlhv.hoc_vien SET Họ_Tên = ?, Ngày_Sinh = ?, Giới_Tính = ?, SĐT = ?, Địa_Chỉ = ?, Mã_Lớp = ?, Tình_Trạng = ? WHERE Mã_HV = ?;";
		try(
				Connection conn = new DBConnect().getConnec();
				PreparedStatement pre = conn.prepareStatement(sql);
			){
			pre.setString(1, hocVien.getHo_Ten());
			pre.setDate(2, hocVien.getNgay_Sinh());
			pre.setBoolean(3, hocVien.isGioi_Tinh());
			pre.setString(4, hocVien.getSo_Dien_Thoai());
			pre.setString(5, hocVien.getDia_Chi());
			pre.setString(6, hocVien.getMa_Hoc_Vien());
			pre.setBoolean(7, hocVien.isTinh_trang());
			pre.setString(8, hocVien.getMa_Hoc_Vien());
			
			return pre.executeUpdate() > 0;
		}
	}
	
}
