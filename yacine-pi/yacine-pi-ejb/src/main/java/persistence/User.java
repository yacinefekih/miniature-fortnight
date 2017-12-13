package persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@XmlRootElement

@DiscriminatorColumn(name = "type")
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String username;

	private String firstname;

	private String lastname;

	private String email;

	private String password;

	private String country;

	private String sexe;
	private static final long serialVersionUID = 1L;
	@Column(name = "type", insertable = false, updatable = false)
	private String type;

	public List<Events> getEventslist() {
		return Eventslist;
	}

	public void setEventslist(List<Events> eventslist) {
		Eventslist = eventslist;
	}

	@OneToMany(mappedBy = "userAssos", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	private List<Events> Eventslist;

	public User(String username) {
		super();
		this.username = username;
	}

	public User() {
		super();
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public User(String firstname, String lastname, String email, String country) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;

		this.country = country;
	}

	public User(String username, String firstname, String lastname, String email, String password, String country) {
		super();
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;

		this.password = password;
		this.country = country;
	}

	public User(String username, String firstname, String lastname, String email, String password, String country,
			String sexe) {
		super();
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.country = country;
		this.sexe = sexe;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
