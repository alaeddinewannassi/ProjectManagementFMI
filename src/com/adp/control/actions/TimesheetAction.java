package com.adp.control.actions;

import java.io.File;
import java.io.FileInputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.adp.business.services.FunctionService;
import com.adp.business.services.MissionService;
import com.adp.business.services.MonthlyTurnoverService;
import com.adp.business.services.ProjectService;
import com.adp.business.services.TeamService;
import com.adp.business.services.ThirdPartyService;
import com.adp.business.services.TimesheetInputLineService;
import com.adp.business.services.TimesheetInputService;
import com.adp.business.services.TimesheetInstanceService;
import com.adp.business.services.TurnoverService;
import com.adp.entities.AffectationEntity;
import com.adp.entities.FunctionEntity;
import com.adp.entities.MissionEntity;
import com.adp.entities.MonthlyTurnoverEntity;
import com.adp.entities.ProjectEntity;
import com.adp.entities.TeamEntity;
import com.adp.entities.ThirdPartyEntity;
import com.adp.entities.TimesheetErrorEntity;
import com.adp.entities.TimesheetInputEntity;
import com.adp.entities.TimesheetInputLineEntity;
import com.adp.entities.TimesheetInstanceEntity;
import com.adp.entities.TurnoverEntity;
import com.adp.exceptions.ADPException;

public class TimesheetAction extends AbstractAction {

	private static final long serialVersionUID = -4748500436762141116L;

	@Autowired
	TeamService teamService;

	@Autowired
	TimesheetInputLineService timesheetInputLineService;

	@Autowired
	ThirdPartyService thirdPartyService;

	@Autowired
	ProjectService projectService;

	@Autowired
	TimesheetInstanceService timesheetInstanceService;

	@Autowired
	TurnoverService turnoverService;

	@Autowired
	MissionService missionService;

	@Autowired
	FunctionService functionService;

	@Autowired
	MonthlyTurnoverService monthlyTurnoverService;

	@Autowired
	TimesheetInputService timesheetInputService;

	private ThirdPartyEntity contributor;
	private List<ThirdPartyEntity> thirdParties = new ArrayList<ThirdPartyEntity>();
	private List<TeamEntity> teams = new ArrayList<TeamEntity>();
	private List<String> timesheets = new ArrayList<String>();
	private File timesheet;
	private Set<TimesheetInputLineEntity> inputLines = new HashSet<TimesheetInputLineEntity>();
	private String selectedMonth;
	private String selectedTeam;
	private Set<TimesheetErrorEntity> inputErrors = new HashSet<TimesheetErrorEntity>();
	private String selectedProject;
	private List<TimesheetInstanceEntity> instances = new ArrayList<TimesheetInstanceEntity>();
	private String thirdPartyName;

	public ThirdPartyEntity getContributor() {
		return contributor;
	}

	public void setContributor(ThirdPartyEntity contributor) {
		this.contributor = contributor;
	}

	public String getSelectedTeam() {
		return selectedTeam;
	}

	public void setSelectedTeam(String selectedTeam) {
		this.selectedTeam = selectedTeam;
	}

	public List<ThirdPartyEntity> getThirdParties() {
		return thirdParties;
	}

	public void setThirdParties(List<ThirdPartyEntity> thirdParties) {
		this.thirdParties = thirdParties;
	}

	public List<TeamEntity> getTeams() {
		return teams;
	}

	public void setTeams(List<TeamEntity> teams) {
		this.teams = teams;
	}

	public List<String> getTimesheets() {
		return timesheets;
	}

	public void setTimesheets(List<String> timesheets) {
		this.timesheets = timesheets;
	}

	public String getThirdPartyName() {
		return thirdPartyName;
	}

	public void setThirdPartyName(String thirdPartyName) {
		this.thirdPartyName = thirdPartyName;
	}

	public List<TimesheetInstanceEntity> getInstances() {
		return instances;
	}

	public void setInstances(List<TimesheetInstanceEntity> instances) {
		this.instances = instances;
	}

	public String getSelectedProject() {
		return selectedProject;
	}

	public void setSelectedProject(String selectedProject) {
		this.selectedProject = selectedProject;
	}


	public Set<TimesheetErrorEntity> getInputErrors() {
		return inputErrors;
	}

	public void setInputErrors(Set<TimesheetErrorEntity> inputErrors) {
		this.inputErrors = inputErrors;
	}

	public Set<TimesheetInputLineEntity> getInputLines() {
		return inputLines;
	}

	public void setInputLines(Set<TimesheetInputLineEntity> inputLines) {
		this.inputLines = inputLines;
	}

	public String getSelectedMonth() {
		return selectedMonth;
	}

	public void setSelectedMonth(String selectedMonth) {
		this.selectedMonth = selectedMonth;
	}

	public File getTimesheet() {
		return timesheet;
	}

	public void setTimesheet(File timesheet) {
		this.timesheet = timesheet;
	}

	public String upload() throws ADPException {

		return SUCCESS;
	}

	public String doUpload() {
		try {

			DataFormatter formatter = new DataFormatter();
			// SimpleDateFormat df = new SimpleDateFormat();

			FileInputStream file = new FileInputStream(timesheet);
			Workbook wb = WorkbookFactory.create(file);
			Sheet sheet = wb.getSheetAt(0);

			// get Timesheet Month
			Row r = sheet.getRow(1);
			Date date = r.getCell(9).getDateCellValue();
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			int month = cal.get(Calendar.MONTH) + 1;

			// Timesheet Input Parse
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {

				inputErrors = new HashSet<TimesheetErrorEntity>();

				Row row = sheet.getRow(i);

				// timesheetLine constructor
				Date workDate = row.getCell(9).getDateCellValue();
				Float hoursByDay = Float.parseFloat(formatter.formatCellValue(row.getCell(11)));
				String comment = formatter.formatCellValue(row.getCell(13));

				TimesheetInputLineEntity line = new TimesheetInputLineEntity(workDate, comment, hoursByDay);

				MissionEntity m = missionService.getMissionByName(formatter.formatCellValue(row.getCell(4)));
				FunctionEntity f = functionService.getFunctionsByName(formatter.formatCellValue(row.getCell(8)));

				line.setContributorName(row.getCell(0).getStringCellValue());
				line.setMission(m);
				line.setFunction(f);

				ThirdPartyEntity thirdParty = thirdPartyService.getThirdPartyByName(line.getContributorName());
				String fullName = thirdParty.getFirstName() + ' ' + thirdParty.getLastName();

				if (!verif(fullName, inputLines)) {

					TimesheetInstanceEntity instance = new TimesheetInstanceEntity(new Date());
					instance.getInputLines().add(line);
					TimesheetInputEntity timesheetInput = new TimesheetInputEntity();

					if (!valid(month, thirdParty.getTimesheetInputs())) {
						timesheetInput = new TimesheetInputEntity(month);
						timesheetInput.setProject(projectService.getProjectByName(selectedProject));
						timesheetInput.setThirdParty(thirdPartyService.getThirdPartyByName(line.getContributorName()));
						timesheetInput.getTimesheetInstances().add(instance);
						thirdParty.getTimesheetInputs().add(timesheetInput);
					}

					else {
						timesheetInput = check(fullName, month, thirdParty.getTimesheetInputs());
						timesheetInput.setProject(projectService.getProjectByName(selectedProject));
						timesheetInput.getTimesheetInstances().add(instance);

					}

					instance.setTimesheet(timesheetInput);
					line.setTimesheetInstance(instance);

					inputLines.add(line);
					inputErrors = Errors(thirdParty, workDate, hoursByDay, m, instance);

					if (!exist(m, thirdParty.getAssociation())) {
						TimesheetErrorEntity error = new TimesheetErrorEntity();
						error.setTimesheetInstance(instance);
						error.setErrorDescription(
								"Mission" + m.getMissionName() + " not conform with affectation configuration ");
						error.setErrorType("affectation TP - Mission");
						error.setPossibleSolution("configure contributors affectations ");
						inputErrors.add(error);
					}

					for (TimesheetErrorEntity error : inputErrors) {
						instance.getInputErrors().add(error);
					}

					timesheetInputService.updateTimesheet(timesheetInput);
				}

				else {
					Date imp = search(fullName, inputLines).getTimesheetInstance().getImportDate();
					TimesheetInstanceEntity oldInst = timesheetInstanceService.getInstanceByImportDate(imp);
					line.setTimesheetInstance(oldInst);
					oldInst.getInputLines().add(line);
					inputErrors = Errors(thirdParty, workDate, hoursByDay, m, oldInst);
					inputLines.add(line);
					for (TimesheetErrorEntity error : inputErrors) {
						oldInst.getInputErrors().add(error);
					}

					timesheetInputService.updateTimesheet(oldInst.getTimesheet());

				}
			}

			// turnover config

			Date refdate = new Date();
			float actual, progress, RTD, wkl, turnoverAmount, revto;
			
			for (TimesheetInputEntity input : timesheetInputService.getAllTimesheets(month)) {
				for (TimesheetInstanceEntity inst : input.getTimesheetInstances()) {
					if (inst.getInputErrors().isEmpty() && inst == getLatestinstance(input.getThirdParty())) {
						input.setCompleted(true);

						for (MissionEntity m : timesheetInputLineService.getMissionsByInstance(inst)) {

							TurnoverEntity turnover = new TurnoverEntity();
							
							if(validate(m.getMissionName(), turnoverService.getAllTurnovers())){
							   turnover = turnoverService.getTurnover(m);
							}
							
							MonthlyTurnoverEntity monthlyturnover = new MonthlyTurnoverEntity();
							
							monthlyturnover.setMonth(month);
							monthlyturnover.setReferenceDate(date);
							
							if (monthlyTurnoverService.getLatestMonthlyTurnover(month, m.getId()) != null) {
								monthlyturnover = monthlyTurnoverService.getLatestMonthlyTurnover(month, m.getId());
								RTD = monthlyturnover.getRealRTD();
								wkl = monthlyturnover.getTurnover().getRevisedWorkload();
								revto = monthlyturnover.getTurnover().getRevisedBudgetAmount();
								actual = monthlyturnover.getActual() + cumulatedActual(m.getTimesheetLines()) / 8;

							} else {
								actual = cumulatedActual(m.getTimesheetLines()) / 8;
								RTD = m.getWorkload();
								wkl = m.getWorkload();
								revto = m.getBudget();
							}

							if (actual + RTD < wkl) {
								progress = actual / wkl;
							} else
								progress = (wkl - RTD) / wkl;

							turnoverAmount = progress * revto;

							// setters
							monthlyturnover.setProgress(progress);
							monthlyturnover.setTurnoverAmount(turnoverAmount);
							monthlyturnover.setRealRTD(RTD);
							monthlyturnover.setActual(actual);
							monthlyturnover.setReferenceDate(refdate);
							// persistence
							turnover.setRevisedWorkload(wkl); 
							turnover.setRevisedBudgetAmount(revto);
							turnover.getMonthlyTurnovers().add(monthlyturnover);
							monthlyturnover.setTurnover(turnover);
							turnover.setMission(m);
							m.setTurnover(turnover);
							missionService.updateMission(m);

						}
						timesheetInputService.updateTimesheet(input);
					}

				}

			}

			addActionMessage("timesheet persisted into database succefully ! ");

		} catch (Exception e) {
			e.printStackTrace();
			addActionError("you have a problem with you upload !");
			return "timesheetUpload";
		}

		return SUCCESS;

	}

	public String historyThirdParty() throws ADPException {
		TimesheetInstanceEntity timesheetLatestInstance = new TimesheetInstanceEntity();
		contributor = thirdPartyService.getThirdPartyByName(thirdPartyName);
		timesheetLatestInstance = getLatestinstance(contributor);
		instances.add(timesheetLatestInstance);

		return SUCCESS;
	}

	private TimesheetInstanceEntity getLatestinstance(ThirdPartyEntity contributor) {
		TimesheetInstanceEntity timesheetLatestInstance = new TimesheetInstanceEntity();

		for (TimesheetInputEntity input : contributor.getTimesheetInputs()) {
			Date latest = null;
			for (TimesheetInstanceEntity inst : input.getTimesheetInstances()) {

				if (latest == null || inst.getImportDate().compareTo(latest) > 0) {
					latest = inst.getImportDate();
					timesheetLatestInstance = inst;
				}
			}
		}
		return timesheetLatestInstance;
	}


	public Set<TimesheetErrorEntity> Errors(ThirdPartyEntity thirdParty, Date workDate, float hours, MissionEntity m,
			TimesheetInstanceEntity inst) throws ADPException {

		Set<TimesheetErrorEntity> errors = new HashSet<TimesheetErrorEntity>();
		TimesheetErrorEntity error = new TimesheetErrorEntity();
		error.setTimesheetInstance(inst);
		// get startDate & endDate

		Date startDate = new Date();
		Date endDate = new Date();
		for (AffectationEntity aff : thirdParty.getAssociation()) {

			if (aff.getMission().getMissionName().equals(m.getMissionName())) {
				startDate = aff.getStartDate();
				endDate = aff.getEndDate();
			}

		}

		// timesheetError Constructor

		// 2. comparing period on mission to working date

		if (workDate.compareTo(startDate) * workDate.compareTo(endDate) > 0) {
			error.setErrorDescription("Mission " + m.getMissionName() + "  not allowed for thirdParty"
					+ thirdParty.getFullName() + " on date " + workDate);
			error.setErrorType("affectation TP - Mission");
			error.setPossibleSolution("configure contributors affectation periods ");
			errors.add(error);
		}
		
		// 3. nb hours < 8 for a working date
		if (hours < 8) {

			error = new TimesheetErrorEntity(
					"Hours number for mission " + m.getMissionName() + " is less than 8h for working Date" + workDate,
					"Hours Per Mission", "Rework issue ");
			error.setTimesheetInstance(inst);
			errors.add(error);

		}

		return errors;
	}

	public String sendErrors() throws ADPException {

		// EmailUtil Sender = new EmailUtil();
		// Sender.sendEmail(login, email, link);

		return SUCCESS;
	}

	public String viewReport() throws ParseException, ADPException {

		TimesheetInstanceEntity timesheetLatestInstance = new TimesheetInstanceEntity();

		try {
			if (selectedMonth.equals("0") && selectedProject.equals("0") && selectedTeam.equals("0")
					&& thirdPartyName.equals("0")) {

				addActionError("there is no timesheet for this filter ! ");
				return "timesheetShowReport";
			}

			else if (!thirdPartyName.equals("0")) {

				ThirdPartyEntity thirdParty = thirdPartyService.getThirdPartyByName(thirdPartyName);
				for (TimesheetInputEntity input : thirdParty.getTimesheetInputs()) {
					Date latest = null;
					if (input.getMonth() == Integer.parseInt(selectedMonth)) {
						for (TimesheetInstanceEntity inst : input.getTimesheetInstances()) {

							if (latest == null || inst.getImportDate().compareTo(latest) > 0) {
								latest = inst.getImportDate();
								timesheetLatestInstance = inst;
							}
						}
					} else if (selectedMonth.equals("0")) {
						for (TimesheetInstanceEntity inst : input.getTimesheetInstances()) {

							if (latest == null || inst.getImportDate().compareTo(latest) > 0) {
								latest = inst.getImportDate();
								timesheetLatestInstance = inst;
							}
						}
					}
				}

				instances.add(timesheetLatestInstance);
			}

			else if (!selectedTeam.equals("0") && thirdPartyName.equals("0")) {

				TeamEntity team = teamService.getTeamByName(selectedTeam);
				for (ThirdPartyEntity t : team.getEmployees()) {
					for (TimesheetInputEntity input : t.getTimesheetInputs()) {
						Date latest = null;
						for (TimesheetInstanceEntity inst : input.getTimesheetInstances()) {

							if (latest == null || inst.getImportDate().compareTo(latest) > 0) {
								latest = inst.getImportDate();
								timesheetLatestInstance = inst;
							}
						}
					}
					instances.add(timesheetLatestInstance);
				}
			}

			else if (!selectedProject.equals("0") && thirdPartyName.equals("0") && selectedTeam.equals("0")) {

				ProjectEntity p = projectService.getProjectByName(selectedProject);

				for (TeamEntity team : p.getTeams()) {
					for (ThirdPartyEntity t : team.getEmployees()) {
						for (TimesheetInputEntity input : t.getTimesheetInputs()) {
							Date latest = null;
							if (input.getProject().getProjectName().equals(selectedProject)) {
								for (TimesheetInstanceEntity inst : input.getTimesheetInstances()) {

									if (latest == null || inst.getImportDate().compareTo(latest) > 0) {
										latest = inst.getImportDate();
										timesheetLatestInstance = inst;
									}
								}
							}
						}
					}
					instances.add(timesheetLatestInstance);
				}
			}

			else if (!selectedMonth.equals("0")) {

				List<ThirdPartyEntity> list = thirdPartyService.getAllThirdParties();

				for (ThirdPartyEntity t : list) {

					for (TimesheetInputEntity input : t.getTimesheetInputs()) {
						Date latest = null;
						if (input.getMonth() == Integer.parseInt(selectedMonth)) {
							for (TimesheetInstanceEntity inst : input.getTimesheetInstances()) {

								if (latest == null || inst.getImportDate().compareTo(latest) > 0) {
									latest = inst.getImportDate();
									timesheetLatestInstance = inst;
								}
							}
						}
					}
					instances.add(timesheetLatestInstance);
				}

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return SUCCESS;

	}

	public String showReport() throws ADPException {
		timesheets = timesheetInputService.getAllTimesheetsByDistinctMonth();
		teams = teamService.getAllTeams();
		thirdParties = thirdPartyService.getAllThirdParties();

		return SUCCESS;
	}

	public boolean exist(MissionEntity m, Set<AffectationEntity> assoc) {

		boolean contains = false;
		for (AffectationEntity aff : assoc) {
			if (aff.getMission().getMissionName().equals(m.getMissionName())) {
				contains = true;
				break;
			}
		}

		return contains;

	}

	public boolean valid(int m, Set<TimesheetInputEntity> assoc) {

		boolean contains = false;
		for (TimesheetInputEntity aff : assoc) {
			if (aff.getMonth() == m) {
				contains = true;
				break;
			}
		}

		return contains;

	}

	public boolean validate(String m, List<TurnoverEntity> assoc) {

		boolean contains = false;
		for (TurnoverEntity aff : assoc) {
			if (aff.getMission().getMissionName().equals(m)) {
				contains = true;
				break;
			}
		}

		return contains;

	}

	public boolean verif(String m, Set<TimesheetInputLineEntity> assoc) {

		boolean contains = false;
		for (TimesheetInputLineEntity line : assoc) {
			if (line.getContributorName().equals(m)) {

				contains = true;
				break;
			}
		}

		return contains;

	}

	public TimesheetInputLineEntity search(String nom, Set<TimesheetInputLineEntity> lines) {

		TimesheetInputLineEntity result = new TimesheetInputLineEntity();

		for (TimesheetInputLineEntity line : lines) {

			if (line.getContributorName().equals(nom)) {
				result = line;
				break;
			}
		}
		return result;

	}

	public TimesheetInputEntity check(String nom, int m, Set<TimesheetInputEntity> inputs) {

		TimesheetInputEntity result = new TimesheetInputEntity();

		for (TimesheetInputEntity input : inputs) {
			String fullName = input.getThirdParty().getFirstName() + " " + input.getThirdParty().getLastName();
			if (input.getMonth() == m && fullName.equals(nom)) {
				result = input;
				break;
			}
		}
		return result;

	}

	public boolean isBusinessDay(Calendar cal) {

		// verifier si weekend
		if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
			return false;
		}

		// verifier si c est le jour de nouvel an
		if (cal.get(Calendar.MONTH) == Calendar.JANUARY && cal.get(Calendar.DAY_OF_MONTH) == 1) {
			return false;
		}

		// verifier si c est le jour de révolution
		if (cal.get(Calendar.MONTH) == Calendar.JANUARY && cal.get(Calendar.DAY_OF_MONTH) == 14) {
			return false;
		}

		// verifier si c est la fête de l'Indépendance :
		if (cal.get(Calendar.MONTH) == Calendar.MARCH && cal.get(Calendar.DAY_OF_MONTH) == 20) {
			return false;
		}
		// verifier si c est la journée des Martyrs :
		if (cal.get(Calendar.MONTH) == Calendar.APRIL && cal.get(Calendar.DAY_OF_MONTH) == 9) {
			return false;
		}

		// verifier si c est la fête du travail :
		if (cal.get(Calendar.MONTH) == Calendar.MAY && cal.get(Calendar.DAY_OF_MONTH) == 1) {
			return false;
		}
		// verifier si c est la fête de la République :
		if (cal.get(Calendar.MONTH) == Calendar.JULY && cal.get(Calendar.DAY_OF_MONTH) == 25) {
			return false;
		}

		// verifier si c est la fête de la femme et la famille :
		if (cal.get(Calendar.MONTH) == Calendar.AUGUST && cal.get(Calendar.DAY_OF_MONTH) == 13) {
			return false;
		}
		// verifier si c est la fête de la femme et la famille :
		if (cal.get(Calendar.MONTH) == Calendar.AUGUST && cal.get(Calendar.DAY_OF_MONTH) == 13) {
			return false;
		}

		// verifier si c est la fête de l'Évacuation :
		if (cal.get(Calendar.MONTH) == Calendar.OCTOBER && cal.get(Calendar.DAY_OF_MONTH) == 15) {
			return false;
		}

		// sinon => workin day
		return true;
	}

	public float cumulatedActual(Set<TimesheetInputLineEntity> list) {
		float actual = 0;
		for (TimesheetInputLineEntity line : list) {
			actual = actual + line.getHours();
		}

		return actual;
	}

}
