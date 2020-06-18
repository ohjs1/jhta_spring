package com.jhta.spring14.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jhta.spring14.service.MembersService;

import test.vo.MembersVo;
@Controller
public class MembersGetInfo {
	@Autowired
	private MembersService service;
	
	@RequestMapping("/member/user")
	@ResponseBody
	public List<MembersVo> getUserList(String addr) {
		List<MembersVo> vo = service.getUserList(addr);
		
		return vo;
	}
}
