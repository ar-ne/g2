//package g2.controller.user;
//
//import g2.model.Stuff;
//import g2.service.ConsumeService;
//import g2.service.StuffService;
//import g2.util.properties.SessionProperties;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//@Controller
//@RequestMapping("user/QueSta")
//public class QueStaAction {
//    private final ConsumeService consumeService;
//
//    @Autowired
//    public QueStaAction(ConsumeService consumeService) {
//        this.consumeService = consumeService;
//    }
//
//    @RequestMapping("consumeList")
//    public ModelAndView ConsumeIndex() {
//        ModelAndView modelAndView = new ModelAndView("user/QueAction/consumeList");
//        modelAndView.addObject("item", consumeService.selectByCdAmount(SessionProperties.cardID,requset));
//        return modelAndView;
//    }
//
//}
