package g2.controller.auth;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import g2.model.Extra.UserSession;
import g2.util.Properites;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthInterceptor implements HandlerInterceptor {
    private Boolean debug = true;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (debug) return true;
        boolean rlt = false;
        String accessPart = request.getRequestURI();
        UserSession session = new UserSession(request);
        try {
            if (session.getState() && !session.getName().isEmpty() && session.getType() != Properites.Login.unAuth) {
                String vailedURI = Properites.loginUrlString[session.getType()];
                if (accessPart.startsWith(vailedURI)) {//对比访问路径
                    rlt = true;
                    if (accessPart.startsWith(Properites.loginUrlString[Properites.Login.admin])) {
                        if (session.getType() == Properites.Login.admin2) rlt = false;
                    }
                } else {
                    response.sendRedirect(Properites.loginUrlString[session.getType()]);
                    return false;
                }
            }
        } catch (Exception ignored) {
        }
        if (!rlt) response.sendRedirect("/");
        return rlt;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
