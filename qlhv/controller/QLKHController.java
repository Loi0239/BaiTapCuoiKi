package qlhv.controller;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;
import java.util.*;
import qlhv.model.KhoaHoc;
import qlhv.service.*;
import qlhv.utility.ClassTableModel_QLKH;
import qlhv.view.*;

public class QLKHController {
	private JPanel jpnView;
	private JButton jbtAdd, jbtDelete;
	private JTextField tfSearch;
	private KhoaHocService khoahocservice = null;
	
	private String[] listcolumn = {"STT","Mã KH","Tên Khóa Học","Mô Tả","Ngày BĐ","Ngày KT","Tình Trạng"};
	//tạo đối tượng sắp xếp hàng trong bảng
	private TableRowSorter<TableModel> RowSorter = null;
	
	public QLKHController(JPanel jpnView, JButton jbtAdd,JButton jbtDelete, JTextField tfSearch) {
		this.jpnView = jpnView;
		this.jbtAdd = jbtAdd;
		this.jbtDelete = jbtDelete;
		this.tfSearch = tfSearch;
		this.khoahocservice = new KhoaHocServiceImpl();
	}
	
	public void setDateToTable() {
		List<KhoaHoc> List = khoahocservice.getList();
		DefaultTableModel model = new ClassTableModel_QLKH().setTableKhoaHoc(List, listcolumn);
		JTable table = new JTable(model);
		
		//cài đặt chức năng sắp xếp vào bảng
		RowSorter = new TableRowSorter(table.getModel()); 
		table.setRowSorter(RowSorter);
		
		tfSearch.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				String text = tfSearch.getText();
				if(text.trim().length() == 0) {
					RowSorter.setRowFilter(null);
				}else {
					RowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				}
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				String text = tfSearch.getText();
				if(text.trim().length() == 0) {
					RowSorter.setRowFilter(null);
				}else {
					RowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				}
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		//cài đặt hàng đầu tiên trong bảng(hàng chứa tên cột)
		table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 15));
		//setPreferredSize(dùng để cài đặt kích thước cho các ô hàng đầu tiên
		table.getTableHeader().setPreferredSize(new Dimension(30,35));
		table.setRowHeight(50);
		
		JScrollPane scr = new JScrollPane();
		scr.getViewport().add(table);

		
		jpnView.removeAll();
		jpnView.setLayout(new BorderLayout());
		jpnView.add(scr);
	} 
	
	public void setEvent() {
		jbtAdd.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseExited(MouseEvent e) {
					jbtAdd.setBackground(Color.GREEN);
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					jbtAdd.setBackground(new Color(0,250,154));
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					QLKH_Add JframeAdd = new QLKH_Add(new KhoaHoc());
					JframeAdd.setVisible(true);
				}
		});
		jbtDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				jbtAdd.setBackground(Color.GREEN);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				jbtAdd.setBackground(new Color(0,250,154));
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				QLKH_Delete JframeAdd = new QLKH_Delete(new KhoaHoc());
				JframeAdd.setVisible(true);
			}
		});
	}
	
}
