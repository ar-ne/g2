package g2.controller.user;

import g2.model.Consume;
import g2.service.ConsumeService;
import g2.util.Properites;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("user/QueSta")
public class QueStaAction {
    private final ConsumeService consumeService;

    @Autowired
    public QueStaAction(ConsumeService consumeService) {
        this.consumeService = consumeService;
    }

//    @RequestMapping("search")
//    public ModelAndView ConsumeIndex(HttpServletRequest request) {
//        ModelAndView modelAndView = new ModelAndView("user/QueAction/consumeList");
//        List<Consume> consumelist = consumeService.selectByCdAmount((Long) request.getSession().getAttribute(Properites.Session.cardID),);
//        if (cosumelist != null)
//            modelAndView.addObject("cosumelist", cosumelist);
//        return modelAndView;
//    }

}
