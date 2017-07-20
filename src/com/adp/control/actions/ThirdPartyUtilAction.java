package com.adp.control.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.adp.business.services.ThirdPartyService;
import com.adp.business.services.InterestService;
import com.adp.business.services.TeamService;
import com.adp.entities.InterestEntity;
import com.adp.entities.TeamEntity;
import com.adp.entities.ThirdPartyEntity;
import com.adp.exceptions.ADPException;
import com.adp.utils.StringUtil;

public class ThirdPartyUtilAction extends AbstractAction{

	private static final long serialVersionUID = 1L;

	@Autowired
	ThirdPartyService ThirdPartyService ;
	
	@Autowired
	TeamService teamService ;
	
	@Autowired
	InterestService interestService ;
	
	private List<ThirdPartyEntity> thirdPartys ;

	
	private String firstName ;
	
	private String lastName ;
	
	private String phone ;
	
	private String adresse ;
	
	private String gender ;

	private String jobTitle ;
	
	private String email ;
	
	private File profileImage ;
	
	private String selectedTeam ;
	
	private List<String> selectedMissions ;
	
	private List<String> selectedInterests ;
	
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getSelectedInterests() {
		return selectedInterests;
	}

	public void setSelectedInterests(List<String> selectedInterests) {
		this.selectedInterests = selectedInterests;
	}

	public String getSelectedTeam() {
		return selectedTeam;
	}

	public void setSelectedTeam(String selectedTeam) {
		this.selectedTeam = selectedTeam;
	}

	public List<String> getSelectedMissions() {
		return selectedMissions;
	}

	public void setSelectedMissions(List<String> selectedMissions) {
		this.selectedMissions = selectedMissions;
	}

	public File getProfileImage() {
		return profileImage;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setProfileImage(File profileImage) {
		this.profileImage = profileImage;
	}

	private Long id ;
	

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

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

		 byte[] imageFile = new byte[(int) profileImage.length()];
		 
	        try {
	            // persist image to db
	        	FileInputStream fileInputStream = new FileInputStream(profileImage);
	            fileInputStream.read(imageFile);
	            fileInputStream.close();
	            
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        Set<InterestEntity> collection = new HashSet<>();
	        ThirdPartyEntity t = new ThirdPartyEntity(firstName, lastName, email , gender , jobTitle, phone, adresse,imageFile);
	        for (String interestName : selectedInterests){
	        	InterestEntity i = interestService.getInterestByName(interestName);
	        	collection.add(i);
	        }
	        t.setInterests(collection);
	        ThirdPartyService.addThirdParty(t);
			
			 // persist image in local
            FileOutputStream fos = new FileOutputStream("C:\\ProjectManagementFMI\\images\\"+t.getFirstName()+".jpg");  
            fos.write(t.getProfileImage());
            // fos.flush(); 
            fos.close();
            
			addActionMessage("the Contributor "+firstName+" was added successefully ! ");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return SUCCESS ;
	}
	
	public String viewContributors() throws ADPException{
		
		//	TeamEntity team = teamService.getTeamByName(selectedTeam);
			thirdPartys = ThirdPartyService.getAllThirdPartys();
			
		return SUCCESS ;
	
	}
	public String doAffectThirdParty() throws ADPException {
		
		
		
		return SUCCESS ;
	}
	public String updateThirdParty() throws ADPException {
		
		TeamEntity team = teamService.getTeamByName(selectedTeam);
		ThirdPartyEntity m = ThirdPartyService.getThirdParty(id);
		m.setFirstName(firstName);
		m.setLastName(lastName);
		m.setEmail(email);
		m.setJobTitle(jobTitle);
		m.setPhone(phone);
		m.setAdresse(adresse);
		m.setTeam(team);

		ThirdPartyService.updateThirdParty(m);
		
		
		addActionMessage("the ThirdParty "+m.getFirstName()+" was updated successefully ! ");
		
		return SUCCESS ;
	}
	
	
	private boolean check() {
		if(StringUtil.isEmpty(firstName) ||StringUtil.isEmpty(lastName) ){
			return false;
		}
		
		return true;
	}
	
	
	
}
