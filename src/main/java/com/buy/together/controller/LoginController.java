package com.buy.together.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.buy.together.domain.User;
import com.buy.together.service.LoginService;

@Controller
@RequestMapping("/user/*")
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Inject
	private LoginService loginService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() throws Exception {
		
		logger.info("login GET");
		
		return "/views/user/login";
		
	}
	
	// !로그인회원정보 세션에 저장해야함
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestBody User user, RedirectAttributes rttr) throws Exception {
		
		logger.info("login POST");
		
		if(loginService.read(user.getId()).equals("")) { //신규회원이면
			
			loginService.regist(user); //DB에 회원 정보 저장
			rttr.addFlashAttribute("result", "success");
			rttr.addFlashAttribute("newUser", "true");
			return "redirect:/"; //닉네임, 관심카테고리, 관심지역 등록 뷰로 이동
		
		}

		return "/";//같이사냥 회원이면 메인으로 이동
	
	}

}
