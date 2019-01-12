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

    @RequestMapping("")
    public String unitlist(Model model, Long id, String type) {//查询操作
        List<Unit> unit = unitService.UnitGet(id, type);
        model.addAttribute("unit", unit);//查到的结果传到界面
        model.addAttribute("type", type);//输入的type传到界面
        model.addAttribute("id", id);//输入的id传到界面
        return "admin/indexUnit";
    }

    @RequestMapping("/UnitSelect")
    public String unitselect(Model model, Long id) {
        Unit unit = unitService.selectById(id);
        model.addAttribute("unit", unit);
        return "admin/unitUpdate";
    }

    @RequestMapping("/UnitDelete")
    public String unitdelete(Long id) {
        unitService.UnitDelete(id);
        return "redirect:/admin/unit";
    }

    @RequestMapping("/UnitUpdate")
    public String unitupdate(Long id, String type, String account, String password, String pnum) {
        Unit unit = new Unit(id, type, account, password, pnum);
        unitService.update(unit);
        return "redirect:/admin/unit";
    }

    @RequestMapping("/UnitInsertDo")
    public String unitinsertdo(Long id, String type, String account, String password, String pnum) {
        Unit unit = new Unit(null, type, account, password, pnum);
        unitService.insert(unit);
        return "redirect:/admin/unit";
    }

    @RequestMapping("/UnitInsert")
    public String unitinsert() {
        return "admin/unitInsert";
    }

}
