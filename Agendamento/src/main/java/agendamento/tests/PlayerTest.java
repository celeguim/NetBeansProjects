package agendamento.tests;

import agendamento.model.Player;
import agendamento.service.PlayerService;

public class PlayerTest {

	public static void main(String[] args) {
		Player player = new Player();
		player.setEmail("luiz.celeguim@gmail.com");
		player.setName("Luiz Celeguim");
		player.setPassword("password");
		player.setTelephone("799 898 996");
		PlayerService service = new PlayerService();
		service.addPlayer(player);
	}

}
