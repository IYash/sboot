package com.example.demo.service.impl;

import com.example.demo.component.RedisUtil;
import com.example.demo.dto.Package;
import com.example.demo.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultPackageService implements PackageService<Package> {

    @Autowired
    private RedisUtil redisUtil;

    private static final String PACKAGE_FETCH="packageAll";

    @Override
    public List<Package> fetchPackage() {
        List<Object> objs = redisUtil.lGet(PACKAGE_FETCH,0,-1);
        List<Package> packages= new ArrayList<>();
        for(Object obj:objs){
            if(obj instanceof Package){
                packages.add((Package)obj);
            }
        }
        return packages;
    }

    @Override
    public void conPackage(Package pack) {
        redisUtil.lSet(PACKAGE_FETCH,pack);
    }
}
