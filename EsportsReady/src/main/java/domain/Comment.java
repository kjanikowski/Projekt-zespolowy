package domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Comment {
	
	long id;
//	News news;
	String content;
	String author;
	public Comment( String content, String author) {
		super();
		this.content = content;
		this.author = author;
	}
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
//	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
//	@ManyToOne
//	public News getNews() {
//		return news;
//	}
//	public void setNews(News news) {
//		this.news = news;
//	}

}
