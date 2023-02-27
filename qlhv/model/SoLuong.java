package qlhv.model;

import java.sql.*;
import qlhv.dao.*;

public class SoLuong {
	private int SoHV, SoKH, SoLH;
	
	public int DemHV() throws SQLException {
		Connection conn = new DBConnect().getConnec();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM qlhv.hoc_vien;");
		SoHV = 0;
		while(rs.next()) {
			SoHV++;
		}
		return SoHV;
	}
	
	public int DemKH() throws SQLException {
		Connection conn = new DBConnect().getConnec();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM qlhv.Khoa_hoc;");
		SoKH = 0;
		while(rs.next()) {
			SoKH++;
		}
		return SoKH;
	}
	
	public int DemLH() throws SQLException {
		Connection conn = new DBConnect().getConnec();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM qlhv.lop_hoc;");
		SoLH = 0;
		while(rs.next()) {
			SoLH++;
		}
		return SoLH;
	}
}
