package com.example.demo;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.demo.entities.KhachHang;
import com.example.demo.entities.LichSuGia;
import com.example.demo.services.BaseService;

public class Main {
	@Autowired
	private static BaseService<KhachHang> khService;

	@Autowired
	private static BaseService<LichSuGia> lsgService;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		khService = (BaseService<KhachHang>) context.getBean("khachHangService");
		for (KhachHang kh : khService.findAll()) {
			System.out.println(kh.toString());
		}

		
		
//		KhachHang kh = new KhachHang();
//		khService.save(kh);
//		System.out.println(kh.toString());

//		lsgService = (BaseService<LichSuGia>) context.getBean("lichSuGiaService");
//		LichSuGia lsg1 = new LichSuGia("LSG103", 120, 30, Calendar.getInstance().getTime());
//		lsgService.save(lsg1);
//		lsg1.setMaHH("LSG101");
//		lsgService.save(lsg1);
//		lsgService.delete("LSG101");
//		for (LichSuGia lsg : lsgService.findAll()) {
//			System.out.println(lsg.toString());
//		}
	}

}
