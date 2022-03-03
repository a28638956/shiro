package com.lianxi.shiro.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfig {
    //ShiroFilterFactoryBean3
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("Security") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);
        return bean;
    }
    //DefaultWebSecurityManager2
    @Bean(name = "Security")
    public DefaultWebSecurityManager getdefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        //关联UserRealm
        defaultWebSecurityManager.setRealm(userRealm);
        return defaultWebSecurityManager;
    }
    //创建realm对象，需要自定义类1

    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }
}
