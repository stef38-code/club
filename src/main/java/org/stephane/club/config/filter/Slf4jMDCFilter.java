package org.stephane.club.config.filter;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import org.stephane.club.config.Slf4jMDCFilterConfiguration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

/**
 * Logging sur les transactions afin d'avoir : adresse ip appelante, le protocole http utilisé et le endpoint et temps de traitement
 *
 */
@Slf4j
@Component
@Order(1)
public class Slf4jMDCFilter extends OncePerRequestFilter {

    private final String responseHeader;
    private final String mdcTokenKey;
    private final String mdcClientIpKey;
    private final String requestHeader;
    public Slf4jMDCFilter() {
        responseHeader = Slf4jMDCFilterConfiguration.DEFAULT_RESPONSE_TOKEN_HEADER;
        mdcTokenKey = Slf4jMDCFilterConfiguration.DEFAULT_MDC_UUID_TOKEN_KEY;
        mdcClientIpKey = Slf4jMDCFilterConfiguration.DEFAULT_MDC_CLIENT_IP_KEY;
        requestHeader = null;
    }

    public Slf4jMDCFilter(final String responseHeader, final String mdcTokenKey, final String mdcClientIPKey, final String requestHeader) {
        this.responseHeader = responseHeader;
        this.mdcTokenKey = mdcTokenKey;
        this.mdcClientIpKey = mdcClientIPKey;
        this.requestHeader = requestHeader;
    }

/*    @Override
    public void init(FilterConfig filterconfig)
            throws ServletException {
        log.info( filterconfig.getFilterName() + " created" );
    }*/

   /* @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain filterchain)
            throws IOException, ServletException {

        UUID uuid = UUID.randomUUID();
        Long start = System.currentTimeMillis();
        HttpServletRequest req = (HttpServletRequest) request;
        request.setAttribute(mdcUuid , uuid);
        log.info( "{} - remote host {}" , uuid , request.getRemoteHost() );
        filterchain.doFilter(request, response);
        log.info( "{} - {} -> {} - response in {}ms",
                uuid,req.getMethod(),req.getRequestURI(),
                System.currentTimeMillis() - start );
    }*/

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            /*final String token = extractToken(request);
            final String clientIP = extractClientIP(request);
            MDC.put(mdcClientIpKey, clientIP);
            MDC.put(mdcTokenKey, token);
            if (StringUtils.hasText(responseHeader)) {
                response.addHeader(responseHeader, token);
            }*/
            filterChain.doFilter(request, response);
        } finally {
            MDC.remove(mdcTokenKey);
            MDC.remove(mdcClientIpKey);
        }
    }

    @Override
    public void destroy() {
        log.info( "LoggingFilter destroyed" );
    }
    private String extractToken(final HttpServletRequest request) {
        final String token;
        if (StringUtils.hasText(requestHeader) && StringUtils.hasText(request.getHeader(requestHeader))) {
            token = request.getHeader(requestHeader);
        } else {
            token = UUID.randomUUID().toString().toUpperCase().replace("-", "");
        }
        return token;
    }

    private String extractClientIP(final HttpServletRequest request) {
        final String clientIP;
        if (request.getHeader("X-Forwarded-For") != null) {
            clientIP = request.getHeader("X-Forwarded-For").split(",")[0];
        } else {
            clientIP = request.getRemoteAddr();
        }
        return clientIP;
    }

    @Override
    protected boolean isAsyncDispatch(final HttpServletRequest request) {
        return false;
    }

    @Override
    protected boolean shouldNotFilterErrorDispatch() {
        return false;
    }
}
