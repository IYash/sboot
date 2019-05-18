package com.example.demo.controller;

import com.example.demo.common.BaseResponse;
import com.example.demo.dto.Package;
import com.example.demo.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/package")
public class PackageController extends BaseController {

    @Autowired
    private PackageService packageService;

    @GetMapping("fetchPackage")
    public BaseResponse fetchPackage()  {
        List<Package> packageList = packageService.fetchPackage();
        return ok(packageList);
    }
    @PostMapping("conPackage")
    public BaseResponse conPackage(@RequestBody Package pack) {
        packageService.conPackage(pack);
        return ok("");
    }
}
