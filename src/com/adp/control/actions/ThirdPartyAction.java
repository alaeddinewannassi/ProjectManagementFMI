package com.adp.control.actions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.adp.business.services.TeamService;
import com.adp.business.services.ThirdPartyService;
import com.adp.entities.TeamEntity;
import com.adp.entities.ThirdPartyEntity;
import com.adp.exceptions.ADPException;

public class ThirdPartyAction extends AbstractAction {

	private static final long serialVersionUID = 1L;

	@Autowired
	TeamService teamService ;
	
	@Autowired
	ThirdPartyService thirdPartyService ;
	
	private ThirdPartyEntity thirdParty ;
	
	private List<TeamEntity> teams ;
	
	

	public ThirdPartyEntity getThirdParty() {
		return thirdParty;
	}

	public void setThirdParty(ThirdPartyEntity thirdParty) {
		this.thirdParty = thirdParty;
	}

	

	public List<TeamEntity> getTeams() {
		return teams;
	}

	public void setTeams(List<TeamEntity> teams) {
		this.teams = teams;
	}

	public String addThirdParty() throws ADPException  {
		teams = teamService.getAllTeams() ;
		return SUCCESS ;
	}
	
	
	
	private Long id ;
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String detailThirdParty() throws ADPException {
		
		return SUCCESS ;
		
	}
	public String modifyThirdParty() throws ADPException {
		
		
		thirdParty = thirdPartyService.getThirdParty(id);
		
		
		return SUCCESS ;
	}
	public String viewThirdPartys() throws ADPException {
		
		try {
			teams = teamService.getAllTeams() ;
		} catch (ADPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return SUCCESS ;
		
	}
	
	public String removeThirdParty() throws ADPException {
		
		ThirdPartyEntity t = thirdPartyService.getThirdParty(id);
		String name = t.getFirstName() ;
		thirdPartyService.deleteThirdParty(id);
		addActionMessage("the member "+name+" was deleted successefully ! ");
		
		return SUCCESS ;
	}
	
	
	
	
}
