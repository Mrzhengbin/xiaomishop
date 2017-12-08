package com.xiaomishop.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xiaomishop.entity.Cart;
import com.xiaomishop.entity.CartItem;
import com.xiaomishop.entity.OrderItem;
import com.xiaomishop.user.service.OrderService;
import com.xiaomishop.user.service.ProductService;
import com.xiaomishop.user.service.UserService;

@Controller
@RequestMapping("/order")
public class OrderController {
	@Resource
	private OrderService orderService;
	@Resource
	private UserService userService;
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String addOrder(HttpSession session){
		Cart c = (Cart) session.getAttribute("cart");
		String name = (String) session.getAttribute("name");
		int userid = Integer.parseInt(userService.findByName(name).getName());
		Iterator i =c.container.values().iterator();
		while(i.hasNext()){
			CartItem ci =(CartItem)i.next();
			OrderItem o = new OrderItem();
			o.setName(ci.getProduct().getName());
			o.setPrice(ci.getProduct().getPrice());
			o.setCount(ci.getCount());
			o.setUserid(userid);
			o.setChec(0);
//			System.out.println(o.getId());
//			System.out.println(o.getName());
			orderService.insertOrder(o);
		}
		c = null;
		session.setAttribute("cart", c);
		return "forward:/order/find";
	}
	
	@RequestMapping(value="/find",method=RequestMethod.GET)
	public String findOrder(HttpSession session){
		String name = (String) session.getAttribute("name");
//		System.out.println(name);
		int userid = Integer.parseInt(userService.findByName(name).getName());
		List<OrderItem> list = orderService.findByUserId(userid);
//		session.setAttribute("list", list);
		List<OrderItem> list1 =new ArrayList();
		List<OrderItem> list2 =new ArrayList();
		for(int i = 0;i<list.size();i++){
			if(list.get(i).getChec()==1){
				list1.add(list.get(i));
			}else{
				list2.add(list.get(i));
			}
		}
		session.setAttribute("list1", list1);
		session.setAttribute("list2", list2);
//		System.out.println(list1.size());
//		System.out.println(list2.size());
		
		return "dingdanzhongxin";
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String deleteOrder(HttpServletRequest request){
		int id = Integer.parseInt(request.getParameter("id"));
//		System.out.println(id);
		orderService.deleteOrder(id);
		return "forward:/order/find";
	}
	
	@RequestMapping(value="/address",method=RequestMethod.GET)
	public String addaddress(HttpServletRequest request){
		String address = request.getParameter("address");
		System.out.println(request.getParameter("orderid"));
		int id = Integer.parseInt(request.getParameter("orderid"));
		orderService.addaddress(address, id);
		System.out.println("add OK");
		return "forward:/order/find";
	}
	
	@RequestMapping(value="/findorder",method=RequestMethod.GET)
	public String findOrderById(HttpServletRequest request,HttpSession session){
		int id = Integer.parseInt(request.getParameter("id"));
		OrderItem o = orderService.findById(id);
		session.setAttribute("id", id);
		session.setAttribute("address", o.getAddress());
		return "address";
	}
}
