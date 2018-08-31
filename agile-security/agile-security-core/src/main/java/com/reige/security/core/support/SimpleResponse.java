package com.reige.security.core.support;

/**
 * @author chenrui reige3@gmail.com
 * @date 2018/8/30.
 */
public class SimpleResponse<T> {
    private T content;

    public SimpleResponse(T content) {
        this.content = content;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}
