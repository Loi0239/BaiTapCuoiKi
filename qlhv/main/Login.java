package qlhv.main;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import qlhv.view.*;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField tf_tk;
	private JPasswordField tf_mk;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("Đăng Nhập");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 633, 347);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tf_tk = new JTextField();
		tf_tk.setFont(new Font("Arial", Font.BOLD, 15));
		tf_tk.setBounds(342, 68, 215, 33);
		contentPane.add(tf_tk);
		tf_tk.setColumns(10);
		
		JLabel jlb_tk = new JLabel("Tên tài khoản :");
		jlb_tk.setFont(new Font("Arial", Font.BOLD, 20));
		jlb_tk.setForeground(Color.WHITE);
		jlb_tk.setBounds(186, 65, 146, 33);
		contentPane.add(jlb_tk);
		
		JLabel jlb_mk = new JLabel("Mật khẩu :");
		jlb_mk.setFont(new Font("Arial", Font.BOLD, 20));
		jlb_mk.setForeground(Color.WHITE);
		jlb_mk.setBounds(186, 127, 113, 33);
		contentPane.add(jlb_mk);
		
		JButton login_bt = new JButton("Đăng Nhập");
		login_bt.setBackground(Color.WHITE);
		login_bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tf_tk.getText().equals("admin") && tf_mk.getText().equals("123456")) {
					setVisible(false);
					new MainPanel();
				}else {
					JOptionPane.showMessageDialog(login_bt, "Sai thông tin tài khoản hoặc mật khẩu \nVui lòng đăng nhập lại!");
				}
			}
		});
		login_bt.setFont(new Font("Arial", Font.BOLD, 15));
		login_bt.setBounds(384, 192, 134, 40);
		contentPane.add(login_bt);
		
		tf_mk = new JPasswordField();
		tf_mk.setBounds(342, 130, 215, 33);
		contentPane.add(tf_mk);
		
		JLabel jlb_login = new JLabel("New label");
		jlb_login.setIcon(new ImageIcon(Login.class.getResource("/qlhv/images/login-3.jpg")));
		jlb_login.setBounds(0, 0, 619, 319);
		contentPane.add(jlb_login);
		
		
	}
}
