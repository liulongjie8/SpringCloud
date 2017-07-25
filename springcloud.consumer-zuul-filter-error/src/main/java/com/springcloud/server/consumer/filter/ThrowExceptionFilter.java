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
public class ThrowExceptionFilter extends ZuulFilter {

	private static Logger log = LoggerFactory
			.getLogger(ThrowExceptionFilter.class);

	@Override
	public Object run() {

		log.info(" This is a pre filter, it will throw a RuntimeException");

		RequestContext ctx = RequestContext.getCurrentContext();

		try {
			doSomthing();
		} catch (Exception e) {
			ctx.set("error.status_code",
					HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			ctx.set("error.exception", e);
		}

		return null;
	}

	private void doSomthing() {
		throw new RuntimeException("Exist somw errors");
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
		return 0;
	}

	/**
	 * 请求过滤前后 ‘pre’ 前
	 */
	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

}
