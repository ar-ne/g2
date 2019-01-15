package g2.controller.user;

import g2.model.Consume;
import g2.service.CardService;
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
    private final CardService cardService;

    @Autowired
    public User(ConsumeService consumeService, MachineService machineService, CardService cardService) {
        this.consumeService = consumeService;
        this.machineService = machineService;
        this.cardService = cardService;
    }

    @RequestMapping("")
    public String index() {
        return "user/index";
    }

    @RequestMapping("QRCode")
    public ModelAndView doQRCode(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView("user/QRCode");
        mv.addObject("left", cardService.selectAmountById(((Long) request.getSession().getAttribute(Properites.Session.cardID))));
        mv.addObject("qrText", request.getSession().getAttribute(Properites.Session.name) + " " + request.getSession().getAttribute(Properites.Session.cardID));
        return mv;
    }

    @RequestMapping("QueSta")
    public ModelAndView consumeList(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("user/QueSta");
//        List<Consume> cosumelist = consumeService.getCosumeList((Long) request.getSession().getAttribute(Properites.Session.cardID));
        List<Long> macIDList = machineService.getmacID();
//        if (cosumelist != null)
//            modelAndView.addObject("cosumelist", cosumelist);
        modelAndView.addObject("macIDList", macIDList);
        return modelAndView;
    }

    @RequestMapping("Management")
    public ModelAndView doManagement(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("user/Management");
        String status = cardService.getStateById((Long) request.getSession().getAttribute(Properites.Session.cardID));
        modelAndView.addObject("state", status);
        return modelAndView;
    }
}