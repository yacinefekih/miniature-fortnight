package persistence;

import java.io.Serializable;

import javax.persistence.Entity;

/**
 * Entity implementation class for Entity: UserAssos
 *
 */

@Entity

public class UserAssos extends User implements Serializable {

	private static final long serialVersionUID = 1L;

	public UserAssos() {
		super();
	}

	public UserAssos(String username, String firstname, String lastname, String email,

			String password, String country, String sexe) {
		super(username, firstname, lastname, email, password, country, sexe);

	}

}
