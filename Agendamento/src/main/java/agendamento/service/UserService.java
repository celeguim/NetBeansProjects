package agendamento.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import agendamento.model.User;

public class UserService {

	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		List<User> userList = new ArrayList<>();
		EntityManager em;
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("AgendamentoPU");
			em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			et.begin();
			Query query = em.createQuery("from User t");
			userList = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		return userList;
	}

	public User getUserById(int id) {
		User user = new User();
		EntityManager em = null;
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("AgendamentoPU");
			em = emf.createEntityManager();
			user = em.find(User.class, id);
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

	public User addUser(User user) {
		EntityManager em = null;
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("AgendamentoPU");
			em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.persist(user);
			em.flush();
			user = em.getReference(User.class, user.getId());
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

	public User updateUser(User user) {
		EntityManager em = null;
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("AgendamentoPU");
			em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			et.begin();
			User ref = em.getReference(User.class, user.getId());

			ref.setStatus(user.getStatus());
			ref.setEmail(user.getEmail());
			ref.setPassword(user.getPassword());
			ref.setTelephone(user.getTelephone());
			ref.setType(user.getType());

			user = ref;
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

	public User deleteUser(int id) {
		EntityManager em = null;
		User user = new User();
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("AgendamentoPU");
			em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			et.begin();
			user = em.getReference(User.class, id);
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
