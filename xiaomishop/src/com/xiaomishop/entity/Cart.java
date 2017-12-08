package com.xiaomishop.entity;

import java.util.HashMap;
import java.util.Map;

public class Cart {
	public Map<Integer,CartItem> container = new HashMap<Integer,CartItem>();
	
	public Map<Integer, CartItem> getContainer() {
		return container;
	}

	public void setContainer(Map<Integer, CartItem> container) {
		this.container = container;
	}

	public void addCart(Product pro){
		if(container.containsKey(pro.getId())){
			CartItem ci=container.get(pro.getId());
			ci.setCount(ci.getCount()+1);
		}else{
			CartItem ci=new CartItem(); 
			ci.setProduct(pro);
			ci.setCount(1);
			container.put(pro.getId(),ci);
		}
	}
	
	public void subtractCart(Product pro){
		CartItem ci=container.get(pro.getId());
		if(ci.getCount()==1){
			container.remove(pro.getId());
		}else{
			ci.setCount(ci.getCount()-1);
		}
	}
}
