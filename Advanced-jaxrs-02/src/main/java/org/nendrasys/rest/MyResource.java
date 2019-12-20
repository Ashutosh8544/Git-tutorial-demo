package org.nendrasys.rest;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("test")
@Singleton
public class MyResource {

	private int count;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String textMethod() {
		//it returns how many times this method will be called
		count++;
		return "it works! This method os called "+count+"time(s)";
	}
}
