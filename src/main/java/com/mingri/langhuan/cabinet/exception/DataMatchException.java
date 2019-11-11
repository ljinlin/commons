package com.mingri.langhuan.cabinet.exception;

public class DataMatchException extends IllegalArgumentException{
  
	/**
	 * 
	 */
	private static final long serialVersionUID = 3819376393254061297L;

	public static void throwForNotMatch(Class<?> matchClass,Object v) {
				throw new DataMatchException("data:"+v+" not match"+matchClass);
	}
	
	public DataMatchException() {
	super();
	}
	
	public DataMatchException(String msg) {
		super(msg);
	}

}
