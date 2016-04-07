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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.test.word.*;
import com.test.word.MemberDAOService;

@Controller
public class wordController {
	
	private final String dev = "http://localhost:8080/controller/";
	private final String web = "http://daearcdo.cafe24.com/www/";
	private String homeurl = dev;
	
	
	// 
	@Autowired
	private MemberDAOService memberDAOService;
	
	private static final Logger logger = LoggerFactory.getLogger(wordController.class);
	
	
	//���� ����ȭ��.
	@RequestMapping("/main")
	public ModelAndView main(Locale locale, Model model) {
		logger.info("Welcome main.", locale);

		// view ȭ���� main.jsp�� DB�κ��� �о�� �����͸� �����ش�.
		ModelAndView result = new ModelAndView();
		//addObject view�� �Ѿ�� ������
		List<Member> memberList = memberDAOService.getMembers();
		
		if(memberList.size() < 1){
			result.addObject("count",1);
			
		}else{
			
			result.addObject("count",memberList.get(0).getNum()+1);
		}
		result.addObject("result", memberList);
		result.setViewName("word/main");
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
	   RedirectView rv = new RedirectView();
//	   rv.setUrl("http://localhost:8080/controller/main");
	   rv.setUrl(homeurl+"main");
	   
		List<Member> memberList = memberDAOService.getMembers();
		System.out.println(memberList.size());
		result.addObject("result", memberList);
		result.setView(rv);
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
		RedirectView rv = new RedirectView();
		
//		rv.setUrl("http://localhost:8080/controller/main");
		rv.setUrl(homeurl+"main");
		List<Member> memberList = memberDAOService.getMembers();
		result.addObject("result", memberList);
		result.setView(rv);
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
		RedirectView rv = new RedirectView();
//		rv.setUrl("http://localhost:8080/controller/main");
		rv.setUrl(homeurl+"main");
		System.out.println("삭제완료");
		List<Member> memberList = memberDAOService.getMembers();
		result.addObject("result", memberList);
		result.setView(rv);
		return result;
	}
	@RequestMapping(value ="swipe", method= RequestMethod.GET)
	public ModelAndView swipe(Locale locale, Model model) {
		logger.info("Welcome main.", locale);

		// view ȭ���� main.jsp�� DB�κ��� �о�� �����͸� �����ش�.
		ModelAndView result = new ModelAndView();
		
		List<Member> memberList = memberDAOService.getMembers();
		result.addObject("result", memberList);
		result.setViewName("word/swipedrow");
		return result;
	}
	@RequestMapping(value ="/tabledrop", method = RequestMethod.GET)
	public ModelAndView tabledrop(HttpServletRequest request){
		
		ModelAndView result = new ModelAndView();
		memberDAOService.dropTable();
		RedirectView rv = new RedirectView();
//		rv.setUrl("http://localhost:8080/controller/main");
		rv.setUrl(homeurl+"main");
		
		result.setView(rv);
		return result;
	}
	
	
}
