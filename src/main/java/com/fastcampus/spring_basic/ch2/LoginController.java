package com.fastcampus.spring_basic.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URLEncoder;

@Controller
@RequestMapping("/login")
public class LoginController {
    @RequestMapping("/login")
    public String loginForm(){
        return "loginForm";
    }

    @PostMapping("/login")
    public String login(String id, String pwd, String rememberId) throws Exception{
        // 1. id와 pwd를 확인
        if (!loginCheck(id, pwd)){
            String msg = URLEncoder.encode( "id 또는 pwd가 일치하지 않습니다.", "utf-8");

            return "redirect:/login/login?msg="+msg;
        }
        // 2. id와 pwd가 일치하면, 홈으로 이동
        //      일치하지 않으면, loginForm으로 이동
        return "loginForm";
    }

    private boolean loginCheck(String id, String pwd){
        return "asdf".equals(id) && "1234".equals(pwd);
    }

}
