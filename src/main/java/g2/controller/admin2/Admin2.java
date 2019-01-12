package g2.controller.admin2;

import g2.model.Machine;
import g2.model.Schedule;
import g2.model.Stuff;
import g2.model.Unit;
import g2.service.MachineService;
import g2.service.ScheduleService;
import g2.service.StuffService;
import g2.service.UnitService;
import g2.util.Properites;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("admin2")
public class Admin2 {

    private final StuffService stuffService;
    private final ScheduleService scheduleService;
    private final UnitService unitService;
    private final MachineService machineService;

    @Autowired
    public Admin2(StuffService stuffService, ScheduleService scheduleService, UnitService unitService, MachineService machineService) {
        this.stuffService = stuffService;
        this.scheduleService = scheduleService;
        this.unitService = unitService;
        this.machineService = machineService;
    }

    @RequestMapping("")
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("admin2/index");
        modelAndView.addObject("user", request.getSession().getAttribute(Properites.Session.name));
        return modelAndView;
    }

    @RequestMapping("stuff")
    public ModelAndView stuffList() {
        ModelAndView modelAndView = new ModelAndView("admin2/stuff");
        List<Stuff> list = stuffService.getAll();
        if (list != null)
            modelAndView.addObject("list", list);
        return modelAndView;
    }

    @RequestMapping("schedule")
    public ModelAndView schedule() {
        ModelAndView modelAndView = new ModelAndView("admin2/schedule");
        List<Schedule> list = scheduleService.getAll();
        if (list != null)
            modelAndView.addObject("list", list);
        return modelAndView;
    }

    @RequestMapping("charge")
    public ModelAndView charge() {
        ModelAndView modelAndView = new ModelAndView("admin2/charge");
        List<Unit> unitList = unitService.getAll();
        modelAndView.addObject("unitList", unitList);
        return modelAndView;
    }

    @RequestMapping("error")
    public String error() {
        return "admin2/error";
    }
}
