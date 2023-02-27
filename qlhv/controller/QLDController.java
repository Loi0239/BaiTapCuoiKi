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
import qlhv.model.Diem;
import qlhv.service.*;
import qlhv.utility.ClassTableModel_QLD;
import qlhv.view.*;

public class QLDController {
	private JPanel jpnView;
	private JButton jbtAdd, jbtDelete;
	private JTextField tfSearch;
	private DiemService diemservice = null;
	
	private String[] listcolumn = {"Mã HV","Mã KH","Điểm","Kết Quả"};
	//tạo đối tượng sắp xếp hàng trong bảng
	private TableRowSorter<TableModel> RowSorter = null;
	
	public QLDController(JPanel jpnView, JButton jbtAdd,JButton jbtDelete, JTextField tfSearch) {
		this.jpnView = jpnView;
		this.jbtAdd = jbtAdd;
		this.jbtDelete = jbtDelete;
		this.tfSearch = tfSearch;
		this.diemservice = new DiemServiceImpl();
	}
	
	public void setDateToTable() {
		List<Diem> List = diemservice.getList();
		DefaultTableModel model = new ClassTableModel_QLD().setTableDiem(List, listcolumn);
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
					QLD_Add JframeAdd = new QLD_Add(new Diem());
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
				QLD_Delete JframeAdd = new QLD_Delete(new Diem());
				JframeAdd.setVisible(true);
			}
		});
	}
	
}
