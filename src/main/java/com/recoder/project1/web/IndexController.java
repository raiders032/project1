package com.recoder.project1.web;

import com.recoder.project1.auth.LoginUser;
import com.recoder.project1.auth.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser sessionUser){
        if(sessionUser != null){
            model.addAttribute("userName",sessionUser.getNickname());
        }
        return"index";
    }

}
