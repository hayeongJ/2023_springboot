package com.ict.edu2.member.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ict.edu2.member.dao.MemberDAO;
import com.ict.edu2.member.vo.VO;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin(originPatterns = "http://localhost:3000")
// 정보가 들어온게 나간다.
// MVC 안 탐 >> 들어온대로 리턴됨
@RestController
@RequestMapping("/member")
@Slf4j

public class MyController {
    @Autowired
    private MemberDAO memberDAO;
    
    @GetMapping("/")
    public String Hello(){
        return "Hello World";
    }
    @PostMapping("/login")
    
    public Map<String, Object> login(VO vo){
    // \n은 쌍따옴표 안에 넣어야한다.
        log.info("\nlogin 서버입니당\n");
        log.info("\n"+vo.getM_id()+"\n");
        log.info("\n"+vo.getM_pw()+"\n");
        Map<String, Object> resMap = new HashMap<>();
        resMap.put("chk", 0);
    
        return resMap;
    }

    @GetMapping("/list")
    public Map<String, Object> getList(){
        List<VO> list = memberDAO.getList();
        Map<String, Object> resMap = new HashMap<>();
        resMap.put("list", list);
        return resMap;
    }
}
