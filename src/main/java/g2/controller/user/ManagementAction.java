package g2.controller.user;

import com.sun.org.apache.xpath.internal.operations.Mod;
import g2.model.User;
import g2.service.CardService;
import g2.service.UserService;
import g2.util.Properites;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("user/Management")
public class ManagementAction {
    private final CardService cardService;
    private final UserService userService;

    @Autowired
    public ManagementAction(CardService cardService, UserService userService) {
        this.cardService = cardService;
        this.userService = userService;
    }

    @RequestMapping("reportless")
    public ModelAndView confirm(HttpServletRequest request) {
        boolean result;
        ModelAndView modelAndView = new ModelAndView("user/Management");
        String status = cardService.getStateById((Long) request.getSession().getAttribute(Properites.Session.cardID));
        if (status.equals(Properites.CardStatus.frozen)) {
            result = false;
        } else {
            result = true;
            cardService.reportLoss((Long) request.getSession().getAttribute(Properites.Session.cardID));
        }
        status = cardService.getStateById((Long) request.getSession().getAttribute(Properites.Session.cardID));
        modelAndView.addObject("result", result);
        modelAndView.addObject("state", status);
        return modelAndView;
    }

    @RequestMapping("cancelReportLoss")
    public ModelAndView cancel() {
        ModelAndView modelAndView = new ModelAndView("user/CancelReportLoss");
        return modelAndView;
    }

    @RequestMapping(value = "cancelReportLosss.do", method = RequestMethod.POST)
    @ResponseBody
    public String docancel(String password, HttpServletRequest request) {
        if (userService.getPasswordByCardID((Long) request.getSession().getAttribute(Properites.Session.cardID)).equals(password)) {
            cardService.cReportLoss((Long) request.getSession().getAttribute(Properites.Session.cardID));
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping("ePassword")
    public ModelAndView ePassword() {
        ModelAndView modelAndView = new ModelAndView("user/ePassword");
        return modelAndView;
    }

    @RequestMapping(value = "ePassword.do", method = RequestMethod.POST)
    @ResponseBody
    public String doePassword(String opassword, String password, HttpServletRequest request) {
        if (userService.getPasswordByCardID((Long) request.getSession().getAttribute(Properites.Session.cardID)).equals(opassword)) {
            userService.editPassword((Long) request.getSession().getAttribute(Properites.Session.cardID), password);
            return "success";
        } else {
            return "failed";
        }
    }

    @RequestMapping("recharge")
    public ModelAndView recharge() {
        ModelAndView modelAndView = new ModelAndView("user/Recharge");
        return modelAndView;
    }

    @RequestMapping(value = "recharge.do", method = RequestMethod.POST)
    @ResponseBody
    public String doRecharge(Double money, String password, HttpServletRequest request) {
        if (userService.getPasswordByCardID((Long) request.getSession().getAttribute(Properites.Session.cardID)).equals(password)) {
            cardService.reCharge((Long) request.getSession().getAttribute(Properites.Session.cardID), money);
            return "success";
        } else {
            return "failed";
        }
    }
}
