package agendamento.controller;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import agendamento.model.User;
import agendamento.service.UserService;

@Path("/users")
@LocalBean
public class UserController {

	UserService userService = new UserService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUsers() {
		List<User> listOfCountries = userService.getAllUsers();
		return listOfCountries;
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

}
