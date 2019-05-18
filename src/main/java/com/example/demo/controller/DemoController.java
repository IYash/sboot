package com.example.demo.controller;

import com.example.demo.common.BaseResponse;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/demo")
public class DemoController extends BaseController{

    @GetMapping("hello")
    public BaseResponse getAuthorization() throws Exception {
        return ok("");
    }
}
