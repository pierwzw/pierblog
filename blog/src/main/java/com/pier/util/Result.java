package com.pier.util;

import java.util.HashMap;

/**
 * @auther zhongweiwu
 * @date 2019/6/30 19:30
 */
public class Result extends HashMap<String, Object> {

	public Result() {
		setCode("0");
		setMessage("success");
	}

	public void setCode(String code) {
		put("code", code);
	}

	public void setMessage(String message) {
		put("message", message);
	}

	public void setError(String code, String message) {
		setCode(code);
		setMessage(message);
	}

	public String getCode() {
		return (String)get("code");
	}

	public String getMessage() {
		return (String)get("message");
	}
}
