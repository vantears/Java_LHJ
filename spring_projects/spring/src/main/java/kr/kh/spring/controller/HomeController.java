package kr.kh.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/")
	public String home(Model model) {
		/* model.addAttribute("화면에서 사용 할 이름", 전송할 값); */
		/* model.addAttribute("name", "abc"); */
		return "home";
	}
	
	@RequestMapping(value = "/signup")
	public String signup(Model model) {
		/* model.addAttribute("화면에서 사용 할 이름", 전송할 값); */
		/* model.addAttribute("name", "abc"); */
		return "signup";
	}
	
}
