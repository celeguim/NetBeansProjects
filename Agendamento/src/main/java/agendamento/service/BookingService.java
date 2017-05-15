package agendamento.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import agendamento.model.Booking;

public class BookingService {

	@SuppressWarnings("unchecked")
	public List<Booking> getAllBookings() {
		List<Booking> userList = new ArrayList<>();
		EntityManager em;
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("AgendamentoPU");
			em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			et.begin();
			Query query = em.createQuery("from Booking t");
			userList = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		return userList;
	}

	public Booking getBookingById(int id) {
		Booking user = new Booking();
		EntityManager em = null;
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("AgendamentoPU");
			em = emf.createEntityManager();
			user = em.find(Booking.class, id);
			user.setOK();
		} catch (Exception e) {
			user.setError(e.toString());
			e.printStackTrace(System.out);
		} finally {
			if (em != null) {
				em.clear();
			}
		}
		return user;
	}

	public Booking addBooking(Booking user) {
		EntityManager em = null;
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("AgendamentoPU");
			em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.persist(user);
			em.flush();
			user = em.getReference(Booking.class, user.getId());
			et.commit();
			user.setOK();
		} catch (Exception e) {
			user.setError(e.toString());
			e.printStackTrace(System.out);
		} finally {
			if (em != null) {
				em.clear();
			}
		}
		return (user);
	}

	public Booking updateBooking(Booking booking) {
		EntityManager em = null;
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("AgendamentoPU");
			em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			et.begin();
			Booking ref = em.getReference(Booking.class, booking.getId());
			ref.setCourtName(booking.getCourtName());
			ref.setDateFrom(booking.getDateFrom());
			ref.setDateTo(booking.getDateTo());
			ref.setDtResDay(booking.getDtResDay());
			ref.setDtResFrom(booking.getDtResFrom());
			ref.setDtResTo(booking.getDtResTo());
			ref.setId(booking.getId());
			ref.setName(booking.getName());
			ref.setPlayerName(booking.getPlayerName());
			ref.setTblCourt(booking.getTblCourt());
			ref.setTblPlayer(booking.getTblPlayer());
			em.flush();
			booking = ref;
			et.commit();
			booking.setOK();
		} catch (Exception e) {
			booking.setError(e.toString());
			e.printStackTrace(System.out);
		} finally {
			if (em != null) {
				em.clear();
			}
		}
		return (booking);
	}

	public Booking deleteBooking(int id) {
		EntityManager em = null;
		Booking user = new Booking();
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("AgendamentoPU");
			em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			et.begin();
			user = em.getReference(Booking.class, id);
			em.remove(user);
			et.commit();
			user.setOK();
		} catch (Exception e) {
			user.setError(e.toString());
			e.printStackTrace(System.out);
		} finally {
			if (em != null) {
				em.clear();
			}
		}
		return (user);
	}

}
