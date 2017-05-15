package agendamento.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import agendamento.model.Player;

public class PlayerService {

	@SuppressWarnings("unchecked")
	public List<Player> getAllPlayers() {
		List<Player> userList = new ArrayList<>();
		EntityManager em;
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("AgendamentoPU");
			em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			et.begin();
			Query query = em.createQuery("from Player t");
			userList = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		return userList;
	}

	public Player getPlayerById(int id) {
		Player user = new Player();
		EntityManager em = null;
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("AgendamentoPU");
			em = emf.createEntityManager();
			user = em.find(Player.class, id);
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

	public Player addPlayer(Player user) {
		EntityManager em = null;
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("AgendamentoPU");
			em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.persist(user);
			user = em.getReference(Player.class, user.getId());
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

	public Player updatePlayer(Player player) {
		EntityManager em = null;
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("AgendamentoPU");
			em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			et.begin();
			Player ref = em.getReference(Player.class, player.getId());
			ref.setEmail(player.getEmail());
			ref.setId(player.getId());
			ref.setName(player.getName());
			ref.setPassword(player.getPassword());
			ref.setTelephone(player.getTelephone());
			player = ref;
			et.commit();
			player.setOK();
		} catch (Exception e) {
			player.setError(e.toString());
			e.printStackTrace(System.out);
		} finally {
			if (em != null) {
				em.clear();
			}
		}
		return (player);
	}

	public Player deletePlayer(int id) {
		EntityManager em = null;
		Player user = new Player();
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("AgendamentoPU");
			em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			et.begin();
			user = em.getReference(Player.class, id);
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
