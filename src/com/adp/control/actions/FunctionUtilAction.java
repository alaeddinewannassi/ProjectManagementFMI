package com.adp.control.actions;




import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.adp.business.services.FunctionService;
import com.adp.business.services.MissionService;
import com.adp.entities.FunctionEntity;
import com.adp.entities.MissionEntity;
import com.adp.exceptions.ADPException;
import com.adp.utils.StringUtil;

public class FunctionUtilAction extends AbstractAction{

	private static final long serialVersionUID = 1L;

	@Autowired
	FunctionService FunctionService ;
	
	@Autowired
	MissionService missionService ;
	
	private List<FunctionEntity> Functions ;
	
	private String selectedMission ;
	
	private String FunctionName ;

	private String description ;
	
	private Long id ;
	
	
	
	
	


	public List<FunctionEntity> getFunctions() {
		return Functions;
	}

	public void setFunctions(List<FunctionEntity> Functions) {
		this.Functions = Functions;
	}

	public String getSelectedMission() {
		return selectedMission;
	}

	public void setSelectedMission(String selectedMission) {
		this.selectedMission = selectedMission;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFunctionName() {
		return FunctionName;
	}

	public void setFunctionName(String FunctionName) {
		this.FunctionName = FunctionName;
	}

	

	public FunctionUtilAction() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String desc) {
		this.description = desc;
	}

	

	public String saveFunction() throws ADPException {
		
		try {
		if (!check()) {
			addActionError("verify Function fields (*)!");
			return "addFunction" ;
		}
		 	MissionEntity m = missionService.getMissionByName(selectedMission);
			FunctionEntity f = new FunctionEntity(FunctionName, description);
			f.setMission(m);
			
				Collection<FunctionEntity> Functions = m.getFunctions();
				Functions.add(f);
				m.setFunctions(Functions);
				
				FunctionService.addFunction(f);
				missionService.updateMission(m);
				
			addActionMessage("the Function "+FunctionName+" was added successefully ! ");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return SUCCESS ;
	}
	
	public String viewFunctions() throws ADPException{
		try {
			MissionEntity m = missionService.getMissionByName(selectedMission);
			Functions = FunctionService.getFunctionsByMission(m.getId());
			
		} catch (ADPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return SUCCESS ;
	
	}
	
	public String updateFunction() throws ADPException {
		
	
		FunctionEntity m = FunctionService.getFunction(id);
		m.setDescription(description);
		m.setFunctionName(FunctionName);
		
		FunctionService.updateFunction(m);
		
		addActionMessage("the Function "+FunctionName+" was updated successefully ! ");
		
		return SUCCESS ;
	}
	


	
	private boolean check() {
		if(StringUtil.isEmpty(FunctionName) ||StringUtil.isEmpty(description) ){
			return false;
		}
		
		return true;
	}
	
	
	
}
