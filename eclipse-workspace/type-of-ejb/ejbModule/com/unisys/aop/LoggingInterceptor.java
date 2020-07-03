package com.unisys.aop;

import java.util.logging.Logger;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class LoggingInterceptor {
	
	Logger logger = Logger.getLogger("LoggingInterceptor");
	
	// this method is invoked by the framework (skeleton/proxy), and 
	// it is the responsibility of the framework to inject value of the parameter
	// which is called DEPENDENCY INJECTION
	
	@AroundInvoke
	public Object doIntercept(InvocationContext ctx) throws Exception {
		logger.info("[VINOD] Proceeding to execute " + ctx.getMethod().getName());
		
		var retValue = ctx.proceed();
		
		logger.info("[VINOD] Coming back from the method " + ctx.getMethod().getName());
		
		return retValue;
	}

}
