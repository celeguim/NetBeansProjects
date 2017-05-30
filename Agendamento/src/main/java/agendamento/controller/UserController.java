package agendamento.controller;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Priorities;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;

import com.sun.jersey.core.util.Priority;
import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;

import agendamento.model.User;
import agendamento.service.UserService;

@Path("/users")
@LocalBean
@Provider
@Priority(Priorities.HEADER_DECORATOR)
public class UserController implements ContainerResponseFilter {

	UserService userService = new UserService();

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
	public ContainerResponse filter(ContainerRequest request, ContainerResponse response) {
		final MultivaluedMap<String, Object> headers = response.getHttpHeaders();

		headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Headers", "Authorization, Origin, X-Requested-With, Content-Type");
		headers.add("Access-Control-Expose-Headers", "Location, Content-Disposition");
		headers.add("Access-Control-Allow-Methods", "POST, PUT, GET, DELETE, HEAD, OPTIONS");

		return response;
	}

}
