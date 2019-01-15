package g2.controller.user;

import g2.model.Consume;
import g2.service.ConsumeService;
import g2.service.MachineService;
import g2.util.Properites;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("user/QueSta")
public class QueStaAction {
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


}
