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

import javax.servlet.ServletContext;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.struts2.util.ServletContextAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.adp.business.services.FunctionService;
import com.adp.business.services.MissionService;
import com.adp.business.services.ProjectService;
import com.adp.business.services.ThirdPartyService;
import com.adp.business.services.TimesheetService;
import com.adp.entities.ProjectEntity;
import com.adp.entities.TimesheetInputEntity;
import com.adp.entities.TimesheetInputLineEntity;
import com.adp.exceptions.ADPException;
import com.opensymphony.xwork2.ActionSupport;

public class TimesheetAction extends ActionSupport implements ServletContextAware{

	private static final long serialVersionUID = -4748500436762141116L;
	
	@Autowired
	ThirdPartyService thirdPartyService;
	
	@Autowired
	ProjectService projectService ;
	
	@Autowired
	MissionService missionService ;
	
	@Autowired
	FunctionService functionService ;
	
	@Autowired
	TimesheetService timesheetService ;

	private File timesheet;
	
	private String selectedProject ;
	
	private TimesheetInputEntity t ;
	
	private List<ProjectEntity> projects = new ArrayList<ProjectEntity>();
		
	private String selectedMonth ;
	
	private List<TimesheetInputEntity> timesheets ;
	
	
	public String getSelectedProject() {
		return selectedProject;
	}
	public void setSelectedProject(String selectedProject) {
		this.selectedProject = selectedProject;
	}
	public List<ProjectEntity> getProjects() {
		return projects;
	}
	public void setProjects(List<ProjectEntity> projects) {
		this.projects = projects;
	}
	public List<TimesheetInputEntity> getTimesheets() {
		return timesheets;
	}
	public void setTimesheets(List<TimesheetInputEntity> timesheets) {
		this.timesheets = timesheets;
	}
	
	
	public String getSelectedMonth() {
		return selectedMonth;
	}
	public void setSelectedMonth(String selectedMonth) {
		this.selectedMonth = selectedMonth;
	}
	public TimesheetInputEntity getT() {
		return t;
	}
	public void setT(TimesheetInputEntity t) {
		this.t = t;
	}
	public File getTimesheet() {
		return timesheet;
	}
	public void setTimesheet(File timesheet) {
		this.timesheet = timesheet;
	}

	public String upload() throws ADPException{
		projects = projectService.getAllProjects();
		return SUCCESS ;
	}
	public String doUpload(){
		try 
	       {
			DataFormatter formatter = new DataFormatter();
			//DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			 t = new TimesheetInputEntity() ;
			Set<TimesheetInputLineEntity> inputLines = new HashSet<TimesheetInputLineEntity>();
	        FileInputStream file = new FileInputStream(timesheet);
	        Workbook wb = WorkbookFactory.create(file);
	        Sheet sheet = wb.getSheetAt(0);
	        
	        // get month
	        Row r = sheet.getRow(1);
			Date date= r.getCell(9).getDateCellValue();
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			int month = cal.get(Calendar.MONTH);
			t.setMonth(month+1);
			t.setCompleted(false);
	        t.setProject(projectService.getProjectByName(selectedProject));
	        
			//timesheet parse
	        for (int i = 1; i <= sheet.getLastRowNum() ; i++) {
		           
	        	Row row = sheet.getRow(i);
				            
		   //timesheetLine constructor
            TimesheetInputLineEntity line = new TimesheetInputLineEntity(
            row.getCell(9).getDateCellValue(),
	        formatter.formatCellValue(row.getCell(13)),
	        Float.parseFloat(formatter.formatCellValue(row.getCell(11)))
	        );
            
            line.setHumanRessource(thirdPartyService.getThirdPartyByName(row.getCell(0).getStringCellValue()));
	        line.setMission(missionService.getMissionByName(formatter.formatCellValue(row.getCell(4))));
	        line.setFunction(functionService.getFunctionsByName(formatter.formatCellValue(row.getCell(8))));
	        line.setTimesheet(t);
				        
			        //timesheetInput Constructor
				        inputLines.add(line);
	          }
	       
	        //persist into database
	        	t.setInputLines(inputLines);	
	        	timesheetService.addTimesheet(t);
		         addActionMessage("timesheet persisted into database succefully ! ");   
		        } catch (Exception e) {
		            e.printStackTrace();
		            addActionError("you have a problem with you upload !");
		            return "timesheetUpload";
		        }
			
			return SUCCESS ;
		
	}
	
	public String showReport() throws ADPException {
		timesheets = timesheetService.getAllTimesheets();
		return SUCCESS ;
	}
	
	public String viewReport() throws ParseException, ADPException {
		
		
		try {
			t= timesheetService.getTimesheetByMonth(Integer.parseInt(selectedMonth));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			addActionError("there is no timesheet for this month ! ");
			return "timesheetUpload" ;
			
		}
		
		
		return SUCCESS ;
	}
	
	@Override
	public void setServletContext(ServletContext arg0) {
		// TODO Auto-generated method stub
		
	}

	

}
	
	


