package g2.controller.admin2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin2")
public class admin2 {
    @RequestMapping("/")
    public String index(){
        return "admin2/index";
    }


}
