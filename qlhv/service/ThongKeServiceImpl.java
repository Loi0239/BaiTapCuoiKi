package qlhv.service;

import java.sql.*;
import java.util.List;

import qlhv.bean.KhoaHocBean;
import qlhv.bean.LopHocBean;
import qlhv.dao.ThongKeDAO;
import qlhv.dao.ThongKeDAOImpl;

public class ThongKeServiceImpl implements ThongKeService{
	private ThongKeDAO thongkeDAO = null;
	
	public ThongKeServiceImpl() {
		this.thongkeDAO = new ThongKeDAOImpl();
	}

	@Override
	public List<LopHocBean> getListByLopHoc() {
		try {
			return thongkeDAO.getListByLopHoc();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<KhoaHocBean> getListByKhoaHoc() {
		try {
			return thongkeDAO.getListByKhoaHoc();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;	}

}
