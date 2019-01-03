package g2.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Unit {
    @RequestMapping("/unit")
    public String unit(){
        return "admin/indexUnit";
    }
}
