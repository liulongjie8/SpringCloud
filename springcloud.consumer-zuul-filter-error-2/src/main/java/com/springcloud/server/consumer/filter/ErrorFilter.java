package com.springcloud.server.consumer.filter;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * 请求过滤
 * 
 * @author LLS
 * 
 */
@Component
public class ErrorFilter extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(ErrorFilter.class);

	@Override
	public Object run() {

		RequestContext ctx = RequestContext.getCurrentContext();
		Throwable throwable = ctx.getThrowable();
		log.error("this is a error filter: {}", throwable.getCause()
				.getMessage());
		ctx.set("error.status_code",
				HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		ctx.set("error.exception", throwable.getCause());
		return null;
	}

	/**
	 * 是否应该过滤
	 */
	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * 过滤顺序
	 */
	@Override
	public int filterOrder() {
		return 10;
	}

	/**
	 * 请求过滤前后 ‘pre’ 前
	 */
	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "error";
	}

}
