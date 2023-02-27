package qlhv.dao;

import java.sql.SQLException;
import java.util.List;

import qlhv.bean.KhoaHocBean;
import qlhv.bean.LopHocBean;

public interface ThongKeDAO {
	public List<LopHocBean> getListByLopHoc() throws SQLException;
	
	public List<KhoaHocBean> getListByKhoaHoc() throws SQLException;
}
