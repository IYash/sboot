package com.example.demo.controller;

import com.example.demo.common.BaseResponse;
import com.example.demo.util.ApiVersion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/{version}/dd")
@ApiVersion(1)
public class VersionController extends BaseController{
    @GetMapping("hello")
    public BaseResponse versionHello(){
        return ok(1);
    }
}
