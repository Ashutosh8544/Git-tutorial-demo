package org.nendrasys.rest;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;

public class LoggigFilter implements ContainerRequestFilter,ContainerResponseFilter{
	
	public void filter(ContainerRequestContext requestContext) throws IOException {
		System.out.println(requestContext.getHeaders());		
	}

	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {
		System.out.println("Response Filter");
		System.out.println(requestContext.getHeaders());
	}

}
