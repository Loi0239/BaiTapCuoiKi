package qlhv.dao;

import java.sql.SQLException; 
import java.util.List;
import qlhv.model.Diem;

public interface DiemDAO {
	
	public List<Diem> getList() throws SQLException;
	
	public boolean create(Diem diem) throws SQLException;
	
	public boolean delete(String MaHV, String MaKH) throws SQLException;
	
	public boolean update(Diem diem) throws SQLException;
}
