package com.reige.security.core.properties;

/**
 * 图片验证码配置
 *
 * @author chenrui reige3@gmail.com
 * @date 2018/8/24.
 */
public class ImageCodeProperties extends BaseCodeProperties {

    public ImageCodeProperties() {
        //设置验证码默认长度 4
        setLength(4);
    }

    /**
     * 验证码的宽
     */
    private int width = 67;

    /**
     * 验证码的高
     */
    private int height = 23;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
