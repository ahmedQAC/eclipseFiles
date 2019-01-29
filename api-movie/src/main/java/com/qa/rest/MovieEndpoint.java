package com.qa.rest;

import javax.inject.Inject;


import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.service.MovieService;

@Path("/movie")
public class MovieEndpoint {

	@Inject
	private MovieService service;

	@Path("/getAllMovies")
	@GET
	@Produces({ "application/json" })
	public String getAllMovies() {
		return service.getAllMovies();
	}

	@Path("/createMovie")
	@POST
	@Produces({ "application/json" })
	public String addMovie(String movie) {
		return service.addMovie(movie);
	}

	@Path("/deleteMovie/{id}") //curly braces respresents dynamic parameter as part of the path
	@DELETE
	@Produces({ "application/json" })
	public String deleteMovie(@PathParam("id") Long id) {
		return service.deleteMovie(id);
	}

	public void setService(MovieService service) {
		this.service = service;
	}
}