package com.guojianghao.rpc.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.alibaba.fastjson.JSON;
import com.guojianghao.rpc.message.Request;
import com.guojianghao.rpc.message.Response;
import com.guojianghao.rpc.net.RpcClient;

public class RpcHandler implements InvocationHandler{
	
	public RpcHandler() {}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		Request request = new Request();
		
		request.setMethodName(method.getName());
		request.setIntefaceClass(method.getDeclaringClass());
		request.setParameterType(method.getParameterTypes());
		request.setParameterValue(args);
		
		Response response = RpcClient.send(request);
		
		String result = "";
		if(response.getStatus().equals("200")){
			result = response.getData();
			System.out.println("result------------------"+result);
			return JSON.parseObject(result, method.getReturnType());
		}
		return null;
	}

}
