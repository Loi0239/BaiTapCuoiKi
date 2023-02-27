package qlhv.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import lib.connect;
import qlhv.bean.KhoaHocBean;
import qlhv.bean.LopHocBean;

public class ThongKeDAOImpl implements ThongKeDAO{

	@Override
	public List<LopHocBean> getListByLopHoc() throws SQLException{
		Connection cont = new DBConnect().getConnec();
		String sql = "select Tên_LH, count(*)as Số_lớp_học from qlhv.lop_hoc where Tình_Trạng = TRUE group by Tên_LH;";
		List<LopHocBean> list = new ArrayList<>();
		PreparedStatement ps = cont.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			LopHocBean lopHocBean = new LopHocBean();
			lopHocBean.setTenLopHoc(rs.getString("Tên_LH"));
			lopHocBean.setSoLuongLopHoc(rs.getInt("Số_lớp_học"));
			list.add(lopHocBean);
		}
		return list;
	}

	@Override
	public List<KhoaHocBean> getListByKhoaHoc() throws SQLException {
		Connection cont = new DBConnect().getConnec();
		String sql = "select Mã_Khóa_Học, Ngày_BĐ, Ngày_KT from qlhv.khoa_hoc where Tình_Trạng = TRUE;";
		List<KhoaHocBean> list = new ArrayList<>();
		PreparedStatement ps = cont.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			KhoaHocBean khoaHocBean = new KhoaHocBean();
			khoaHocBean.setMaKhoaHoc(rs.getString("Mã_Khóa_Học"));
			khoaHocBean.setNgayBatDau(rs.getDate("Ngày_BĐ"));
			khoaHocBean.setNgayKetThuc(rs.getDate("Ngày_KT"));
			list.add(khoaHocBean);
		}
		return list;
	}
	
}
