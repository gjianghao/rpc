package com.guojianghao.rpc.net.thread;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;

import com.guojianghao.rpc.cache.Cache;
import com.guojianghao.rpc.message.Request;
import com.guojianghao.rpc.message.Response;

public class RpcThread implements Runnable{

	private Socket socket;
	
	private ObjectInputStream oi;
	private ObjectOutputStream oo;
	
	public RpcThread(Socket socket) {
		this.socket = socket;
		try {
			oi = new ObjectInputStream(socket.getInputStream());
			oo = new ObjectOutputStream(socket.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	@Override
	public void run() {
		Object result = null;
		try {
			Request request = (Request)oi.readObject();
			String methodName = request.getMethodName();
			Class clazz = request.getIntefaceClass();
			Class<?>[] parameterTypes = request.getParameterType();
			Object[] args = request.getParameterValue();
			
			Method method = clazz.getMethod(methodName, parameterTypes);
			result = method.invoke(Cache.beanMap.get(clazz.getName()), args);
			
			Response response = new Response();
			response.setStatus("200");
			response.setData(result);
			oo.writeObject(response);
			oo.flush();
			System.out.println("返回结果");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.close();
		}
	}
	
	private void close(){
		try {
			if(this.oi != null){
				this.oi.close();
			}
			if(this.oo != null){
				this.oo.close();
			}
			if(this.socket != null){
				this.socket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
