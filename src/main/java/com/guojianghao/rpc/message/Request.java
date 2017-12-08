package com.guojianghao.rpc.message;

import java.io.Serializable;

public class Request implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/** 方法名 */
	private String methodName;
	/** 接口class*/
	private Class<?> intefaceClass;
	/** 参数类型 */
	private Class<?>[] parameterType;
	/** 参数值 */
	private Object[] parameterValue;
	
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public Class<?> getIntefaceClass() {
		return intefaceClass;
	}
	public void setIntefaceClass(Class<?> intefaceClass) {
		this.intefaceClass = intefaceClass;
	}
	public Class<?>[] getParameterType() {
		return parameterType;
	}
	public void setParameterType(Class<?>[] parameterType) {
		this.parameterType = parameterType;
	}
	public Object[] getParameterValue() {
		return parameterValue;
	}
	public void setParameterValue(Object[] parameterValue) {
		this.parameterValue = parameterValue;
	}
}
