package persistence;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity implementation class for Entity: SponsorDetails
 *
 */
@Entity
@XmlRootElement
public class SponsorDetails implements Serializable {

	@EmbeddedId
	private SponsorDetailsId SponsorDetailsId;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "UserSponsorId", referencedColumnName = "id", insertable = false, updatable = false)
	private User UserSponsor;
	private String produit;
	private int quantity;
	private String sponsor_price;
	private String notes;
	private String validate;
	private String notify;
	@ManyToOne
	@JoinColumn(name = "eventsId", referencedColumnName = "id", insertable = false, updatable = false)
	private Events events;
	private static final long serialVersionUID = 1L;

	public SponsorDetails() {
		super();
	}

	public SponsorDetails(User user, Events events) {
		super();
		this.SponsorDetailsId = new SponsorDetailsId(user.getId(), events.getId());
		this.UserSponsor = user;
		this.events = events;
	}

	public SponsorDetails(User user, Events events, String notes, String produit, String sponsor_price, int quantity,
			String validate,String notify) {
		super();
		this.SponsorDetailsId = new SponsorDetailsId(user.getId(), events.getId());
		this.UserSponsor = user;
		this.events = events;
		this.notes = notes;
		this.produit = produit;
		this.sponsor_price = sponsor_price;
		this.quantity = quantity;
		this.validate = validate;
		this.notify=notify;

	}

	public SponsorDetailsId getEventsDetailsId() {
		return SponsorDetailsId;
	}

	public void setEventsDetailsId(SponsorDetailsId sponsorDetailsId) {
		SponsorDetailsId = sponsorDetailsId;
	}

	public Events getEvents() {
		return events;
	}

	public void setEvents(Events events) {
		this.events = events;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public SponsorDetailsId getSponsorDetailsId() {
		return SponsorDetailsId;
	}

	public void setSponsorDetailsId(SponsorDetailsId sponsorDetailsId) {
		SponsorDetailsId = sponsorDetailsId;
	}

	public User getUserSponsor() {
		return UserSponsor;
	}

	public void setUserSponsor(User userSponsor) {
		UserSponsor = userSponsor;
	}

	public String getProduit() {
		return produit;
	}

	public void setProduit(String produit) {
		this.produit = produit;
	}

	public String getSponsor_price() {
		return sponsor_price;
	}

	public void setSponsor_price(String sponsor_price) {
		this.sponsor_price = sponsor_price;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getValidate() {
		return validate;
	}

	public void setValidate(String validate) {
		this.validate = validate;
	}

	public String getNotify() {
		return notify;
	}

	public void setNotify(String notify) {
		this.notify = notify;
	}

}
