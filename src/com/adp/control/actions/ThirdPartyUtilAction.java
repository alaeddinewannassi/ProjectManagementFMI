package com.adp.control.actions;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.adp.business.services.ThirdPartyService;
import com.adp.business.services.TeamService;
import com.adp.entities.ThirdPartyEntity;
import com.adp.entities.TeamEntity;
import com.adp.exceptions.ADPException;
import com.adp.utils.StringUtil;

public class ThirdPartyUtilAction extends AbstractAction{

	private static final long serialVersionUID = 1L;

	@Autowired
	ThirdPartyService ThirdPartyService ;
	
	@Autowired
	TeamService teamService ;
	
	private List<ThirdPartyEntity> thirdPartys ;
	
	private String selectedTeam ;
	
	private String firstName ;
	
	private String lastName ;
	
	private String gender ;
	
	private String phone ;
	
	private Date birthday ;

	private String jobTitle ;
	
	private Long id ;
	

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<ThirdPartyEntity> getThirdPartys() {
		return thirdPartys;
	}

	public void setThirdPartys(List<ThirdPartyEntity> thirdPartys) {
		this.thirdPartys = thirdPartys;
	}

	public String getSelectedTeam() {
		return selectedTeam;
	}

	public void setSelectedTeam(String selectedTeam) {
		this.selectedTeam = selectedTeam;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public ThirdPartyUtilAction() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String saveThirdParty() throws ADPException {
		
		try {
		if (!check()) {
			addActionError("verify ThirdParty fields (*)!");
			return "addThirdParty" ;
		}
		 	TeamEntity team = teamService.getTeamByName(selectedTeam);
			ThirdPartyEntity t = new ThirdPartyEntity(firstName, lastName, jobTitle, birthday, gender, phone);
			t.setTeam(team);
			
				Collection<ThirdPartyEntity> ThirdPartys = team.getEmployees() ;
				ThirdPartys.add(t);
				team.setEmployees(ThirdPartys);

				ThirdPartyService.addThirdParty(t);

				teamService.updateTeam(team);
				
			
			addActionMessage("the ThirdParty "+firstName+" was added successefully ! ");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return SUCCESS ;
	}
	
	public String viewThirdPartys() throws ADPException{
		try {
			TeamEntity team = teamService.getTeamByName(selectedTeam);
			thirdPartys = ThirdPartyService.getThirdPartysByTeam(team.getId());
			
		} catch (ADPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return SUCCESS ;
	
	}
	
	public String updateThirdParty() throws ADPException {
		
		TeamEntity team = teamService.getTeamByName(selectedTeam);
		ThirdPartyEntity m = ThirdPartyService.getThirdParty(id);
		m.setBirthday(birthday);
		m.setFirstName(firstName);
		m.setGender(gender);
		m.setJobTitle(jobTitle);
		m.setPhone(phone);
		m.setTeam(team);
		ThirdPartyService.updateThirdParty(m);
		
		addActionMessage("the ThirdParty "+firstName+" was updated successefully ! ");
		
		return SUCCESS ;
	}
	


	
	private boolean check() {
		if(StringUtil.isEmpty(firstName) ||StringUtil.isEmpty(lastName) ){
			return false;
		}
		
		return true;
	}
	
	
	
}
