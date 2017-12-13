package services;

import java.util.List;

import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import persistence.Admin;
import persistence.CommentDetails;
import persistence.Events;
import persistence.Refugee;
import persistence.SponsorDetails;
import persistence.User;

/**
 * Session Bean implementation class UserManagement
 */
@Stateless
@WebService(name = "UserServicePortType", portName = "UserService", serviceName = "UserService", targetNamespace = "http://UserServicePi.tn", endpointInterface = "services.UserManagementRemote"

)
public class UserManagement implements UserManagementRemote, UserManagementLocal {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public UserManagement() {
	}

	@Override
	public void addUser(User user) {
		entityManager.persist(user);

	}

	@Override
	public void addEvents(Events Events) {
		entityManager.persist(Events);

	}

	@Override
	public void updateUser(User user) {
		entityManager.merge(user);
	}

	@Override
	public void deleteUserById(int id) {
		entityManager.remove(findUserById(id));
	}

	@Override
	public void deleteUser(User user) {
		entityManager.remove(user);
	}

	@Override
	public User findUserById(int id) {
		return entityManager.find(User.class, id);
	}

	@Override
	public List<User> findAllUsers() {
		String jpql = "SELECT u FROM User u";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public List<Events> findAllEvents() {
		String jpql = "SELECT e FROM Events e";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public List<User> findByType(Class type) {
		String jpql = "SELECT pe FROM User pe WHERE TYPE(pe)=:t";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("t", type);

		return query.getResultList();
	}

	@Override
	public User findUser(String username) {
		String jpql = "SELECT pe FROM User pe WHERE pe.username=:t";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("t", username);

		return (User) query.getSingleResult();
	}

	@Override
	public List login(String username, String password) {
		Query query = entityManager.createQuery("select e from User e where e.username=:l and e.password=:p");
		query.setParameter("l", username).setParameter("p", password);
		return query.getResultList();
	}

	@Override
	public List<Refugee> findAllRefugee() {
		String jpql = "SELECT u FROM Refugee u";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public void addUser1(Admin user) {
		entityManager.persist(user);

	}

	@Override
	public User login1(String username, String password) {
		Query query = entityManager.createQuery("select e from User e where e.username=:l and e.password=:p");
		query.setParameter("l", username).setParameter("p", password);
		return (User) query.getSingleResult();
	}

	@Override
	public void register(String username, String firstname, String lastname, String email, String password,
			String country, String usertype, String sexe, String produit, String mark, String domain) {

		if (usertype.equals("User")) {
			User u = new User(username, firstname, lastname, email, password, country, sexe);
			addUser(u);
		} else if (usertype.equals("Refugee")) {
			Refugee u = new Refugee(firstname, lastname, username, email, password, country, sexe);
			addUser(u);
		}

	}

	@Override
	public List<Events> findEventsByUser(int id) {
		String jpql = "SELECT z FROM Events z WHERE z.userAssos.id=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", id);

		return query.getResultList();
	}

	@Override
	public List<Events> findEventsByStat(String state) {
		String jpql = "SELECT z FROM Events z WHERE z.state=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", state);

		return query.getResultList();
	}

	@Override
	public void saveEventsDetails(User user, Events events) {
		SponsorDetails i = new SponsorDetails(entityManager.merge(user), events);
		entityManager.persist(i);
	}

	@Override
	public void addCom(User user, Events events, String commentaire) {
		CommentDetails i = new CommentDetails(entityManager.merge(user), events, commentaire);
		entityManager.persist(i);
	}

	@Override
	public void saveSponsoringDetails(User user, Events events, String notes, String produit, String sponsor_price,
			int quantity, String validate,String notify) {
		SponsorDetails i = new SponsorDetails(entityManager.merge(user), events, notes, produit, sponsor_price,
				quantity, validate,notify);
		entityManager.persist(i);
	}

	@Override
	public List<CommentDetails> findAllComEvents(int id) {
		String jpql = "SELECT z FROM CommentDetails z WHERE z.events.id=:param ";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", id);
		return query.getResultList();
	}

	@Override
	public List<SponsorDetails> findAllEventsDetails() {
		String jpql = "SELECT m FROM EventsDetails m";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public List<SponsorDetails> findAllSponsorEvents(int id) {
		String jpql = "SELECT z FROM SponsorDetails z WHERE z.events.id=:param ";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", id);
		return query.getResultList();
	}
	@Override
	public List<SponsorDetails> findValideSponsorEvents(int id,String valide) {
		String jpql = "SELECT z FROM SponsorDetails z WHERE z.UserSponsor.id=:param AND z.validate=:p ";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", id);
		query.setParameter("p", valide);
		return query.getResultList();
	}

	@Override
	public List<SponsorDetails> findEtatEvent(String etat) {
		String jpql = "SELECT z FROM SponsorDetails z WHERE z.validate=:param ";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", etat);
		return query.getResultList();
	}

	@Override
	public List<Events> findEtatSposoring(String state) {
		String jpql = "SELECT z FROM Events z WHERE z.state=:param ";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", state);
		return query.getResultList();
	}

	@Override
	public int numberOfSponsoring(int id) {
		String jpql = "SELECT Count (*) m FROM sponsorDetails  m WHERE m.events.id=:param ";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", id);
		return (int) query.getSingleResult();

	}

	@Override
	public void updateSponsorDetail(SponsorDetails SponsorDetails) {
		entityManager.merge(SponsorDetails);
	}

	@Override
	public void updateEvent(Events Events) {
		entityManager.merge(Events);
	}

}
