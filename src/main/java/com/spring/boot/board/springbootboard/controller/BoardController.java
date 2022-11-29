package com.spring.boot.board.springbootboard.controller;

import com.spring.boot.board.springbootboard.dto.BoardDto;
import com.spring.boot.board.springbootboard.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {

//    private final BoardService boardService;
//
//    public BoardController(BoardService boardService) {
//        this.boardService = boardService;
//    }

    @GetMapping("/posts")
    public String list() {
        return "/board/list.html";
    }

    @GetMapping("/post")
    public String write() {
        return "/board/write.html";
    }

    @PostMapping("/post")
    public String write(BoardDto boardDto) {
        return "redirect:/";
    }

}
