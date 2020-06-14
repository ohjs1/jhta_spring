package com.jhta.spring09.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jhta.spring09.service.MyUsersService;

import quiz.vo.MyUsersVo;

@Controller
public class ViewController {
	@Autowired
	private MyUsersService service;
	
	@RequestMapping("/member/view/users")
	public ModelAndView showUsersAll(HttpSession session, int pageNum){
		ModelAndView mv = new ModelAndView();
//		List<MyUsersVo> list = service.showUsersAll();
		int sNum =0; //������ ���۹�ȣ
		int eNum =0; //������ �� ��ȣ
		int wsize = 5; //���������� ǥ���� �� ����
		int scNum = 0; //���� �۹�ȣ
		int ecNum = 0; //�� �۹�ȣ
		
		//�� �۰���
		int pageCount = service.countPage();
//		System.out.println("�ѱ۰��� :" + pageCount);
		
		//��ü ������ ��
		int maxPageCount = ( (pageCount-1) / wsize ) + 1;
//		System.out.println("��ü �������� : " + maxPageCount);
		
		//����������
		sNum = ((pageNum-1)/maxPageCount) * maxPageCount + 1;
		
		//��������
		if(sNum + maxPageCount -1 < maxPageCount) {
			eNum = maxPageCount;
		} else {
			eNum = sNum + maxPageCount -1;
		}
		
		scNum = (pageNum * wsize) - wsize + 1;
		ecNum = pageNum * wsize;
		
//		System.out.println("����������:" + sNum);
//		System.out.println("��������:" + eNum);
//		System.out.println("���� ������:" + pageNum);
//		System.out.println("���� �۹�ȣ :" + scNum);
//		System.out.println("�� �۹�ȣ :" + ecNum);
		
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("sNum", scNum);
		map.put("eNum", ecNum);
		
		
		List<MyUsersVo> list = service.pagningList(map);
		
		session.setAttribute("sNum", sNum);
		session.setAttribute("eNum", eNum);
		session.setAttribute("pageNum", pageNum);
		session.setAttribute("maxPageCount", maxPageCount);
		
		mv.addObject("usersListAll", list);
		mv.setViewName("home");
		session.setAttribute("ipage", "usersList");
		return mv;
	}
}