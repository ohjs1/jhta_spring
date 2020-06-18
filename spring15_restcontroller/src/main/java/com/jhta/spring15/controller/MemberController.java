package com.jhta.spring15.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import test.vo.MembersVo;

@RestController
public class MemberController {
	@RequestMapping(value="/member", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE,
			MediaType.APPLICATION_XML_VALUE})
	public MembersVo member() {
		MembersVo vo = new MembersVo(1, "È«±æµ¿", "010", "¼­¿ï", new Date());
		return vo;
	}
	
	@RequestMapping(value="/member/list", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE,
			MediaType.APPLICATION_XML_VALUE})
	public ArrayList<MembersVo> list(){
		ArrayList<MembersVo> list = new ArrayList<MembersVo>();
		list.add(new MembersVo(1, "È«±æµ¿1", "011" , "¼­¿ï1", new Date()));
		list.add(new MembersVo(2, "È«±æµ¿2", "012" , "¼­¿ï2", new Date()));
		list.add(new MembersVo(3, "È«±æµ¿3", "013" , "¼­¿ï3", new Date()));
		
		return list;
	}
	
	
	@RequestMapping(value="/member/getlist", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE,
			MediaType.APPLICATION_XML_VALUE})
	public HashMap<String, Object> grade(){
		ArrayList<MembersVo> list = new ArrayList<MembersVo>();
		list.add(new MembersVo(1, "È«±æµ¿1", "011" , "¼­¿ï1", new Date()));
		list.add(new MembersVo(2, "È«±æµ¿2", "012" , "¼­¿ï2", new Date()));
		list.add(new MembersVo(3, "È«±æµ¿3", "013" , "¼­¿ï3", new Date()));
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("grade", "GOLD");
		
		return map;
	}
}
