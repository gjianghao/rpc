package com.guojianghao.rpc.client;

import com.guojianghao.rpc.bean.User;
import com.guojianghao.rpc.proxy.RpcProxy;
import com.guojianghao.rpc.service.UserService;

public class Client {

	public static void main(String[] args) {
		
		UserService userService = RpcProxy.create(UserService.class);
		
		User user = userService.getUserByUsername("zhangsan");
		System.out.println(user);
	}
}
