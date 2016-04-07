package com.test.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.type.IntegerTypeHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import com.test.account.Account;
import com.test.account.AccountDAOService;
import com.test.word.*;
import com.test.word.MemberDAOService;

@Controller
public class signupController {

	private final String dev = "http://localhost:8080/controller/";
	private final String web = "http://daearcdo.cafe24.com/www/";
	private String homeurl = dev;
	//
	@Autowired
	private AccountDAOService accountDAOService;

	private static final Logger logger = LoggerFactory.getLogger(signupController.class);

	// ���� ����ȭ��.
	@RequestMapping("/signup")
	public ModelAndView main(Locale locale, Model model) {
		logger.info("Welcome main.", locale);

		ModelAndView result = new ModelAndView();
		List<Account> accountList = accountDAOService.getAccounts();

		result.addObject("result", accountList);
		result.setViewName("signup/signupmain");
		return result;
	}

	@RequestMapping(value = "/signupinsert", method = RequestMethod.POST)
	public ModelAndView insert(HttpServletRequest request) {

		Account account = new Account();
		account.setId((String) request.getParameter("id"));
		account.setPwd((String) request.getParameter("pwd"));
		account.setPermission((String) request.getParameter("permission"));

		accountDAOService.insertAccount(account);
		System.out.println("insert complet");

		ModelAndView result = new ModelAndView();
		RedirectView rv = new RedirectView();
		rv.setUrl(homeurl + "signup");

		List<Account> accountList = accountDAOService.getAccounts();
		System.out.println(accountList.size());
		result.addObject("result", accountList);
		result.setView(rv);
		return result;
	}

	@RequestMapping(value = "/signuplist", method = RequestMethod.GET)
	public ModelAndView select(HttpServletRequest request) {

		String id = request.getParameter("id").toString();

		ModelAndView result = new ModelAndView();
		List<Account> accountList = accountDAOService.selectAccount(id);
		System.out.println(accountList.toString());
		result.addObject("result", accountList);
		result.setViewName("signup/signupupdate");
		return result;
	}

	@RequestMapping(value = "/signupupdate", method = RequestMethod.POST)
	public ModelAndView update(HttpServletRequest request) {

		ModelAndView result = new ModelAndView();
		Account account = new Account();

		account.setPwd((String) request.getParameter("pwd"));
		account.setPermission((String) request.getParameter("permission"));
		account.setId((String) request.getParameter("id"));
		accountDAOService.updateAccount(account);
		System.out.println("수정완료");
		RedirectView rv = new RedirectView();

		rv.setUrl(homeurl + "signup");
		List<Account> accountList = accountDAOService.getAccounts();
		result.addObject("result", accountList);
		result.setView(rv);
		return result;
	}

	@RequestMapping(value = "/signupdelete", method = RequestMethod.GET)
	public ModelAndView delete(HttpServletRequest request) {

		ModelAndView result = new ModelAndView();
		Account account = new Account();
		String id = request.getParameter("id");
		System.out.println(id);
		accountDAOService.deleteAccount(id);
		RedirectView rv = new RedirectView();
		rv.setUrl(homeurl + "signup");
		System.out.println("삭제완료");
		List<Account> accountList = accountDAOService.getAccounts();
		result.addObject("result", accountList);
		result.setView(rv);
		return result;
	}

	@RequestMapping(value = "/signuptabledrop", method = RequestMethod.GET)
	public ModelAndView tabledrop(HttpServletRequest request) {

		ModelAndView result = new ModelAndView();
		accountDAOService.dropTable();
		RedirectView rv = new RedirectView();
		rv.setUrl(homeurl + "signup");
		result.setView(rv);
		return result;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request) {
		ModelAndView result = new ModelAndView();
		String id = ((String) request.getParameter("id"));
		String pwd = ((String) request.getParameter("pwd"));

		List<Account> accountList = accountDAOService.selectAccount(id);

		if (accountList.size() == 0) {
			result.addObject("message1", "로그인에 실패하였습니다.");
			result.addObject("message2", "회원정보가 존재하지 않습니다.");

		} else {
			String getid = accountList.get(0).getId().toString().trim();
			String getpwd = accountList.get(0).getPwd().toString().trim();

			if (getid.hashCode() == id.hashCode()) {
				if (getpwd.hashCode() == pwd.hashCode()) {
					result.addObject("message1", "로그인에 성공하였습니다.");
					result.addObject("message2", id + " 님 안녕하세요");
						request.getSession().setAttribute("logininfo", "dd");
					
				} else {
					result.addObject("message1", "로그인에 실패하였습니다.");
					result.addObject("message2", "로그인정보가 틀립니다.");

				}
			} else {
				result.addObject("message1", "로그인에 실패하였습니다.");
				result.addObject("message2", "로그인정보가 틀립니다.");
			}
		}

		result.setViewName("signup/login");
		return result;

	}

	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public ModelAndView signin(HttpServletRequest request) {
		ModelAndView result = new ModelAndView();
		result.setViewName("signup/signin");

		return result;

	}

	@RequestMapping(value = "/idcheck", method = RequestMethod.POST)
	public ModelAndView idcheck(HttpServletRequest request) {
		ModelAndView result = new ModelAndView();
		String id = ((String) request.getParameter("id"));
		String pwd = ((String) request.getParameter("pwd"));

		List<Account> accountList = accountDAOService.selectAccount(id);

		if (accountList.size() == 0) {
			result.addObject("message", "사용하셔도 좋습니다.");

		} else {
			result.addObject("message", "현재 중복된 계정이 존재합니다.");
		}

		result.setViewName("signup/idcheck");
		return result;

	}
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request) {

		ModelAndView result = new ModelAndView();
		
		RedirectView rv = new RedirectView();
		request.getSession().invalidate();
		rv.setUrl(homeurl + "signin");
		result.setView(rv);
		return result;
	}

}
