package com.test.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.type.IntegerTypeHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.test.mybatis.Member;
import com.test.mybatis.MemberDAOService;

@Controller
public class MybatisController {
	
	// 
	@Autowired
	private MemberDAOService memberDAOService;
	
	private static final Logger logger = LoggerFactory.getLogger(MybatisController.class);
	
	
	//���� ����ȭ��.
	@RequestMapping("/main")
	public ModelAndView main(Locale locale, Model model) {
		logger.info("Welcome main.", locale);

		// view ȭ���� main.jsp�� DB�κ��� �о�� �����͸� �����ش�.
		ModelAndView result = new ModelAndView();
		//addObject view�� �Ѿ�� ������
		List<Member> memberList = memberDAOService.getMembers();
		result.addObject("result", memberList);
		result.setViewName("main");
		return result;
	}
	
	//insert ��ư Ŭ���� ���� �����ͼ� result.jsp�� ȭ����ȯ ���ش�.
	@RequestMapping(value ="/insert", method = RequestMethod.POST)
	public ModelAndView insert(HttpServletRequest request){
		
		// HttpServletRequest�� �̿��Ͽ� main.jsp�κ��� 
		Member member = new Member();
		member.setNum(Integer.parseInt(request.getParameter("num")));
		member.setEmail((String) request.getParameter("email"));
		member.setPhone((String) request.getParameter("phone"));
		
		memberDAOService.insertMember(member);
		System.out.println("insert complet");
		
		//�Ʒ��κ��� select���� result.jsp���Ͽ� �����ֱ� ���� �ǻ��.
		ModelAndView result = new ModelAndView();
		List<Member> memberList = memberDAOService.getMembers();
		result.addObject("result", memberList);
		result.setViewName("result");
		return result;
	}
	
	@RequestMapping(value ="/list", method = RequestMethod.GET)
	public ModelAndView select(HttpServletRequest request){
		
		// HttpServletRequest�� �̿��Ͽ� main.jsp�κ��� 
		int num = Integer.parseInt(request.getParameter("num"));
		System.out.println(num);
		
		//�Ʒ��κ��� select���� result.jsp���Ͽ� �����ֱ� ���� �ǻ��.
		ModelAndView result = new ModelAndView();
		List<Member> memberList = memberDAOService.selectMember(num);
		System.out.println(memberList.toString());
		result.addObject("result", memberList);
		result.setViewName("update");
		return result;
	}
	@RequestMapping(value ="update", method = RequestMethod.POST)
	public ModelAndView update(HttpServletRequest request){
		
		// HttpServletRequest�� �̿��Ͽ� main.jsp�κ��� 
		
		//�Ʒ��κ��� select���� result.jsp���Ͽ� �����ֱ� ���� �ǻ��.
		ModelAndView result = new ModelAndView();
		Member member = new Member();
		
		member.setEmail((String) request.getParameter("email"));
		System.out.println(request.getParameter("email"));
		member.setPhone((String) request.getParameter("phone"));
		System.out.println(request.getParameter("phone"));
		member.setNum(Integer.parseInt(request.getParameter("num")));
		System.out.println(request.getParameter("num"));
		memberDAOService.updateMember(member);
		System.out.println("수정완료");
		List<Member> memberList = memberDAOService.getMembers();
		result.addObject("result", memberList);
		result.setViewName("main");
		return result;
	}
	@RequestMapping(value ="delete", method = RequestMethod.GET)
	public ModelAndView delete(HttpServletRequest request){
		
		// HttpServletRequest�� �̿��Ͽ� main.jsp�κ��� 
		
		//�Ʒ��κ��� select���� result.jsp���Ͽ� �����ֱ� ���� �ǻ��.
		ModelAndView result = new ModelAndView();
		Member member = new Member();
		int num = Integer.parseInt(request.getParameter("num"));
		System.out.println(num);
		memberDAOService.deleteMember(num);
		
		System.out.println("삭제완료");
		List<Member> memberList = memberDAOService.getMembers();
		result.addObject("result", memberList);
		result.setViewName("main");
		return result;
	}
}
