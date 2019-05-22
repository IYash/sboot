package com.example.demo.controller;

import com.example.demo.common.BaseResponse;
import com.example.demo.dto.AuthorizeIn;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/authorize")
public class AuthorizeController extends BaseController {

    @PostMapping("authorize")
    public BaseResponse authorize(@Valid AuthorizeIn ain, BindingResult result){
       validate(result);
       return ok();
    }
}
