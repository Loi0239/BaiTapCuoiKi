package qlhv.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import qlhv.controller.QLDController;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QLD extends JPanel {
	private JLabel lb1, lb2;
	private JTextField tfSearch;
	private JButton jbtAdd, jbtDelete;
	private JPanel jpbTable;
	
	public QLD() {
		setSize(1120,797);
		setLayout(null);
		
		lb1 = new JLabel("Tìm kiếm theo");
		lb1.setForeground(new Color(255, 153, 51));
		lb1.setFont(new Font("Arial", Font.BOLD, 20));
		lb1.setBounds(10, 10, 140, 25);
		add(lb1);
		
		lb2 = new JLabel("tên học viên :");
		lb2.setForeground(new Color(255, 153, 51));
		lb2.setFont(new Font("Arial", Font.BOLD, 20));
		lb2.setBounds(10, 40, 140, 25);
		add(lb2);
		
		tfSearch = new JTextField();
		tfSearch.setFont(new Font("Arial", Font.BOLD, 20));
		tfSearch.setBounds(152, 11, 343, 55);
		add(tfSearch);
		tfSearch.setColumns(10);
		
		jbtAdd =  new JButton("Thêm hoặc cập nhật dữ liệu");
		jbtAdd.setForeground(Color.WHITE);
		jbtAdd.setBackground(Color.GREEN);
		jbtAdd.setIcon(new ImageIcon(HSHV.class.getResource("/qlhv/images/add-icon (32x32).png")));
		jbtAdd.setFont(new Font("Arial", Font.BOLD, 25));
		jbtAdd.setBounds(693, 10, 404, 55);
		add(jbtAdd);
		
		jbtDelete = new JButton("Xóa");
		jbtDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		jbtDelete.setForeground(Color.WHITE);
		jbtDelete.setBackground(new Color(255, 0, 51));
		jbtDelete.setIcon(new ImageIcon(HSHV.class.getResource("/qlhv/images/Close-2-icon.png")));
		jbtDelete.setFont(new Font("Arial", Font.BOLD, 25));
		jbtDelete.setBounds(543, 10, 140, 55);
		add(jbtDelete);
		
		jpbTable = new JPanel();
		jpbTable.setBackground(Color.PINK);
		jpbTable.setBounds(40, 110, 1040, 642);
		add(jpbTable);
		jpbTable.setLayout(null);
		
		QLDController controller = new QLDController(jpbTable, jbtAdd, jbtDelete, tfSearch);
		controller.setDateToTable();
		controller.setEvent();
	}
}
