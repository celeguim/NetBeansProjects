package agendamento.tests;

import agendamento.model.User;
import agendamento.service.UserService;

public class UserTest {

	public static void main(String[] args) {
		User user = new User();

		user.setUsername("midori");
		user.setPassword("password");
		UserService userService = new UserService();
		userService.addUser(user);
	}

}
