package com.vasu.fairshare.filters;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.vasu.fairshare.commons.AttributeConstants;
import com.vasu.fairshare.filters.XSSIFilter;

public class MyFilter implements Filter{

	private static final Logger logger = LoggerFactory.getLogger(MyFilter.class);
	/**
	 * Default constructor. 
	 */
	public MyFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		HttpServletRequest httpReq = (HttpServletRequest) request;
		Cache<String, Boolean> csrfPreventionSaltCache = (Cache<String, Boolean>) httpReq.getSession().getAttribute(AttributeConstants.CSRF_SALT);

		if(csrfPreventionSaltCache == null){
			csrfPreventionSaltCache = CacheBuilder.newBuilder()
					.maximumSize(5000)
					.expireAfterWrite(2, TimeUnit.HOURS)
					.build();
			httpReq.getSession().setAttribute(AttributeConstants.CSRF_SALT, csrfPreventionSaltCache);
		}
		
		String salt = org.apache.commons.lang3.RandomStringUtils.random(20,0,0,true,true, null, new SecureRandom());
		csrfPreventionSaltCache.put(salt, Boolean.TRUE);
		httpReq.setAttribute(AttributeConstants.RAND_ID, salt);
		logger.info("Filter host : "+request.getRemoteHost());
		logger.info("Filter port : "+request.getLocalPort());
		System.out.println("");
		// pass the request along the filter chain
		chain.doFilter(new XSSIFilter(httpReq), response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
