/**
 * 
 */
package com.adp.control.actions;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.adp.business.services.ProjectService;
import com.adp.business.services.UserService;
import com.adp.entities.ProjectEntity;
import com.adp.entities.UserEntity;
import com.adp.exceptions.ADPException;
import com.adp.utils.StringUtil;

/**
 * @author A.WANNASSI
 *
 */
public class LoginAuthAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	ProjectService projectService ;
	
	@Autowired
	UserService userService;

	private String username;
	
	private ProjectEntity project ;
	
	
	
	private String email;

	private String password;

	
	public ProjectEntity getProject() {
		return project;
	}

	public void setProject(ProjectEntity project) {
		this.project = project;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String execute() throws ADPException {

		if (!check()) {
			addActionError("verify connexion fields (*)!");
			return "login";
		}

		UserEntity user = userService.getUser(email, password);
		
		if (user == null) {
			addActionError("incorrect credentials !");
			return "login";
		}

		String loggedInUser = user.getLogin();
		// session prepare
		setLoggedInUser(loggedInUser);
		ServletActionContext.getRequest().getSession().setAttribute("loggedInUser", user);
		project = projectService.getProject(1L);
		List<ProjectEntity> projects = projectService.getAllProjects();
		ServletActionContext.getRequest().getSession().setAttribute("projects", projects);
		
		return SUCCESS;

	}

	private boolean check() {
		if (StringUtil.isEmpty(email) || StringUtil.isEmpty(password)) {
			return false;
		}

		return true;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
