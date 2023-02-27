package qlhv.controller;

import javax.swing.*;
import qlhv.view.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
import java.util.List;
import qlhv.bean.*;

public class ChuyenManHinh {
	private JPanel root;
	private String KindSelected = "";
	
	private List<DanhMuc> ListJpanel = null;
	
	public ChuyenManHinh(JPanel root) {
		this.root = root;
	}
	
	public void setDefault(JPanel jpn, JLabel jlb) throws SQLException {
		KindSelected = "ManHinhChinh";
		jpn.setBackground(new Color(30,144,255));
		jlb.setBackground(new Color(30,144,255));
		root.removeAll();
		root.setLayout(new BorderLayout());
		root.add(new ManHinhChinh());
		root.validate();
		root.repaint();
	}
	
	public void setEvent(List<DanhMuc> ListJpanel) {
		this.ListJpanel = ListJpanel;
		for(DanhMuc item : ListJpanel) {
			item.getJlb().addMouseListener(new labelEvent(item.getKind(), item.getJpn(), item.getJlb()));
		}
	}
	
	class labelEvent implements MouseListener{
		private JPanel node;
		private String kind;
		private JPanel jpnItem;
		private JLabel jlbItem;
		
		public labelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
			this.kind = kind;
			this.jpnItem = jpnItem;
			this.jlbItem = jlbItem;
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			switch (kind) {
				case "Main":
				try {
					node = new ManHinhChinh();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					break;
				case "HSHV":
					node = new HSHV();
					break;
				case "QLKH":
					node = new QLKH();
					break;
				case "QLLH":
					node = new QLLH();
					break;
				case "QLD":
					node = new QLD();
					break;
				case "Thong_Ke":
					node = new Thong_Ke();
					break;
				default:
					break;
			}	
			root.removeAll();
			root.setLayout(new BorderLayout());
			root.add(node);
			root.validate();
			root.repaint();
			setChangeBackground(kind);
		}

		@Override
		public void mousePressed(MouseEvent e) {
			KindSelected = kind;
			jpnItem.setBackground(new Color(30,144,255));
			jlbItem.setBackground(new Color(30,144,255));
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			jpnItem.setBackground(new Color(30,144,255));
			jlbItem.setBackground(new Color(30,144,255));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			if(!KindSelected.equalsIgnoreCase(kind)) {
				jpnItem.setBackground(new Color(0, 153, 51));
				jlbItem.setBackground(new Color(0, 153, 51));
			}
		}
		private void setChangeBackground(String kind) {
			for(DanhMuc item: ListJpanel) {
				if(item.getKind().equalsIgnoreCase(kind)) {
					item.getJpn().setBackground(new Color(30,144,255));
					item.getJlb().setBackground(new Color(30,144,255));
				}else {
					item.getJpn().setBackground(new Color(0, 153, 51));
					item.getJlb().setBackground(new Color(0, 153, 51));
				}
			}
			
		}
	}
	
}
