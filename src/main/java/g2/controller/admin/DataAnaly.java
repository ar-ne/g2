package g2.controller.admin;

import g2.service.CardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Calendar;
import java.util.Date;

@Controller
@RequestMapping("/admin/data")
public class DataAnaly {
    private CardService cardService;

    public DataAnaly(CardService cardService) {
        this.cardService = cardService;
    }

    @RequestMapping("")
    public String index() {
        return "admin/indexDataAnaly";
    }

    @RequestMapping("jsData")
    public ModelAndView jsData() {
        ModelAndView modelAndView = new ModelAndView("admin/jsData");
        modelAndView.addObject("name", "safdd");
        int n1 = cardService.selectCount("正常");
        int n2 = cardService.selectCount("冻结");
        System.out.println(n1);
        System.out.println(n2);
        modelAndView.addObject("n1", n1);
        modelAndView.addObject("n2", n2);
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.get(Calendar.HOUR_OF_DAY);
        return modelAndView;
    }
}
