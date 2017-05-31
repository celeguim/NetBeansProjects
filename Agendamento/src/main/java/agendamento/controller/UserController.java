package agendamento.controller;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import agendamento.model.User;
import agendamento.service.UserService;

@Path("/users")
@LocalBean
@Provider
public class UserController implements ContainerResponseFilter {
	//
	UserService userService = new UserService();

	@GET
	@Path("{id}")
	public Response getId() {
		return Response.ok() // 200
				.entity(1, new Annotation[0]).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUsers() {
		return (userService.getAllUsers());
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUserById(@PathParam("id") int id) {
		return userService.getUserById(id);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public void addUser(User user) {
		userService.addUser(user);
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public User updateUser(User user) {
		return (userService.updateUser(user));
	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public User deleteUser(@PathParam("id") int id) {
		return (userService.deleteUser(id));
	}

	@Override
	public void filter(ContainerRequestContext request, ContainerResponseContext response) throws IOException {
		response.getHeaders().add("Access-Control-Allow-Origin", "*");
		response.getHeaders().add("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
		response.getHeaders().add("Access-Control-Allow-Credentials", "true");
		response.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
	}

}
