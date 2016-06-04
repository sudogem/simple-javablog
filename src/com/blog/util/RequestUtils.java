package com.blog.util;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RequestUtils {
	
	public static int getParam(HttpServletRequest request, String param, int defaultValue) {
		try {
			String value = request.getParameter(param);
			return Integer.parseInt(value);
		} catch (Exception e) {
		}
		return defaultValue;
	}

	public static String getParam(HttpServletRequest request, String param, String defaultValue) {
		String value = request.getParameter(param);
		if (value != null) {
			value = value.trim();
		}
		return (StringUtils.isEmpty(value)) ? defaultValue : value;
	}
	
	public static String[] getParamValues(HttpServletRequest request, String param) {
		return request.getParameterValues(param);
	}
	
	public static Integer[] getParamValuesInt(HttpServletRequest request, String param) {
		String[] values = getParamValues(request, param);
		Integer[] intValues = new Integer[0];
		if (values != null) {
			intValues = new Integer[values.length];
			for (int i = 0; i < values.length; i++) {
				int val = 0;
				try {
					val = Integer.parseInt(values[i]);
				} catch (NumberFormatException e) {
				}
				intValues[i] = val;
			}
		}
		return intValues;
	}
	
	public static Cookie getCookie(HttpServletRequest request, String name) {
		Cookie[] cookies = request.getCookies();
		if (cookies == null) {
			return new Cookie(name, "");
		}
		Cookie theCookie = null;
		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals(name)) {
				theCookie = cookies[i];
				break;
			}
		}
		if (theCookie == null) {
			theCookie = new Cookie(name, "");
		}

		return theCookie;
	}

	/**
	 * @param name : name of cookie
	 * @param value : value of cookie
	 * */
	public static void addCookie(HttpServletResponse response, String name, String value) {
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(-1);
		response.addCookie(cookie);
	}

	/**
	 * Cookie path is default to /
	 * 
	 * @param name : name of cookie
	 * @param value : value of cookie
	 * @param age : -1 means it will be invalid when browser is closed
	 * */
	public static void addCookie(HttpServletResponse response, String name, String value, int age) {
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(age);
		cookie.setPath("/");
		response.addCookie(cookie);
	}
	
	/**
	 * @param name : name of cookie
	 * @param value : value of cookie
	 * @param age : -1 means it will be invalid when browser is closed
	 * @param path : path for cookie
	 * */
	public static void addCookie(HttpServletResponse response, String name, String value, int age, String path) {
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(age);
		cookie.setPath(path);
		response.addCookie(cookie);
	}
	
	public static void addSessionAttribute(HttpServletRequest request, String name, Object value) {
		HttpSession session = request.getSession();
		session.setAttribute(name, value);
	}
	
	public static void delCookie(HttpServletResponse response, String name) {
		Cookie cookie = new Cookie(name, null);
		//0 means it will be delete
		cookie.setMaxAge(0);
		cookie.setPath("/");
		response.addCookie(cookie);
	}
	
	public static int getAttribute(HttpServletRequest req, String param, int defaultValue) {
		try {
			Object obj = req.getAttribute(param);
			if (obj != null) {
				return (Integer) obj;
			} else {
				return defaultValue;
			}
		} catch (Exception e) {
			return defaultValue;
		}
	}
	
	@SuppressWarnings("unchecked")
	public static StringBuffer getParamString(HttpServletRequest request) {
		StringBuffer paramString = new StringBuffer(32);
		
		Map<String, String[]> requestMap = request.getParameterMap();
		Set<String> keySet = requestMap.keySet();
		Iterator<String> iterator = keySet.iterator();
		while (iterator.hasNext()) {
			final String paramKey = iterator.next();
			String[] paramValue = requestMap.get(paramKey);
			paramString.append(paramKey);
			paramString.append("=");
			paramString.append(paramValue[0]);
			if (iterator.hasNext()) {
				paramString.append("&");
			}
		}
		
		return paramString;
	}
	
	public static String getComponentContextPath(HttpServletRequest request) {
		return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/";
	}

}
