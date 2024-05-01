package kz.kbtu.scopes.Controller;

import jakarta.annotation.Resource;
import kz.kbtu.scopes.Model.HelloMessageGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.*;

@RestController
public class ScopesController {
    public static final Logger LOG = LoggerFactory.getLogger(ScopesController.class);

    @Resource(name = "requestScopedBean")
    HelloMessageGenerator requestScopedBean;

    @Resource(name = "sessionScopedBean")
    HelloMessageGenerator sessionScopedBean;

    @Resource(name = "applicationScopedBean")
    HelloMessageGenerator applicationScopedBean;

    @RequestMapping("/scopes/request")
    public String getRequestScopeMessage(final Model model) {
        LOG.info("Previous Message: " + requestScopedBean.getMessage());
        requestScopedBean.setMessage("Request Scope Message!");
        LOG.info("Current Message: " + requestScopedBean.getMessage());
        return "scopesExample";
    }

    @RequestMapping("/scopes/session")
    public String getSessionScopeMessage(final Model model) {
        LOG.info("Previous Message: " + sessionScopedBean.getMessage());
        sessionScopedBean.setMessage("Session Scope Message!");
        LOG.info("Current Message: " + sessionScopedBean.getMessage());
        return "scopesExample";
    }

    @RequestMapping("/scopes/application")
    public String getApplicationScopeMessage(final Model model) {
        LOG.info("Current Message: " + applicationScopedBean.getMessage());
        applicationScopedBean.setMessage("Application Scope Message!");
        LOG.info("Current Message: " + applicationScopedBean.getMessage());
        return "scopesExample";
    }
}
