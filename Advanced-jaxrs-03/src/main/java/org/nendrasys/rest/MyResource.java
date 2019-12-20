package org.nendrasys.rest;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("{pathParam}/test")
//@Singleton
public class MyResource {

	@PathParam("pathParam")private String pathParamExapmle;
	@QueryParam("query")private String queryParamExapmle;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String textMethod() {
		return "it works! path param used" + pathParamExapmle+" and Query Param used"+queryParamExapmle;
	}
}
