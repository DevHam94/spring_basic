package com.fastcampus.spring_basic.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RequestInfo {
    @RequestMapping("/requestInfo")
    public void main(HttpServletRequest request) {
        System.out.println();
    }

}
