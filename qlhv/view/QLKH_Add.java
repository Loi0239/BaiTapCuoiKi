package qlhv.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import qlhv.dao.KhoaHocDAO;
import qlhv.dao.KhoaHocDAOImpl;
import qlhv.model.KhoaHoc;

public class QLKH_Add extends JFrame {

	private JPanel contentPane;
	private JButton jbtUpdate, jbtSave;
	private JPanel panel;
		private JTextField tfMaKH, tfTenKH, tfMo_Ta;
		private JLabel jlbMaKH, jlbTenKH, jlbNgay_BD, jlbTinh_Trang, jlbMo_ta, jlbNgay_KT , jlbcheck1, jlbcheck2, jlbcheck3, jlbcheck4;
		private JCheckBox checkbox;
		private JDateChooser tfNgay_BD, tfNgay_KT;


	public QLKH_Add(KhoaHoc khoaHoc) {
		setTitle("Lưu Dữ Liệu");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 640, 430);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		jbtSave = new JButton("Lưu Dữ Liệu");
		jbtSave.setForeground(Color.GREEN);
		jbtSave.setBackground(Color.GRAY);
		jbtSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuilder sb = new StringBuilder();
				if(tfMaKH.getText().length() == 0 || tfTenKH.getText().length() == 0 || tfNgay_BD.getDate() == null || tfNgay_KT.getDate() == null) {
					sb.append("Không được để trống phần bắt buộc!");
					tfMaKH.setBackground(Color.RED);
					tfTenKH.setBackground(Color.RED);
					tfMaKH.setForeground(Color.WHITE);
					tfTenKH.setForeground(Color.WHITE);
				}else {
					tfMaKH.setBackground(Color.WHITE);
					tfTenKH.setBackground(Color.WHITE);
					tfMaKH.setForeground(Color.BLACK);
					tfTenKH.setForeground(Color.BLACK);
				}
				if(sb.length() > 0) {
					JOptionPane.showMessageDialog(jbtSave, sb);
					return;
				}
				try {
					KhoaHoc khoaHoc = new KhoaHoc();
					khoaHoc.setMa_Khoa_Hoc(tfMaKH.getText());
					khoaHoc.setTen_Khoa_Hoc(tfTenKH.getText());
					khoaHoc.setMo_Ta(tfMo_Ta.getText());
					khoaHoc.setNgay_Bat_Dau(covertDateToDateSql(tfNgay_BD.getDate()));
					khoaHoc.setNgay_Ket_Thuc(covertDateToDateSql(tfNgay_KT.getDate()));
					khoaHoc.setTinh_Trang(checkbox.isSelected());
					
					KhoaHocDAO KhoaHocDAO = new KhoaHocDAOImpl();
					KhoaHocDAO.create(khoaHoc);
					
					JOptionPane.showMessageDialog(jbtSave, "Thành Công");
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(jbtSave, "Erorr: " + e2.getMessage());
					e2.printStackTrace();
				}
			}
		});
		jbtSave.setIcon(new ImageIcon(HSHV_Add.class.getResource("/qlhv/images/Save-icon.png")));
		jbtSave.setFont(new Font("Arial", Font.BOLD, 20));
		jbtSave.setBounds(406, 15, 210, 41);
		contentPane.add(jbtSave);
		
		jbtUpdate = new JButton("Cập Nhật Dữ Liệu");
		jbtUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuilder sb = new StringBuilder();
				if(tfMaKH.getText().length() == 0 || tfTenKH.getText().length() == 0 || tfNgay_BD.getDate() == null || tfNgay_KT.getDate() == null) {
					sb.append("Không được để trống phần bắt buộc!");
					tfMaKH.setBackground(Color.RED);
					tfTenKH.setBackground(Color.RED);
					tfMaKH.setForeground(Color.WHITE);
					tfTenKH.setForeground(Color.WHITE);
				}else {
					tfMaKH.setBackground(Color.WHITE);
					tfTenKH.setBackground(Color.WHITE);
					tfMaKH.setForeground(Color.BLACK);
					tfTenKH.setForeground(Color.BLACK);
				}
				if(sb.length() > 0) {
					JOptionPane.showMessageDialog(jbtUpdate, sb);
					return;
				}
				if(JOptionPane.showConfirmDialog(tfMaKH, "Bạn có muốn cập nhật dữ liệu khóa học này không?"
						+ "\nNhấn vào 'Yes' hoặc 'Cancel' để cập nhật \n Nhấn vào 'No' để hoàn tác ") == JOptionPane.NO_OPTION) {
					return;
				}
				try {
					KhoaHoc khoaHoc = new KhoaHoc();
					khoaHoc.setMa_Khoa_Hoc(tfMaKH.getText());
					khoaHoc.setTen_Khoa_Hoc(tfTenKH.getText());
					khoaHoc.setMo_Ta(tfMo_Ta.getText());
					khoaHoc.setNgay_Bat_Dau(covertDateToDateSql(tfNgay_BD.getDate()));
					khoaHoc.setNgay_Ket_Thuc(covertDateToDateSql(tfNgay_KT.getDate()));
					khoaHoc.setTinh_Trang(checkbox.isSelected());
					
					KhoaHocDAO KhoaHocDAO = new KhoaHocDAOImpl();
					KhoaHocDAO.update(khoaHoc);
					
					JOptionPane.showMessageDialog(jbtUpdate, "Thành Công");
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(jbtUpdate, "Erorr: " + e2.getMessage());
					e2.printStackTrace();
				}
			}
		});
		jbtUpdate.setIcon(new ImageIcon(HSHV_Add.class.getResource("/qlhv/images/edit-validated-icon.png")));
		jbtUpdate.setForeground(Color.ORANGE);
		jbtUpdate.setFont(new Font("Arial", Font.BOLD, 20));
		jbtUpdate.setBackground(Color.GRAY);
		jbtUpdate.setBounds(128, 15, 253, 41);
		contentPane.add(jbtUpdate);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Thông Tin Khóa Học", TitledBorder.LEADING, TitledBorder.TOP, new Font("Arial", Font.BOLD, 15), null));
		panel.setBounds(10, 65, 610, 310);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		//set jlabel
		jlbMaKH = new JLabel("Mã Khóa Học :");
		jlbMaKH.setFont(new Font("Arial", Font.PLAIN, 15));
		jlbMaKH.setBounds(40, 40, 110, 30);
		panel.add(jlbMaKH);
		
		jlbTenKH = new JLabel("Tên Khóa Học :");
		jlbTenKH.setFont(new Font("Arial", Font.PLAIN, 15));
		jlbTenKH.setBounds(40, 90, 110, 30);
		panel.add(jlbTenKH);
		
		jlbNgay_BD = new JLabel("Ngày BĐ:");
		jlbNgay_BD.setFont(new Font("Arial", Font.PLAIN, 15));
		jlbNgay_BD.setBounds(40, 140, 95, 30);
		panel.add(jlbNgay_BD);
		
		jlbNgay_KT = new JLabel("Ngày KT:");
		jlbNgay_KT.setFont(new Font("Arial", Font.PLAIN, 15));
		jlbNgay_KT.setBounds(40, 190, 95, 30);
		panel.add(jlbNgay_KT);
		
		jlbTinh_Trang = new JLabel("Tình Trạng :");
		jlbTinh_Trang.setFont(new Font("Arial", Font.PLAIN, 15));
		jlbTinh_Trang.setBounds(40, 240, 95, 30);
		panel.add(jlbTinh_Trang);
		
		jlbMo_ta = new JLabel("Mô Tả  :");
		jlbMo_ta.setFont(new Font("Arial", Font.PLAIN, 15));
		jlbMo_ta.setBounds(400, 40, 95, 30);
		panel.add(jlbMo_ta);
		
		jlbcheck1 = new JLabel("(*)");
		jlbcheck1.setForeground(Color.RED);
		jlbcheck1.setFont(new Font("Arial", Font.BOLD, 15));
		jlbcheck1.setBounds(342, 40, 21, 23);
		panel.add(jlbcheck1);
		
		jlbcheck2 = new JLabel("(*)");
		jlbcheck2.setForeground(Color.RED);
		jlbcheck2.setFont(new Font("Arial", Font.BOLD, 15));
		jlbcheck2.setBounds(342, 90, 21, 23);
		panel.add(jlbcheck2);
		
		jlbcheck3 = new JLabel("(*)");
		jlbcheck3.setForeground(Color.RED);
		jlbcheck3.setFont(new Font("Arial", Font.BOLD, 15));
		jlbcheck3.setBounds(342, 140, 21, 23);
		panel.add(jlbcheck3);
		
		jlbcheck4 = new JLabel("(*)");
		jlbcheck4.setForeground(Color.RED);
		jlbcheck4.setFont(new Font("Arial", Font.BOLD, 15));
		jlbcheck4.setBounds(342, 190, 21, 23);
		panel.add(jlbcheck4);
		
		//set jtextfield
		tfMaKH = new JTextField();
		tfMaKH.setFont(new Font("Arial", Font.PLAIN, 15));
		tfMaKH.setBounds(160, 40, 170, 25);
		panel.add(tfMaKH);
		tfMaKH.setColumns(10);
		
		tfTenKH = new JTextField();
		tfTenKH.setFont(new Font("Arial", Font.PLAIN, 15));
		tfTenKH.setColumns(10);
		tfTenKH.setBounds(160, 90, 170, 25);
		panel.add(tfTenKH);
		
		tfMo_Ta = new JTextField();
		tfMo_Ta.setFont(new Font("Arial", Font.BOLD, 15));
		tfMo_Ta.setBounds(399, 69, 187, 44);
		panel.add(tfMo_Ta);
		tfMo_Ta.setColumns(10);
		
		tfNgay_BD = new JDateChooser();
		tfNgay_BD.setBackground(new Color(255, 255, 255));
		tfNgay_BD.setDateFormatString("yyyy-MM-dd");
		tfNgay_BD.setBounds(160, 140, 170, 25);
		panel.add(tfNgay_BD);
		
		tfNgay_KT = new JDateChooser();
		tfNgay_KT.setDateFormatString("yyyy-MM-dd");
		tfNgay_KT.setBackground(Color.WHITE);
		tfNgay_KT.setBounds(160, 190, 170, 25);
		panel.add(tfNgay_KT);
		
		checkbox = new JCheckBox("Hoạt Động");
		checkbox.setFont(new Font("Arial", Font.PLAIN, 15));
		checkbox.setBounds(160, 243, 105, 25);
		panel.add(checkbox);
	}
	
	public java.sql.Date covertDateToDateSql(java.util.Date date) {
        return new java.sql.Date(date.getTime());
    }
}