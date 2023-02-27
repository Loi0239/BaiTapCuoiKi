package qlhv.service;

import java.sql.SQLException; 
import java.util.List;
import qlhv.dao.HocVienDAO;
import qlhv.dao.HocVienDAOImpl;
import qlhv.model.HocVien;

public class HocVienServiceImpl implements HocVienService{
	private HocVienDAO hocvien = null;
	
	public HocVienServiceImpl() {
		hocvien = new HocVienDAOImpl();
	}


	@Override
	public List<HocVien> getList() {
		try {
			return hocvien.getList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
