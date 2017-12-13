package bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import persistence.Events;
import persistence.UserAssos;
import services.UserManagementLocal;

@ManagedBean
@ViewScoped
public class UserBean {

	private Events eventsSelected = new Events();
	private List<Events> AllEvents = new ArrayList<>();

	private UserAssos userAssos = new UserAssos();
	private List<UserAssos> userAssoss = new ArrayList<>();

	private boolean showEventsList = false;
	@EJB
	private UserManagementLocal UsermanagementLocal;

	@PostConstruct
	private void init() {
		AllEvents = UsermanagementLocal.findAllEvents();

	}

	public void doshowEventsList() {
		showEventsList = true;
	}

	

	public List<Events> getAllEvents() {
		return AllEvents;
	}

	public void setAllEvents(List<Events> allEvents) {
		AllEvents = allEvents;
	}

	public UserAssos getUserAssos() {
		return userAssos;
	}

	public void setUserAssos(UserAssos userAssos) {
		this.userAssos = userAssos;
	}

	public List<UserAssos> getUserAssoss() {
		return userAssoss;
	}

	public void setUserAssoss(List<UserAssos> userAssoss) {
		this.userAssoss = userAssoss;
	}

	public boolean isShowEventsList() {
		return showEventsList;
	}

	public void setShowEventsList(boolean showEventsList) {
		this.showEventsList = showEventsList;
	}

	public Events getEventsSelected() {
		return eventsSelected;
	}

	public void setEventsSelected(Events eventsSelected) {
		this.eventsSelected = eventsSelected;
	}

}
