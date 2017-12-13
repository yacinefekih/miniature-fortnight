package persistence;

import java.io.Serializable;
import java.lang.String;

import javax.persistence.*;

import persistence.User;

/**
 * Entity implementation class for Entity: UserRefugee
 *
 */
@Entity

public class UserRefugee extends User implements Serializable {

	private static final long serialVersionUID = 1L;

	public UserRefugee() {
		super();
	}

	public UserRefugee(String username, String firstname, String lastname, String email,

			String password, String country, String sexe) {
		super(username, firstname, lastname, email, password, country, sexe);

	}

}
