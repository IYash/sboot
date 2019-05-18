package com.example.demo.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class Package implements Serializable {

    private String uuid;//识别号
    private PackageItem from;
    private PackageItem to;
    private String desc;
    @Data
    static class PackageItem implements Serializable{
        private String username;
        private String updateTime;
        private Point point;//坐标
        @Data
        static class Point implements Serializable{
            private  String x;
            private  String y;
        }
    }
}
