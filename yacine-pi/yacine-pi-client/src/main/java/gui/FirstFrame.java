package gui;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import persistence.UserAssos;
import persistence.UserRefugee;
import persistence.UserSponsor;
import services.UserManagementRemote;

public class FirstFrame {

	public static void main(String[] args) throws NamingException {
		// TODO Auto-generated method stub
		Context context = new InitialContext();
		UserManagementRemote UserManagementRemote = (UserManagementRemote) context
				.lookup("yacine-pi-ear/yacine-pi-ejb/UserManagement!services.UserManagementRemote");

		UserAssos assos1 = new UserAssos("assos1", "assos1", "assos1", "assos1", "assos1", "assos1", "assos1");
		UserAssos assos2 = new UserAssos("assos2", "assos2", "assos2", "assos2", "assos2", "assos2", "assos2");
		UserAssos assos3 = new UserAssos("assos3", "assos3", "assos3", "assos3", "assos3", "assos3", "assos3");
		UserRefugee yacine = new UserRefugee("yacine", "yacine", "yacine", "yacine", "yacine", "yacine", "yacine");
		UserRefugee kouti = new UserRefugee("kouti", "kouti", "kouti", "kouti", "kouti", "kouti", "kouti");
		UserSponsor sponsor1 = new UserSponsor("delice", "delice", "delice", "delice", "delice", "delice", "delice",
				"delice", "delice", "delice");

		UserSponsor sponsor2 = new UserSponsor("sponsor2", "sponsor2", "sponsor2", "sponsor2", "sponsor2", "sponsor2",
				"sponsor2", "sponsor2", "sponsor2", "sponsor2");

		UserManagementRemote.addUser(assos1);
		UserManagementRemote.addUser(assos2);
		UserManagementRemote.addUser(assos3);
		UserManagementRemote.addUser(sponsor1);
		UserManagementRemote.addUser(sponsor2);
		UserManagementRemote.addUser(yacine);
		UserManagementRemote.addUser(kouti);
	}

}
