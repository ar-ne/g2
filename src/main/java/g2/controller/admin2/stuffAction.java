package g2.controller.admin2;

import g2.model.Stuff;
import g2.service.StuffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("admin2/stuff")
public class stuffAction {
    private final StuffService stuffService;

    @Autowired
    public stuffAction(StuffService stuffService) {
        this.stuffService = stuffService;
    }

    @RequestMapping("edit")
    public ModelAndView edit(Long id) {
        ModelAndView modelAndView = new ModelAndView("admin2/stuffAction/edit");
        modelAndView.addObject("item", stuffService.get(id));
        return modelAndView;
    }

    @RequestMapping("add")
    public String add() {
        return "admin2/stuffAction/add";
    }

    @RequestMapping("add.do")
    public String addDo(Stuff stuff) {
        stuff.setId(null);
        if (stuffService.add(stuff) == 1)
            return "redirect:admin2/stuff";
        return "admin2/error";
    }
}
