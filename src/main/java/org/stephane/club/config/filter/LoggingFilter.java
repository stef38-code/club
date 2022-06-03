package org.stephane.club.config.filter;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.stephane.club.share.tools.CustomTime;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * Logging sur les transactions afin d'avoir : adresse ip appelante, le protocole http utilisé et le endpoint et temps de traitement
 */
@Slf4j
@Component
@Order(1)
public class LoggingFilter implements Filter {
    public static final String DEFAULT_MDC_UUID_TOKEN_KEY = "Slf4jMDCFilter.UUID";

    @Override
    public void init(FilterConfig filterconfig) {
        log.info(filterconfig.getFilterName() + " created");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterchain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        LocalDateTime start = LocalDateTime.now();
        String value = MDC.get(DEFAULT_MDC_UUID_TOKEN_KEY);
        if (Objects.nonNull(value)) {
            log.info("--------------- {} -> {}", DEFAULT_MDC_UUID_TOKEN_KEY, value);
        } else {
            String uuid = getUuid();
            log.info("Add --------------- {} -> {}", DEFAULT_MDC_UUID_TOKEN_KEY, uuid);
            MDC.put(DEFAULT_MDC_UUID_TOKEN_KEY, uuid);
        }
        //Log start traitement
        log.info("remote host {} - {} -> {} - Start", request.getRemoteHost(), req.getMethod(), req.getRequestURI());

        filterchain.doFilter(request, response);
        LocalDateTime end = LocalDateTime.now();
        //Log End traitement
        log.info("{} -> {} - End en {}", req.getMethod(), req.getRequestURI(), CustomTime.findDifferenceWithStringFormat(start, end));
    }

    private String getUuid() {
        return UUID.randomUUID().toString().toUpperCase().replace("-", "");
    }

    @Override
    public void destroy() {
        log.info("LoggingFilter destroyed");
        MDC.remove(DEFAULT_MDC_UUID_TOKEN_KEY);
    }


}
