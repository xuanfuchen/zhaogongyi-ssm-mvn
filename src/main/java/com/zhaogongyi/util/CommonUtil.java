package com.zhaogongyi.util;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class CommonUtil {
	public static String convertDate2Str(java.util.Date d, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(d);
	}
	
	public static String articleFormat(String content) {
    	if (content == null) {
    		return "";
    	}
    	//目标是英语的时候单词和单词之间的空格会被替换成&nbsp;导致显示的英文单词连成一片，不能实现自动换行！
    	//必须替换成"&nbsp; "，加多一个空格
        content = content.replaceAll(" ", "&nbsp; ");
        content = content.replaceAll("\n", "<br>");
        content = content.replaceAll("\r", "<br>");
        content = content.replaceAll("\r\n", "<br>");
        return content;
    }
	
	public static boolean notNullnotEmty(String target) {
		return (target != null && !target.equals(""));
	}
	
	public static boolean notNullnotEmty(Integer target) {
		return (target != null);
	}

	public static boolean nullOrEmty(String target) {
		return (target == null || target.equals(""));
	}
	
	public static String devidedByComma(List list) {
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < list.size(); i++) {
			if (i == list.size() - 1) {
				buf.append(list.get(i));
			} else {
				buf.append(list.get(i)).append(",");
			}
		}
		return buf.toString();
	}
	
	public static String devidedByComma(Object[] list) {
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < list.length; i++) {
			if (i == list.length - 1) {
				buf.append(list[i]);
			} else {
				buf.append(list[i]).append(",");
			}
		}
		return buf.toString();
	}
	
	public static String dateToString(Date date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String s = "";
		if (date != null && !"".equals(date)) {
			s = sdf.format(date);
		}
		return s;
	}

	public static String getNullString(Object obj) {
		String str = "";
		if (obj == null || "".equals(obj) || obj == "null" || "null".equals(obj)) {
			str = "";
		} else {
			str = obj.toString();
		}
		return str;
	}
	
	// 生成ID,长度为32位
	public static String getUUID() {
		return java.util.UUID.randomUUID().toString().replaceAll("-", "");
	}

	// 得到随机数，传入maxNumNotContain，得到0~maxNumNotContain-1之间的int随机数，不包括maxNumNotContain
	public static int getRandomInt(int maxNumNotContain) {
		return new Random().nextInt(maxNumNotContain);
	}
	
	public static String getStrByArr(String[] ids) {
		if (ids == null) {
			return "";
		}
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < ids.length; i++) {
			buf.append(ids[i]).append(",");
		}
		return buf.substring(0, buf.length() - 1);
	}
	public static String unescape(final String dataStr) throws UnsupportedEncodingException {
		int start = 0;
		int end = 0;
		if (dataStr==null || dataStr.equals(""))//等于null短路不造成dataStr.equals空指针
			return "";
		
		String data = java.net.URLEncoder.encode(dataStr, "UTF-8");
		final StringBuffer buffer = new StringBuffer();
		end = data.indexOf("%0");
		while(data.length()>0){
			if (end==-1){//没有中文
				buffer.append(java.net.URLDecoder.decode(data, "UTF-8"));
				break;
			}
			String charStrF = data.substring(0, end);
			String charStrN = data.substring(end+2, end+6);
			data = data.substring(end+6);
			buffer.append(java.net.URLDecoder.decode(charStrF, "UTF-8"));
			char letter = (char) Integer.parseInt(charStrN, 16);
			buffer.append(new Character(letter).toString());
			end = data.indexOf("%0");
		}
		return buffer.toString();
	}

	public static String escape(String src) {
		int i;
		char j;
		StringBuffer tmp = new StringBuffer();
		tmp.ensureCapacity(src.length() * 6);
		for (i = 0; i < src.length(); i++) {
			j = src.charAt(i);
			if (Character.isDigit(j) || Character.isLowerCase(j) || Character.isUpperCase(j))
				tmp.append(j);
			else if (j < 256) {
				tmp.append("%");
				if (j < 16)
					tmp.append("0");
				tmp.append(Integer.toString(j, 16));
			} else {
				tmp.append("%u");
				tmp.append(Integer.toString(j, 16));
			}
		}
		return tmp.toString();
	}
	
}
