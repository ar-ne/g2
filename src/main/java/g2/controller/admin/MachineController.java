package g2.controller.admin;

import g2.model.Charge;
import g2.model.Machine;
import g2.service.ChargeService;
import g2.service.MachineService;
import g2.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/admin/ma")
public class MachineController {
    private final MachineService machineService;
    private final UnitService unitService;
    private final ChargeService chargeService;

    @Autowired

    public MachineController(MachineService machineService, UnitService unitService, ChargeService chargeService) {
        this.machineService = machineService;
        this.unitService = unitService;
        this.chargeService = chargeService;
    }

    @RequestMapping("")
    public String maList(Model model, Long id, Long Uni_id) {
        List<Machine> mac = machineService.getByTwoId(id, Uni_id);
        model.addAttribute("mac", mac);
        model.addAttribute("Uni_id", Uni_id);
        model.addAttribute("id", id);
        return "admin/indexMachine";
    }

    @RequestMapping("/MaInsert")
    public String insert(Model model) {
        List<Long> list = unitService.getIdList();
        model.addAttribute("list", list);
        return "admin/machineInsert";
    }

    @RequestMapping("/MaInsertDo")
    @ResponseBody
    public String insertDo(Model model, Long id, Long Uni_id, String addr) {
        System.out.println(addr);
        System.out.println(Uni_id);
        Machine machine = new Machine(null, Uni_id, addr);
        int i = machineService.insertSelective(machine);
        return i > 0 ? "success" : "failed";
        //  return "redirect:/admin/ma";
    }

    @RequestMapping("/MaDelete")
    public String delete(Long id) {
        machineService.deleteById(id);
        System.out.println(machineService.deleteById(id));
        return "redirect:/admin/ma";
    }

    @RequestMapping("/MaUpdate")
    public String update(Model model, Long id) {
        Machine machine = machineService.selectByPrimaryKey(id);
        List<Long> list = unitService.getIdList();
        model.addAttribute("list", list);
        model.addAttribute("machine", machine);
        return "admin/machineUpdate";
    }

    @RequestMapping("/MaUpdateDo")
    @ResponseBody
    public String upDateDo(Long id, Long Uni_id, String addr) {
        Machine machine = new Machine(id, Uni_id, addr);
        int n = machineService.updateByPrimaryKey(machine);
        return n > 0 ? "success" : "failed";
        // return "redirect:/admin/ma";
    }

    @RequestMapping("/chargedo")
    public String charge(Model model, Long id) {
        System.out.println("11111111");
        List<Charge> charges = chargeService.selectByMacId(id);
        model.addAttribute("charges", charges);
        return "admin/chargeLog";
    }
}
