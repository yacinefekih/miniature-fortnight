package persistence;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity implementation class for Entity: CommentDetails
 *
 */
@Entity
@XmlRootElement
public class CommentDetails implements Serializable {

	@EmbeddedId
	private CommentDetailsId CommentDetailsId;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "UserRefugeeId", referencedColumnName = "id", insertable = false, updatable = false)
	private User UserRefugee;

	private String commentaire;
	@ManyToOne
	@JoinColumn(name = "eventsId", referencedColumnName = "id", insertable = false, updatable = false)
	private Events events;
	private static final long serialVersionUID = 1L;

	public CommentDetails() {
		super();
	}

	public CommentDetails(User user, Events events) {
		super();
		this.CommentDetailsId = new CommentDetailsId(user.getId(), events.getId());
		this.UserRefugee = user;
		this.events = events;
	}

	public CommentDetails(User user, Events events, String commentaire) {
		super();
		this.CommentDetailsId = new CommentDetailsId(user.getId(), events.getId());
		this.UserRefugee = user;
		this.events = events;
		this.commentaire = commentaire;

	}

	public Events getEvents() {
		return events;
	}

	public void setEvents(Events events) {
		this.events = events;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public User getUserRefugee() {
		return UserRefugee;
	}

	public void setUserRefugee(User userRefugee) {
		UserRefugee = userRefugee;
	}

	public CommentDetailsId getCommentDetailsId() {
		return CommentDetailsId;
	}

	public void setCommentDetailsId(CommentDetailsId commentDetailsId) {
		CommentDetailsId = commentDetailsId;
	}

}
