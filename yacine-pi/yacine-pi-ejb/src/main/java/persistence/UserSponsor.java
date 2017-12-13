package persistence;

import java.io.Serializable;
import java.lang.String;

import javax.persistence.*;

import persistence.User;

/**
 * Entity implementation class for Entity: UserSponsor
 *
 */

@Entity

public class UserSponsor extends User implements Serializable {

	private String domain;

	private String produit;

	private String mark;
	
	
	private static final long serialVersionUID = 1L;

	public UserSponsor() {
		super();
	}

	public UserSponsor(String username, String firstname, String lastname, String email, String password,
			String country, String sexe, String domain, String produit, String mark) {
		super(username, firstname, lastname, email, password, country, sexe);
		this.domain=domain;
		this.produit=produit;
		this.mark=mark;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getProduit() {
		return produit;
	}

	public void setProduit(String produit) {
		this.produit = produit;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

}
