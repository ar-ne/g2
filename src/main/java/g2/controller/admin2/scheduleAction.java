package g2.controller.admin2;

import g2.model.Schedule;
import g2.service.ScheduleService;
import g2.controller.BaseController;
import g2.util.Parse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;


@Controller
@RequestMapping("admin2/schedule")
public class scheduleAction extends BaseController {
    private final ScheduleService scheduleService;

    @Autowired
    public scheduleAction(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @RequestMapping("add")
    public String add() {
        return "/admin2/scheduleAction/add";
    }

    @RequestMapping("add.do")
    public String addDo(Schedule schedule) {
        if (scheduleService.add(schedule) > 0)
            return "redirect:/admin2/schedule";
        return "redirect:/admin2/error";
    }

    @RequestMapping("edit")
    public ModelAndView edit(Long id) {
        ModelAndView modelAndView = new ModelAndView("/admin2/scheduleAction/edit");
        Schedule schedule = scheduleService.get(id);
        modelAndView.addObject("id", schedule.getId());
        modelAndView.addObject("address", schedule.getAddress());
        modelAndView.addObject("start", Parse.simpleDateFormatter.format(schedule.getStart()).replace(" ", "T"));
        modelAndView.addObject("stop", Parse.simpleDateFormatter.format(schedule.getStop()).replace(" ", "T"));
        return modelAndView;
    }

    @RequestMapping("edit.do")
    public String editDo(Schedule schedule) {
        if (scheduleService.update(schedule) > 0)
            return "redirect:/admin2/schedule";
        return "redirect:/admin2/error";
    }

    @RequestMapping("del")
    public String delete(Long id) {
        if (scheduleService.delete(id) > 0)
            return "redirect:/admin2/schedule";
        return "redirect:/admin2/error";
    }
}
