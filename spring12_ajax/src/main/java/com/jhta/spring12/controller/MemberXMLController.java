package com.jhta.spring12.controller;

import java.sql.Date;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import test.vo.MembersVo;

@Controller
public class MemberXMLController {
	//응답을 xml로 하기
	@RequestMapping(value="/member/xml", produces = "application/xml; charset=utf8")
	@ResponseBody	//ajax를 사용할때는 반드시 @ResponseBody 어노테이션을 주어, 페이지 이동발생을 막아야 한다.
	public String getList() {
		java.util.Date d = new java.util.Date();
		Date regdate = new Date(d.getTime());
		
		ArrayList<MembersVo> list = new ArrayList<MembersVo>();
		list.add(new MembersVo(1, "홍길동", "010", "서울", regdate));
		list.add(new MembersVo(2, "이길동", "010", "부산", regdate));
		list.add(new MembersVo(3, "삼길동", "010", "제주", regdate));

		
		StringBuffer sb = new StringBuffer();
		sb.append("<members>");
		for(MembersVo vo : list) {
			sb.append("<member>");
			sb.append("<num>" + vo.getNum() + "</num>");
			sb.append("<name>" + vo.getName() + "</name>");
			sb.append("<phone>" + vo.getPhone() + "</phone>");
			sb.append("<addr>" + vo.getAddr() + "</addr>");
			sb.append("<regdate>" + vo.getRegdate() + "</regdate>");
			sb.append("</member>");
		}
		sb.append("</members>");
		return sb.toString();
	}
}
