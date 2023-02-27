package qlhv.controller;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.Date;
import java.util.List;
import java.util.Spliterators.AbstractDoubleSpliterator;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;
import org.jfree.data.general.Dataset;

import qlhv.bean.KhoaHocBean;
import qlhv.bean.LopHocBean;
import qlhv.service.ThongKeService;
import qlhv.service.ThongKeServiceImpl;

public class ThongKeController {
	private ThongKeService thongkeService = null;
	
	public ThongKeController() {
		this.thongkeService = new ThongKeServiceImpl();
	}
	
	public void setDataToChart1(JPanel jpnItem) {
		List<LopHocBean> listItem = thongkeService.getListByLopHoc();
		if(listItem != null) {
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
			for(LopHocBean item : listItem) {
				dataset.addValue(item.getSoLuongLopHoc(), "Số Lớp Học", item.getTenLopHoc());
			}
			
			JFreeChart chart = ChartFactory.createBarChart("BIỂU ĐỒ HIỂN THỊ SỐ LƯỢNG LỚP HỌC ĐANG HOẠT ĐỘNG", "Tên lớp học", "Số lượng", dataset);
			ChartPanel chartpn = new ChartPanel(chart);
			chartpn.setPreferredSize(new Dimension(jpnItem.getWidth(), 300));
			
			jpnItem.removeAll();
			jpnItem.setLayout(new BorderLayout());
			jpnItem.add(chartpn);
		}
	}
	
	public void setDataToChart2(JPanel jpnItem) {
		List<KhoaHocBean> listItem = thongkeService.getListByKhoaHoc();
		if(listItem != null) {
			TaskSeriesCollection ds = new TaskSeriesCollection();
			TaskSeries taskSeries;
			Task task;
			for(KhoaHocBean item : listItem) {
				taskSeries = new TaskSeries(item.getMaKhoaHoc());
				task = new Task(item.getMaKhoaHoc(), item.getNgayBatDau(), item.getNgayKetThuc());
				taskSeries.add(task);
				ds.add(taskSeries);
			}
			
			JFreeChart chart = ChartFactory.createGanttChart("BIỂU ĐỒ THEO DÕI TÌNH TRẠNG KHÓA HỌC ĐANG HOẠT ĐỘNG", "Khóa học", "Thời gian", ds);
			
			ChartPanel chartpn = new ChartPanel(chart);
			chartpn.setPreferredSize(new Dimension(jpnItem.getWidth(), 300));
			
			jpnItem.removeAll();
			jpnItem.setLayout(new BorderLayout());
			jpnItem.add(chartpn);
		}
	}
}
