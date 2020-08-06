package com.lti.resource;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.lti.resource.Passengers.Gender;
import com.lti.resource.Passengers.Status;

@Path("/pnr")
public class PnrResource {
	@GET
	//  //@Produces("application/json")    can write in this way also but can get typo error
	@Produces(MediaType.APPLICATION_JSON)
	public Pnr check(@QueryParam("pnrNo") int pnrNo, @Context HttpServletResponse response) {
		//add a delay in this server side code or we can also add some loading gifs for better views and after the image loading we can unload the image.
		response.setHeader("Access-Control-Allow-Origin","*");
		Pnr pnr = new Pnr(pnrNo, 12345, (LocalDate.of(2020, 12, 25)));
		List<Passengers> passengers = new ArrayList<Passengers>();
		passengers.add(new Passengers("rohit", Gender.MALE, Status.RAC));
		passengers.add(new Passengers("john", Gender.MALE, Status.RAC));
		passengers.add(new Passengers("jack", Gender.MALE, Status.CONFIRMED));
		pnr.setPassengers(passengers);
		return pnr;
	}

}
