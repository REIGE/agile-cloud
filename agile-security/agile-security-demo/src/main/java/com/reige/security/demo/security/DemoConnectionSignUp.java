package com.reige.security.demo.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.stereotype.Component;

/**
 * @author chenrui reige3@gmail.com
 * @date 2018/8/29.
 */
@Component
public class DemoConnectionSignUp implements ConnectionSignUp{

    private Logger logger = LoggerFactory.getLogger(DemoConnectionSignUp.class);

    @Override
    public String execute(Connection<?> connection) {
        logger.info("DemoConnectionSignUp:{}", connection.getDisplayName());
        return connection.getDisplayName();
    }
    
}
