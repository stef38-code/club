package org.stephane.club.config.filter;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.stephane.club.config.Slf4jMDCFilterConfiguration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;

/**
 * Logging sur les transactions afin d'avoir : adresse ip appelante, le protocole http utilisé et le endpoint et temps de traitement
 *
 */
@Slf4j
@Component
@Order(1)
public class LoggingFilter implements Filter {

    @Override
    public void init(FilterConfig filterconfig)
            throws ServletException {
        log.info( filterconfig.getFilterName() + " created" );
    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain filterchain)
            throws IOException, ServletException {

        UUID uuid = UUID.randomUUID();
        Long start = System.currentTimeMillis();
        HttpServletRequest req = (HttpServletRequest) request;
        /*request.setAttribute("request-id" , uuid);*/
        /*request.setAttribute(Slf4jMDCFilterConfiguration.DEFAULT_MDC_UUID_TOKEN_KEY , uuid);*/
        MDC.put(Slf4jMDCFilterConfiguration.DEFAULT_MDC_UUID_TOKEN_KEY , uuid.toString());
        /*log.info( "remote host {}" , uuid , request.getRemoteHost() );*/
        log.info( "remote host {} - {} -> {} - Start",request.getRemoteHost(),req.getMethod(),req.getRequestURI());
        filterchain.doFilter(request, response);
        log.info( "{} - {} -> {} - End in {}ms",
                uuid,req.getMethod(),req.getRequestURI(),
                System.currentTimeMillis() - start );
    }

    @Override
    public void destroy() {
        log.info( "LoggingFilter destroyed" );
        MDC.remove(Slf4jMDCFilterConfiguration.DEFAULT_MDC_UUID_TOKEN_KEY);
    }

}
