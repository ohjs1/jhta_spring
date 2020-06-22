package com.jhta.tiles.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class ItemsController {
	@RequestMapping
	public String items(Model model) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("ªÁ≈¡");
		list.add("ªÁ≈¡");
		list.add("ªÁ≈¡");
		model.addAttribute("list",list);
		return ".items";
	}

}
