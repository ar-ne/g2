package g2.controller.user;

import g2.util.properties.SessionProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
@Controller
@RequestMapping("user")
public class User {
    @RequestMapping("")
    public String index() {
        return "user/index";
    }

    @RequestMapping("QRCode")
    public ModelAndView doQRCode(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView("/user/QRCode");
        mv.addObject("qrText", request.getSession().getAttribute(SessionProperties.cardID));
        return mv;
    }

    @RequestMapping("QueSta")
    public String doQueSta() {
        return "user/QueSta";
    }

    @RequestMapping("Management")
    public String doManagement() {
        return "user/Management";
    }

    @RequestMapping("ReportLoss")
    public String doReportLoss() {
        return "user/ReportLoss";
    }
}