package g2.controller.user;

import g2.model.Consume;
import g2.service.ConsumeService;
import g2.service.MachineService;
import g2.util.Properites;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("user")
public class User {
    private final ConsumeService consumeService;
    private final MachineService machineService;

    @Autowired
    public User(ConsumeService consumeService, MachineService machineService) {
        this.consumeService = consumeService;
        this.machineService = machineService;
    }

    @RequestMapping("")
    public String index() {
        return "user/index";
    }

    @RequestMapping("QRCode")
    public ModelAndView doQRCode(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView("user/QRCode");
        mv.addObject("qrText", request.getSession().getAttribute(Properites.Session.name) + " " + request.getSession().getAttribute(Properites.Session.cardID));
        return mv;
    }

    @RequestMapping("QueSta")
    public ModelAndView consumeList(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("user/QueSta");
        List<Consume> cosumelist = consumeService.getCosumeList((Long) request.getSession().getAttribute(Properites.Session.cardID));
        List<String> addrlist = machineService.getAddr();
        if (cosumelist != null)
            modelAndView.addObject("cosumelist", cosumelist);
        modelAndView.addObject("addrlist", addrlist);
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