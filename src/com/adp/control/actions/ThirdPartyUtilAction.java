package com.adp.control.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.adp.business.services.ThirdPartyService;
import com.adp.business.services.InterestService;
import com.adp.business.services.MissionService;
import com.adp.business.services.TeamService;
import com.adp.entities.AffectationEntity;
import com.adp.entities.InterestEntity;
import com.adp.entities.MissionEntity;
import com.adp.entities.TeamEntity;
import com.adp.entities.ThirdPartyEntity;
import com.adp.exceptions.ADPException;
import com.adp.utils.StringUtil;

public class ThirdPartyUtilAction extends AbstractAction{

	private static final long serialVersionUID = 1L;
	private static final String MISSION_PARAM_PREFIX = "selectedMission";

	@Autowired
	ThirdPartyService thirdPartyService ;
	
	@Autowired
	TeamService teamService ;
	
	@Autowired
	InterestService interestService ;
	
	@Autowired
	MissionService missionService ;
	
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
	
	private List<String> selectedInterests ;
	
	private List<String> selectedMissions = new ArrayList<String>();
	
	private List<Date> selectedStartDate = new ArrayList<Date>();
	
	private List<Date> selectedEndDate = new ArrayList<Date>();
	
	

	public List<String> getSelectedMissions() {
		return selectedMissions;
	}

	public void setSelectedMissions(List<String> selectedMissions) {
		this.selectedMissions = selectedMissions;
	}

	public List<Date> getSelectedStartDate() {
		return selectedStartDate;
	}

	public void setSelectedStartDate(List<Date> selectedStartDate) {
		this.selectedStartDate = selectedStartDate;
	}

	public List<Date> getSelectedEndDate() {
		return selectedEndDate;
	}

	public void setSelectedEndDate(List<Date> selectedEndDate) {
		this.selectedEndDate = selectedEndDate;
	}

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
	        thirdPartyService.addThirdParty(t);
			
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
			thirdPartys = thirdPartyService.getAllThirdPartys();
			
		return SUCCESS ;
	
	}
	public String doAffectThirdParty() throws ADPException, ParseException {
		ThirdPartyEntity t = thirdPartyService.getThirdParty(id);
		List<MissionToThirdPartyLink> list = buildLinks();
		
		for(MissionToThirdPartyLink mt : list){
			MissionEntity m = missionService.getMissionByName(mt.getMissionName());
			AffectationEntity association = new AffectationEntity(t, m, mt.getStartDate(), mt.getEndDate());
			t.getAssociation().add(association);
			thirdPartyService.updateThirdParty(t);
		}
		
		
		
		addActionMessage("the contributor" + t.getFirstName() +"was affected successefully !");
		
		return SUCCESS ;
	}
	
	private List<MissionToThirdPartyLink> buildLinks() throws ParseException{
		
		List<MissionToThirdPartyLink> links = new ArrayList<>();
		HttpServletRequest request = getRequest();
		@SuppressWarnings("unchecked")
		Map<String, String[]> parameters = request.getParameterMap();
		
		for(String parameterName : parameters.keySet()){
			if(parameterName.startsWith(MISSION_PARAM_PREFIX)){
				
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				
				int index = Integer.valueOf(parameterName.substring(MISSION_PARAM_PREFIX.length()));
				MissionToThirdPartyLink link = new MissionToThirdPartyLink(request.getParameter(MISSION_PARAM_PREFIX+index),
					 df.parse(request.getParameter("startDate"+index)), 
						df.parse(request.getParameter("endDate"+index)) ) ;
				
				links.add(link);
			}
		}
		
		return links;
	}
	
	private class MissionToThirdPartyLink{
		private String missionName;
		private Date startDate;
		private Date endDate;
		

		public String getMissionName() {
			return missionName;
		}

		public Date getStartDate() {
			return startDate;
		}

		public Date getEndDate() {
			return endDate;
		}



		private MissionToThirdPartyLink(String missionName, Date startDate, Date endDate){
			this.missionName = missionName;
			this.startDate = startDate;
			this.endDate = endDate;
		}
	}
	
	public String updateThirdParty() throws ADPException {
		
		TeamEntity team = teamService.getTeamByName(selectedTeam);
		ThirdPartyEntity t = thirdPartyService.getThirdParty(id);
		t.setFirstName(firstName);
		t.setLastName(lastName);
		t.setEmail(email);
		t.setJobTitle(jobTitle);
		t.setPhone(phone);
		t.setAdresse(adresse);
		t.setTeam(team);

		thirdPartyService.updateThirdParty(t);
		
		
		addActionMessage("the ThirdParty "+t.getFirstName()+" was updated successefully ! ");
		
		return SUCCESS ;
	}
	
	
	private boolean check() {
		if(StringUtil.isEmpty(firstName) ||StringUtil.isEmpty(lastName) ){
			return false;
		}
		
		return true;
	}
	
	
	
}
