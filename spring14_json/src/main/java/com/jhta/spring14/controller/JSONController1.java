package com.jhta.spring14.controller;

import java.util.ArrayList;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import test.vo.MembersVo;

@Controller
public class JSONController1 {
	@RequestMapping(value="/member/list", produces="application/json; charset=utf-8")
	@ResponseBody
	public String list() {
		ArrayList<MembersVo> list = new ArrayList<MembersVo>();
		list.add(new MembersVo(1, "홍길동", "010", "서울", new Date()));
		list.add(new MembersVo(2, "이길동", "011", "대구", new Date()));
		list.add(new MembersVo(3, "삼길동", "012", "부산", new Date()));
		
		JSONArray jrr = new JSONArray();
		for(MembersVo vo : list) {
			JSONObject json = new JSONObject();
			json.put("num", vo.getNum());
			json.put("name", vo.getName());
			json.put("phone", vo.getPhone());
			json.put("addr", vo.getAddr());
			json.put("regdate", vo.getRegdate());
			jrr.put(json);
		}
		return jrr.toString();
	}
}
