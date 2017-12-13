package bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import persistence.CommentDetails;
import persistence.Events;
import persistence.SponsorDetails;
import persistence.UserRefugee;
import persistence.UserSponsor;
import services.UserManagementLocal;

@ManagedBean
@ViewScoped
public class RefugeeBean {
	private boolean doshowlist = true;
	private boolean doshowCom = false;
	private boolean doShowevent = false;
	private Events eventsSelected = new Events();

	private UserSponsor SponsorSelected = new UserSponsor();
	private UserRefugee refugee = new UserRefugee();
	private String commentaire;
	private List<Events> events = new ArrayList<>();
	private SponsorDetails sponsor = new SponsorDetails();
	private List<SponsorDetails> sponsors = new ArrayList<>();
	private List<CommentDetails> comment = new ArrayList<>();
	private CommentDetails comment1 = new CommentDetails();;
	private Date date2;
	@EJB
	private UserManagementLocal UsermanagementLocal;

	@PostConstruct
	public void init() {
		sponsors = UsermanagementLocal.findEtatEvent("validate");
		events = UsermanagementLocal.findEtatSposoring("notsponsor");
		comment = UsermanagementLocal.findAllComEvents(eventsSelected.getId());

	}

	public void doshowCom() {
		init();
		doshowCom = true;
	}

	public void doShowevent() {
		init();
		doshowlist = false;
		doShowevent = true;
	}

	public void doComment() {
		UsermanagementLocal.addCom(Identity.user, eventsSelected, commentaire);
		doshowCom = false;
		init();
	}

	public void doBack() {
		init();
		doshowlist = true;
		doshowCom = false;
		doShowevent = false;
	}

	public SponsorDetails getSponsor() {
		return sponsor;
	}

	public void setSponsor(SponsorDetails sponsor) {
		this.sponsor = sponsor;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public List<CommentDetails> getComment() {
		return comment;
	}

	public void setComment(List<CommentDetails> comment) {
		this.comment = comment;
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

	public boolean isDoshowCom() {
		return doshowCom;
	}

	public void setDoshowCom(boolean doshowCom) {
		this.doshowCom = doshowCom;
	}

	public UserRefugee getRefugee() {
		return refugee;
	}

	public void setRefugee(UserRefugee refugee) {
		this.refugee = refugee;
	}

	public boolean isDoShowevent() {
		return doShowevent;
	}

	public void setDoShowevent(boolean doShowevent) {
		this.doShowevent = doShowevent;
	}

	public CommentDetails getComment1() {
		return comment1;
	}

	public void setComment1(CommentDetails comment1) {
		this.comment1 = comment1;
	}

	public Date getDate2() {
		return date2;
	}

	public void setDate2(Date date2) {
		this.date2 = date2;
	}

	public boolean isDoshowlist() {
		return doshowlist;
	}

	public void setDoshowlist(boolean doshowlist) {
		this.doshowlist = doshowlist;
	}

}
