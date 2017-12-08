package com.guojianghao.rpc.message;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;

public class Response implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String status;
	private String data;

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = JSON.toJSONString(data);
	}
	
	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
}
