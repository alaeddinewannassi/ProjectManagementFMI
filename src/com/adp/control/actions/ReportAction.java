package com.adp.control.actions;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.struts2.util.ServletContextAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.adp.business.services.ProjectService;
import com.adp.business.services.TeamService;
import com.adp.business.services.ThirdPartyService;
import com.adp.entities.TeamEntity;
import com.adp.entities.ThirdPartyEntity;
import com.adp.exceptions.ADPException;

public class ReportAction extends AbstractAction implements ServletContextAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	TeamService teamService;

	@Autowired
	ThirdPartyService thirdPartyService;

	@Autowired
	ProjectService projectService;

	private String selectedProject;

	private List<String> teams = new ArrayList<>();

	private List<String> thirdParties = new ArrayList<>();

	private String selectedTeam;

	public List<String> getThirdParties() {
		return thirdParties;
	}

	public void setThirdParties(List<String> thirdParties) {
		this.thirdParties = thirdParties;
	}

	public String getSelectedTeam() {
		return selectedTeam;
	}

	public void setSelectedTeam(String selectedTeam) {
		this.selectedTeam = selectedTeam;
	}

	public List<String> getTeams() {
		return teams;
	}

	public void setTeams(List<String> teams) {
		this.teams = teams;
	}

	public String getSelectedProject() {
		return selectedProject;
	}

	public void setSelectedProject(String selectedProject) {
		this.selectedProject = selectedProject;
	}

	public String doShowReport() throws ADPException {

		List<TeamEntity> teamsByProject = teamService.getTeamsByProject(selectedProject);

		for (TeamEntity team : teamsByProject) {
			teams.add(team.getTeamName());
		}

		TeamEntity team = teamService.getTeamByName(selectedTeam);
		
		if (team != null) {
			List<ThirdPartyEntity> contributors = thirdPartyService.getThirdPartiesByTeam(team.getId());

			for (ThirdPartyEntity thirdParty : contributors) {
				thirdParties.add(thirdParty.getFullName());
			}

			return SUCCESS;
		} else
			return SUCCESS;
	}

	@Override
	public void setServletContext(ServletContext arg0) {
		// TODO Auto-generated method stub

	}

}
