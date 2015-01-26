package com.singgih.jsp.sample;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.apache.log4j.Logger;

/*The @WebFilter annotation has the following attributes : 
 - filterName
 - description
 - displayName
 - initParams
 - servletNames
 - value
 - urlPatterns
 - dispatcherTypes
 - asyncSupported
 */

@WebFilter(filterName = "simple_filter", urlPatterns={"*"})
public class SimpleFilter implements Filter {
	Logger log = Logger.getLogger("com.singgih.jsp");

	public void destroy() {
	}

	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		log.debug("filtered");
		filterChain.doFilter(servletRequest, servletResponse);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		log.debug("Initialize filter : " + filterConfig.getFilterName());
	}

}
