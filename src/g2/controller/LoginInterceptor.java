package g2.controller;

import g2.util.SessionKey;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        if (session.getAttribute(SessionKey.state) != null && !session.getAttribute(SessionKey.state).toString().isEmpty()) {
            return true;
        }
        else {
            response.sendRedirect(request.getContextPath());
            return false;
        }
    }
}
