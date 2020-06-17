package com.jhta.spring12.controller;

import java.sql.Date;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import test.vo.MembersVo;

@Controller
public class MemberXMLController {
	//������ xml�� �ϱ�
	@RequestMapping(value="/member/xml", produces = "application/xml; charset=utf8")
	@ResponseBody	//ajax�� ����Ҷ��� �ݵ�� @ResponseBody ������̼��� �־�, ������ �̵��߻��� ���ƾ� �Ѵ�.
	public String getList() {
		java.util.Date d = new java.util.Date();
		Date regdate = new Date(d.getTime());
		
		ArrayList<MembersVo> list = new ArrayList<MembersVo>();
		list.add(new MembersVo(1, "ȫ�浿", "010", "����", regdate));
		list.add(new MembersVo(2, "�̱浿", "010", "�λ�", regdate));
		list.add(new MembersVo(3, "��浿", "010", "����", regdate));

		
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
