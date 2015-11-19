package com.test.spring;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.Macro;
import spring.Member;
import spring.MemberDao;
import macro.*;

@Controller
public class MacroController {
	private static MemberDao memberDao;
	private static ExtendThread et;

	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public ModelAndView macroexe() {


		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");

		memberDao = ctx.getBean("memberDao", MemberDao.class);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("testt");

		List<Macro> macros = memberDao.macroselete();

		System.out.println(macros.get(1).toString());
		mv.addObject("macros", macros);
		ctx.close();

		return mv;

	}
	
	@RequestMapping(value="/macroexe", method=RequestMethod.GET)
	public ModelAndView macrostart(){
		
		ModelAndView mv = new ModelAndView();
		
		et.macrorun();
		mv.setViewName("macro");
		
		return mv;
	}

}
