package services;

import java.util.List;

import javax.ejb.Local;
import javax.jws.WebParam;

import persistence.Admin;
import persistence.CommentDetails;
import persistence.Events;
import persistence.Refugee;
import persistence.SponsorDetails;
import persistence.User;

@Local
public interface UserManagementLocal {
	void addUser(User user);

	void updateUser(User user);

	void deleteUserById(int id);

	void deleteUser(User user);

	User findUserById(int id);

	List<User> findAllUsers();

	void addCom(User user, Events events, String commentaire);

	void addEvents(Events Events);

	List<Events> findEventsByStat(String state);

	List<SponsorDetails> findValideSponsorEvents(int id, String valide);

	// List login(String username,String password);
	List<User> findByType(Class type);

	void saveSponsoringDetails(User user, Events events, String notes, String produit, String sponsor_price,
			int quantity, String validate, String notify);

	List<CommentDetails> findAllComEvents(int id);

	User findUser(String username);

	List<Events> findAllEvents();

	List<Events> findEventsByUser(int id);

	List login(String username, String password);

	List<SponsorDetails> findAllEventsDetails();

	List<Refugee> findAllRefugee();

	void saveEventsDetails(User user, Events events);

	void addUser1(Admin user);

	List<SponsorDetails> findAllSponsorEvents(int id);

	int numberOfSponsoring(int id);

	List<SponsorDetails> findEtatEvent(String etat);

	void register(String username, String firstname, String lastname, String email, String password, String country,
			String usertype, String sexe, String produit, String mark, String domain);

	User login1(@WebParam(name = "username") String username, @WebParam(name = "password") String password);

	List<Events> findEtatSposoring(String state);

	void updateSponsorDetail(SponsorDetails SponsorDetails);

	void updateEvent(Events Events);
}
