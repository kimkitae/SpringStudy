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
import spring.voltvalues;
import macro.*;

@Controller
public class MacroController {
	private static MemberDao memberDao;
	private static ExtendThreadtmp et;

	@RequestMapping(value = "/macro")
	public ModelAndView macroexe() {


		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");

		memberDao = ctx.getBean("memberDao", MemberDao.class);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("macro");

		List<Macro> macros = memberDao.macroselete();

		
		mv.addObject("macros", macros);
		if(macros.size() == 0){
			
			mv.addObject("laststats", macros);
		}else{
			
//			mv.addObject("laststats", macros.get(macros.size()-1).getStats());
			
			mv.addObject("laststats", macros.get(0).getStats());
		}
		
		ctx.close();

		return mv;

	}
	
	@RequestMapping(value = "/value", method = RequestMethod.GET)
	public ModelAndView result(HttpServletRequest request) {

		String tc = request.getParameter("tc");
		String service = request.getParameter("service");

		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");

		memberDao = ctx.getBean("memberDao", MemberDao.class);
		ModelAndView mv = new ModelAndView();
		

			mv.setViewName("table1");

			List<voltvalues> members = memberDao.seletetable(service,tc);
System.out.println(service +" / " + tc);
			mv.addObject("members", members);
		
		ctx.close();
		return mv;

	}
	
	
	@RequestMapping(value="/macroexe", method=RequestMethod.GET)
	public ModelAndView macrostart(){
		
		ModelAndView mv = new ModelAndView();
		
		//et.macrorun();
		Runnable r = new ExtendThreadtmp();
		Thread t = new Thread(r);
		r.run();
		mv.setViewName("macroexe");
		
		return mv;
	}

}
