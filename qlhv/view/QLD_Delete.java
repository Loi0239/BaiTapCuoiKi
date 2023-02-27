package qlhv.view;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import qlhv.dao.DiemDAO;
import qlhv.dao.DiemDAOImpl;
import qlhv.model.Diem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QLD_Delete extends JFrame {

	private JPanel contentPane;
	private JLabel jlb1, jlb2;
	private JTextField tfMaHV;
	private JButton jbtDelete;
	private JLabel lb3;
	private JLabel lb4;
	private JTextField tfMaKH;

	public QLD_Delete(Diem diem) {
		setTitle("Xóa Dữ Liệu");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 620, 240);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		jlb1 = new JLabel("Nhập mã học viên và mã khóa học để tìm thông tin");
		jlb1.setForeground(new Color(255, 153, 51));
		jlb1.setFont(new Font("Arial", Font.BOLD, 20));
		jlb1.setBounds(60, 10, 500, 30);
		contentPane.add(jlb1);
		
		jlb2 = new JLabel("điểm học viên cần xóa :");
		jlb2.setForeground(new Color(255, 153, 51));
		jlb2.setFont(new Font("Arial", Font.BOLD, 20));
		jlb2.setBounds(180, 46, 237, 30);
		contentPane.add(jlb2);
		
		tfMaHV = new JTextField();
		tfMaHV.setFont(new Font("Arial", Font.BOLD, 20));
		tfMaHV.setBounds(20, 130, 184, 40);
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
					sb.append("Không được để trống mã lớp học cần xóa!");
					tfMaHV.setBackground(Color.RED);
				}else {
					tfMaHV.setBackground(Color.WHITE);
				}
				if(sb.length() > 0) {
					JOptionPane.showMessageDialog(jbtDelete, sb);
					return;
				}
				if(JOptionPane.showConfirmDialog(tfMaHV, "Bạn có chắc chắn muốn xóa dữ liệu điểm học viên này không?"
						+ "\nNhấn vào 'Yes' hoặc 'Cancel' để xóa \n Nhấn vào 'No' để hoàn tác ") == JOptionPane.NO_OPTION) {
					return;
				}
				try {
					DiemDAO diemDAO = new DiemDAOImpl();
					diemDAO.delete(tfMaHV.getText(), tfMaKH.getText());
					
					JOptionPane.showMessageDialog(jbtDelete, "Xóa thành công");
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(jbtDelete, "Erorr: " + e2.getMessage());
					e2.printStackTrace();
				}
			}
		});
		jbtDelete.setIcon(new ImageIcon(HSHV_Delete.class.getResource("/qlhv/images/Close-2-icon.png")));
		jbtDelete.setFont(new Font("Arial", Font.BOLD, 20));
		jbtDelete.setBounds(460, 130, 125, 40);
		contentPane.add(jbtDelete);
		
		lb3 = new JLabel("Mã Học Viên :");
		lb3.setForeground(new Color(255, 153, 51));
		lb3.setFont(new Font("Arial", Font.BOLD, 20));
		lb3.setBounds(20, 90, 222, 30);
		contentPane.add(lb3);
		
		lb4 = new JLabel("Mã Khóa Học :");
		lb4.setForeground(new Color(255, 153, 51));
		lb4.setFont(new Font("Arial", Font.BOLD, 20));
		lb4.setBounds(240, 90, 222, 30);
		contentPane.add(lb4);
		
		tfMaKH = new JTextField();
		tfMaKH.setFont(new Font("Arial", Font.BOLD, 20));
		tfMaKH.setColumns(10);
		tfMaKH.setBounds(240, 130, 184, 40);
		contentPane.add(tfMaKH);
	}
}