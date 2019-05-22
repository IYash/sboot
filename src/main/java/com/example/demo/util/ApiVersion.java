package com.example.demo.util;

import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.servlet.mvc.condition.RequestCondition;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Mapping
@Documented
public @interface ApiVersion {
    /**
     * 标识版本号
     * @return
     */
    int value();
}
