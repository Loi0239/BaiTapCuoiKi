package qlhv.dao;

import java.sql.SQLException; 
import java.util.List;
import qlhv.model.HocVien;

public interface HocVienDAO {
	
	public List<HocVien> getList() throws SQLException;
	
	public boolean create(HocVien hocVien) throws SQLException;
	
	public boolean delete(String MaHV) throws SQLException;
	
	public boolean update(HocVien hocVien) throws SQLException;
}
