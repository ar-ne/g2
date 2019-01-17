package g2.controller.user;

import g2.controller.BaseController;
import g2.model.Consume;
import g2.service.ConsumeService;
import g2.service.MachineService;
import g2.util.Properites;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.Console;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("user/QueSta")
public class QueStaAction extends BaseController {
    private final ConsumeService consumeService;
    private final MachineService machineService;

    @Autowired
    public QueStaAction(ConsumeService consumeService, MachineService machineService) {
        this.consumeService = consumeService;
        this.machineService = machineService;
    }

    @RequestMapping(value = "cmlist", method = RequestMethod.POST)
    public ModelAndView cmlist(Double money, Long macID, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("user/QueSta");
        List<Consume> consumelist = consumeService.selectByCDMAmount((Long) request.getSession().getAttribute(Properites.Session.cardID), money, macID);
        List<Long> macIDList = machineService.getmacID();
        modelAndView.addObject("macIDList", macIDList);
        modelAndView.addObject("cosumelist", consumelist);
        return modelAndView;
    }

    @RequestMapping("stastic")
    public ModelAndView doStastic(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("user/Stastic");
        return modelAndView;
    }

    @RequestMapping(value = "stastic.do", method = RequestMethod.POST)
    public ModelAndView doStastic(Date time, HttpServletRequest request) {
        if (time != null) {
            String showTime = (time.getYear() + 1900) + "年" + (time.getMonth() + 1) + "月" + time.getDate() + '日';
            ModelAndView modelAndView = new ModelAndView("user/Stastic");
            List<Consume> total = consumeService.getCosumeList((Long) request.getSession().getAttribute(Properites.Session.cardID));
            double totalAmount = 0;
            for (Consume consume : total) {
                if (consume.getTime().getYear() == time.getYear() && consume.getTime().getMonth() == time.getMonth() &&
                        consume.getTime().getDate() == time.getDate()) {
                    totalAmount += consume.getAmount();
                }
            }
            modelAndView.addObject("showtime", showTime);
            modelAndView.addObject("total", totalAmount);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("user/Stastic");
            modelAndView.addObject("error", "*请输入时间");
            return modelAndView;
        }
    }


}
