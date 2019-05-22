package com.example.demo.controller;



import com.example.demo.common.BaseResponse;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class BaseController {

	public BaseResponse ok(Object obj) {
		BaseResponse response = new BaseResponse();
		response.setOutput(obj);
		return response;
	}

	public BaseResponse success(Object obj) {
		return ok(obj);
	}

	protected void responseMessagetCharset(HttpServletResponse response, String message) throws IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("application/json;charset=utf-8");
		try {
			pw.append(message);
		} finally {
			pw.close();
		}
	}

	protected BaseResponse ok() {
		BaseResponse response = new BaseResponse();
		response.setOutput("Operate Success");
		return response;
	}

	protected void validate(BindingResult result){
		if(result.hasFieldErrors()){
			List<FieldError> errorList = result.getFieldErrors();
			errorList.stream().forEach(item -> Assert.isTrue(false,item.getDefaultMessage()));
		}
	}
}
