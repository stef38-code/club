package org.stephane.club.config.filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
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

        MDC.put(DEFAULT_MDC_UUID_TOKEN_KEY, getUuid());
        //Log start traitement
        log.info("remote host {} - {} -> {} - Start", request.getRemoteHost(), req.getMethod(), req.getRequestURI());

        filterchain.doFilter(request, response);
        LocalDateTime end = LocalDateTime.now();
        //Log End traitement
        log.info("{} -> {} - End en {}", req.getMethod(), req.getRequestURI(), findDifference(start, end));
    }

    private String getUuid() {
        return UUID.randomUUID().toString().toUpperCase().replace("-", "");
    }

    @Override
    public void destroy() {
        log.info("LoggingFilter destroyed");
        MDC.remove(DEFAULT_MDC_UUID_TOKEN_KEY);
    }

    private String findDifference(LocalDateTime from, LocalDateTime to) {
        //
        String strHeure = formatText(ChronoUnit.HOURS.between(from, to), "%d h");
        String strMinutes = formatText(ChronoUnit.MINUTES.between(from, to), "%d m");
        String strSecondes = formatText(ChronoUnit.SECONDS.between(from, to), "%d s");
        String strMillisecondes = formatText(ChronoUnit.MILLIS.between(from, to), "%d ms");

        return "".concat(strHeure).concat(strMinutes).concat(strSecondes).concat(strMillisecondes);
    }

    private String formatText(long value, String text) {
        if (value <= 0 || StringUtils.isEmpty(text)) {
            return StringUtils.EMPTY;
        }
        return String.format(text, value);
    }
}
