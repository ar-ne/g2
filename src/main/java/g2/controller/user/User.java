package g2.controller.user;

import g2.model.Consume;
import g2.service.ConsumeService;
import g2.util.properties.SessionProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.Console;
import java.util.List;

@Controller
@RequestMapping("user")
public class User {
    private final ConsumeService consumeService;

    public User(ConsumeService consumeService) {
        this.consumeService = consumeService;
    }

    @RequestMapping("")
    public String index() {
        return "user/index";
    }

    @RequestMapping("QRCode")
    public ModelAndView doQRCode(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView("user/QRCode");
        mv.addObject("qrText", request.getSession().getAttribute(SessionProperties.cardID));
        return mv;
    }

    @RequestMapping("QueSta")
    public ModelAndView consumeList(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("user/QueSta");
        List<Consume> cosumelist = consumeService.getCosumeList((Long) request.getSession().getAttribute(SessionProperties.cardID));
        System.out.println((Long) request.getSession().getAttribute(SessionProperties.cardID));
        if (cosumelist != null)
            modelAndView.addObject("cosumelist", cosumelist);
        return modelAndView;
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