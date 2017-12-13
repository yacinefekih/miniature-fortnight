package persistence;

import java.io.Serializable;
import java.lang.String;

import javax.persistence.*;

import persistence.User;

/**
 * Entity implementation class for Entity: UserWoker
 *
 */

@Entity

public class UserWoker extends User implements Serializable {

	private String job;

	private String cin;

	private static final long serialVersionUID = 1L;

	public UserWoker() {
		super();
	}

	public UserWoker(String username, String firstname, String lastname, String email,

			String password, String country, String sexe, String job, String cin) {
		super(username, firstname, lastname, email, password, country, sexe);
		this.job = job;
		;
		this.cin = cin;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

}
