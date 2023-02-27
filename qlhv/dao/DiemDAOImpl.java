package qlhv.dao;

import java.sql.*;
import java.sql.Date;
import java.util.*;
import lib.connect;
import qlhv.model.Diem;
import qlhv.model.HocVien;

public class DiemDAOImpl implements DiemDAO{

	@Override
	public List<Diem> getList() throws SQLException {
		Connection conn = new DBConnect().getConnec();
		String sql = "SELECT * FROM qlhv.diem;";
		List<Diem> list = new ArrayList<>(); 
		PreparedStatement PrSta = conn.prepareCall(sql);
		ResultSet rs = PrSta.executeQuery();
		while (rs.next()) {
			Diem diem = new Diem();
			diem.setMa_Hoc_Vien(rs.getString("Mã_HV"));
			diem.setMa_Khoa_Hoc(rs.getString("Mã_KH"));
			diem.setDiem(rs.getFloat("Điểm"));
			diem.setKet_Qua(rs.getString("KQ"));
			list.add(diem);
		}
		PrSta.close();
		rs.close();
		conn.close();
		return list;
	}

	@Override
	public boolean create(Diem diem) throws SQLException {
		String sql = "INSERT INTO qlhv.diem(Mã_HV,Mã_KH,Điểm,KQ) VALUES (?,?,?,?)";
		try (
				Connection conn = new DBConnect().getConnec();
				PreparedStatement pre = conn.prepareStatement(sql);
			){
			pre.setString(1, diem.getMa_Hoc_Vien());
			pre.setString(2, diem.getMa_Khoa_Hoc());
			pre.setFloat(3, diem.getDiem());
			pre.setString(4, diem.getKet_Qua());
			
			return pre.executeUpdate() > 0;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return false;
	}

	@Override
	public boolean delete(String MaHV, String MaKH) throws SQLException {
		String sql = "DELETE FROM qlhv.diem WHERE Mã_HV = ? AND Mã_KH = ?";
		try(
				Connection conn = new DBConnect().getConnec();
				PreparedStatement pre = conn.prepareStatement(sql);
			){
			pre.setString(1, MaHV);
			pre.setString(2, MaKH);
			
			return pre.executeUpdate() > 0;
		}
	}
	
	@Override
	public boolean update(Diem diem) throws SQLException {
		String sql = "UPDATE qlhv.diem SET Điểm = ?, KQ = ? WHERE Mã_HV = ?, Mã_KH = ?;";
		try(
				Connection conn = new DBConnect().getConnec();
				PreparedStatement pre = conn.prepareStatement(sql);
			){
			pre.setFloat(1, diem.getDiem());
			pre.setString(2, diem.getKet_Qua());
			pre.setString(3, diem.getMa_Hoc_Vien());
			pre.setString(4, diem.getMa_Khoa_Hoc());
			
			return pre.executeUpdate() > 0;
		}
	}
}
