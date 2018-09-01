package com.reige.security.browser.session;

import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * session 并发登录导致前一个失效的处理策略
 *
 * @author chenrui reige3@gmail.com
 * @date 2018/9/1.
 */
public class BrowserExpiredSessionStrategy extends AbstractSessionStrategy implements SessionInformationExpiredStrategy {

    /**
     * @param invalidSessionUrl
     */
    public BrowserExpiredSessionStrategy(String invalidSessionUrl) {
        super(invalidSessionUrl);
    }

    @Override
    public void onExpiredSessionDetected(SessionInformationExpiredEvent event) throws IOException, ServletException {
        onSessionInvalid(event.getRequest(), event.getResponse());
    }

    @Override
    protected boolean isConcurrency() {
        return true;
    }
}
