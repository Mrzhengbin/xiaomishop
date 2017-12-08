package com.xiaomishop.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xiaomishop.entity.Cart;
import com.xiaomishop.entity.Product;
import com.xiaomishop.user.service.ProductService;

@Controller
@RequestMapping("/cart")
public class CartController {
	@Resource
	private ProductService productService;
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String addCart(HttpSession session,HttpServletRequest request){
		String pid = request.getParameter("pid");
		Product p=productService.findById(Integer.parseInt(pid));
		Cart c = (Cart) session.getAttribute("cart");
		if(c==null){
			c=new Cart();
		}
		c.addCart(p);
		session.setAttribute("cart", c);
		return "redirect:/product/single?pid="+p.getId();
	}
	
	@RequestMapping(value="/addpro",method=RequestMethod.GET)
	public String addproCart(HttpSession session,HttpServletRequest request){
		String pid = request.getParameter("pid");
		Product p=productService.findById(Integer.parseInt(pid));
		Cart c = (Cart) session.getAttribute("cart");
		c.addCart(p);
		session.setAttribute("cart", c);
		return "gouwuche";
	}
	
	@RequestMapping(value="/clear",method=RequestMethod.POST)
	public String clearCart(HttpSession session){
		return null; 
	}
	
	@RequestMapping(value="/subtract",method=RequestMethod.GET)
	public String substractCart(HttpSession session,HttpServletRequest request){
		String pid = request.getParameter("pid");
		System.out.println(pid);
		Product p=productService.findById(Integer.parseInt(pid));
		Cart c = (Cart) session.getAttribute("cart");
		c.subtractCart(p);
		session.setAttribute("cart", c);
		return "gouwuche";
	}
}
