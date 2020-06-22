package com.jhta.spring15.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import test.vo.MembersVo;
@RestController
public class MemberController {
	//http://localhost:9090/spring15/member.json
	//http://localhost:9090/spring15/member.xml
	@RequestMapping(value="/member",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE,MediaType.APPLICATION_XML_VALUE})
	public MembersVo member() {
		MembersVo vo=new MembersVo(1, "홍길동","010","서울",new Date());
		return vo;
	}
	@RequestMapping(value="/member/list",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ArrayList<MembersVo> memberList(){
		ArrayList<MembersVo> list=new ArrayList<MembersVo>();
		list.add(new MembersVo(1,"홍길동","010","서울",new Date()));
		list.add(new MembersVo(2,"이길동","011","대구",new Date()));
		list.add(new MembersVo(3,"삼길동","012","부산",new Date()));	
		return list;
	}
	@RequestMapping(value="/member/gradeList",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE,MediaType.APPLICATION_XML_VALUE})
	public HashMap<String,Object> grade(){
		List<MembersVo> list=new ArrayList<MembersVo>();
		list.add(new MembersVo(1,"홍길동","010","서울",new Date()));
		list.add(new MembersVo(2,"이길동","011","대구",new Date()));
		list.add(new MembersVo(3,"삼길동","012","부산",new Date()));	
		HashMap<String,Object> map=new HashMap<String,Object>();
		map.put("list",list);
		map.put("grade","GOLD");
		return map;
	}
}













