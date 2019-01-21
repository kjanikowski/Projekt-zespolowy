package domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
@Entity
@NamedQueries({
	@NamedQuery(name = "tournament.getAll", query = "SELECT t FROM Tournament t"),
	@NamedQuery(name = "getAllu", query = "SELECT u FROM User u WHERE u.email  = :email" )
})
public class Tournament {
	
	long id;
	List<User> userList;
	String game;
	public Tournament( String game) {
		super();
		this.game = game;
	}
	public Tournament() {
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
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public List<User> getuserList() {
		return userList;
	}
	public void setuserList(List<User> userList) {
		this.userList = userList;
	}
	public String getGame() {
		return game;
	}
	public void setGame(String game) {
		this.game = game;
	}
	
	
	

}
