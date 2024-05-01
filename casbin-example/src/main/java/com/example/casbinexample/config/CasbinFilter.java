package com.example.casbinexample.config;

import com.example.casbinexample.model.User;
import com.example.casbinexample.service.IUserService;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.casbin.jcasbin.main.Enforcer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.logging.LogRecord;

public class CasbinFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(CasbinFilter.class);

    private final Enforcer enforcer;
    private final IUserService userAccessService;

    public CasbinFilter(Enforcer enforcer, IUserService userAccessService) {
        this.enforcer = enforcer;
        this.userAccessService = userAccessService;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("initializing ...");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String sessionId = httpServletRequest.getSession(true).getId();
        Optional<User> u = userAccessService.isAuthenticated(sessionId);
        if (u.isPresent()) {
            String user = u.get().getUsername();
            String method = httpServletRequest.getMethod();
            String path = httpServletRequest.getRequestURI();

            if (enforcer.enforce(user, path, method)) {
                logger.info("session is authorized: {} {} {} {}", sessionId, user, method, path);
                List<String> rolesForUser = enforcer.getRolesForUser(user);
                SecurityContext securityContext = SecurityContextHolder.getContext();
                securityContext.setAuthentication(new AuthenticationImpl(u.get().getUsername(), rolesForUser));
                HttpSession session = httpServletRequest.getSession();
                session.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);
                chain.doFilter(request, response);
            } else {
                logger.error("session is not authorized: {} {} {} {}", sessionId, user, method, path);
                HttpServletResponse httpServletResponse = (HttpServletResponse) response;
                httpServletResponse.setStatus(HttpStatus.FORBIDDEN.value());
            }
        } else {
            logger.error("session is not authenticated: {}", sessionId);
            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
            httpServletResponse.setStatus(HttpStatus.FORBIDDEN.value());
        }
    }


    @Override
    public void destroy() {
        logger.info("destroy.");
    }
}
