package com.example.demo.service;

import java.util.List;

public interface PackageService<T> {

    List<T> fetchPackage();
    void conPackage(T pack);
}
