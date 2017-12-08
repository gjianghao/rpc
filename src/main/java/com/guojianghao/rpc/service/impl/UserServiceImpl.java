package com.guojianghao.rpc.service.impl;

import com.guojianghao.rpc.bean.User;
import com.guojianghao.rpc.cache.Cache;
import com.guojianghao.rpc.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public User getUserByUsername(String username) {
		return Cache.map.get(username);
	}

}
