package com.guojianghao.rpc.net;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.guojianghao.rpc.message.Request;
import com.guojianghao.rpc.message.Response;

public class RpcClient {
	
	public static Response send(Request request) throws Exception{
		Socket socket = new Socket("127.0.0.1", 10000);
		
		ObjectOutputStream oo = new ObjectOutputStream(socket.getOutputStream());
		
		oo.writeObject(request);
		oo.flush();
		
		ObjectInputStream oi = new ObjectInputStream(socket.getInputStream());
		Response response = (Response)oi.readObject();
		oo.close();
		oi.close();
		socket.close();
		return response;
	}
}
