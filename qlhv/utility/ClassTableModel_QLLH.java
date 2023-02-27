package qlhv.utility;

import java.util.List; 
import javax.swing.table.DefaultTableModel;
import qlhv.model.LopHoc;

public class ClassTableModel_QLLH {
	
	public DefaultTableModel setTableLopHoc(List<LopHoc> List, String[] listColumn) {
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
				LopHoc lopHoc = List.get(i);
				obj = new Object[columns];
				obj[0] = (i + 1);
				obj[1] = lopHoc.getMa_Lop_Hoc();
				obj[2] = lopHoc.getTen_Lop_Hoc();
				obj[3] = lopHoc.getMa_Khoa_Hoc();
				obj[4] = lopHoc.getHoc_Phi();
				obj[5] = lopHoc.isTinh_Trang() == true ? "Hoạt Động" : "Kết Thúc";
				dtm.addRow(obj);
			}
		}
		return dtm;
	}
}
