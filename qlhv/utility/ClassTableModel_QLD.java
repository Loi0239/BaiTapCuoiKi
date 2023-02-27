package qlhv.utility;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import qlhv.model.Diem;
import qlhv.model.HocVien;


public class ClassTableModel_QLD {
	public DefaultTableModel setTableDiem(List<Diem> List, String[] listColumn) {
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
				Diem diem = List.get(i);
				obj = new Object[columns];
				obj[0] = diem.getMa_Hoc_Vien();
				obj[1] = diem.getMa_Khoa_Hoc();
				obj[2] = diem.getDiem();
				obj[3] = diem.getKet_Qua();
				dtm.addRow(obj);
			}
		}
		return dtm;
	}
}
