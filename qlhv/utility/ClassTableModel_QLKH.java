package qlhv.utility;

import java.util.List; 
import javax.swing.table.DefaultTableModel;
import qlhv.model.KhoaHoc;

public class ClassTableModel_QLKH {
	
	public DefaultTableModel setTableKhoaHoc(List<KhoaHoc> List, String[] listColumn) {
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
				KhoaHoc khoaHoc = List.get(i);
				obj = new Object[columns];
				obj[0] = (i + 1);
				obj[1] = khoaHoc.getMa_Khoa_Hoc();
				obj[2] = khoaHoc.getTen_Khoa_Hoc();
				obj[3] = khoaHoc.getMo_Ta();
				obj[4] = khoaHoc.getNgay_Bat_Dau();
				obj[5] = khoaHoc.getNgay_Ket_Thuc();
				obj[6] = khoaHoc.isTinh_Trang() == true ? "Hoạt Động" : "Kết Thúc";
				dtm.addRow(obj);
			}
		}
		return dtm;
	}
}
