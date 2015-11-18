package com.test.spring;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	public String hello(Model model, @RequestParam(value = "name", required = false) int name) {

		
		Random r = new Random();
	    int a = r.nextInt(name);
		model.addAttribute("greeting", "입력한 숫자범위 랜덤 " + a);
		return "hello";

	}
}
