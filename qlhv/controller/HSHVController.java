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
import qlhv.model.HocVien;
import qlhv.service.*;
import qlhv.utility.ClassTableModel_HSHV;
import qlhv.view.*;

public class HSHVController {
	private JPanel jpnView;
	private JButton jbtAdd, jbtDelete;
	private JTextField tfSearch;
	private HocVienService hocvienservice = null;
	
	private String[] listcolumn = {"Mã HV","Họ Tên","Ngày Sinh","Giới Tính","SĐT","Địa Chỉ","Mã Lớp","Tình Trạng"};
	//tạo đối tượng sắp xếp hàng trong bảng
	private TableRowSorter<TableModel> RowSorter = null;
	
	public HSHVController(JPanel jpnView, JButton jbtAdd,JButton jbtDelete, JTextField tfSearch) {
		this.jpnView = jpnView;
		this.jbtAdd = jbtAdd;
		this.jbtDelete = jbtDelete;
		this.tfSearch = tfSearch;
		this.hocvienservice = new HocVienServiceImpl();
	}
	
	public void setDateToTable() {
		List<HocVien> List = hocvienservice.getList();
		DefaultTableModel model = new ClassTableModel_HSHV().setTableHocVien(List, listcolumn);
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
					HSHV_Add JframeAdd = new HSHV_Add(new HocVien());
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
				HSHV_Delete JframeAdd = new HSHV_Delete(new HocVien());
				JframeAdd.setVisible(true);
			}
		});
	}
	
}
