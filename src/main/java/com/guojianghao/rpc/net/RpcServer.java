package com.guojianghao.rpc.net;

import java.net.ServerSocket;
import java.net.Socket;

import com.guojianghao.rpc.net.thread.RpcThread;


public class RpcServer {

	public void revice() throws Exception{
		ServerSocket serverSocket = new ServerSocket(10000);
		while(true){
			Socket socket = serverSocket.accept();
			System.out.println("--------------一个请求过来--------------");
			new Thread(new RpcThread(socket)).start();
		}
	}
}
