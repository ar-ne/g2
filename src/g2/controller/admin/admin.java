package g2.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class admin {
    @RequestMapping("/admin")
    public String admin(){
        return "admin/index";
    }
}
