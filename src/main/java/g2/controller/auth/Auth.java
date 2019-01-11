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
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView index(String o) {
        ModelAndView modelAndView = new ModelAndView("/index");
        if (o != null && !o.isEmpty()) modelAndView.addObject("err", o);
        return modelAndView;
    }

    @RequestMapping("/login")
    public ModelAndView doLogin(UserKey userKey, HttpServletRequest request) {
        User chkUSer = userService.login(userKey);
        if (chkUSer != null) {
            UserSession session = new UserSession(chkUSer);
            session.setSession(request);
            return new ModelAndView("redirect:" + UserProperties.urlString[session.getType()]);
        }
        return index("t");
    }

    @RequestMapping("/logout")
    public String doLogout(HttpServletRequest request) {
        request.getSession().removeAttribute(SessionProperties.state);
        request.getSession().removeAttribute(SessionProperties.name);
        request.getSession().removeAttribute(SessionProperties.type);
        request.getSession().removeAttribute(SessionProperties.cardID);
        request.getSession().invalidate();
        return "redirect:index";
    }
}
