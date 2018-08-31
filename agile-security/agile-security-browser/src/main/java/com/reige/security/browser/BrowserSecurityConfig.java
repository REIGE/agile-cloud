package com.reige.security.browser;

import com.reige.security.core.authentication.FormAuthenticationConfig;
import com.reige.security.core.authorize.AuthorizeConfigManager;
import com.reige.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.session.InvalidSessionStrategy;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import org.springframework.social.security.SpringSocialConfigurer;

import javax.sql.DataSource;

/**
 * @author chenrui reige3@gmail.com
 * @date 2018/8/30.
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private LogoutSuccessHandler logoutSuccessHandler;

    @Autowired
    private AuthorizeConfigManager authorizeConfigManager;

    @Autowired
    private FormAuthenticationConfig formAuthenticationConfig;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 表单登录配置项
        formAuthenticationConfig.configure(http);

        http
                .rememberMe()
                    .tokenValiditySeconds(securityProperties.getBrowser().getRememberMeSeconds())
                    .userDetailsService(userDetailsService)
                    .and()
                // session 配置
                .sessionManagement()
                    // 设置session失效之后跳转到的url
    //                .invalidSessionUrl("/session/invalid")
    //                // 设置最大session数量
    //                .maximumSessions(1)
    //                //当session数量达到最大时，阻止后来的用户登录
    //                //.maxSessionsPreventsLogin(true)
    //                // session超时处理策略
    //                .expiredSessionStrategy(new ExpiredSessionStrategy())
                    .and()
                .logout()
                    .logoutUrl("/signOut")
                    //.logoutSuccessUrl("/agile-logout.html")
                    .logoutSuccessHandler(logoutSuccessHandler)
                    .deleteCookies("JSESSIONID")
                    .and()
                .authorizeRequests()

                .and()
                .csrf().disable();

        authorizeConfigManager.config(http.authorizeRequests());


    }
}
