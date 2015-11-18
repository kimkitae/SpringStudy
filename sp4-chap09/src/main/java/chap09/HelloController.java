package chap09;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	public String hello(Model model,
			@RequestParam(value = "name", required = false) String name) {
		model.addAttribute("greeting", "æ»≥Á«œººø‰, " + name);
		return "hello";
	}
	
	@RequestMapping(value = "/hello1" , method = RequestMethod.POST)
public ModelAndView hello1(parametertest dd){
	System.out.println(dd.getName());
	System.out.println(dd.getAvg());
	System.out.println(dd.getId());
	
	String name = dd.getName();
	String avg = dd.getAvg();
	String id = dd.getId();
	
		
	asdf af = new asdf();
		ModelAndView view = new ModelAndView();
		
		view.setViewName("/haha");
		view.addObject("name",  af.name(name));
		view.addObject("avg",  avg );
		view.addObject("id", id);
		
		return view;
	}	
	
	@RequestMapping(value = "/", method= RequestMethod.GET)
	public ModelAndView home(){
		
		ModelAndView ma = new ModelAndView();
		ma.setViewName("index");
		
		return ma;
	}
}
