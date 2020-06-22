package com.jhta.spring22.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ItemsController {
	@RequestMapping("/items")
	public String items(Model model) {
		ArrayList<String> list=new ArrayList<String>();
		list.add("����");
		list.add("����");
		list.add("�ٳ���");
		model.addAttribute("list",list);
		return ".items";
	}
	/*
	@RequestMapping("/items1")
	public ModelAndView items() {
		ModelAndView mv=new ModelAndView();
		ArrayList<String> list=new ArrayList<String>();
		list.add("����");
		list.add("����");
		list.add("�ٳ���");
		mv.setViewName(".items");
		mv.addObject("list",list);
		return mv;
	}
	*/
}	









