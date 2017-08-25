package com.adp.control.actions;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import com.adp.business.services.MissionService;
import com.adp.business.services.MonthlyTurnoverService;
import com.adp.business.services.ProjectService;
import com.adp.entities.MissionEntity;
import com.adp.entities.MonthlyTurnoverEntity;
import com.adp.exceptions.ADPException;

public class MissionAction extends AbstractAction {

	private static final long serialVersionUID = 1L;

	@Autowired
	MissionService missionService;

	@Autowired
	MonthlyTurnoverService monthlyTurnoverService;

	@Autowired
	ProjectService projectService;

	private MissionEntity mission;

	private float overridenBudget;

	private float overridenWorkload;

	private String currentMonth;

	private float newRTD;

	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public float getOverridenBudget() {
		return overridenBudget;
	}

	public void setOverridenBudget(float overridenBudget) {
		this.overridenBudget = overridenBudget;
	}

	public float getOverridenWorkload() {
		return overridenWorkload;
	}

	public void setOverridenWorkload(float overridenWorkload) {
		this.overridenWorkload = overridenWorkload;
	}

	public float getNewRTD() {
		return newRTD;
	}

	public void setNewRTD(float newRTD) {
		this.newRTD = newRTD;
	}

	public String getCurrentMonth() {
		return currentMonth;
	}

	public void setCurrentMonth(String currentMonth) {
		this.currentMonth = currentMonth;
	}

	public MissionEntity getMission() {
		return mission;
	}

	public void setMission(MissionEntity mission) {
		this.mission = mission;
	}

	public String addMission() throws ADPException {

		return SUCCESS;
	}

	public String modifyMission() throws ADPException {

		mission = missionService.getMission(id);

		return SUCCESS;
	}

	public String showMissions() throws ADPException {

		return SUCCESS;
	}

	public String removeMission() throws ADPException {

		MissionEntity p = missionService.getMission(id);
		String name = p.getMissionName();
		missionService.deleteMission(id);
		addActionMessage("the Mission " + name + " was deleted successefully ! ");

		return SUCCESS;
	}

	public String detailMission() throws ADPException {
		mission = missionService.getMission(id);
		SimpleDateFormat sdf = new SimpleDateFormat("MM/yyyy");
		Date date = new Date();
		currentMonth = sdf.format(date);

		return SUCCESS;
	}

	public String calculateMissionCA() throws ADPException {

		try {
			float progress;
			mission = missionService.getMission(id);
			mission.getTurnover().setRevisedBudgetAmount(overridenBudget);
			mission.getTurnover().setRevisedWorkload(overridenWorkload);
			MonthlyTurnoverEntity m = getLatestMonthlyTurnover(mission);
			m.setRealRTD(newRTD);

			if (m.getTurnover().getRevisedWorkload() - m.getRealRTD() < m.getTurnover().getCumulatedActuals()) {
				progress = (m.getTurnover().getRevisedWorkload() - m.getRealRTD())
						/ m.getTurnover().getRevisedWorkload();
			} else
				progress = m.getActual() / m.getTurnover().getRevisedWorkload();

			m.setTurnoverAmount(progress * m.getTurnover().getRevisedBudgetAmount());
			m.setProgress(progress * 100);

			monthlyTurnoverService.updateMonthlyTurnover(m);
			missionService.updateMission(mission);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		addActionMessage(" Mission turnover has been successefully calculated for mission " + mission.getMissionName());
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
}
