package persistence;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity implementation class for Entity: Events
 *
 */
@Entity
@XmlRootElement

public class Events implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;
	private String title;
	private String description;
	private String category;
	private Date datedebut;
	private Date datefin;
	private String state;

	@ManyToOne
	private User userAssos;

	@OneToMany(mappedBy = "events")
	private List<SponsorDetails> sponsorDetails;
	private static final long serialVersionUID = 1L;

	public Events() {
		super();
	}

	public Events(String title, String description, String category, Date datedebut, Date datefin, User user,
			String state) {
		super();
		this.title = title;
		this.description = description;
		this.category = category;
		this.datedebut = datedebut;
		this.datefin = datefin;
		this.userAssos = user;
		this.state = state;
	}

	public String getTitle() {
		return title;
	}

	public List<SponsorDetails> getSponsorDetails() {
		return sponsorDetails;
	}

	public void setSponsorDetails(List<SponsorDetails> sponsorDetails) {
		this.sponsorDetails = sponsorDetails;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Date getDatedebut() {
		return datedebut;
	}

	public void setDatedebut(Date datedebut) {
		this.datedebut = datedebut;
	}

	public Date getDatefin() {
		return datefin;
	}

	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUserAssos() {
		return userAssos;
	}

	public void setUserAssos(User userAssos) {
		this.userAssos = userAssos;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
