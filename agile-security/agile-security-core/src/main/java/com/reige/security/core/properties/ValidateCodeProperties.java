package com.reige.security.core.properties;

/**
 * 验证码配置
 *
 * @author chenrui reige3@gmail.com
 * @date 2018/8/24.
 */
public class ValidateCodeProperties {

    /**
     * 图片验证码选项
     */
    private ImageCodeProperties imageCode = new ImageCodeProperties();

    /**
     * 短信验证码
     */
    private SmsCodeProperties smsCode = new SmsCodeProperties();


    public ImageCodeProperties getImageCode() {
        return imageCode;
    }

    public void setImageCode(ImageCodeProperties imageCode) {
        this.imageCode = imageCode;
    }

    public SmsCodeProperties getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(SmsCodeProperties smsCode) {
        this.smsCode = smsCode;
    }
}
