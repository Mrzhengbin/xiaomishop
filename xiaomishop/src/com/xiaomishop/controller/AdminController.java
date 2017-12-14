package com.xiaomishop.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.swing.JOptionPane;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xiaomishop.entity.OrderItem;
import com.xiaomishop.entity.Product;
import com.xiaomishop.user.service.AdminService;
import com.xiaomishop.user.service.OrderService;
import com.xiaomishop.user.service.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Resource
	private AdminService adminService;
	@Resource
	private ProductService productService;
	@Resource
	private OrderService orderService;
	
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public String findAllProduct(Model model){
		List list = adminService.findAllProduct();
		model.addAttribute("list", list);
		return "adminproduct";
	}
	
	@RequestMapping(value="/change", method=RequestMethod.GET)
	public String changeProduct(HttpServletRequest request,Model model){
		int id = Integer.parseInt(request.getParameter("pid"));
		Product p = productService.findById(id);
		model.addAttribute("product", p);
		return "changeproduct";
	}
	
	@RequestMapping(value="/change1", method=RequestMethod.GET)
	public String changeProduct(HttpServletRequest request){
		Product p = new Product();
		p.setId(Integer.parseInt(request.getParameter("id")));
		p.setName(request.getParameter("name"));
		p.setDescription(request.getParameter("description"));
		p.setPrice(Integer.parseInt(request.getParameter("price")));
		p.setProducttypeid(Integer.parseInt(request.getParameter("producttypeid")));
		productService.updateProduct(p);
		
		return "redirect:/admin/all";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String deleteProduct(HttpServletRequest request){
		int id = Integer.parseInt(request.getParameter("pid"));
		productService.deleteProduct(id);
		return "redirect:/admin/all";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String addProduct(HttpServletRequest request){
		Product p = new Product();
		p.setName(request.getParameter("name"));
		p.setProducttypeid(Integer.parseInt(request.getParameter("producttypeid")));
		p.setDescription(request.getParameter("description"));
		p.setPrice(Integer.parseInt(request.getParameter("price")));
		productService.addProduct(p);
		JOptionPane.showMessageDialog(null,"增加商品成功!", "系统提示", JOptionPane.INFORMATION_MESSAGE);
		return "redirect:/admin/all";
	}
	
	@RequestMapping(value="/allorder", method=RequestMethod.GET)
	public String allOrder(Model model){
		List list = orderService.allOrder();
		model.addAttribute("list", list);
		return "adminorder";
	}
	
	@RequestMapping(value="/deleteorder", method=RequestMethod.GET)
	public String deleteOrder(HttpServletRequest request){
		int id = Integer.parseInt(request.getParameter("id"));
		orderService.deleteOrder(id);
		JOptionPane.showMessageDialog(null,"删除成功!", "系统提示", JOptionPane.INFORMATION_MESSAGE);
		return "redirect:/admin/allorder";
	}
	
	@RequestMapping(value="/findorder", method=RequestMethod.GET)
	public String findOrder(HttpServletRequest request,Model model){
		int id = Integer.parseInt(request.getParameter("id"));
		OrderItem o = orderService.findById(id);
		List list = new ArrayList();
		list.add(o);
		model.addAttribute("list", list);
		return "adminorder";
	}
}
