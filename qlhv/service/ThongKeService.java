package qlhv.service;

import java.sql.*;
import java.util.List;

import qlhv.bean.KhoaHocBean;
import qlhv.bean.LopHocBean;

public interface ThongKeService {
	public List<LopHocBean> getListByLopHoc();
	
	public List<KhoaHocBean> getListByKhoaHoc();
}
