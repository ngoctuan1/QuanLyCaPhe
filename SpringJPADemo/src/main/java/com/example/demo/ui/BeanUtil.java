package com.example.demo.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanUtil {

	public static Object getBeanByName(String name) {
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("src\\main\\java\\beans.xml");
			
			return context.getBean(name);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("NULL");
			return null;
		}
	}
}
