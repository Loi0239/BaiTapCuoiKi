package qlhv.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import qlhv.dao.LopHocDAO;
import qlhv.dao.LopHocDAOImpl;
import qlhv.model.LopHoc;

public class QLLH_Add extends JFrame {

	private JPanel contentPane;
	private JButton jbtUpdate, jbtSave;
	private JPanel panel;
		private JTextField tfMaLH, tfTenLH, tfMaKH, tfHocPhi;
		private JLabel jlbMaLH, jlbTenLH, jlbMaKH, jlbTinh_Trang, jlbHocPhi , jlbcheck1, jlbcheck2, jlbcheck3, jlbcheck4;
		private JCheckBox checkbox;


	public QLLH_Add(LopHoc lopHoc) {
		setTitle("Lưu Dữ Liệu");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 490, 430);
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
				if(tfMaLH.getText().length() == 0 || tfTenLH.getText().length() == 0 || tfMaKH.getText().length() == 0 || tfHocPhi.getText().length() == 0) {
					sb.append("Không được để trống phần bắt buộc!");
					tfMaLH.setBackground(Color.RED);
					tfTenLH.setBackground(Color.RED);
					tfMaKH.setBackground(Color.RED);
					tfHocPhi.setBackground(Color.RED);
					tfMaLH.setForeground(Color.WHITE);
					tfTenLH.setForeground(Color.WHITE);
					tfMaKH.setForeground(Color.WHITE);
					tfHocPhi.setForeground(Color.WHITE);
				}else {
					tfMaLH.setBackground(Color.WHITE);
					tfTenLH.setBackground(Color.WHITE);
					tfMaKH.setBackground(Color.WHITE);
					tfHocPhi.setBackground(Color.WHITE);
					tfMaLH.setForeground(Color.BLACK);
					tfTenLH.setForeground(Color.BLACK);
					tfMaKH.setForeground(Color.BLACK);
					tfHocPhi.setForeground(Color.BLACK);
				}
				if(sb.length() > 0) {
					JOptionPane.showMessageDialog(jbtSave, sb);
					return;
				}
				try {
					LopHoc lopHoc = new LopHoc();
					lopHoc.setMa_Lop_Hoc(tfMaLH.getText());
					lopHoc.setTen_Lop_Hoc(tfTenLH.getText());
					lopHoc.setMa_Khoa_Hoc(tfMaKH.getText());
					lopHoc.setHoc_Phi(tfHocPhi.getText());
					lopHoc.setTinh_Trang(checkbox.isSelected());
					
					LopHocDAO lopHocDAO = new LopHocDAOImpl();
					lopHocDAO.create(lopHoc);
					
					JOptionPane.showMessageDialog(jbtSave, "Thành Công");
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(jbtSave, "Erorr: " + e2.getMessage());
					e2.printStackTrace();
				}
			}
		});
		jbtSave.setIcon(new ImageIcon(HSHV_Add.class.getResource("/qlhv/images/Save-icon.png")));
		jbtSave.setFont(new Font("Arial", Font.BOLD, 20));
		jbtSave.setBounds(276, 15, 190, 40);
		contentPane.add(jbtSave);
		
		jbtUpdate = new JButton("Cập Nhật Dữ Liệu");
		jbtUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuilder sb = new StringBuilder();
				if(tfMaLH.getText().length() == 0 || tfTenLH.getText().length() == 0 || tfMaKH.getText().length() == 0 || tfHocPhi.getText().length() == 0) {
					sb.append("Không được để trống phần bắt buộc!");
					tfMaLH.setBackground(Color.RED);
					tfTenLH.setBackground(Color.RED);
					tfMaKH.setBackground(Color.RED);
					tfHocPhi.setBackground(Color.RED);
					tfMaLH.setForeground(Color.WHITE);
					tfTenLH.setForeground(Color.WHITE);
					tfMaKH.setForeground(Color.WHITE);
					tfHocPhi.setForeground(Color.WHITE);
				}else {
					tfMaLH.setBackground(Color.WHITE);
					tfTenLH.setBackground(Color.WHITE);
					tfMaKH.setBackground(Color.WHITE);
					tfHocPhi.setBackground(Color.WHITE);
					tfMaLH.setForeground(Color.BLACK);
					tfTenLH.setForeground(Color.BLACK);
					tfMaKH.setForeground(Color.BLACK);
					tfHocPhi.setForeground(Color.BLACK);
				}
				if(sb.length() > 0) {
					JOptionPane.showMessageDialog(jbtUpdate, sb);
					return;
				}
				if(JOptionPane.showConfirmDialog(tfMaLH, "Bạn có muốn cập nhật dữ liệu lớp học này không?"
						+ "\nNhấn vào 'Yes' hoặc 'Cancel' để cập nhật \n Nhấn vào 'No' để hoàn tác ") == JOptionPane.NO_OPTION) {
					return;
				}
				try {
					LopHoc lopHoc = new LopHoc();
					lopHoc.setMa_Lop_Hoc(tfMaLH.getText());
					lopHoc.setTen_Lop_Hoc(tfTenLH.getText());
					lopHoc.setMa_Khoa_Hoc(tfMaKH.getText());
					lopHoc.setHoc_Phi(tfHocPhi.getText());
					lopHoc.setTinh_Trang(checkbox.isSelected());
					
					LopHocDAO lopHocDAO = new LopHocDAOImpl();
					lopHocDAO.update(lopHoc);
					
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
		jbtUpdate.setBounds(10, 15, 253, 40);
		contentPane.add(jbtUpdate);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Thông Tin Lớp Học", TitledBorder.LEADING, TitledBorder.TOP, new Font("Arial", Font.BOLD, 15), null));
		panel.setBounds(40, 65, 400, 310);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		//set jlabel
		jlbMaLH = new JLabel("Mã Lóp Học :");
		jlbMaLH.setFont(new Font("Arial", Font.PLAIN, 15));
		jlbMaLH.setBounds(40, 40, 110, 30);
		panel.add(jlbMaLH);
		
		jlbTenLH = new JLabel("Tên Lớp Học :");
		jlbTenLH.setFont(new Font("Arial", Font.PLAIN, 15));
		jlbTenLH.setBounds(40, 90, 110, 30);
		panel.add(jlbTenLH);
		
		jlbMaKH = new JLabel("Mã Khóa Học :");
		jlbMaKH.setFont(new Font("Arial", Font.PLAIN, 15));
		jlbMaKH.setBounds(40, 140, 110, 30);
		panel.add(jlbMaKH);
		
		jlbHocPhi = new JLabel("Học Phí :");
		jlbHocPhi.setFont(new Font("Arial", Font.PLAIN, 15));
		jlbHocPhi.setBounds(40, 190, 95, 30);
		panel.add(jlbHocPhi);
		
		jlbTinh_Trang = new JLabel("Tình Trạng :");
		jlbTinh_Trang.setFont(new Font("Arial", Font.PLAIN, 15));
		jlbTinh_Trang.setBounds(40, 240, 95, 30);
		panel.add(jlbTinh_Trang);
		
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
		tfMaLH = new JTextField();
		tfMaLH.setFont(new Font("Arial", Font.PLAIN, 15));
		tfMaLH.setBounds(160, 40, 170, 25);
		panel.add(tfMaLH);
		tfMaLH.setColumns(10);
		
		tfTenLH = new JTextField();
		tfTenLH.setFont(new Font("Arial", Font.PLAIN, 15));
		tfTenLH.setColumns(10);
		tfTenLH.setBounds(160, 90, 170, 25);
		panel.add(tfTenLH);
		
		checkbox = new JCheckBox("Hoạt Động");
		checkbox.setFont(new Font("Arial", Font.PLAIN, 15));
		checkbox.setBounds(160, 243, 105, 25);
		panel.add(checkbox);
		
		tfMaKH = new JTextField();
		tfMaKH.setFont(new Font("Arial", Font.PLAIN, 15));
		tfMaKH.setColumns(10);
		tfMaKH.setBounds(160, 140, 170, 25);
		panel.add(tfMaKH);
		
		tfHocPhi = new JTextField();
		tfHocPhi.setFont(new Font("Arial", Font.PLAIN, 15));
		tfHocPhi.setColumns(10);
		tfHocPhi.setBounds(160, 190, 170, 25);
		panel.add(tfHocPhi);
	}
}