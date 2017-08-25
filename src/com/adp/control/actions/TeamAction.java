package com.adp.control.actions;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.adp.business.services.TeamService;
import com.adp.entities.TeamEntity;
import com.adp.exceptions.ADPException;

public class TeamAction extends AbstractAction {

	private static final long serialVersionUID = 1L;

	@Autowired
	TeamService teamService;

	private TeamEntity team;

	private List<TeamEntity> teams;

	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<TeamEntity> getTeams() {
		return teams;
	}

	public void setTeams(List<TeamEntity> teams) {
		this.teams = teams;
	}

	public TeamEntity getTeam() {
		return team;
	}

	public void setTeam(TeamEntity team) {
		this.team = team;
	}

	public String addTeam() throws ADPException {

		try {
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return SUCCESS;
	}

	public String modifyTeam() throws ADPException {

		team = teamService.getTeam(id);

		return SUCCESS;
	}

	public String viewTeams() throws ADPException {

		try {
			teams = teamService.getAllTeams();

		} catch (ADPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return SUCCESS;

	}

	public String removeTeam() throws ADPException {

		TeamEntity t = teamService.getTeam(id);
		String name = t.getTeamName();
		teamService.deleteTeam(id);
		addActionMessage("the Team " + name + " was deleted successefully ! ");

		return SUCCESS;
	}

}
