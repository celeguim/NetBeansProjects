package agendamento.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import agendamento.model.Court;

public class CourtService {

	@SuppressWarnings("unchecked")
	public List<Court> getAllCourts() {
		List<Court> courtList = new ArrayList<>();
		EntityManager em;
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("AgendamentoPU");
			em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			et.begin();
			Query query = em.createQuery("from Court t");
			courtList = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		return courtList;
	}

	public Court getCourtById(int id) {
		Court court = new Court();
		EntityManager em = null;
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("AgendamentoPU");
			em = emf.createEntityManager();
			court = em.find(Court.class, id);
			court.setOK();
		} catch (Exception e) {
			court.setError(e.toString());
			e.printStackTrace(System.out);
		} finally {
			if (em != null) {
				em.clear();
			}
		}
		return court;
	}

	public Court addCourt(Court court) {
		EntityManager em = null;
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("AgendamentoPU");
			em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.persist(court);
			court = em.getReference(Court.class, court.getId());
			et.commit();
			court.setOK();
		} catch (Exception e) {
			court.setError(e.toString());
			e.printStackTrace(System.out);
		} finally {
			if (em != null) {
				em.clear();
			}
		}
		return (court);
	}

	public Court updateCourt(Court court) {
		EntityManager em = null;
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("AgendamentoPU");
			em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			et.begin();
			Court ref = em.getReference(Court.class, court.getId());
			ref.setAvailable(court.getAvailable());
			ref.setId(court.getId());
			ref.setName(court.getName());
			court = ref;
			et.commit();
			court.setOK();
		} catch (Exception e) {
			court.setError(e.toString());
			e.printStackTrace(System.out);
		} finally {
			if (em != null) {
				em.clear();
			}
		}
		return (court);
	}

	public Court deleteCourt(int id) {
		EntityManager em = null;
		Court court = new Court();
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("AgendamentoPU");
			em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			et.begin();
			court = em.getReference(Court.class, id);
			em.remove(court);
			et.commit();
			court.setOK();
		} catch (Exception e) {
			court.setError(e.toString());
			e.printStackTrace(System.out);
		} finally {
			if (em != null) {
				em.clear();
			}
		}
		return (court);
	}

}
