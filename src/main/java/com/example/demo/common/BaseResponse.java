package com.example.demo.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;


public class BaseResponse {
	private String code;
	private String message;
	private Object data;

	public void setOutput(Object data) {
		this.data = data;
		this.code = ResponseTypeEnum.SUCCESS.getCode();
		this.message = ResponseTypeEnum.SUCCESS.name();
	}

	public void setErrorOutput(String code, String msg) {
		this.code = code;
		this.message = msg;
	}

	public void setErrorOutput(String msg) {
		this.code = ResponseTypeEnum.FAILED.getCode();
		this.message = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this, SerializerFeature.WriteMapNullValue);
	}

	

}
