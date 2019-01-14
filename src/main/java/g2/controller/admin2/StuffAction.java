package g2.controller.admin2;

import g2.model.Stuff;
import g2.service.ScheduleService;
import g2.service.StuffService;
import g2.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("admin2/stuff")
public class StuffAction {
    private final StuffService stuffService;
    private final UnitService unitService;
    private final ScheduleService scheduleService;

    @Autowired
    public StuffAction(StuffService stuffService, UnitService unitService, ScheduleService scheduleService) {
        this.stuffService = stuffService;
        this.unitService = unitService;
        this.scheduleService = scheduleService;
    }

    @RequestMapping("edit")
    public ModelAndView edit(Long id) {
        ModelAndView modelAndView = new ModelAndView("/admin2/stuffAction/edit");
        List<Long> uniList = unitService.getIdList();
        List<Long> schList = scheduleService.getIdList();
        modelAndView.addObject("stuff", stuffService.get(id));
        modelAndView.addObject("uniList", uniList);
        modelAndView.addObject("schList", schList);
        return (modelAndView);
    }

    @RequestMapping("edit.do")
    public String editDo(Stuff stuff) {
        if (stuffService.update(stuff) > 0)
            return "redirect:/admin2/stuff";
        else return "redirect:/admin2/error";
    }

    @RequestMapping("add")
    public ModelAndView add() {
        ModelAndView modelAndView = new ModelAndView("admin2/stuffAction/add");
        List<Long> uniList = unitService.getIdList();
        List<Long> schList = scheduleService.getIdList();
        modelAndView.addObject("uniList", uniList);
        modelAndView.addObject("schList", schList);
        return (modelAndView);
    }


    @RequestMapping("add.do")
    public String addDo(Stuff stuff) {
        stuff.setId(null);
        if (stuffService.add(stuff) > 0)
            return "redirect:/admin2/stuff";
        return "redirect:/admin2/error";
    }

    @RequestMapping("del")
    public String delete(Long id) {
        if (stuffService.delete(id) > 0)
            return "redirect:/admin2/stuff";
        return "redirect:/admin2/error";
    }
}
