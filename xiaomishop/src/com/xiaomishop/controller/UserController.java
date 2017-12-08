package com.xiaomishop.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.xiaomishop.entity.User;
import com.xiaomishop.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserService userService;
	
	@RequestMapping(value="/judgelogin1", method=RequestMethod.GET)
	public String judgeLogin1(HttpSession session){
		if(session.getAttribute("name")!=null){
			return "redirect:/product/hot";
		}else{
			return "login";
		}
	}
	
	@RequestMapping(value="/judgelogin", method=RequestMethod.GET)
	public String judgeLogin(HttpSession session){
		if(session.getAttribute("name")!=null){
			return "redirect:/product/page";
		}else{
			return "login";
		}
	}
	
	@RequestMapping(value="/regist", method=RequestMethod.GET)
	public String toRegist(Model model){
//		model.addAttribute("user", new User());
		return "register";
	}
	
	@RequestMapping(value="/regist", method=RequestMethod.POST)
	public String regist(User user){
//		if(bindingResult.hasErrors()){
//			model.addAttribute("user", user);
//			return "register";
//		}else{
//			session.setAttribute("user", user);
//		model.addAttribute("user", user);
		try{
//			System.out.println(user.getId());
//			System.out.println(user.getName());
//			System.out.println(user.getPassword());
//			System.out.println(user.getPhone());
			userService.regist(user);
			return "login";
		}catch(Exception e){
			e.printStackTrace();
			return "registfail";
		}
		
//		if(result){
//			System.out.print("注册失败，请重试!");
//			return "register";
//		}else{
//			System.out.print("注册成功!");
//			return "login";
//		}
		
//			return "login";
//		}
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String toLogin(){
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String Login(@RequestParam("name") String name, @RequestParam("password") String password,HttpSession session){
		User u = userService.login(name, password);
		if(u!=null){
			if(u.getPassword().equals(password)){
//				return "index";
				session.setAttribute("name", name);
				return "redirect:/product/page";
			}
			return "loginfail";
		}else{
			return "loginfail";
		}
	}
}
