package com.xiaomishop.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xiaomishop.dao.ProductDao;
import com.xiaomishop.entity.Page;
import com.xiaomishop.entity.Product;
import com.xiaomishop.user.service.ProductService;
import com.xiaomishop.user.service.UserService;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Resource
	private ProductService productService;
	

	
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public String page(Model model,HttpServletRequest request){ 
		String pageNum = (String)request.getParameter("pageNum");
		int num = 0;
		if(pageNum ==null || pageNum.equals("")){
			num = 1;
		}else{
			num = Integer.parseInt(pageNum);
		}
		int count = productService.findCount();
		List<Product> list = productService.findByPage(num,5);
		Page<Product> p = new Page<Product>(num,5);
		p.setList(list);
		p.setTotalCount(count);
		model.addAttribute("page", p);
		model.addAttribute("list", list);
		return "liebiao";
	}
	
	@RequestMapping(value="/single", method=RequestMethod.GET)
	public String single(Model model,HttpServletRequest request){
		int id = Integer.parseInt(request.getParameter("pid"));
		Product p = productService.findById(id);
		model.addAttribute("p", p);
		return "xiangqing";
	}
}
