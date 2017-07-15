package com.adp.control.actions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.adp.business.services.ThirdPartyService;
import com.adp.entities.ThirdPartyEntity;
import com.adp.exceptions.ADPException;

public class ThirdPartyAction extends AbstractAction {

	private static final long serialVersionUID = 1L;

	@Autowired
	ThirdPartyService thirdPartyService ;
	
	private ThirdPartyEntity ThirdParty ;
	
	private List<ThirdPartyEntity> ThirdPartys ;
	
	
	
	public ThirdPartyEntity getThirdParty() {
		return ThirdParty;
	}

	public void setThirdParty(ThirdPartyEntity ThirdParty) {
		this.ThirdParty = ThirdParty;
	}

	public List<ThirdPartyEntity> getThirdPartys() {
		return ThirdPartys;
	}

	public void setThirdPartys(List<ThirdPartyEntity> ThirdPartys) {
		this.ThirdPartys = ThirdPartys;
	}

	public String addThirdParty()  {
		
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
		
		
		ThirdParty = thirdPartyService.getThirdParty(id);
		
		
		return SUCCESS ;
	}
	public String viewThirdPartys() throws ADPException {
		
		try {
			ThirdPartys = thirdPartyService.getAllThirdPartys();
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
