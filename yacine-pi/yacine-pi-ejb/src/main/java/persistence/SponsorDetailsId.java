package persistence;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable

@SuppressWarnings("serial")
public class SponsorDetailsId implements Serializable {
	private int UserSponsorId;
	private int eventsId;

	public SponsorDetailsId(int UserSponsorId, int eventsId) {
		super();
		this.setUserSponsorId(UserSponsorId);
		this.eventsId = eventsId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + UserSponsorId;
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
		SponsorDetailsId other = (SponsorDetailsId) obj;
		if (UserSponsorId != other.UserSponsorId)
			return false;
		if (eventsId != other.eventsId)
			return false;
		return true;
	}

	public SponsorDetailsId() {
	}

	public int getEventsId() {
		return eventsId;
	}

	public void setEventsId(int eventsId) {
		this.eventsId = eventsId;
	}

	public int getUserSponsorId() {
		return UserSponsorId;
	}

	public void setUserSponsorId(int userSponsorId) {
		UserSponsorId = userSponsorId;
	}

}
