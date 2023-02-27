package qlhv.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import qlhv.dao.HocVienDAO;
import qlhv.dao.HocVienDAOImpl;
import qlhv.model.HocVien;

public class HSHV_Add extends JFrame {

	private JPanel contentPane;
	private JButton jbtUpdate, jbtSave;
	private JPanel panel;
		private JTextField tfMaHV, tfHoTen, tfSDT, tfDia_Chi, tfMa_Lop;
		private JLabel jlbMaHV, jlbHoTen, jlbNgay_Sinh, jlbGioi_Tinh, jlbTinh_Trang, jlbSDT, jlbDia_Chi, jlbMa_Lop, jlbcheck1, jlbcheck2, jlbcheck3, jlbcheck4;
		private JRadioButton rdbtNam, rdbtNu;
		private JCheckBox checkbox;
		private JDateChooser jDate;



	public HSHV_Add(HocVien hocVien) {
		setTitle("Lưu Dữ Liệu");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 690, 430);
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
				if(tfMaHV.getText().length() == 0 || tfHoTen.getText().length() == 0 || jDate.getDate() == null || tfMa_Lop.getText().length() == 0) {
					sb.append("Không được để trống phần bắt buộc!");
					tfMaHV.setBackground(Color.RED);
					tfHoTen.setBackground(Color.RED);
					tfMa_Lop.setBackground(Color.RED);
					tfMaHV.setForeground(Color.WHITE);
					tfHoTen.setForeground(Color.WHITE);
					tfMa_Lop.setForeground(Color.WHITE);
				}else {
					tfMaHV.setBackground(Color.WHITE);
					tfHoTen.setBackground(Color.WHITE);
					tfMa_Lop.setBackground(Color.WHITE);
					tfMaHV.setForeground(Color.BLACK);
					tfHoTen.setForeground(Color.BLACK);
					tfMa_Lop.setForeground(Color.BLACK);
				}
				if(sb.length() > 0) {
					JOptionPane.showMessageDialog(jbtSave, sb);
					return;
				}
				try {
					HocVien hocVien = new HocVien();
					hocVien.setMa_Hoc_Vien(tfMaHV.getText());
					hocVien.setHo_Ten(tfHoTen.getText());
					hocVien.setNgay_Sinh(covertDateToDateSql(jDate.getDate()));
					hocVien.setSo_Dien_Thoai(tfSDT.getText());
					hocVien.setDia_Chi(tfDia_Chi.getText());
					hocVien.setGioi_Tinh(rdbtNam.isSelected() ? true : false);
					hocVien.setMa_Lop_Hoc(tfMa_Lop.getText());
					hocVien.setTinh_trang(checkbox.isSelected());
					
					HocVienDAO hocvienDAO = new HocVienDAOImpl();
					hocvienDAO.create(hocVien);
					
					JOptionPane.showMessageDialog(jbtSave, "Thành Công");
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(jbtSave, "Erorr: " + e2.getMessage());
					e2.printStackTrace();
				}
			}
		});
		jbtSave.setIcon(new ImageIcon(HSHV_Add.class.getResource("/qlhv/images/Save-icon.png")));
		jbtSave.setFont(new Font("Arial", Font.BOLD, 20));
		jbtSave.setBounds(460, 15, 210, 41);
		contentPane.add(jbtSave);
		
		jbtUpdate = new JButton("Cập Nhật Dữ Liệu");
		jbtUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuilder sb = new StringBuilder();
				if(tfMaHV.getText().length() == 0 || tfHoTen.getText().length() == 0 || jDate.getDate() == null || tfMa_Lop.getText().length() == 0) {
					sb.append("Không được để trống phần bắt buộc!");
					tfMaHV.setBackground(Color.RED);
					tfHoTen.setBackground(Color.RED);
					tfMa_Lop.setBackground(Color.RED);
					tfMaHV.setForeground(Color.WHITE);
					tfHoTen.setForeground(Color.WHITE);
					tfMa_Lop.setForeground(Color.WHITE);
				}else {
					tfMaHV.setBackground(Color.WHITE);
					tfHoTen.setBackground(Color.WHITE);
					tfMa_Lop.setBackground(Color.WHITE);
					tfMaHV.setForeground(Color.BLACK);
					tfHoTen.setForeground(Color.BLACK);
					tfMa_Lop.setForeground(Color.BLACK);
				}
				if(sb.length() > 0) {
					JOptionPane.showMessageDialog(jbtUpdate, sb);
					return;
				}
				if(JOptionPane.showConfirmDialog(tfMaHV, "Bạn có muốn cập nhật dữ liệu học viên này không?"
						+ "\nNhấn vào 'Yes' hoặc 'Cancel' để cập nhật \n Nhấn vào 'No' để hoàn tác ") == JOptionPane.NO_OPTION) {
					return;
				}
				try {
					HocVien hocVien = new HocVien();
					hocVien.setMa_Hoc_Vien(tfMaHV.getText());
					hocVien.setHo_Ten(tfHoTen.getText());
					hocVien.setNgay_Sinh(covertDateToDateSql(jDate.getDate()));
					hocVien.setSo_Dien_Thoai(tfSDT.getText());
					hocVien.setDia_Chi(tfDia_Chi.getText());
					hocVien.setGioi_Tinh(rdbtNam.isSelected() ? true : false);
					hocVien.setMa_Lop_Hoc(tfMa_Lop.getText());
					hocVien.setTinh_trang(checkbox.isSelected());
					
					HocVienDAO hocvienDAO = new HocVienDAOImpl();
					hocvienDAO.update(hocVien);
					
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
		jbtUpdate.setBounds(180, 15, 253, 41);
		contentPane.add(jbtUpdate);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Thông Tin Học Viên", TitledBorder.LEADING, TitledBorder.TOP, new Font("Arial", Font.BOLD, 15), null));
		panel.setBounds(10, 65, 660, 310);
		contentPane.add(panel);
		panel.setLayout(null);
		
		//set jlabel
		jlbMaHV = new JLabel("Mã Học Viên :");
		jlbMaHV.setFont(new Font("Arial", Font.PLAIN, 15));
		jlbMaHV.setBounds(40, 40, 95, 30);
		panel.add(jlbMaHV);
		
		jlbHoTen = new JLabel("Họ Tên :");
		jlbHoTen.setFont(new Font("Arial", Font.PLAIN, 15));
		jlbHoTen.setBounds(40, 90, 95, 30);
		panel.add(jlbHoTen);
		
		jlbNgay_Sinh = new JLabel("Ngày Sinh :");
		jlbNgay_Sinh.setFont(new Font("Arial", Font.PLAIN, 15));
		jlbNgay_Sinh.setBounds(40, 140, 95, 30);
		panel.add(jlbNgay_Sinh);
		
		jlbGioi_Tinh = new JLabel("Giới Tính :");
		jlbGioi_Tinh.setFont(new Font("Arial", Font.PLAIN, 15));
		jlbGioi_Tinh.setBounds(40, 190, 95, 30);
		panel.add(jlbGioi_Tinh);
		
		jlbTinh_Trang = new JLabel("Tình Trạng :");
		jlbTinh_Trang.setFont(new Font("Arial", Font.PLAIN, 15));
		jlbTinh_Trang.setBounds(40, 240, 95, 30);
		panel.add(jlbTinh_Trang);
		
		jlbSDT = new JLabel("SĐT :");
		jlbSDT.setFont(new Font("Arial", Font.PLAIN, 15));
		jlbSDT.setBounds(350, 40, 95, 30);
		panel.add(jlbSDT);
		
		jlbDia_Chi = new JLabel("Địa Chỉ :");
		jlbDia_Chi.setFont(new Font("Arial", Font.PLAIN, 15));
		jlbDia_Chi.setBounds(350, 140, 95, 30);
		panel.add(jlbDia_Chi);
		
		jlbMa_Lop = new JLabel("Mã Lớp :");
		jlbMa_Lop.setFont(new Font("Arial", Font.PLAIN, 15));
		jlbMa_Lop.setBounds(350, 90, 95, 30);
		panel.add(jlbMa_Lop);
		
		jlbcheck1 = new JLabel("(*)");
		jlbcheck1.setForeground(Color.RED);
		jlbcheck1.setFont(new Font("Arial", Font.BOLD, 15));
		jlbcheck1.setBounds(315, 40, 21, 23);
		panel.add(jlbcheck1);
		
		jlbcheck2 = new JLabel("(*)");
		jlbcheck2.setForeground(Color.RED);
		jlbcheck2.setFont(new Font("Arial", Font.BOLD, 15));
		jlbcheck2.setBounds(315, 90, 21, 23);
		panel.add(jlbcheck2);
		
		jlbcheck3 = new JLabel("(*)");
		jlbcheck3.setForeground(Color.RED);
		jlbcheck3.setFont(new Font("Arial", Font.BOLD, 15));
		jlbcheck3.setBounds(315, 147, 21, 23);
		panel.add(jlbcheck3);
		
		jlbcheck4 = new JLabel("(*)");
		jlbcheck4.setForeground(Color.RED);
		jlbcheck4.setFont(new Font("Arial", Font.BOLD, 15));
		jlbcheck4.setBounds(623, 90, 21, 23);
		panel.add(jlbcheck4);
		
		//set jtextfield
		tfMaHV = new JTextField();
		tfMaHV.setFont(new Font("Arial", Font.PLAIN, 15));
		tfMaHV.setBounds(140, 40, 170, 25);
		panel.add(tfMaHV);
		tfMaHV.setColumns(10);
		
		tfHoTen = new JTextField();
		tfHoTen.setFont(new Font("Arial", Font.PLAIN, 15));
		tfHoTen.setColumns(10);
		tfHoTen.setBounds(140, 93, 170, 25);
		panel.add(tfHoTen);
		
		tfSDT = new JTextField();
		tfSDT.setFont(new Font("Arial", Font.PLAIN, 15));
		tfSDT.setColumns(10);
		tfSDT.setBounds(443, 43, 170, 25);
		panel.add(tfSDT);
		
		tfDia_Chi = new JTextField();
		tfDia_Chi.setFont(new Font("Arial", Font.BOLD, 15));
		tfDia_Chi.setColumns(10);
		tfDia_Chi.setBounds(443, 147, 187, 44);
		panel.add(tfDia_Chi);
		
		tfMa_Lop = new JTextField();
		tfMa_Lop.setFont(new Font("Arial", Font.PLAIN, 15));
		tfMa_Lop.setColumns(10);
		tfMa_Lop.setBounds(443, 93, 170, 25);
		panel.add(tfMa_Lop);
		
		//set jradiobutton
		rdbtNam = new JRadioButton("Nam");
		rdbtNam.setSelected(true);
		rdbtNam.setFont(new Font("Arial", Font.PLAIN, 15));
		rdbtNam.setBounds(140, 196, 57, 21);
		panel.add(rdbtNam);
		
		rdbtNu = new JRadioButton("Nữ");
		rdbtNu.setFont(new Font("Arial", Font.PLAIN, 15));
		rdbtNu.setBounds(220, 196, 57, 21);
		panel.add(rdbtNu);
		
		// buttonGroup dùng để kết nối các radiobutton (chỉ duy nhất một button trong group đc nhấn xuống)
		ButtonGroup br = new ButtonGroup();
		br.add(rdbtNam);
		br.add(rdbtNu);
		
		checkbox = new JCheckBox("Hoạt Động");
		checkbox.setFont(new Font("Arial", Font.PLAIN, 15));
		checkbox.setBounds(140, 244, 105, 25);
		panel.add(checkbox);
		
		jDate = new JDateChooser();
		jDate.setBackground(new Color(255, 255, 255));
		jDate.setDateFormatString("yyyy-MM-dd");
		jDate.setBounds(140, 145, 170, 25);
		panel.add(jDate);
		
	}
	
	public java.sql.Date covertDateToDateSql(java.util.Date date) {
        return new java.sql.Date(date.getTime());
    }
}
