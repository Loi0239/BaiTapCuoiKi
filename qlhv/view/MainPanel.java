package qlhv.view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import qlhv.bean.DanhMuc;
import qlhv.controller.ChuyenManHinh;

public class MainPanel extends JFrame {

	private JPanel contentPane;
	private JPanel jpnMenu;
		private JPanel jpnQLHV,jpnMain,jpnHSHV,jpnQLKH,jpnQLLH,jpnQLD,jpnThong_Ke;
		private JLabel jlbQLHV,jlbMain,jlbHSHV,jlbQLKH,jlbQLLH,jlbQLD,jlbThong_Ke;
	private JPanel jpnView;
	/**
	 * Create the frame.
	 */
	public MainPanel() {
		setTitle("Quản Lý Học Viên");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1540, 820);
		setLocationRelativeTo(null);
		setVisible(true);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		jpnMenu = new JPanel();
		jpnMenu.setBackground(Color.GRAY);
		jpnMenu.setBounds(0, 0, 420, 797);
		contentPane.add(jpnMenu);
		jpnMenu.setLayout(null);
		
		jpnQLHV = new JPanel();
		jpnQLHV.setBackground(new Color(204, 51, 0));
		jpnQLHV.setBounds(0, 0, 420, 120);
		jpnMenu.add(jpnQLHV);
		jpnQLHV.setLayout(null);
		
		jlbQLHV = new JLabel("QUẢN LÝ HỌC VIÊN");
		jlbQLHV.setIcon(new ImageIcon(MainPanel.class.getResource("/qlhv/images/QuanLyHocVien_icon.png")));
		jlbQLHV.setFont(new Font("Arial", Font.BOLD, 25));
		jlbQLHV.setHorizontalAlignment(SwingConstants.CENTER);
		jlbQLHV.setBounds(20, 25, 380, 70);
		jpnQLHV.add(jlbQLHV);
		
		jpnMain = new JPanel();
		jpnMain.setBackground(new Color(0, 153, 51));
		jpnMain.setBounds(15, 140, 390, 90);
		jpnMenu.add(jpnMain);
		jpnMain.setLayout(null);
		
		jlbMain = new JLabel("Màn Hình Chính");
		jlbMain.setIcon(new ImageIcon(MainPanel.class.getResource("/qlhv/images/Man_Hinh_Chinh_icon.png")));
		jlbMain.setForeground(Color.LIGHT_GRAY);
		jlbMain.setFont(new Font("Arial", Font.BOLD, 20));
		jlbMain.setBounds(25, 20, 340, 50);
		jpnMain.add(jlbMain);
		
		jpnHSHV = new JPanel();
		jpnHSHV.setBackground(new Color(0, 153, 51));
		jpnHSHV.setBounds(15, 240, 390, 90);
		jpnMenu.add(jpnHSHV);
		jpnHSHV.setLayout(null);
		
		jlbHSHV = new JLabel("Hồ Sơ Học Viên");
		jlbHSHV.setIcon(new ImageIcon(MainPanel.class.getResource("/qlhv/images/HSHV_icon.png")));
		jlbHSHV.setForeground(Color.LIGHT_GRAY);
		jlbHSHV.setFont(new Font("Arial", Font.BOLD, 20));
		jlbHSHV.setBounds(25, 20, 340, 50);
		jpnHSHV.add(jlbHSHV);
		
		jpnQLKH = new JPanel();
		jpnQLKH.setBackground(new Color(0, 153, 51));
		jpnQLKH.setBounds(15, 340, 390, 90);
		jpnMenu.add(jpnQLKH);
		jpnQLKH.setLayout(null);
		
		jlbQLKH = new JLabel("Quản Lý Khóa Học");
		jlbQLKH.setIcon(new ImageIcon(MainPanel.class.getResource("/qlhv/images/QLKH_icon.png")));
		jlbQLKH.setForeground(Color.LIGHT_GRAY);
		jlbQLKH.setFont(new Font("Arial", Font.BOLD, 20));
		jlbQLKH.setBounds(25, 20, 340, 50);
		jpnQLKH.add(jlbQLKH);
		
		jpnQLLH = new JPanel();
		jpnQLLH.setBackground(new Color(0, 153, 51));
		jpnQLLH.setBounds(15, 440, 390, 90);
		jpnMenu.add(jpnQLLH);
		jpnQLLH.setLayout(null);
		
		jlbQLLH = new JLabel("Quản Lý Lớp Học");
		jlbQLLH.setIcon(new ImageIcon(MainPanel.class.getResource("/qlhv/images/QLLH_icon.png")));
		jlbQLLH.setForeground(Color.LIGHT_GRAY);
		jlbQLLH.setFont(new Font("Arial", Font.BOLD, 20));
		jlbQLLH.setBounds(25, 20, 340, 50);
		jpnQLLH.add(jlbQLLH);
		
		jpnQLD = new JPanel();
		jpnQLD.setBackground(new Color(0, 153, 51));
		jpnQLD.setBounds(15, 540, 390, 90);
		jpnMenu.add(jpnQLD);
		jpnQLD.setLayout(null);
		
		jlbQLD = new JLabel("Quản Lý Điểm");
		jlbQLD.setIcon(new ImageIcon(MainPanel.class.getResource("/qlhv/images/QLDicon.png")));
		jlbQLD.setForeground(Color.LIGHT_GRAY);
		jlbQLD.setFont(new Font("Arial", Font.BOLD, 20));
		jlbQLD.setBounds(25, 20, 340, 50);
		jpnQLD.add(jlbQLD);
		
		jpnThong_Ke = new JPanel();
		jpnThong_Ke.setBackground(new Color(0, 153, 51));
		jpnThong_Ke.setBounds(15, 640, 390, 90);
		jpnMenu.add(jpnThong_Ke);
		jpnThong_Ke.setLayout(null);
		
		jlbThong_Ke = new JLabel("Thống Kê");
		jlbThong_Ke.setIcon(new ImageIcon(MainPanel.class.getResource("/qlhv/images/Thong_Ke_icon.png")));
		jlbThong_Ke.setForeground(Color.LIGHT_GRAY);
		jlbThong_Ke.setFont(new Font("Arial", Font.BOLD, 20));
		jlbThong_Ke.setBounds(25, 20, 340, 50);
		jpnThong_Ke.add(jlbThong_Ke);
		
		jpnView = new JPanel();
		jpnView.setBackground(Color.LIGHT_GRAY);
		jpnView.setBounds(421, 0, 1120, 797);
		contentPane.add(jpnView);
		jpnView.setLayout(null);
		
		ChuyenManHinh transfer = new ChuyenManHinh(jpnView);
		try {
			transfer.setDefault(jpnMain, jlbMain);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<DanhMuc> ListJpanel = new ArrayList<>();
		ListJpanel.add(new DanhMuc("Main", jpnMain, jlbMain));
		ListJpanel.add(new DanhMuc("HSHV", jpnHSHV, jlbHSHV));
		ListJpanel.add(new DanhMuc("QLKH", jpnQLKH, jlbQLKH));
		ListJpanel.add(new DanhMuc("QLLH", jpnQLLH, jlbQLLH));
		ListJpanel.add(new DanhMuc("QLD", jpnQLD, jlbQLD));
		ListJpanel.add(new DanhMuc("Thong_Ke", jpnThong_Ke, jlbThong_Ke));
		
		transfer.setEvent(ListJpanel);
	}
}
