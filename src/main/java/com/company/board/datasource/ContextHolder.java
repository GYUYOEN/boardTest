package com.company.board.datasource;

public class ContextHolder {
	private static final ThreadLocal<Integer> contextHolder = new ThreadLocal<Integer>();
	
	public static void setDataSourceNo(int dataSourceNo) {
		contextHolder.set(dataSourceNo);
	}
	
	public static int getDataSourceNo() {
		return contextHolder.get();
	}
	
	public static void clearDataSourceNo() {
		contextHolder.remove();
	}
}
