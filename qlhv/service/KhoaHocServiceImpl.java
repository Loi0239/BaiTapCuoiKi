package qlhv.service;

import java.sql.SQLException; 
import java.util.List;
import qlhv.dao.KhoaHocDAO;
import qlhv.dao.KhoaHocDAOImpl;
import qlhv.model.KhoaHoc;

public class KhoaHocServiceImpl implements KhoaHocService{
	private KhoaHocDAO khoahoc = null;
	
	public KhoaHocServiceImpl() {
		khoahoc = new KhoaHocDAOImpl();
	}


	@Override
	public List<KhoaHoc> getList() {
		try {
			return khoahoc.getList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
