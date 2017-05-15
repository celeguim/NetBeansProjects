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

import agendamento.model.Court;
import agendamento.service.CourtService;

@Path("/courts")
@LocalBean
public class CourtController {

	CourtService courtService = new CourtService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Court> getCourts() {
		return (courtService.getAllCourts());
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Court getCourtById(@PathParam("id") int id) {
		return courtService.getCourtById(id);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public void addCourt(Court court) {
		courtService.addCourt(court);
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Court updateCourt(Court court) {
		return (courtService.updateCourt(court));
	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Court deleteCourt(@PathParam("id") int id) {
		return (courtService.deleteCourt(id));
	}

}
