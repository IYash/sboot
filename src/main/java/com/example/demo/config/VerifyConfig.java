package com.example.demo.config;


import com.paic.verify.service.ComponentAuthService;
import com.paic.verify.service.MessageGenerator;
import com.paic.verify.service.NoticeIntercepter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;


import java.util.HashMap;
import java.util.Map;


//@Configuration
@Slf4j
public class VerifyConfig {
    private final static String AUTH_URL="remote.auth.url";
    private final static String AUTH_ORGCODE="remote.auth.orgCode";
    private final static String AUTH_CODE="remote.auth.authCode";
    private final static String AUTH_CHNLID="remote.auth.chnlId";
    private final static String AUTH_DESKEY="remote.auth.desKey";
    private final static String AUTH_USERNAME="remote.auth.userName";
    private final static String AUTH_USERPASSWORD="remote.auth.userPassword";
    private final static String AUTH_PERIOD="remote.auth.period";
    private final static String AUTH_CER="remote.auth.cer";
    private final static String AUTH_JKS="remote.auth.jks";
    private final static String AUTH_STOREPWD="remote.auth.storePassword";
    private final static String AUTH_STOREALIAS="remote.auth.storeAlias";
    private final static String AUTH_APPNAME="remote.auth.appName";
    private final static String AUTH_FILEPATH="remote.auth.authDataFilePath";
    private final static String AUTH_ZONE="remote.auth.zone";
    @Autowired
    private Environment environment;
    @Bean
    public MessageGenerator generator(Environment environment) throws Exception{

        MessageGenerator generator = new MessageGenerator();
        Map<String,String> envMap = new HashMap<>();
        String env = environment.getActiveProfiles()[0];
        String base = "/"+env+"/";
        envMap.put(AUTH_URL,environment.getProperty(AUTH_URL));
        envMap.put(AUTH_ORGCODE,environment.getProperty(AUTH_ORGCODE));
        envMap.put(AUTH_CODE,environment.getProperty(AUTH_CODE));
        envMap.put(AUTH_CHNLID,environment.getProperty(AUTH_CHNLID));
        envMap.put(AUTH_DESKEY,environment.getProperty(AUTH_DESKEY));
        envMap.put(AUTH_USERNAME,environment.getProperty(AUTH_USERNAME));
        envMap.put(AUTH_USERPASSWORD,environment.getProperty(AUTH_USERPASSWORD));
        envMap.put(AUTH_PERIOD,environment.getProperty(AUTH_PERIOD));
        envMap.put(AUTH_CER,base+environment.getProperty(AUTH_CER));
        envMap.put(AUTH_JKS,base + environment.getProperty(AUTH_JKS));
        envMap.put(AUTH_STOREPWD,environment.getProperty(AUTH_STOREPWD));
        envMap.put(AUTH_STOREALIAS,environment.getProperty(AUTH_STOREALIAS));
        envMap.put(AUTH_APPNAME,environment.getProperty(AUTH_APPNAME));
        envMap.put(AUTH_FILEPATH,base+environment.getProperty(AUTH_FILEPATH));
        envMap.put(AUTH_ZONE,environment.getProperty(AUTH_ZONE));
        generator.setEnv(envMap);
        return generator;
    }
    @Bean
    public NoticeIntercepter noticeIntercepter(){
        return new NoticeIntercepter() {
            @Override
            public void notice(String s) {
                log.info(s+"----------------notice info");
            }
        };
    }
    @Bean(initMethod = "init")
    public ComponentAuthService componentAuthService(NoticeIntercepter intercepter,MessageGenerator generator) {
        return new ComponentAuthService(intercepter,generator);
    }

}
