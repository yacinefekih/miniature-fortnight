package persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable

@SuppressWarnings("serial")
public class CommentDetailsId implements Serializable {
	private int UserRefugeeId;
	private int eventsId;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date = new Date();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + UserRefugeeId;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + eventsId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommentDetailsId other = (CommentDetailsId) obj;
		if (UserRefugeeId != other.UserRefugeeId)
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (eventsId != other.eventsId)
			return false;
		return true;
	}

	public CommentDetailsId(int UserRefugeeId, int eventsId) {
		super();
		this.setUserRefugeeId(UserRefugeeId);
		this.eventsId = eventsId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public CommentDetailsId() {
	}

	public int getEventsId() {
		return eventsId;
	}

	public void setEventsId(int eventsId) {
		this.eventsId = eventsId;
	}

	public int getUserRefugeeId() {
		return UserRefugeeId;
	}

	public void setUserRefugeeId(int userRefugeeId) {
		UserRefugeeId = userRefugeeId;
	}

}
