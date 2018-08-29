package com.reige.security.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author chenrui reige3@gmail.com
 * @date 2018/8/23.
 */
@ConfigurationProperties(prefix = "agile.security")
public class SecurityProperties {

    /**
     * 浏览器配置
     */
    private BrowserProperties browser = new BrowserProperties();

    public BrowserProperties getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserProperties browser) {
        this.browser = browser;
    }
}

