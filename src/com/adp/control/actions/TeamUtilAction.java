package com.adp.control.actions;

import javax.servlet.ServletContext;

import org.apache.struts2.util.ServletContextAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.adp.business.services.ProjectService;
import com.adp.business.services.TeamService;
import com.adp.entities.ProjectEntity;
import com.adp.entities.TeamEntity;
import com.adp.exceptions.ADPException;
import com.adp.utils.StringUtil;

public class TeamUtilAction extends AbstractAction implements ServletContextAware{

	private static final long serialVersionUID = 1L;

	@Autowired
	ProjectService projectService;

	@Autowired
	TeamService teamService;

	private String teamName;

	private String projectName;

	private Long id;

	private String selectedProject;

	public String getSelectedProject() {
		return selectedProject;
	}

	public void setSelectedProject(String selectedProject) {
		this.selectedProject = selectedProject;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public TeamUtilAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String saveTeam() throws ADPException {

		try {
			if (!check()) {
				addActionError("verify Team fields (*)!");
				return "addTeam";
			}

			TeamEntity t = new TeamEntity(teamName);
			ProjectEntity p = projectService.getProjectByName(projectName);
			t.setProject(p);
			p.getTeams().add(t);

			projectService.updateProject(p);

			addActionMessage("the Team " + teamName + " was added successefully ! ");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return SUCCESS;
	}

	public String updateTeam() throws ADPException {

		TeamEntity t = teamService.getTeam(id);

		t.setTeamName(teamName);
		ProjectEntity p = projectService.getProjectByName(selectedProject);
		t.setProject(p);
		teamService.updateTeam(t);

		addActionMessage("the Team " + teamName + " was updated successefully ! ");

		return SUCCESS;
	}

	private boolean check() {
		if (StringUtil.isEmpty(teamName)) {
			return false;
		}

		return true;
	}

	@Override
	public void setServletContext(ServletContext arg0) {
		// TODO Auto-generated method stub
		
	}

}
