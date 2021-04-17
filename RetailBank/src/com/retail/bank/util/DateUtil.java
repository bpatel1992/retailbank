package com.retail.bank.util;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtil {
	
	public static Date getCurrentDate() {
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		return date;
	}

}
