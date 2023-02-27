package qlhv.dao;

import java.sql.SQLException; 
import java.util.List;
import qlhv.model.KhoaHoc;

public interface KhoaHocDAO {
	
	public List<KhoaHoc> getList() throws SQLException;
	
	public boolean create(KhoaHoc khoaHoc) throws SQLException;
	
	public boolean delete(String MaKH) throws SQLException;
	
	public boolean update(KhoaHoc khoaHoc) throws SQLException;
}
