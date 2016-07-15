package com.ini.xfn.nmcuong.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ini.xfn.nmcuong.service.MemberService;

@Controller
@RequestMapping(value="/category")
public class CategoryController {
	
	@Autowired(required = true)
	private MemberService memberService;
	
	@RequestMapping(value="/create", method = RequestMethod.GET)
	public String prepareCreateCategory(Model model){
		model.addAttribute("members", memberService.getAll());
		return "createCategory";
	}
	
	@RequestMapping(value="/create", method = RequestMethod.POST)
	public String createCategory(){
		System.out.println("submited");
		return "createIssue";
	}
	
	@RequestMapping(value="/test", method = RequestMethod.GET)
	public String test(Model model){
		
		return "test";
	}
}
