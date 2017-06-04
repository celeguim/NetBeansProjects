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
//
	@SuppressWarnings("unchecked")
	public List<Player> getAllPlayers() {
		List<Player> playerList = new ArrayList<>();
		EntityManager em;
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("AgendamentoPU");
			em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			et.begin();
			Query query = em.createQuery("from Player t");
			playerList = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		return playerList;
	}

	public Player getPlayerById(int id) {
		Player player = new Player();
		EntityManager em = null;
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("AgendamentoPU");
			em = emf.createEntityManager();
			player = em.find(Player.class, id);
			player.setOK();
		} catch (Exception e) {
			player.setError(e.toString());
			e.printStackTrace(System.out);
		} finally {
			if (em != null) {
				em.clear();
			}
		}
		return player;
	}

	public Player addPlayer(Player player) {
		EntityManager em = null;
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("AgendamentoPU");
			em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.persist(player);
			em.flush();
			player = em.getReference(Player.class, player.getId());
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
			et.commit();
			em.flush();
			player = ref;
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
		Player player = new Player();
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("AgendamentoPU");
			em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			et.begin();
			player = em.getReference(Player.class, id);
			em.remove(player);
			et.commit();
			em.flush();
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

}
