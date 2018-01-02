package com.zm.publics.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 文件名：DateUtils.java 日期处理相关工具�?
 */
public class DateUtils {

	/** �?-�?-�? �?:�?:�? 显示格式 */
	// 备注:如果使用大写HH标识使用24小时显示格式,如果使用小写hh就表示使�?12小时制格式�??
	public static String DATE_TO_STRING_DETAIAL_PATTERN = "yyyy-MM-dd HH:mm:ss";

	/** �?-�?-�? 显示格式 */
	public static String DATE_TO_STRING_SHORT_PATTERN = "yyyy-MM-dd";

	private static SimpleDateFormat simpleDateFormat;

	/**
	 * Date类型转为指定格式的String类型
	 * 
	 * @param source
	 * @param pattern
	 * @return
	 */
	public static String DateToDatetime(Date source) {
		simpleDateFormat = new SimpleDateFormat(DATE_TO_STRING_DETAIAL_PATTERN);
		if (null != source)
			return simpleDateFormat.format(source);
		else
			return null;
	}

	/**
	 * Date类型转为指定格式的String类型
	 * 
	 * @param source
	 * @param pattern
	 * @return
	 */
	public static String DateToDate(Date source) {
		simpleDateFormat = new SimpleDateFormat(DATE_TO_STRING_SHORT_PATTERN);
		if (null != source)
			return simpleDateFormat.format(source);
		else
			return null;
	}

	/**
	 * Date类型转为指定格式的String类型
	 * 
	 * @param source
	 * @param pattern
	 * @return
	 */
	public static String DateToString(Date source, String pattern) {
		simpleDateFormat = new SimpleDateFormat(pattern);
		return simpleDateFormat.format(source);
	}

	/**
	 * 
	 * unix时间戳转为指定格式的String类型
	 * 
	 * 
	 * System.currentTimeMillis()获得的是是从1970�?1�?1日开始所经过的毫秒数
	 * unix时间�?:是从1970�?1�?1日（UTC/GMT的午夜）�?始所经过的秒�?,不�?�虑闰秒
	 * 
	 * @param source
	 * @param pattern
	 * @return
	 */
	public static String timeStampToString(long source, String pattern) {
		simpleDateFormat = new SimpleDateFormat(pattern);
		Date date = new Date(source * 1000);
		return simpleDateFormat.format(date);
	}

	/**
	 * 
	 * 字符串转换为对应日期(可能会报错异�?)
	 * 
	 * @param source
	 * @param pattern
	 * @return
	 */
	public static Date stringToDate(String source, String pattern) {
		simpleDateFormat = new SimpleDateFormat(pattern);
		Date date = null;
		try {
			date = simpleDateFormat.parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 获得当前时间对应的指定格�?
	 * 
	 * @param pattern
	 * @return
	 */
	public static String currentFormatDate(String pattern) {
		simpleDateFormat = new SimpleDateFormat(pattern);
		return simpleDateFormat.format(new Date());

	}

	/**
	 * 获得当前unix时间�?(单位�?)
	 * 
	 * @return 当前unix时间�?
	 */
	public static long currentTimeStamp() {
		return System.currentTimeMillis() / 1000;
	}
}
