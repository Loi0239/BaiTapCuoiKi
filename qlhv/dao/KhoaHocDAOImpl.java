package qlhv.dao;

import java.sql.*; 
import java.sql.Date;
import java.util.*;
import lib.connect;
import qlhv.model.KhoaHoc;

public class KhoaHocDAOImpl implements KhoaHocDAO{

	@Override
	public List<KhoaHoc> getList() throws SQLException {
		Connection conn = DBConnect.getConnec();
		String sql = "SELECT * FROM qlhv.khoa_hoc;";
		List<KhoaHoc> list = new ArrayList<>();
		PreparedStatement PrSta = conn.prepareCall(sql);
		ResultSet rs = PrSta.executeQuery();
		while (rs.next()) {
			KhoaHoc khoahoc = new KhoaHoc();
			khoahoc.setMa_Khoa_Hoc(rs.getString("Mã_Khóa_Học"));
			khoahoc.setTen_Khoa_Hoc(rs.getString("Tên_KH"));
			khoahoc.setMo_Ta(rs.getString("Mô_Tả"));
			khoahoc.setNgay_Bat_Dau(rs.getDate("Ngày_BĐ"));
			khoahoc.setNgay_Ket_Thuc(rs.getDate("Ngày_KT"));
			khoahoc.setTinh_Trang(rs.getBoolean("Tình_Trạng"));
			list.add(khoahoc);
		}
		PrSta.close();
		rs.close();
		conn.close();
		return list;
	}

	@Override
	public boolean create(KhoaHoc khoaHoc) throws SQLException {
		String sql = "INSERT INTO qlhv.Khoa_hoc(Mã_Khóa_Học, Tên_KH, Mô_tả, Ngày_BĐ, Ngày_KT, Tình_Trạng) VALUES(?, ?, ?, ?, ?, ?)";
		try(
				Connection conn = new DBConnect().getConnec();
				PreparedStatement pre = conn.prepareStatement(sql);
			){
			pre.setString(1, khoaHoc.getMa_Khoa_Hoc());
			pre.setString(2, khoaHoc.getTen_Khoa_Hoc());
			pre.setString(3, khoaHoc.getMo_Ta());
			pre.setDate(4, khoaHoc.getNgay_Bat_Dau());
			pre.setDate(5, khoaHoc.getNgay_Ket_Thuc());
			pre.setBoolean(6, khoaHoc.isTinh_Trang());
			
			return pre.executeUpdate() > 0;
		}
	}
	
	@Override
	public boolean delete(String MaKH) throws SQLException {
		String sql = "DELETE FROM qlhv.Khoa_hoc WHERE Mã_Khóa_Học = ?";
		try(
				Connection conn = new DBConnect().getConnec();
				PreparedStatement pre = conn.prepareStatement(sql);
			){
			pre.setString(1, MaKH);
			
			return pre.executeUpdate() > 0;
		}
	}
	
	@Override
	public boolean update(KhoaHoc khoaHoc) throws SQLException {
		String sql = "UPDATE qlhv.Khoa_hoc SET Tên_KH = ?, Mô_Tả = ?, Ngày_BĐ = ?, Ngày_KT = ?, Tình_Trạng = ? WHERE Mã_Khóa_Học = ?;";
		try(
				Connection conn = new DBConnect().getConnec();
				PreparedStatement pre = conn.prepareStatement(sql);
			){
			pre.setString(1, khoaHoc.getTen_Khoa_Hoc());
			pre.setString(2, khoaHoc.getMo_Ta());
			pre.setDate(3, khoaHoc.getNgay_Bat_Dau());
			pre.setDate(4, khoaHoc.getNgay_Ket_Thuc());
			pre.setBoolean(5, khoaHoc.isTinh_Trang());
			pre.setString(6, khoaHoc.getMa_Khoa_Hoc());
			
			return pre.executeUpdate() > 0;
		}
	}
	
}
