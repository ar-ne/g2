package g2.controller.admin2;

import g2.util.properties.SessionProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("admin2")
public class admin2 {
    @RequestMapping("")
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("admin2/index");
        modelAndView.addObject("user",request.getSession().getAttribute(SessionProperties.name));
        return modelAndView;
    }

    @RequestMapping("stuff")
    public ModelAndView stuffList() {
        ModelAndView modelAndView = new ModelAndView("admin2/stuff");
        return modelAndView;
    }

    @RequestMapping("schedule")
    public ModelAndView schedule(){
        ModelAndView modelAndView=new ModelAndView("admin2/schedule");
        return modelAndView;
    }

    @RequestMapping("charge")
    public ModelAndView charge(){
        ModelAndView modelAndView=new ModelAndView("admin2/charge");
        return modelAndView;
    }

}
