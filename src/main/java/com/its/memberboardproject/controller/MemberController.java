package com.its.memberboardproject.controller;

import com.its.memberboardproject.dto.MemberDTO;
import com.its.memberboardproject.service.MemberService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.io.IOException;

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

    @PostMapping("/save")
    public String save(@ModelAttribute MemberDTO memberDTO) throws IOException {
        memberService.save(memberDTO);
        return "/memberPages/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session){
        MemberDTO loginDTO = memberService.login(memberDTO);
        if(loginDTO != null){
            session.setAttribute("loginEmail",loginDTO.getMemberEmail());
            session.setAttribute("loginId",loginDTO.getId());
            return "redirect:/";
        }else {
            return "/memberPages/login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";

    }

    @GetMapping("/admin")
    public String admin(){
        return "/memberPages/admin";
    }

    @GetMapping("/findAll")
    public String list(){
        return "/memberPages/list";
    }

    @GetMapping("/mypage")
    public String mypage(){
        return "/memberPages/mypage";
    }

}
