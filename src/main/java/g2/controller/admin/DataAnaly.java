package g2.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Calendar;
import java.util.Date;

@Controller
@RequestMapping("/admin/data")
public class DataAnaly {
    @RequestMapping("")
    public String index() {
        return "admin/indexDataAnaly";
    }

    @RequestMapping("jsData")
    public ModelAndView jsData() {
        ModelAndView modelAndView = new ModelAndView("admin/jsData");
        modelAndView.addObject("name", "safdd");
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.get(Calendar.HOUR_OF_DAY);
        return modelAndView;
    }
}
