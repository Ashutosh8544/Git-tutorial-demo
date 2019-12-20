package org.nendrasys.rest;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.StringTokenizer;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

public class SecurityFilter implements ContainerRequestFilter {
	private static final String AUTHORIZATION_HEADER = "Authorization";
	private static final String AUTHORIZATION_HEADER_PREFIX = "basic";
	private static final String SECURED_URI_HEADER = "secured";

	public void filter(ContainerRequestContext requestContext) throws IOException {
		if (requestContext.getUriInfo().getPath().contains(SECURED_URI_HEADER)) {
			List<String> authHeader = requestContext.getHeaders().get(AUTHORIZATION_HEADER);
			if (authHeader!=null && authHeader.size() > 0) {
				String authToken = authHeader.get(0);
				authToken = authToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX, "");
				String decodeString = Base64.decodeAsString(authToken);
				StringTokenizer tokenizer = new StringTokenizer(decodeString, ":");
				String username = tokenizer.nextToken();
				String password = tokenizer.nextToken();
				if ("user".equals(username) && "password".equals(password))
					return;

				Response unauthoizedStatus = Response.status(Response.Status.UNAUTHORIZED)
						.entity("User can not access the resuource").build();
				requestContext.abortWith(unauthoizedStatus);
			}

		}
	}

}
