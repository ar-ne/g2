package g2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class login {
    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
