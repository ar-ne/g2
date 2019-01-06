package g2.controller;

import g2.util.properties.Session;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthInterceptor implements HandlerInterceptor {
    private Boolean debug =true;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (debug)return true;
        HttpSession session = request.getSession();
        if (session.getAttribute(Session.state) != null && !session.getAttribute(Session.state).toString().isEmpty()) {
            return true;
        }
        else {
            response.sendRedirect(request.getContextPath());
            return false;
        }
    }
}
