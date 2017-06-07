package agendamento.tests;

import java.util.List;

import agendamento.model.User;
import agendamento.service.UserService;

public class UserTest {
	//
	public static void main(String[] args) {

		User user = new User();
		user.setUsername("midori");
		user.setPassword("password");
		UserService userService = new UserService();
		userService.addUser(user);

		List<User> users = userService.getAllUsers();
		for (User user1 : users) {
			System.out.print(user1.getUsername() + ":" + user1.getEmail());
		}
	}

}
