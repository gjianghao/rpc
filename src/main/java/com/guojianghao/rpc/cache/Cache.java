package com.guojianghao.rpc.cache;

import java.util.HashMap;
import java.util.Map;

import com.guojianghao.rpc.bean.User;
import com.guojianghao.rpc.service.impl.UserServiceImpl;

public class Cache {

	public static Map<String, User> map = new HashMap<String,User>();
	
	public static Map<String,Object> beanMap = new HashMap<String,Object>();
	
	static{
		map.put("zhangsan", new User("zhangsan", "password"));
		map.put("lisi", new User("lisi", "password"));
		
		beanMap.put("com.guojianghao.rpc.service.UserService", new UserServiceImpl());
	}
}
