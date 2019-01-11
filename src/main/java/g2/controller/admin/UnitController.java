package g2.controller.admin;

import g2.model.Unit;
import g2.service.UnitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/unit")
public class UnitController {
    private final UnitService unitService;

    public UnitController(UnitService unitService) {
        this.unitService = unitService;
    }

    @RequestMapping("/")
    public String unit(){
        return "admin/index";
    }

    @RequestMapping("/UnitList")
    public String unitlist(Model model, Long id, String type) {
        List<Unit> unit = unitService.UnitGet(id, type);
        model.addAttribute("unit", unit);
        model.addAttribute("type", type);
        model.addAttribute("id", id);
        return "admin/indexUnit";
    }

    @RequestMapping("/UnitSelect")
    public String unitselect(Model model, Long id) {
        Unit unit = unitService.unitselectbyid(id);
        model.addAttribute("unit", unit);
        return "admin/unitUpdate";
    }

    @RequestMapping("/UnitDelete")
    public String unitdelete(Long id) {
        unitService.UnitDelete(id);
        return "redirect:/admin/unit/UnitList";
    }

    @RequestMapping("/UnitUpdate")
    public String unitupdate(Long id, String type, String account, String password, String pnum) {
        Unit unit = new Unit(id, type, account, password, pnum);
        unitService.UnitUpdate(unit);
        return "redirect:/admin/unit/UnitList";
    }

    @RequestMapping("/UnitInsertDo")
    public String unitinsertdo(Long id, String type, String account, String password, String pnum) {
        Unit unit = new Unit(null, type, account, password, pnum);
        unitService.unitInsert(unit);
        return "redirect:/admin/unit/UnitList";
    }

    @RequestMapping("/UnitInsert")
    public String unitinsert() {
        return "admin/unitInsert";
    }

}
