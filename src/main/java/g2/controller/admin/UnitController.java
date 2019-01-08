package g2.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/unit")
public class UnitController {
    @RequestMapping("/")
    public String unit(){
        return "admin/index";
    }

    @RequestMapping("/UnitList")
    public String indexunit(){
        return "admin/indexUnit";
    }

}
