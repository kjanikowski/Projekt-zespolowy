package domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity
@NamedQueries({
	@NamedQuery(name = "getAll", query = "SELECT u FROM User u WHERE u.email  = :email" ),
	@NamedQuery(name = "getRole", query = "SELECT u FROM User u WHERE u.email  = :email" )
})
public class User {

	long id;
	String email;
	String pwdHash;
	Role role;
	public User(String email, String pwdHash) {
		super();
		this.email = email;
		this.pwdHash = pwdHash;
		if(email.equals("admin"))
		this.role = new Role("Admin");
		else
			this.role = new Role("user");
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Column(unique=true)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwdHash() {
		return pwdHash;
	}
	public void setPwdHash(String pwdHash) {
		this.pwdHash = pwdHash;
	}
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return email + pwdHash;
	}
	
	
	
}
