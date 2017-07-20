package com.adp.control.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.adp.business.services.InterestService;
import com.adp.business.services.MissionService;
import com.adp.business.services.TeamService;
import com.adp.business.services.ThirdPartyService;
import com.adp.entities.InterestEntity;
import com.adp.entities.MissionEntity;
import com.adp.entities.TeamEntity;
import com.adp.entities.ThirdPartyEntity;
import com.adp.exceptions.ADPException;

public class ThirdPartyAction extends AbstractAction {

	private static final long serialVersionUID = 1L;

	@Autowired
	TeamService teamService ;
	
	@Autowired
	ThirdPartyService thirdPartyService ;
	
	@Autowired
	InterestService interestService ;
	
	@Autowired
	MissionService missionService ;
	
	private ThirdPartyEntity thirdParty ;
	
	private List<TeamEntity> teams ;

	private List<InterestEntity> interests = new ArrayList<InterestEntity>() ;
	
	private List<String> oldInterests = new ArrayList<String>();
	
	private List<MissionEntity> missions ;

	
	public List<String> getOldInterests() {
		return oldInterests;
	}

	public void setOldInterests(List<String> oldInterests) {
		this.oldInterests = oldInterests;
	}

	public List<InterestEntity> getInterests() {
		return interests;
	}

	public void setInterests(List<InterestEntity> interests) {
		this.interests = interests;
	}

	public List<MissionEntity> getMissions() {
		return missions;
	}

	public void setMissions(List<MissionEntity> missions) {
		this.missions = missions;
	}

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
		//teams = teamService.getAllTeams() ;
		//missions = missionService.getAllMissions();
		interests = interestService.getAllInterests() ;
		
		return SUCCESS ;
	}
	
	public String contactThirdParty() throws ADPException  {
		
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
		thirdParty = thirdPartyService.getThirdParty(id);
		
		
		return SUCCESS ;
		
	}
	public String modifyThirdParty() throws ADPException {
		
		missions = missionService.getAllMissions() ;
		thirdParty = thirdPartyService.getThirdParty(id);
		teams = teamService.getAllTeams();
		interests = interestService.getAllInterests() ;
		Set<InterestEntity> collection = thirdParty.getInterests() ;
		for(InterestEntity interest : collection){
			oldInterests.add(interest.getInterestName()) ;
		}
		
		 
		return SUCCESS ;
	}
	public String viewContibutor() throws ADPException {
		
		try {
			teams = teamService.getAllTeams() ;
			
		} catch (ADPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return SUCCESS ;
		
	}
	
	public String affectThirdParty() throws ADPException {
		missions = missionService.getAllMissions() ;
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
