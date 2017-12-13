package bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import persistence.Events;
import persistence.SponsorDetails;
import services.UserManagementLocal;

@ManagedBean
@ViewScoped
public class SponsorBean {
	private String notes;
	private String Produit;
	private int Quantity;
	private String Sponsor_price;
	private boolean showDetails = false;
	private Events eventsSelected = new Events();
	private List<Events> events = new ArrayList<>();
	private List<Events> allevents = new ArrayList<>();
	private SponsorDetails sponsor = new SponsorDetails();
	private List<SponsorDetails> sponsors = new ArrayList<>();
	private List<SponsorDetails> sponsorslist = new ArrayList<>();

	@EJB
	private UserManagementLocal UsermanagementLocal;

	@PostConstruct
	public void init() {
		events = UsermanagementLocal.findEtatSposoring("notsponsor");
		allevents = UsermanagementLocal.findEtatSposoring("sponsor");
		sponsorslist = UsermanagementLocal.findValideSponsorEvents(Identity.user.getId(), "validate");
	}
	 
	public void doSaveOrUpdateSoponsor() {

		UsermanagementLocal.saveSponsoringDetails(Identity.user, eventsSelected, notes, Produit, Sponsor_price,
				Quantity, "notvalid", "wait");
		showDetails = false;
		init();

	}

	 
	    public void saveMessage() {
	        FacesContext context = FacesContext.getCurrentInstance();
	         for(SponsorDetails a : sponsorslist)
	        context.addMessage(null, new FacesMessage("Successful",  "Your message: " + a.getNotify()) );
	       
	    }

	

		
	


	public void doshowNewSponsor() {

		sponsor = new SponsorDetails();
		showDetails = true;
	}

	public boolean doExist() {

		boolean exist = false;
		sponsors = UsermanagementLocal.findAllSponsorEvents(eventsSelected.getId());
		for (SponsorDetails sponso : sponsors) {
			if (sponso.getUserSponsor().getId() == Identity.user.getId()) {
				exist = true;
			}
		}
		return exist;
	}

	public SponsorDetails getSponsor() {
		return sponsor;
	}

	public void setSponsor(SponsorDetails sponsor) {
		this.sponsor = sponsor;
	}

	public void doSelect() {

		if (doExist() == false) {
			showDetails = true;
		} else
			showDetails = false;

	}

	public void doCancel() {
		showDetails = false;
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

	public List<Events> getAllevents() {
		return allevents;
	}

	public void setAllevents(List<Events> allevents) {
		this.allevents = allevents;
	}

	public List<SponsorDetails> getSponsorslist() {
		return sponsorslist;
	}

	public void setSponsorslist(List<SponsorDetails> sponsorslist) {
		this.sponsorslist = sponsorslist;
	}

}
