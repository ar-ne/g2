package g2.controller.admin;

import g2.model.Machine;
import g2.service.MachineService;
import g2.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/ma")
public class MachineController {
    private final MachineService machineService;
    private final UnitService unitService;

    @Autowired

    public MachineController(MachineService machineService, UnitService unitService) {
        this.machineService = machineService;
        this.unitService = unitService;
    }


    @RequestMapping("/MaList")
    public String maList(Model model, Long id, Long Uni_id) {
        List<Machine> mac = machineService.getByTwoId(id, Uni_id);
        model.addAttribute("mac", mac);
        model.addAttribute("Uni_id", Uni_id);
        model.addAttribute("id", id);
        return "admin/indexMachine";
    }

    @RequestMapping("/MaInsert")
    public String insert(Model model) {
        List<Long> list = unitService.getById();
        model.addAttribute("list", list);
        return "admin/machineInsert";
    }

    @RequestMapping("/MaInsertDo")
    public String insertDo(Model model, Long id, Long Uni_id, String addr) {
        Machine machine = new Machine(null, Uni_id, addr);
        machineService.insertSelective(machine);
        return "redirect:/admin/ma/MaList";
    }

    @RequestMapping("/MaDelete")
    public String delete(Long id) {
        machineService.deleteById(id);
        System.out.println(machineService.deleteById(id));
        return "redirect:/admin/ma/MaList";
    }

    @RequestMapping("/MaUpdate")
    public String update(Model model, Long id) {
        Machine machine = machineService.selectByPrimaryKey(id);
        List<Long> list = unitService.getById();
        model.addAttribute("list", list);
        model.addAttribute("machine", machine);
        return "admin/machineUpdate";
    }

    @RequestMapping("/MaUpdateDo")
    public String upDateDo(Long id, Long Uni_id, String addr) {
        Machine machine = new Machine(id, Uni_id, addr);
        machineService.updateByPrimaryKey(machine);
        return "redirect:/admin/ma/MaList";
    }
}
