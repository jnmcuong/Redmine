package com.ini.xfn.nmcuong.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ini.xfn.nmcuong.model.MemberModel;
import com.ini.xfn.nmcuong.service.MemberService;

@Controller
@RequestMapping(value="/member")
public class MemberController {
    @Autowired(required = true)
    private MemberService memberService;
    
    @ResponseBody
    @RequestMapping(value="/list-json")
    public List<MemberModel> getJSONMembers(){
        return memberService.getAll();
    }
}
