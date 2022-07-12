package com.its.memberboardproject.controller;

import com.its.memberboardproject.dto.BoardDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
public class BoardController {



    //글 작성 화면 이동
    @GetMapping("/save-form")
    public String saveForm() {
        return "/boardPages/save";
    }
    //글 작성 처리
    @PostMapping("/save")
    public String save(@ModelAttribute BoardDTO boardDTO) throws IOException {
        boardService.save(boardDTO);
        return "redirect:/board";
    }

}
