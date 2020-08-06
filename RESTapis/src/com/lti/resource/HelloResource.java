package com.lti.resource;


import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.PathParam;
@Path("/hello")
public class HelloResource {
	/*@GET
	public String hello() {
		return "Hello from JAX-RS";
	}*/
	
	/*@GET
	public String hello(@QueryParam("name") String name) {
		return "hello " + name + " Welcome to jax";
				} */
	
	/*@Path("/{name}")
	@GET
	public String hello(@PathParam("name") String name) {
		return "hello "+ name + ". Welcome boi..";
	}*/
	
	@GET
	public String hello(@MatrixParam("name") String name) {
		return "hello " + name +". weclome how do you do";
	} ///http://localhost:8080/RESTapis/api/hello;name=rohit
	

}
