package agendamento.tests;

import agendamento.model.User;
import agendamento.model.UserPK;
import agendamento.service.UserService;

public class UserTest {

	public static void main(String[] args) {
		User user = new User();
		user.setId(new UserPK());
		user.getId().setUsername("midori");
		user.setPassword("password");
		UserService userService = new UserService();
		userService.addUser(user);
	}

}
