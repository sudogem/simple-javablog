package com.blog.util;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils extends org.apache.commons.lang.StringUtils {
	
	public static boolean isEmail(String email) {
		Pattern pattern = Pattern.compile("^[\\w-]+(?:\\.[\\w-]+)*@(?:[\\w-]+\\.)+[a-zA-Z]{2,7}$");
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
	
	public String[] splitString(String source, String flg) {
		StringTokenizer st = new StringTokenizer(source, flg);
		String[] arry = new String[st.countTokens()];
		int i = 0;
		while (st.hasMoreTokens()) {
			arry[i] = st.nextToken();
			i++;
		}
		return arry;
	}
	
	public static String filter(String data) {
		String filtered;
		if (isEmpty(data))
			filtered = "";
		else
			filtered = data.trim();
		return filtered;
	}

	public boolean checkContain(String str, String[] arr) {
		boolean flg = false;
		for (int i = 0; i < arr.length; i++) {
			String tempStr = arr[i];
			if (str.equals(tempStr)) {
				flg = true;
				break;
			}
		}
		return flg;
	}

	public static String changeDateOrder(String dateStr) {
		if (dateStr == null) {
			return null;
		}
		String[] arrayStr = dateStr.split("/");
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < arrayStr.length; i++) {
			if (i > 0) {
				buffer.append("/");
			}
			buffer.append(arrayStr[arrayStr.length - 1 - i]);
		}
		return buffer.toString();
	}

	public static Boolean checkIsNumber(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (Exception e) {
		}
		return false;
	}

	public static byte[] getByte(String str) {
		if (str != null && str.equals("")) {
			return str.getBytes();
		} else {
			return null;
		}
	}

//	public static boolean isEmpty(String str) {
//		if (str == null) {
//			return true;
//		}
//		str = str.trim();
//		if (str.equals("")) {
//			return true;
//		}
//		if (str.length() < 1) {
//			return true;
//		}
//		return false;
//	}

	public static double getRound(double dSource, int scale) {
		BigDecimal bd = new BigDecimal(dSource);
		double dRound = bd.setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
		return dRound;
	}

	public static String beginUpper(String str) {
		if (StringUtils.isEmpty(str)) {
			return "";
		}
		if (str.length() < 2) {
			try {
				return String.valueOf(str.toUpperCase().charAt(0));
			} catch (Exception _e) {
				return null;
			}
		} else if (str.indexOf(" ") > -1) {
			String[] arrStr = str.split(" ");
			StringBuffer buffer = new StringBuffer();
			for (int i = 0; i < arrStr.length; i++) {
				if (i > 0) {
					buffer.append(" ");
				}
				if (arrStr[i] != null && arrStr[i].length() > 0) {
					buffer.append(Character.toUpperCase(arrStr[i].charAt(0)));
				}
				if (arrStr[i].length() > 0) {
					buffer.append(arrStr[i].toLowerCase().substring(1, arrStr[i].length()));
				}
			}
			return buffer.toString();
		} else {
			return Character.toUpperCase(str.charAt(0))
					+ str.toLowerCase().substring(1, str.length());
		}
	}

	public static String allBegingUpper(String str) {
		if (str == null) {
			return "";
		}
		String[] arrStr = str.split(" ");
		StringBuffer sb = new StringBuffer();
		for (String tmp : arrStr) {
			sb.append(beginUpper(tmp)).append(" ");
		}
		String allStr = null;
		if (sb.length() > 0) {
			allStr = sb.substring(0, sb.length() - 1);
		} else {
			allStr = sb.toString();
		}
		sb.delete(0, sb.length());
		return allStr;
	}

	/**
	 * inserting a slash after every 3rd character in the user id string.
	 * Eg user id 12357 would be 123/57
	 * @param UserId
	 * @return
	 */
	public static String formatUserId(int UserId) {
		String strUserId = String.valueOf(UserId);
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < strUserId.length(); i++) {
			if (i % 3 == 0 && i != 0) {
				result.append("/");
			}
			result.append(strUserId.charAt(i));
		}
		return result.toString();
	}

	/**
	 * change the new line sign(\n) to the new line sign of HTML(<br/>)
	 * 
	 * @param source
	 *         the source string contain (\n)
	 *         
	 * @return
	 *         the result of change
	 */
	public static String changeNewlineSign(String source) {
		String temp = source;
		if (temp != null && "".equalsIgnoreCase(temp)) {
			temp = temp.replaceAll("\\n", "<br/>");
		}
		return temp;
	}

	public static String formatSQLCondition(String value, boolean isExact) {
		String temp = value;
		if (temp == null) {
			return null;
		}
		if (temp.indexOf("'") > -1) {
			temp = temp.replaceAll("'", "''");
		}
		if (!isExact) {
			if (temp.indexOf("/") > -1) {
				temp = temp.replaceAll("/", "//");
			}
			if (temp.indexOf("%") > -1) {
				temp = temp.replaceAll("%", "/%");
			}
		}
		return temp;
	}
	
	public static String formatFileName(String fileName) {
		String newFileName = fileName;
		if (!isEmpty(newFileName)) {
			newFileName = newFileName.trim().replaceAll(" ", "_");
//			int idx = newFileName.lastIndexOf('.');
//			String name = newFileName.substring(0, idx);
//			String ext = newFileName.substring(name.length());
//			
//			URLEncoder encoder = new URLEncoder();
////			newFileName = encoder.encode(newFileName.trim());
//			
//			newFileName = encoder.encode(name) + ext;
		}
		return newFileName;
	}
	
	public static String replaceHTMLUnicode(String string) {
	    StringBuffer sb = new StringBuffer(string.length());
	    int len = string.length();
	    char c;

	    for (int i = 0; i < len; i++)
	        {
	        c = string.charAt(i);
	        if (c == ' ') {
	                sb.append(' ');
	            }
	        else {
	            
	            if (c == 'Ô')
	            	sb.append("'");
	            else if (c == 'Õ')
	            	sb.append("'");
	            else if (c == 'â')
	            	sb.append("'");
	            else if (c == 'Ò')
	            	sb.append("\"");
	            else if (c == 'Ó')
	            	sb.append("\"");
	            else if (c == 'ã')
	            	sb.append("\"");
	            else {
	                int ci = 0xffff & c;
	                if (ci < 160 )
	                    sb.append(c);
	                else {
	                    sb.append("&#");
	                    sb.append(new Integer(ci).toString());
	                    sb.append(';');
	                    }
	                }
	            }
	        }
	    return sb.toString();
	}
	
	public static HashMap<Integer, Integer> listProductId(String strProducts) {
		
		HashMap<Integer, Integer> productApplied = new HashMap<Integer, Integer>();
		
		if (!strProducts.equals(null)) {
			String[] productAppliedSplit = strProducts.split("[,]");
			Integer[] products = new Integer[productAppliedSplit.length];
			for (int i = 0; i < productAppliedSplit.length; i++) {
				products[i] = Integer.parseInt(productAppliedSplit[i].trim());
			}
			
			for (Integer pa : products) {
				productApplied.put(pa, pa);
			}
		
		}
		
		return productApplied;
	}
	
	public static String filterHighlight(String content, String param) {
		if (content != null && content.length() > 0) {
			StringBuffer newString = new StringBuffer();
			String[] split = content.split(" ");
			for (String str : split) {
				String[] splitParam = param.split(" ");
				for (String strParam : splitParam) {
					if (str.toLowerCase().contains(alterSuffix(strParam.toLowerCase()))) {
						str = highlight(str);
						break;
					}
				}
				newString.append(str);
				newString.append(" ");
			}
			content = newString.toString().trim();
		}
		return content;
	}
	
	public static String trimToFit(String content, String term) {
		if (content != null && content.length() > 0) {
			StringBuffer newString = new StringBuffer();
			String[] split = content.split("[.][ ]");
			for (String sentence : split) {
				int idx = sentence.indexOf(term);
				if (idx >= 0) {
					newString.append(sentence);
					newString.append("&nbsp;...&nbsp;&nbsp;");
				}
			}
			content = newString.toString().trim();
		}
		return content;
	}
	
	public static String alterSuffix(String text) {
		int ext = 0;
		if (text.toLowerCase().endsWith("ed")) {
			ext = "ed".length();
		} else if (text.endsWith("ing")) {
			ext = "ing".length();
		} else if (text.endsWith("est")) {
			ext = "est".length();
		} else if (text.endsWith("en")) {
			ext = "en".length();
		} else if (text.endsWith("ize")) {
			ext = "ize".length();
		} else if (text.endsWith("ise")) {
			ext = "ise".length();
		} else if (text.endsWith("ly")) {
			ext = "ly".length();
		} else if (text.endsWith("able")) {
			ext = "able".length();
		} else if (text.endsWith("ible")) {
			ext = "ible".length();
		} else if (text.endsWith("ful")) {
			ext = "ful".length();
		} else if (text.endsWith("less")) {
			ext = "less".length();
		} else if (text.endsWith("ness")) {
			ext = "ness".length();
		} else if (text.endsWith("ism")) {
			ext = "ism".length();
		} else if (text.endsWith("ment")) {
			ext = "ment".length();
		} else if (text.endsWith("ist")) {
			ext = "ist".length();
		} else if (text.endsWith("er")) {
			ext = "er".length();
		} else if (text.endsWith("al")) {
			ext = "al".length();
		}
		return text.substring(0, text.length() - ext);
	}
	
	public static String highlight(String text) {
		String end = "";
		if (text.endsWith(".")) {
			end = ".";
		} else if (text.endsWith("..")) {
			end = "..";
		} else if (text.endsWith("...")) {
			end = "...";
		} else if (text.endsWith(",")) {
			end = ",";
		} else if (text.endsWith("!")) {
			end = "!";
		} else if (text.endsWith("!!")) {
			end = "!!";
		} else if (text.endsWith("!!!")) {
			end = "!!!";
		} else if (text.endsWith(";")) {
			end = ";";
		} else if (text.endsWith(":")) {
			end = ":";
		} else if (text.endsWith("?")) {
			end = "?";
		} else if (text.endsWith("??")) {
			end = "??";
		} else if (text.endsWith("???")) {
			end = "???";
		}
		
		String newText = text;
		if (end.length() > 0) {
			newText = text.substring(0, text.length() - end.length());
		}
		
		StringBuffer bd = new StringBuffer();
		bd.append("<span style='font-weight:bold;'>").append(newText).append("</span>").append(end);
		return bd.toString();
	}
	
	public static String trimToSize(String text, int maxLen) {
		int len = text.length();
		String newText = text;
		if (len > maxLen) {
			newText = text.substring(0, maxLen) + "...";
		}
		return newText;
	}
	
	public static String getFileExt(String fullFileName) {
		int idx = fullFileName.trim().lastIndexOf(".");
		String ext = "";
		if (idx >= 0) {
			ext = fullFileName.substring(idx + 1, fullFileName.length());
		}
		return ext;
	}
	
	public static String getFileName(String fullFileName) {
		String ext = getFileExt(fullFileName);
		int idx = fullFileName.indexOf('.' + ext);
		return fullFileName.substring(0, idx);
	}
	
	public static String getFileNameForMemcached(String fileName) {
		return fileName = fileName.replaceAll(" ", "_");
	}
	
	public static String formatFromTextArea(String text) {
		if (text == null) 
			return null;
		
		return text.replaceAll("\\n\\r", "<br/><br/>");
	}
	
	public static String formatPlayerName(String name) {
		String playerName = "";
		if (name == null)
			return playerName;
		
		String[] split = name.split(",");
		int length = split.length;
		
		if (length == 2 ) {
			playerName = split[1] + " " + split[0];
		} else if (length > 2) {
			String surname = "";
			StringBuilder firstName = new StringBuilder();
			for (int i = 0; i < length; i++) {
				if (i == 0) {
					surname = split[i];
				} else {
					if (i > 1 && i < length) {
						firstName.append(" ");
					}
					firstName.append(split[i].trim());
				}
			}
			playerName = firstName + " " + surname;
		} else {
			playerName = name;
		}
		
		return playerName;
	}

}
