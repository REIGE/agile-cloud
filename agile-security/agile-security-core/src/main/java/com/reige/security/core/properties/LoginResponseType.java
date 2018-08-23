package com.reige.security.core.properties;

/**
 * @author chenrui reige3@gmail.com
 * @date 2018/8/23.
 */
public enum LoginResponseType {

    /**
     * 重定向
     */
    REDIRECT(0),

    /**
     * json 类型
     */
    JSON(1);

    private int value;

    LoginResponseType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
