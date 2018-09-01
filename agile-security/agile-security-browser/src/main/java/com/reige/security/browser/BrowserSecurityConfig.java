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

import javax.sql.DataSource;

/**
 * @author chenrui reige3@gmail.com
 * @date 2018/8/30.
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private InvalidSessionStrategy invalidSessionStrategy;

    @Autowired
    private SessionInformationExpiredStrategy sessionInformationExpiredStrategy;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private LogoutSuccessHandler logoutSuccessHandler;

    @Autowired
    private AuthorizeConfigManager authorizeConfigManager;

    @Autowired
    private FormAuthenticationConfig formAuthenticationConfig;


    /**
     * 记住我功能的token存取器配置
     * 
     * @return
     */
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        // TODO: 2018/9/1 根据自己需求 重写 token repository implementation
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
         // 系统在启动时会自动生成表
//      tokenRepository.setCreateTableOnStartup(true);
        return tokenRepository;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 表单登录配置项
        formAuthenticationConfig.configure(http);

        http
                // remember me 配置
                .rememberMe()
                    .tokenRepository(persistentTokenRepository())
                    .tokenValiditySeconds(securityProperties.getBrowser().getRememberMeSeconds())
                    .userDetailsService(userDetailsService)
                    .and()
                // session 配置
                .sessionManagement()
                    .invalidSessionStrategy(invalidSessionStrategy)
                    .maximumSessions(securityProperties.getBrowser().getSession().getMaximumSessions())
                    .maxSessionsPreventsLogin(securityProperties.getBrowser().getSession().isMaxSessionsPreventsLogin())
                    .expiredSessionStrategy(sessionInformationExpiredStrategy)
                    // 设置session失效之后跳转到的url
    //                .invalidSessionUrl("/session/invalid")
    //                // 设置最大session数量
    //                .maximumSessions(1)
    //                //当session数量达到最大时，阻止后来的用户登录
    //                //.maxSessionsPreventsLogin(true)
    //                // session超时处理策略
    //                .expiredSessionStrategy(new ExpiredSessionStrategy())
                    .and()
                    .and()
                .logout()
                    .logoutUrl("/signOut")
                    .logoutSuccessHandler(logoutSuccessHandler)
                    .deleteCookies("JSESSIONID")
                    .and()
                .authorizeRequests()

                .and()
                .csrf().disable();

        authorizeConfigManager.config(http.authorizeRequests());
    }
}
