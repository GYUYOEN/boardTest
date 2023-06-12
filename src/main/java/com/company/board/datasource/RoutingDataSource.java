package com.company.board.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;


public class RoutingDataSource extends AbstractRoutingDataSource {
	private int				commonDSNo;

	public void setCommonDSNo(int commonDSNo) {
		this.commonDSNo = commonDSNo;
	}
	
	public int getCommonDSNo() {
		return this.commonDSNo;
	}

	@Override
	protected Object determineCurrentLookupKey() {
		return ContextHolder.getDataSourceNo();
	}
}
