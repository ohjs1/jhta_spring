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
		int sNum =0; //페이지 시작번호
		int eNum =0; //페이지 끝 번호
		int wsize = 5; //한페이지에 표시할 글 개수
		int scNum = 0; //시작 글번호
		int ecNum = 0; //끝 글번호
		
		//총 글갯수
		int pageCount = service.countPage();
//		System.out.println("총글갯수 :" + pageCount);
		
		//전체 페이지 수
		int maxPageCount = ( (pageCount-1) / wsize ) + 1;
//		System.out.println("전체 페이지수 : " + maxPageCount);
		
		//시작페이지
		sNum = ((pageNum-1)/maxPageCount) * maxPageCount + 1;
		
		//끝페이지
		if(sNum + maxPageCount -1 < maxPageCount) {
			eNum = maxPageCount;
		} else {
			eNum = sNum + maxPageCount -1;
		}
		
		scNum = (pageNum * wsize) - wsize + 1;
		ecNum = pageNum * wsize;
		
//		System.out.println("시작페이지:" + sNum);
//		System.out.println("끝페이지:" + eNum);
//		System.out.println("현제 페이지:" + pageNum);
//		System.out.println("시작 글번호 :" + scNum);
//		System.out.println("끝 글번호 :" + ecNum);
		
		
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