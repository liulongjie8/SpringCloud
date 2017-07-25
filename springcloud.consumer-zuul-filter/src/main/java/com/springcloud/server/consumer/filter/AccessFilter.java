package com.springcloud.server.consumer.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * 请求过滤
 * 
 * @author LLS
 * 
 */
public class AccessFilter extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(AccessFilter.class);

	@Override
	public Object run() {
		// 获取上下文对象
		RequestContext ctx = RequestContext.getCurrentContext();
		// 获取httprequest请求
		HttpServletRequest request = ctx.getRequest();

		log.info("send {} request to {}", request.getMethod(), request
				.getRequestURI().toString());

		Object accessToken = request.getParameter("accessToken");

		if (accessToken == null) {
			log.warn("access token is empty!");
			ctx.setSendZuulResponse(false);
			ctx.setResponseStatusCode(403);
			return null;
		}
		log.info("access token");
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
