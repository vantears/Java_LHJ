package kr.kh.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.kh.spring.service.MemberService;
import kr.kh.spring.util.Message;
import kr.kh.spring.vo.MemberVO;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "/member/signup", method=RequestMethod.GET)
	public String signup() {

		return "/member/signup";
	}
	
	@RequestMapping(value = "/member/signup", method=RequestMethod.POST)
	public String signupPost(MemberVO member, Model model) {
		Message msg = new Message("member/signup", "Failed to sign up");
		
		if(memberService.signup(member)) {
			msg = new Message("member/signup", "Welcome to HJ BOARD PROJECT!");
		}
		model.addAttribute("msg", msg);
		return "message";
	}
	
	@GetMapping(value = "/member/login")
	public String login() {
		
		return "/member/login";
	}
	
	@PostMapping(value = "/member/login")
	public String loginPost(MemberVO member, Model model) {
		Message msg = new Message("member/login", "Failed to log in");
		MemberVO user = memberService.login(member);
		if(user != null) {
			msg = new Message("", "Now you can share your ideas!");
		}
		model.addAttribute("user", user);
		model.addAttribute("msg", msg);
		return "message";
	}
	
	@GetMapping(value = "/member/logout")
	public String logout(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		MemberVO user = (MemberVO)session.getAttribute("user");
		Message msg = new Message("", "Failed to log out");
		if(user != null) {
			session.removeAttribute("user");
			msg.setMsg("Have a nice day!");
		}
		model.addAttribute("msg", msg);
		return "message";
	}
	
	@GetMapping(value = "/member/info")
	public String info(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		MemberVO user = (MemberVO)session.getAttribute("user");
		model.addAttribute("user", user);
		return "/member/info";
	}

}
