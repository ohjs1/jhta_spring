package com.jhta.spring14.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import test.vo.MembersVo;

@Controller
public class JSONController2 {
	@RequestMapping("/json")
	public String json() {
		return "json";
	}
	
	@RequestMapping("/json/list")
	@ResponseBody
	public List<MembersVo> list(){
		ArrayList<MembersVo> list = new ArrayList<MembersVo>();
		list.add(new MembersVo(1, "ȫ�浿1", "011" , "����1", new Date()));
		list.add(new MembersVo(2, "ȫ�浿2", "012" , "����2", new Date()));
		list.add(new MembersVo(3, "ȫ�浿3", "013" , "����3", new Date()));
		return list;
	}
	
	
	@RequestMapping("/json/find")
	@ResponseBody
	public MembersVo find(int num) {
		if(num == 1) {
			return new MembersVo(1, "ȫ�浿", "010", "����", new Date());
		} else {
			return new MembersVo(2, "ȫ�浿2", "010", "�λ�", new Date());
		}
	}
	
	@RequestMapping("/json/find1")
	@ResponseBody
	public HashMap<String, Object> data(){
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("grade", "gold");
		map.put("name", "�̱浿");
		map.put("email", "test@daum.net");
		
		ArrayList<MembersVo> list = new ArrayList<MembersVo>();
		list.add(new MembersVo(1, "ȫ�浿1", "011" , "����1", new Date()));
		list.add(new MembersVo(2, "ȫ�浿2", "012" , "����2", new Date()));
		list.add(new MembersVo(3, "ȫ�浿3", "013" , "����3", new Date()));
		
		map.put("mem", list); 
		
		return map;
	}
}
