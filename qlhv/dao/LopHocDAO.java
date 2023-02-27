package qlhv.dao;

import java.sql.SQLException; 
import java.util.List;
import qlhv.model.LopHoc;

public interface LopHocDAO {
	
	public List<LopHoc> getList() throws SQLException;
	
	public boolean create(LopHoc lopHoc) throws SQLException;
	
	public boolean delete(String MaLH) throws SQLException;
	
	public boolean update(LopHoc lopHoc) throws SQLException;
}
