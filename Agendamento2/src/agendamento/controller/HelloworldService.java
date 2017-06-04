package agendamento.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/hello")
public class HelloworldService {

	@GET
	public String sayHello() {
		return "Hello World";
	}
}