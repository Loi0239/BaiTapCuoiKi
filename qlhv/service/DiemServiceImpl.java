package qlhv.service;

import java.sql.SQLException; 
import java.util.List;
import qlhv.dao.DiemDAO;
import qlhv.dao.DiemDAOImpl;
import qlhv.model.Diem;

public class DiemServiceImpl implements DiemService{
	private DiemDAO diem = null;
	
	public DiemServiceImpl() {
		diem = new DiemDAOImpl();
	}


	@Override
	public List<Diem> getList() {
		try {
			return diem.getList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
