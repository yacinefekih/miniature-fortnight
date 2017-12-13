package bean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import persistence.User;
import persistence.UserAssos;
import persistence.UserRefugee;
import persistence.UserSponsor;
import services.UserManagementLocal;

@ManagedBean
@SessionScoped
public class Identity {
	public static User user = new User();
	private boolean loggedIn = false;

	@EJB
	private UserManagementLocal UsermanagementLocal;

	public String doLogin() {
		String navigateTo = "";
		User userLoggedIn = UsermanagementLocal.login1(user.getUsername(), user.getPassword());
		if (userLoggedIn != null) {
			user = userLoggedIn;
			loggedIn = true;
			if (userLoggedIn instanceof UserAssos) {
				navigateTo = "/pages/assosiation/home?faces-redirect=true";
			} else if (userLoggedIn instanceof UserSponsor) {
				navigateTo = "/allEvent?faces-redirect=true";
			}else if (userLoggedIn instanceof UserRefugee) {
				navigateTo = "/refugeeSpace?faces-redirect=true";}
		} else {
			navigateTo = "/login?faces-redirect=true";
		}

		return navigateTo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

}
