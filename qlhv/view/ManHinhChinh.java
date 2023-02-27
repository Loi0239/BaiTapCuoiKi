package qlhv.view;

import java.awt.*;  
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.sql.*;
import javax.swing.SwingConstants;
import qlhv.model.SoLuong;
import qlhv.utility.ClassTableModel_HSHV;

public class ManHinhChinh extends JPanel {
	private JPanel jpnHV;
		private JLabel jlb_icon_HV, jlb_SoHV, jlbHV;
	private JPanel jpnLH;
		private JLabel jlb_icon_LH, jlb_SoLH, jlbLH;
	private JPanel jpnKH;
		private JLabel jlb_icon_KH, jlb_SoKH, jlbKH;
	private JPanel jpn_review;
	
	private SoLuong dem = new SoLuong();
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_10;
	
	public ManHinhChinh() throws SQLException{
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		
		jpnHV = new JPanel();
		jpnHV.setBackground(new Color(255, 255, 102));
		jpnHV.setBounds(10, 10, 330, 240);
		add(jpnHV);
		jpnHV.setLayout(null);
		
		jlb_icon_HV = new JLabel("");
		jlb_icon_HV.setIcon(new ImageIcon(ManHinhChinh.class.getResource("/qlhv/images/User-Coat-Green-icon.png")));
		jlb_icon_HV.setBounds(10, 39, 136, 157);
		jpnHV.add(jlb_icon_HV);
		
		jlb_SoHV = new JLabel(String.valueOf(dem.DemHV()));
		jlb_SoHV.setHorizontalAlignment(SwingConstants.CENTER);
		jlb_SoHV.setFont(new Font("Arial", Font.BOLD, 25));
		jlb_SoHV.setBounds(220, 40, 64, 41);
		jpnHV.add(jlb_SoHV);
		
		jlbHV = new JLabel("Học Viên");
		jlbHV.setFont(new Font("Arial", Font.BOLD, 25));
		jlbHV.setBounds(160, 90, 130, 41);
		jpnHV.add(jlbHV);
		
		jpnLH = new JPanel();
		jpnLH.setBackground(new Color(0, 204, 255));
		jpnLH.setBounds(393, 10, 330, 240);
		add(jpnLH);
		jpnLH.setLayout(null);
		
		jlb_icon_LH = new JLabel("");
		jlb_icon_LH.setIcon(new ImageIcon(ManHinhChinh.class.getResource("/qlhv/images/class_icon(128x128).png")));
		jlb_icon_LH.setBounds(10, 41, 136, 157);
		jpnLH.add(jlb_icon_LH);
		
		jlb_SoLH = new JLabel(String.valueOf(dem.DemLH()));
		jlb_SoLH.setHorizontalAlignment(SwingConstants.CENTER);
		jlb_SoLH.setFont(new Font("Arial", Font.BOLD, 25));
		jlb_SoLH.setBounds(220, 40, 64, 41);
		jpnLH.add(jlb_SoLH);
		
		jlbLH = new JLabel("Lớp Học");
		jlbLH.setFont(new Font("Arial", Font.BOLD, 25));
		jlbLH.setBounds(160, 90, 130, 41);
		jpnLH.add(jlbLH);
		
		jpnKH = new JPanel();
		jpnKH.setBackground(new Color(0, 204, 102));
		jpnKH.setBounds(780, 10, 330, 240);
		add(jpnKH);
		jpnKH.setLayout(null);
		
		jlb_icon_KH = new JLabel("");
		jlb_icon_KH.setIcon(new ImageIcon(ManHinhChinh.class.getResource("/qlhv/images/Calendar-icon.png")));
		jlb_icon_KH.setBounds(10, 55, 136, 157);
		jpnKH.add(jlb_icon_KH);
		
		jlb_SoKH = new JLabel(String.valueOf(dem.DemKH()));
		jlb_SoKH.setHorizontalAlignment(SwingConstants.CENTER);
		jlb_SoKH.setFont(new Font("Arial", Font.BOLD, 25));
		jlb_SoKH.setBounds(220, 40, 64, 41);
		jpnKH.add(jlb_SoKH);
		
		jlbKH = new JLabel("Khóa Học");
		jlbKH.setFont(new Font("Arial", Font.BOLD, 25));
		jlbKH.setBounds(160, 90, 130, 41);
		jpnKH.add(jlbKH);
		
		jpn_review = new JPanel();
		jpn_review.setBackground(new Color(255, 102, 204));
		jpn_review.setBounds(10, 279, 1100, 508);
		add(jpn_review);
		jpn_review.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Trung tâm đào tạo lập trình viên");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 35));
		lblNewLabel.setBounds(255, 50, 590, 45);
		jpn_review.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Hỗ trợ đa dạng ngôn ngữ lập trình, cơ hội việc làm mở rộng");
		lblNewLabel_1.setForeground(new Color(102, 255, 51));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel_1.setBounds(175, 120, 750, 40);
		jpn_review.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("JAVA");
		lblNewLabel_2.setIcon(new ImageIcon(ManHinhChinh.class.getResource("/qlhv/images/Java-icon.png")));
		lblNewLabel_2.setForeground(new Color(255, 255, 0));
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_2.setBounds(144, 200, 95, 45);
		jpn_review.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("PYTHON");
		lblNewLabel_3.setIcon(new ImageIcon(ManHinhChinh.class.getResource("/qlhv/images/python-icon.png")));
		lblNewLabel_3.setForeground(Color.YELLOW);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_3.setBounds(358, 200, 120, 45);
		jpn_review.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("C++");
		lblNewLabel_4.setIcon(new ImageIcon(ManHinhChinh.class.getResource("/qlhv/images/c++_icon.png")));
		lblNewLabel_4.setForeground(Color.YELLOW);
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_4.setBounds(622, 200, 95, 45);
		jpn_review.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("C-sharp");
		lblNewLabel_5.setIcon(new ImageIcon(ManHinhChinh.class.getResource("/qlhv/images/c-sharp_icon.png")));
		lblNewLabel_5.setForeground(Color.YELLOW);
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_5.setBounds(836, 200, 120, 45);
		jpn_review.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("HTML");
		lblNewLabel_6.setIcon(new ImageIcon(ManHinhChinh.class.getResource("/qlhv/images/html-icon.png")));
		lblNewLabel_6.setForeground(Color.YELLOW);
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_6.setBounds(144, 340, 95, 45);
		jpn_review.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("CSS");
		lblNewLabel_7.setIcon(new ImageIcon(ManHinhChinh.class.getResource("/qlhv/images/css-icon.png")));
		lblNewLabel_7.setForeground(Color.YELLOW);
		lblNewLabel_7.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_7.setBounds(371, 340, 95, 45);
		jpn_review.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("JavaScript");
		lblNewLabel_8.setIcon(new ImageIcon(ManHinhChinh.class.getResource("/qlhv/images/js_icon.png")));
		lblNewLabel_8.setForeground(Color.YELLOW);
		lblNewLabel_8.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_8.setBounds(587, 340, 145, 45);
		jpn_review.add(lblNewLabel_8);
		
		lblNewLabel_10 = new JLabel("SQL");
		lblNewLabel_10.setIcon(new ImageIcon(ManHinhChinh.class.getResource("/qlhv/images/sql-icon.png")));
		lblNewLabel_10.setForeground(Color.YELLOW);
		lblNewLabel_10.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_10.setBounds(836, 340, 95, 45);
		jpn_review.add(lblNewLabel_10);
	}
}
