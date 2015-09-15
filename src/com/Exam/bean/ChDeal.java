package com.Exam.bean;

import java.text.SimpleDateFormat;
import java.util.*;

//字符处理类
public class ChDeal {
public static String toChinese(String strvalue) {
	try {
		if (strvalue == null) {
			return "";
		} else {
			strvalue = new String(strvalue.getBytes("gb2312"), "GBK")
					.trim();
			return strvalue;
		}
	} catch (Exception e) {
		return "";
	}
}

public static String toISO(String strValue) {
	try {
		if (strValue == null) {
			return "";
		} else {
			strValue = new String(strValue.getBytes("GBK"), "gb2312")
					.trim();
			return strValue;
		}
	} catch (Exception e) {
		return "";
	}
}

		/**
		 * 完成从字符串到String数组的转换
		 * 
		 * @param str
		 * @return
		 */
		public static String[] str2IntegerArr(String str){
			String[] is = null ;
			if(str != null && !str.equalsIgnoreCase("")){
				String[] ss = str.split(" ");
				if(ss != null && ss.length > 0){
					is = new String[ss.length];
					for(int i = 0 ; i < ss.length ; i ++){
						is[i] = ss[i];
					}
				}
			}
			return is ;
		}
//		编写获得日期和时间的方法．
public static String  getDateTime(){						//该方法返回值为String类型
	SimpleDateFormat format;                                //simpleDateFormat类使得可以选择任何用户定义的日期-时间格式的模式
	Date date = null;
	Calendar myDate = Calendar.getInstance();               //Calendar 的方法 getInstance，以获得此类型的一个通用的对象
	myDate.setTime(new java.util.Date());                   //使用给定的 Date 设置此 Calendar 的时间
	date = myDate.getTime();                                //返回一个表示此 Calendar 时间值（从历元至现在的毫秒偏移量）的 Date 对象
	format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   //设置时间格式为：年、月、日、时、分、秒
	String strRtn = format.format(date);                    //将给定的 Date 格式化为日期/时间字符串，并将结果赋值给　给定的 String
	return strRtn;
}
}
