package src.main.java.controller;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import domain.Comment;
import domain.News;

@Stateless
public class NewsManager {
	
	@PersistenceContext
	EntityManager em;
	
	public void addNews(News news) {
		em.persist(news);
	}
	
	@SuppressWarnings("unchecked")
	public List<News> getAll(){
		return em.createNamedQuery("news.getAll").getResultList();
	}
	
//	public News getLatest() {
//		
//	}
	
	public void addCom(Comment c, long id) {
		News n = em.find(News.class, id);
		n.getComments().add(c);
	}

}
