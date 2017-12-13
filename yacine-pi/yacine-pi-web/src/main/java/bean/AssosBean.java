package bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import persistence.Events;
import persistence.SponsorDetails;
import persistence.UserSponsor;
import services.UserManagementLocal;

@ManagedBean
@ViewScoped
public class AssosBean {
	private String notes;
	private String Produit;
	private int Quantity;
	private String Sponsor_price;
	
	private boolean showDetails = false;
	private boolean sp = true;
	private Events eventsSelected = new Events();
	private UserSponsor SponsorSelected = new UserSponsor();
	private List<Events> events = new ArrayList<>();
	private SponsorDetails sponsor = new SponsorDetails();
	private boolean showsponsor = false;
	private List<SponsorDetails> sponsors = new ArrayList<>();
	@EJB
	private UserManagementLocal UsermanagementLocal;

	@PostConstruct
	public void init() {
		events = UsermanagementLocal.findEventsByUser(Identity.user.getId());

	}

	public void dovalidateSponsor() {
		String notify = "Thank's " + sponsor.getUserSponsor().getUsername() + " For Supporting  our Event :"
				+ eventsSelected.getTitle() + "\n " + "Notification From  This Assostion  :"
				+ eventsSelected.getUserAssos().getUsername();
		sponsor.setValidate("validate");
		sponsor.setNotify(notify);
		UsermanagementLocal.updateSponsorDetail(sponsor);
		eventsSelected.setState("sponsor");
		UsermanagementLocal.updateEvent(eventsSelected);
		sp=true;
		showsponsor = false;
		init();

	}

	public boolean doExist() {
		String a = "validate";
		boolean exist = false;
		sponsors = UsermanagementLocal.findAllSponsorEvents(eventsSelected.getId());
		for (SponsorDetails sponso : sponsors) {
			if (sponso.getValidate().equals(a)) {
				exist = true;
			}
		}
		return exist;
	}

	public void doShowSponsorEvent() {
		
		if (doExist() == false) {
			sp=false;
			sponsors = UsermanagementLocal.findAllSponsorEvents(eventsSelected.getId());
			showDetails = true;
		} else{
			showDetails = false;
		sp=true;}
	}

	public SponsorDetails getSponsor() {
		return sponsor;
	}

	public void setSponsor(SponsorDetails sponsor) {
		this.sponsor = sponsor;
	}

	public void doSelectSponsor() {
		sp=false;
		showDetails = false;
		showsponsor = true;
	}

	public void doCancel() {
		sp=true;
		showDetails = false;
		showsponsor = false;
		
		
	}

	public boolean isShowDetails() {
		return showDetails;
	}

	public void setShowDetails(boolean showDetails) {
		this.showDetails = showDetails;
	}

	public String getNotes() {
		return notes;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getProduit() {
		return Produit;
	}

	public void setProduit(String produit) {
		Produit = produit;
	}

	public String getSponsor_price() {
		return Sponsor_price;
	}

	public void setSponsor_price(String sponsor_price) {
		Sponsor_price = sponsor_price;
	}

	public Events getEventsSelected() {
		return eventsSelected;
	}

	public void setEventsSelected(Events eventsSelected) {
		this.eventsSelected = eventsSelected;
	}

	public List<Events> getEvents() {
		return events;
	}

	public void setEvents(List<Events> events) {
		this.events = events;
	}

	public List<SponsorDetails> getSponsors() {
		return sponsors;
	}

	public void setSponsors(List<SponsorDetails> sponsors) {
		this.sponsors = sponsors;
	}

	public UserSponsor getSponsorSelected() {
		return SponsorSelected;
	}

	public void setSponsorSelected(UserSponsor sponsorSelected) {
		SponsorSelected = sponsorSelected;
	}

	public boolean isShowsponsor() {
		return showsponsor;
	}

	public void setShowsponsor(boolean showsponsor) {
		this.showsponsor = showsponsor;
	}



	public boolean isSp() {
		return sp;
	}

	public void setSp(boolean sp) {
		this.sp = sp;
	}

}
