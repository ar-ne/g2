package g2.controller.user;

import g2.util.properties.SessionProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class User {
    @RequestMapping("/user")
    public String index() {
        return "user/index";
    }

    @RequestMapping("/user/QRCode")
    public ModelAndView doQRCode(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView("/user/QRCode");
        mv.addObject("qrText", request.getSession().getAttribute(SessionProperties.cardID));
        return mv;
    }

    @RequestMapping("/user/QueSta")
    public String doQueSta() {
        return "user/QueSta";
    }
}