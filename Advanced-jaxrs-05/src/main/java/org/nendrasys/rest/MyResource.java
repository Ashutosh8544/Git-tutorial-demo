package org.nendrasys.rest;

import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("test")
public class MyResource {

	@GET
	/* @Produces(MediaType.TEXT_PLAIN) */
	/* @Produces("text/shortdate") */
	@Produces(value = { MediaType.TEXT_PLAIN, "text/shortdate" })

	public Date textMethod() {
		return Calendar.getInstance().getTime();
	}
}
