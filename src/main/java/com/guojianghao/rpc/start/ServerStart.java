package com.guojianghao.rpc.start;

import com.guojianghao.rpc.net.RpcServer;

public class ServerStart {
	

	public static void main(String[] args) throws Exception {
		
		
		RpcServer rpcServer = new RpcServer();
		rpcServer.revice();
	}
}
