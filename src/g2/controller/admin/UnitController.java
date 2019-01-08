package g2.controller.admin;
import g2.model.Unit;
import g2.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UnitController {
    @Autowired
    private UnitService unitService;
    @RequestMapping("/unit")
    public String unitGet(Model model, Long id, String type){
        List<Unit> ul = unitService.Get(id,type);
        model.addAttribute("ul",ul);
        return "admin/indexUnit";
    }
}
