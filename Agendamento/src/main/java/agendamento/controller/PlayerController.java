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

import agendamento.model.Player;
import agendamento.service.PlayerService;

@Path("/players")
@LocalBean
public class PlayerController {
//
	PlayerService playerService = new PlayerService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Player> getPlayers() {
		return (playerService.getAllPlayers());
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Player getPlayerById(@PathParam("id") int id) {
		return playerService.getPlayerById(id);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Player addPlayer(Player player) {
		return(playerService.addPlayer(player));
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Player updatePlayer(Player player) {
		return (playerService.updatePlayer(player));
	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Player deletePlayer(@PathParam("id") int id) {
		return (playerService.deletePlayer(id));
	}

}
