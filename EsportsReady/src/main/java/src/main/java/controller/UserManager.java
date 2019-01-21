package src.main.java.controller;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;

import domain.User;

@Stateless
public class UserManager {
	
	@PersistenceContext
	EntityManager em;
	
	//register
	public void addUser(User user) {
		em.persist(user);
	}
	
	public boolean login(String email, String pwd) {
		User u = (User) em.createNamedQuery("getAll").setParameter("email", email).getSingleResult();
		if(u.getPwdHash().equals(pwd)) {
			return true;
		}
		return false;
	}
	
	public String getRole(String email) {
		User u = (User) em.createNamedQuery("getRole").setParameter("email", email).getSingleResult();
		return u.getRole().getRoleName();
	}
	
	
	public User getUser(int id) {
		User user = em.find(User.class, id);
		return user;
	}
	
	
	
	

}
