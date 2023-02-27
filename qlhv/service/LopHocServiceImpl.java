package qlhv.service;

import java.sql.SQLException; 
import java.util.List;
import qlhv.dao.LopHocDAO;
import qlhv.dao.LopHocDAOImpl;
import qlhv.model.LopHoc;

public class LopHocServiceImpl implements LopHocService{
	private LopHocDAO lopHoc = null;
	
	public LopHocServiceImpl() {
		lopHoc = new LopHocDAOImpl();
	}


	@Override
	public List<LopHoc> getList() {
		try {
			return lopHoc.getList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
