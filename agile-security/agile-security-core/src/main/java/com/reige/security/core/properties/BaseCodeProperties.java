package com.reige.security.core.properties;

/**
 * 验证码基类
 *
 * @author chenrui reige3@gmail.com
 * @date 2018/8/24.
 */
public class BaseCodeProperties {

    /**
     * 验证码的长度
     */
    private int length = 6;

    /**
     * 过期时间
     */
    private int expireIn = 60;

    /**
     * 需要处理的url
     */
    private String url;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getExpireIn() {
        return expireIn;
    }

    public void setExpireIn(int expireIn) {
        this.expireIn = expireIn;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
