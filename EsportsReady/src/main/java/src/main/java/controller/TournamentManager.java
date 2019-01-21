package src.main.java.controller;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import domain.Tournament;
import domain.User;
@Stateless
public class TournamentManager {

	@PersistenceContext
	EntityManager em;
	
	public void addTournament(Tournament t) {
		
		em.persist(t);
	}
	
	 @SuppressWarnings("unchecked")
	public List<Tournament> getAll(){
		 return em.createNamedQuery("tournament.getAll").getResultList();
	 }
	
	 public void addUser(long id, String user) {
		 Tournament t = em.find(Tournament.class, id);
		 User u = (User) em.createNamedQuery("getAllu").setParameter("email", user).getSingleResult();
		 em.find(Tournament.class, t.getId());
		 t.getuserList().add(u);
	 }
	
}
