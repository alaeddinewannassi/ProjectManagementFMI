package com.adp.control.actions;

import java.util.List;

import javax.servlet.ServletContext;

import org.apache.struts2.util.ServletContextAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.adp.business.services.MissionService;
import com.adp.business.services.MonthlyTurnoverService;
import com.adp.business.services.ProjectService;
import com.adp.business.services.TimesheetInputService;
import com.adp.entities.MissionEntity;
import com.adp.entities.MonthlyTurnoverEntity;
import com.adp.entities.ProjectEntity;
import com.adp.exceptions.ADPException;

public class DashboardAction extends AbstractAction implements ServletContextAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	MonthlyTurnoverService monthlyTurnoverService;

	@Autowired
	TimesheetInputService timesheetInputService;

	@Autowired
	MissionService missionService;

	@Autowired
	ProjectService projectService;

	private ProjectEntity project;

	private List<String> months;

	private Long id;

	private MissionEntity mission;

	private List<MissionEntity> missions;

	private String selectedProject;

	private String selectedMonth;

	private String selectedMission;

	private String calculType;
	
	private float newRTD;
	
	

	public float getNewRTD() {
		return newRTD;
	}

	public void setNewRTD(float newRTD) {
		this.newRTD = newRTD;
	}

	public String getCalculType() {
		return calculType;
	}

	public void setCalculType(String calculType) {
		this.calculType = calculType;
	}

	public MissionEntity getMission() {
		return mission;
	}

	public void setMission(MissionEntity mission) {
		this.mission = mission;
	}

	public String getSelectedProject() {
		return selectedProject;
	}

	public void setSelectedProject(String selectedProject) {
		this.selectedProject = selectedProject;
	}

	public String getSelectedMonth() {
		return selectedMonth;
	}

	public void setSelectedMonth(String selectedMonth) {
		this.selectedMonth = selectedMonth;
	}

	public String getSelectedMission() {
		return selectedMission;
	}

	public void setSelectedMission(String selectedMission) {
		this.selectedMission = selectedMission;
	}

	public List<MissionEntity> getMissions() {
		return missions;
	}

	public void setMissions(List<MissionEntity> missions) {
		this.missions = missions;
	}

	public List<String> getMonths() {
		return months;
	}

	public void setMonths(List<String> months) {
		this.months = months;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ProjectEntity getProject() {
		return project;
	}

	public void setProject(ProjectEntity project) {
		this.project = project;
	}

	public String addMonth() throws ADPException {

		months = timesheetInputService.getAllTimesheetsByDistinctMonth();
		missions = missionService.getAllMissions();

		return SUCCESS;
	}

	public String viewDashboard() throws ADPException {

		project = projectService.getProject(id);

		return SUCCESS;
	}

	public String calculTurnoverAmount() throws ADPException {
		project = projectService.getProject(id);

		return SUCCESS;
	}

	public String calculateTurnover() throws ADPException {
		
		months = timesheetInputService.getAllTimesheetsByDistinctMonth();
		missions = missionService.getAllMissions();
		if (selectedMonth != null) {

			// verify if CA previous month is already calculated
			if (!selectedMonth.equals("1") && !monthlyTurnoverService.existMonthlyTurnover(Integer.parseInt(selectedMonth) - 1)) {

				addActionError("please calculate the turnover of the previous month !");

				return "addMonth";

			} else {

				// verify if instance is completed
				if (!projectService.getProjectByName(selectedProject).getTimesheet().isCompleted()) {

					addActionError(" Instance is incompleted !");

					return "addMonth";
				}
			}
		}

		float progress;
		mission = missionService.getMissionByName(selectedMission);
		// mission.getTurnover().setRevisedBudgetAmount(overridenBudget);
		// mission.getTurnover().setRevisedWorkload(overridenWorkload);
		MonthlyTurnoverEntity m = getLatestMonthlyTurnover(mission);
		
		// CalculType is manual
		if(calculType != null){
		m.setRealRTD(newRTD);
		
		
		// CalculType is automatic
		
		if (m.getTurnover().getRevisedWorkload() - m.getRealRTD() < m.getTurnover().getCumulatedActuals()) {
			progress = (m.getTurnover().getRevisedWorkload() - m.getRealRTD()) / m.getTurnover().getRevisedWorkload();
		} else
			progress = m.getActual() / m.getTurnover().getRevisedWorkload();

		m.setTurnoverAmount(progress * m.getTurnover().getRevisedBudgetAmount());
		m.setProgress(progress * 100);

		monthlyTurnoverService.updateMonthlyTurnover(m);
		missionService.updateMission(mission);
		}
		
		return SUCCESS;
	}

	public MonthlyTurnoverEntity getLatestMonthlyTurnover(MissionEntity mission) {
		int latestMonth = 0;
		MonthlyTurnoverEntity monthlyTurnover = new MonthlyTurnoverEntity();

		for (MonthlyTurnoverEntity m : mission.getTurnover().getMonthlyTurnovers()) {
			if (latestMonth == 0 || m.getMonth() > latestMonth) {
				latestMonth = m.getMonth();
				monthlyTurnover = m;
			}
		}

		return monthlyTurnover;

	}

	@Override
	public void setServletContext(ServletContext arg0) {
		// TODO Auto-generated method stub

	}

}
