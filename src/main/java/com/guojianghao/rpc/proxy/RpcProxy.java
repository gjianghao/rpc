package com.guojianghao.rpc.proxy;

import java.lang.reflect.Proxy;

public class RpcProxy {
	
	public static <T> T create(Class<?> clazz){
		
		RpcHandler rpcHandler = new RpcHandler();
		
		return (T)Proxy.newProxyInstance(rpcHandler.getClass().getClassLoader(), new Class<?>[]{clazz}, rpcHandler);
	}
}
