package qlhv.dao;

import java.sql.*; 
import java.sql.Date;
import java.util.*;
import lib.connect;
import qlhv.model.LopHoc;

public class LopHocDAOImpl implements LopHocDAO{

	@Override
	public List<LopHoc> getList() throws SQLException {
		Connection conn = DBConnect.getConnec();
		String sql = "SELECT * FROM qlhv.lop_hoc;";
		List<LopHoc> list = new ArrayList<>();
		PreparedStatement PrSta = conn.prepareCall(sql);
		ResultSet rs = PrSta.executeQuery();
		while (rs.next()) {
			LopHoc lopHoc = new LopHoc();
			lopHoc.setMa_Lop_Hoc(rs.getString("Mã_Lớp_Học"));
			lopHoc.setTen_Lop_Hoc(rs.getString("Tên_LH"));
			lopHoc.setMa_Khoa_Hoc(rs.getString("Mã_KH"));
			lopHoc.setHoc_Phi(rs.getString("Học_Phí"));
			lopHoc.setTinh_Trang(rs.getBoolean("Tình_Trạng"));
			list.add(lopHoc);
		}
		PrSta.close();
		rs.close();
		conn.close();
		return list;
	}

	@Override
	public boolean create(LopHoc lopHoc) throws SQLException {
		String sql = "INSERT INTO qlhv.lop_hoc(Mã_Lớp_Học, Tên_LH, Mã_KH, Học_Phí, Tình_Trạng) VALUES(?, ?, ?, ?, ?)";
		try(
				Connection conn = new DBConnect().getConnec();
				PreparedStatement pre = conn.prepareStatement(sql);
			){
			pre.setString(1, lopHoc.getMa_Lop_Hoc());
			pre.setString(2, lopHoc.getTen_Lop_Hoc());
			pre.setString(3, lopHoc.getMa_Khoa_Hoc());
			pre.setString(4, lopHoc.getHoc_Phi());
			pre.setBoolean(5, lopHoc.isTinh_Trang());
			
			return pre.executeUpdate() > 0;
		}
	}
	
	@Override
	public boolean delete(String MaLH) throws SQLException {
		String sql = "DELETE FROM qlhv.lop_hoc WHERE Mã_Lớp_Học = ?";
		try(
				Connection conn = new DBConnect().getConnec();
				PreparedStatement pre = conn.prepareStatement(sql);
			){
			pre.setString(1, MaLH);
			
			return pre.executeUpdate() > 0;
		}
	}
	
	@Override
	public boolean update(LopHoc lopHoc) throws SQLException {
		String sql = "UPDATE qlhv.lop_hoc SET Tên_LH = ?, Mã_KH = ?, Học_Phí = ?, Tình_Trạng = ? WHERE Mã_Lớp_Học = ?;";
		try(
				Connection conn = new DBConnect().getConnec();
				PreparedStatement pre = conn.prepareStatement(sql);
			){
			pre.setString(1, lopHoc.getTen_Lop_Hoc());
			pre.setString(2, lopHoc.getMa_Khoa_Hoc());
			pre.setString(3, lopHoc.getHoc_Phi());
			pre.setBoolean(4, lopHoc.isTinh_Trang());
			pre.setString(5, lopHoc.getMa_Lop_Hoc());
			
			return pre.executeUpdate() > 0;
		}
	}
	
}
