package com.lianxi.shiro.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Configuration;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    //ShiroFilterFactoryBean3
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("Security") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);
        //添加shiro的内置管理器
        /*
            onon：无需认证就可以访问
            authc：必须认证才能访问
            user：拥有记住我功能才能用
            perms：拥有对某个资源权限才能访问；
            role：拥有某个角色权限才能访问
         */
        Map<String,String>filterChainDefinitionMap=new LinkedHashMap<>();
        bean.setFilterChainDefinitionMap(filterChainDefinitionMap);
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
