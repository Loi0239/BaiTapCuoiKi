package qlhv.view;

import java.awt.EventQueue; 
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import qlhv.controller.ThongKeController;

import java.awt.Color;

public class Thong_Ke extends JPanel {
	
	public Thong_Ke() {
		setBackground(Color.WHITE);
		setLayout(null);
		setSize(1120, 797);
		
		JPanel jpnView1 = new JPanel();
		jpnView1.setBounds(10, 10, 1100, 383);
		add(jpnView1);	
		
		JPanel jpnView2 = new JPanel();
		jpnView2.setBounds(10, 403, 1100, 383);
		add(jpnView2);
		
		ThongKeController control = new ThongKeController();
		control.setDataToChart1(jpnView1);
		control.setDataToChart2(jpnView2);
	}
}
