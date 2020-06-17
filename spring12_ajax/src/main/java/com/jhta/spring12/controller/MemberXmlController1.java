package com.jhta.spring12.controller;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import test.vo.MembersList;
import test.vo.MembersVo;

@Controller
public class MemberXmlController1 {
	@ResponseBody	
	@RequestMapping("/xml/list1")
	public MembersList getList() {
		java.util.Date d = new java.util.Date();
		Date regdate = new Date(d.getTime());
		
		MembersList members = new MembersList();
		List<MembersVo> list = new ArrayList<MembersVo>();
		
		list.add(new MembersVo(1, "홍길동", "010", "서울", regdate));
		list.add(new MembersVo(2, "이길동", "010", "부산", regdate));
		list.add(new MembersVo(3, "삼길동", "010", "제주", regdate));
		members.setList(list);
		members.setGrade("GOLD");
		
		return members;
	}
}
