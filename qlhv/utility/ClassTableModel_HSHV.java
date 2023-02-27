package qlhv.utility;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import qlhv.model.HocVien;

public class ClassTableModel_HSHV {
	
	public DefaultTableModel setTableHocVien(List<HocVien> List, String[] listColumn) {
		DefaultTableModel dtm = new DefaultTableModel() {
			//cài đặt cho phép(true)/không cho phép(false)thay đổi dữ liệu trong bảng
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		dtm.setColumnIdentifiers(listColumn);
		int columns = listColumn.length;
		Object[] obj = null;
		int row = List.size();
		if(row > 0) {
			for(int i=0; i<row; ++i) {
				HocVien hocvien = List.get(i);
				obj = new Object[columns];
				obj[0] = hocvien.getMa_Hoc_Vien();
				obj[1] = hocvien.getHo_Ten();
				obj[2] = hocvien.getNgay_Sinh();
				obj[3] = hocvien.isGioi_Tinh() == true ? "Nam" : "Nữ";
				obj[4] = hocvien.getSo_Dien_Thoai();
				obj[5] = hocvien.getDia_Chi();
				obj[6] = hocvien.getMa_Lop_Hoc();
				obj[7] = hocvien.isTinh_trang() == true ? "Còn Học" : "Đã Nghỉ";
				dtm.addRow(obj);
			}
		}
		return dtm;
	}
}
