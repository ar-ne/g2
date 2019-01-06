package g2.controller;

import g2.mapper.java.UserMapper;
import g2.model.User;
import g2.model.UserKey;
import g2.service.LoginService;
import g2.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class login {
    @Autowired
    LoginService loginService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/login")
    public String doLogin(UserKey userKey) {
        System.out.println("login:" + userKey);
        if (loginService.chkLogin(userKey)) {
            System.out.println(true);
        } else System.out.println(false);
        return "404";
    }
}
