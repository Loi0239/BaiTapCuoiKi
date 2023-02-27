package qlhv.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import qlhv.dao.DiemDAO;
import qlhv.dao.DiemDAOImpl;
import qlhv.model.Diem;

public class QLD_Add extends JFrame {

	private JPanel contentPane;
	private JButton jbtUpdate, jbtSave;
	private JPanel panel;
		private JTextField tfMaHV, tfMaKH, tfDiem, tfKetQua;
		private JLabel jlbMaHV, jlbMaKH, jlbDiem, jlbKetQua , jlbcheck1, jlbcheck2;


	public QLD_Add(Diem	diem) {
		setTitle("Lưu Dữ Liệu");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 490, 350);
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
				if(tfMaHV.getText().length() == 0 || tfMaKH.getText().length() == 0 || tfDiem.getText().length() == 0 || tfKetQua.getText().length() == 0) {
					sb.append("Không được để trống phần bắt buộc!");
					tfMaHV.setBackground(Color.RED);
					tfMaKH.setBackground(Color.RED);
					tfMaHV.setForeground(Color.WHITE);
					tfMaKH.setForeground(Color.WHITE);
				}else {
					tfMaHV.setBackground(Color.WHITE);
					tfMaKH.setBackground(Color.WHITE);
					tfMaHV.setForeground(Color.BLACK);
					tfMaKH.setForeground(Color.BLACK);
				}
				if(sb.length() > 0) {
					JOptionPane.showMessageDialog(jbtSave, sb);
					return;
				}
				try {
					float diem_so = Float.valueOf(tfDiem.getText());
					Diem diem = new Diem();
					diem.setMa_Hoc_Vien(tfMaHV.getText());
					diem.setMa_Khoa_Hoc(tfMaKH.getText());
					diem.setDiem(diem_so);
					diem.setKet_Qua(tfKetQua.getText());
					
					DiemDAO diemDAO = new DiemDAOImpl();
					diemDAO.create(diem);
					
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
				if(tfMaHV.getText().length() == 0 || tfMaKH.getText().length() == 0 || tfDiem.getText().length() == 0 || tfKetQua.getText().length() == 0) {
					sb.append("Không được để trống phần bắt buộc!");
					tfMaHV.setBackground(Color.RED);
					tfMaKH.setBackground(Color.RED);
					tfMaHV.setForeground(Color.WHITE);
					tfMaKH.setForeground(Color.WHITE);
				}else {
					tfMaHV.setBackground(Color.WHITE);
					tfMaKH.setBackground(Color.WHITE);
					tfMaHV.setForeground(Color.BLACK);
					tfMaKH.setForeground(Color.BLACK);
				}
				if(sb.length() > 0) {
					JOptionPane.showMessageDialog(jbtUpdate, sb);
					return;
				}
				if(JOptionPane.showConfirmDialog(tfMaHV, "Bạn có muốn cập nhật dữ liệu điểm học viên này không?"
						+ "\nNhấn vào 'Yes' hoặc 'Cancel' để cập nhật \n Nhấn vào 'No' để hoàn tác ") == JOptionPane.NO_OPTION) {
					return;
				}
				try {
					float diem_so = Float.valueOf(tfDiem.getText());
					Diem diem = new Diem();
					diem.setMa_Hoc_Vien(tfMaHV.getText());
					diem.setMa_Khoa_Hoc(tfMaKH.getText());
					diem.setDiem(diem_so);
					diem.setKet_Qua(tfKetQua.getText());
					
					DiemDAO diemDAO = new DiemDAOImpl();
					diemDAO.update(diem);
					
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
		panel.setBorder(new TitledBorder(null, "Thông tin điểm học viên", TitledBorder.LEADING, TitledBorder.TOP, new Font("Arial", Font.BOLD, 15), null));
		panel.setBounds(40, 65, 400, 235);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		//set jlabel
		jlbMaHV = new JLabel("Mã Học Viên :");
		jlbMaHV.setFont(new Font("Arial", Font.PLAIN, 15));
		jlbMaHV.setBounds(40, 40, 110, 30);
		panel.add(jlbMaHV);
		
		jlbMaKH = new JLabel("Mã Khóa Học :");
		jlbMaKH.setFont(new Font("Arial", Font.PLAIN, 15));
		jlbMaKH.setBounds(40, 90, 110, 30);
		panel.add(jlbMaKH);
		
		jlbDiem = new JLabel("Điểm :");
		jlbDiem.setFont(new Font("Arial", Font.PLAIN, 15));
		jlbDiem.setBounds(40, 140, 110, 30);
		panel.add(jlbDiem);
		
		jlbKetQua = new JLabel("Kết Quả :");
		jlbKetQua.setFont(new Font("Arial", Font.PLAIN, 15));
		jlbKetQua.setBounds(40, 190, 95, 30);
		panel.add(jlbKetQua);
		
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
		
		//set jtextfield
		tfMaHV = new JTextField();
		tfMaHV.setFont(new Font("Arial", Font.PLAIN, 15));
		tfMaHV.setBounds(160, 40, 170, 25);
		panel.add(tfMaHV);
		tfMaHV.setColumns(10);
		
		tfMaKH = new JTextField();
		tfMaKH.setFont(new Font("Arial", Font.PLAIN, 15));
		tfMaKH.setColumns(10);
		tfMaKH.setBounds(160, 90, 170, 25);
		panel.add(tfMaKH);
		
		tfDiem = new JTextField();
		tfDiem.setFont(new Font("Arial", Font.PLAIN, 15));
		tfDiem.setColumns(10);
		tfDiem.setBounds(160, 140, 170, 25);
		panel.add(tfDiem);
		
		tfKetQua = new JTextField();
		tfKetQua.setFont(new Font("Arial", Font.PLAIN, 15));
		tfKetQua.setColumns(10);
		tfKetQua.setBounds(160, 190, 170, 25);
		panel.add(tfKetQua);
	}
}