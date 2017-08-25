package com.adp.control.actions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.adp.business.services.FunctionService;
import com.adp.business.services.MissionService;
import com.adp.entities.FunctionEntity;
import com.adp.entities.MissionEntity;
import com.adp.exceptions.ADPException;

public class FunctionAction extends AbstractAction {

	private static final long serialVersionUID = 1L;

	@Autowired
	FunctionService FunctionService;

	@Autowired
	MissionService missionService;

	private FunctionEntity Function;

	private List<MissionEntity> missions;

	public List<MissionEntity> getMissions() {
		return missions;
	}

	public void setMissions(List<MissionEntity> missions) {
		this.missions = missions;
	}

	public FunctionEntity getFunction() {
		return Function;
	}

	public void setFunction(FunctionEntity Function) {
		this.Function = Function;
	}

	public String addFunction() throws ADPException {

		missions = missionService.getAllMissions();

		return SUCCESS;
	}

	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String modifyFunction() throws ADPException {

		Function = FunctionService.getFunction(id);

		return SUCCESS;
	}

	public String showFunctions() throws ADPException {

		missions = missionService.getAllMissions();
		return SUCCESS;
	}

	public String removeFunction() throws ADPException {

		FunctionEntity p = FunctionService.getFunction(id);
		String name = p.getFunctionName();
		FunctionService.deleteFunction(id);
		addActionMessage("the Function " + name + " was deleted successefully ! ");

		return SUCCESS;
	}

}
