package com.its.memberboardproject.controller;

import com.its.memberboardproject.service.MemberService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/save")
    public String saveForm(){
        return "/memberPages/save";
    }

    @GetMapping("/login")
    public String loginForm(){
        return "/memberPages/login";
    }



}
