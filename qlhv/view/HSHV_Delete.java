package qlhv.view;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import qlhv.dao.HocVienDAO;
import qlhv.dao.HocVienDAOImpl;
import qlhv.model.HocVien;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HSHV_Delete extends JFrame {

	private JPanel contentPane;
	private JLabel jlb1, jlb2;
	private JTextField tfMaHV;
	private JButton jbtDelete;

	public HSHV_Delete(HocVien hocVien) {
		setTitle("Xóa Dữ Liệu");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 654, 185);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		jlb1 = new JLabel("Nhập mã học viên để");
		jlb1.setForeground(new Color(255, 153, 51));
		jlb1.setFont(new Font("Arial", Font.BOLD, 20));
		jlb1.setBounds(23, 30, 211, 30);
		contentPane.add(jlb1);
		
		jlb2 = new JLabel("tìm học viên cần xóa :");
		jlb2.setForeground(new Color(255, 153, 51));
		jlb2.setFont(new Font("Arial", Font.BOLD, 20));
		jlb2.setBounds(23, 62, 211, 30);
		contentPane.add(jlb2);
		
		tfMaHV = new JTextField();
		tfMaHV.setFont(new Font("Arial", Font.BOLD, 20));
		tfMaHV.setBounds(244, 41, 184, 40);
		contentPane.add(tfMaHV);
		tfMaHV.setColumns(10);
		
		jbtDelete = new JButton("Xóa");
		jbtDelete.setForeground(Color.WHITE);
		jbtDelete.setBackground(new Color(255, 0, 51));
		jbtDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StringBuilder sb = new StringBuilder();
				if(tfMaHV.getText().length() == 0) {
					sb.append("Không được để trống mã học viên cần xóa!");
					tfMaHV.setBackground(Color.RED);
				}else {
					tfMaHV.setBackground(Color.WHITE);
				}
				if(sb.length() > 0) {
					JOptionPane.showMessageDialog(jbtDelete, sb);
					return;
				}
				if(JOptionPane.showConfirmDialog(tfMaHV, "Bạn có chắc chắn muốn xóa dữ liệu học viên này không?"
						+ "\nNhấn vào 'Yes' hoặc 'Cancel' để xóa \n Nhấn vào 'No' để hoàn tác ") == JOptionPane.NO_OPTION) {
					return;
				}
				try {
					HocVienDAO hocvienDAO = new HocVienDAOImpl();
					hocvienDAO.delete(tfMaHV.getText());
					
					JOptionPane.showMessageDialog(jbtDelete, "Xóa thành công");
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(jbtDelete, "Erorr: " + e2.getMessage());
					e2.printStackTrace();
				}
			}
		});
		jbtDelete.setIcon(new ImageIcon(HSHV_Delete.class.getResource("/qlhv/images/Close-2-icon.png")));
		jbtDelete.setFont(new Font("Arial", Font.BOLD, 20));
		jbtDelete.setBounds(469, 41, 125, 40);
		contentPane.add(jbtDelete);
	}
}
