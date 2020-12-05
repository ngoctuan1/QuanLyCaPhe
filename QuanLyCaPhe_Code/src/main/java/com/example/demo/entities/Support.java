package com.example.demo.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Support {
	public static String returnFromIntType(int object, int type) {

//		---- 1. GioiTinh 2.TraiThai 3. CapDo ----
		switch (type) {
		case 1:
			return (object == 0) ? "Nữ" : "Nam";
		case 2:
			return (object == 0) ? "Khóa" : "Kích Hoạt";
		case 3:
			return (object == 0) ? "Member" : "VIP";
		default:
			return (object == 0) ? "Nhân Viên" : (object == 1) ? "Pha Chế" : (object == 2) ? "Quản Lý" : "Admin";
		}
	}

//	---VD:String.format("%s - %s", this.maCaLam , this.tenCaLam)---
	public static String returnStringFormat(String... objs) {
		String formatText = "%s - ";
		formatText = formatText.repeat(objs.length);
//		for (int i = 1; i < objs.length; i++) {
//			format += "%s - ";
//		}
		formatText = formatText.substring(0, formatText.length() - 3);
		return String.format(formatText, objs);
	}

	public static String returnStringMaObject(String ma, int sId) {
		return String.format(ma + "%03d", sId);
	}

	public static String convertDateToString(Date d) {
		return new SimpleDateFormat("dd/mm/yyyy").format(d);
	}

	@SuppressWarnings("deprecation")
	public static Date convertStringToDate(String s) {
		Pattern t = Pattern.compile("(\\d+)[.\\s/-]{1,3}(\\d{1,2})[.\\s/-]{1,3}(\\d+)");
		Matcher m = t.matcher(s);
		int day, month, year;
		if (m.find()) {
			if (m.group(1).length() == 4) {
				year = Integer.parseInt(m.group(1));
				day = Integer.parseInt(m.group(3));
			} else {
				year = Integer.parseInt(m.group(3));
				day = Integer.parseInt(m.group(1));
			}
			month = Integer.parseInt(m.group(2));
			return new Date(year, month, day);

		} else {
			return null;
		}
	}
}
