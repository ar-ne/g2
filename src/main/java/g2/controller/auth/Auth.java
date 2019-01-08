package g2.controller.auth;

import g2.model.Extra.UserKey;
import g2.model.Extra.UserSession;
import g2.model.User;
import g2.service.UserService;
import g2.util.properties.SessionProperties;
import g2.util.properties.UserProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class Auth {
    private final
    UserService userService;

    @Autowired
    public Auth(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping("/")
    public String index(HttpServletRequest request) {
        return "/admin";
    }

    @RequestMapping("/login")
    public String doLogin(UserKey userKey, HttpServletRequest request) {
        User chkUSer=userService.login(userKey);
        if (chkUSer!=null) {
            UserSession session = new UserSession(chkUSer);
            session.setSession(request);
            return "redirect:" + UserProperties.urlString[session.getType()];
        } return "index";
    }

    @RequestMapping("/logout")
    public String doLogout(HttpServletRequest request) {
        request.getSession().removeAttribute(SessionProperties.state);
        request.getSession().removeAttribute(SessionProperties.name);
        request.getSession().removeAttribute(SessionProperties.type);
        request.getSession().invalidate();
        return "index";
    }
}
