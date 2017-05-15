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

import agendamento.model.Booking;
import agendamento.service.BookingService;

@Path("/bookings")
@LocalBean
public class BookingController {

	BookingService bookingService = new BookingService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Booking> getBookings() {
		return (bookingService.getAllBookings());
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Booking getBookingById(@PathParam("id") int id) {
		return bookingService.getBookingById(id);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public void addBooking(Booking booking) {
		bookingService.addBooking(booking);
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Booking updateBooking(Booking booking) {
		return (bookingService.updateBooking(booking));
	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Booking deleteBooking(@PathParam("id") int id) {
		return (bookingService.deleteBooking(id));
	}

}
