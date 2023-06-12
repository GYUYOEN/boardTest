package com.company.board.aop;

import com.company.board.datasource.RoutingDataSource;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.company.board.annotation.DataSource;
import com.company.board.datasource.ContextHolder;
import com.company.board.datasource.RoutingDataSource;

@Aspect
@Component
@Order(value=1)
public class DataSourceAspect {
	private static final Logger logger = LoggerFactory.getLogger(DataSourceAspect.class);
	
	@Autowired
	RoutingDataSource routingDataSource;
	
	@Around(value="execution(* com.company.board.service.*.*(..)) && @annotation(dataSource)")
	public Object routeDataSourceDefault(ProceedingJoinPoint joinPoint, DataSource dataSource) throws Throwable {		
		
		logger.debug("Route DataSource Start : dataSourceType({})", dataSource.type());
		switch(dataSource.type()){
			case COMMON:
				ContextHolder.setDataSourceNo(routingDataSource.getCommonDSNo());
				break;
		}
		
		logger.debug("Route DataSource ===> {}", ContextHolder.getDataSourceNo());
		
		Object returnValue = joinPoint.proceed();
		
		ContextHolder.clearDataSourceNo();
		
		logger.debug("Route DataSource End : dataSourceType({})", dataSource.type());
		
		return returnValue;
	}
}