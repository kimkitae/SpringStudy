package com.test.spring;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import macro.ExtendThread;
import spring.Macro;
import spring.Member;
import spring.MemberDao;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	private static MemberDao memberDao;
	private static ExtendThread et;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(Locale locale, Model model) {

		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");

		memberDao = ctx.getBean("memberDao", MemberDao.class);

		List<String> table = memberDao.showtt();

		ctx.close();

		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		mv.addObject("tables", table);

		return mv;
	}

	@RequestMapping(value = "/result1")
	public String home2() {

		return "result";
	}

	@RequestMapping(value = "/result", method = RequestMethod.GET)
	public ModelAndView result(HttpServletRequest request) {

		String service = request.getParameter("service");

		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");

		memberDao = ctx.getBean("memberDao", MemberDao.class);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("result");

		List<Member> members = memberDao.selectAll(service);

		mv.addObject("service", members);
		ctx.close();

		return mv;

	}
	
}
