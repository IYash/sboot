package com.example.demo.component;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Aspect
@Component
@Slf4j
public class WebExceptionAspect implements ThrowsAdvice {
    //凡是注解了PostMapping的方法都被拦截
    @Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    private void webPointcut(){}

    @AfterThrowing(pointcut = "webPointcut()",throwing ="e" )
    public void handleThrowing(Exception e){
        log.error("发现异常" + e.getMessage());
        if(StringUtils.isNotBlank(e.getMessage())){
            writeContent(e.getMessage());
        }else
        writeContent("出现异常");
    }

    /**
     * 将内容输出到浏览器
     * @param content
     */
    private void writeContent(String content){
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        response.reset();
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Type","text/plain;charset=UTF-8");
        response.setHeader("icop-content-type","exception");
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        writer.print(content);
        writer.flush();
        writer.close();
    }
}
