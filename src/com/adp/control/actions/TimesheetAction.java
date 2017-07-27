package com.adp.control.actions;


import java.io.File;
import java.io.FileInputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
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
import com.adp.entities.AffectationEntity;
import com.adp.entities.FunctionEntity;
import com.adp.entities.MissionEntity;
import com.adp.entities.ProjectEntity;
import com.adp.entities.ThirdPartyEntity;
import com.adp.entities.TimesheetInputEntity;
import com.adp.entities.TimesheetInputLineEntity;
import com.adp.entities.TimesheetInstanceEntity;
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
	
	private TimesheetInstanceEntity timesheetLatestInstance ;
	
	private String selectedProject ;
	
	private TimesheetInputEntity timesheetInput ;
	
	private List<ProjectEntity> projects = new ArrayList<ProjectEntity>();
		
	private String selectedMonth ;
	
	private List<TimesheetInputEntity> timesheets ;
	
	
	public TimesheetInstanceEntity getTimesheetLatestInstance() {
		return timesheetLatestInstance;
	}
	public void setTimesheetLatestInstance(TimesheetInstanceEntity timesheetLatestInstance) {
		this.timesheetLatestInstance = timesheetLatestInstance;
	}
	public TimesheetInputEntity getTimesheetInput() {
		return timesheetInput;
	}
	public void setTimesheetInput(TimesheetInputEntity timesheetInput) {
		this.timesheetInput = timesheetInput;
	}
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
			 
			 TimesheetInstanceEntity instance = new TimesheetInstanceEntity(new Date()) ;
			Set<TimesheetInputLineEntity> inputLines = new HashSet<TimesheetInputLineEntity>();
		//	Set<TimesheetErrorEntity> inputErrors = new HashSet<TimesheetErrorEntity>();
	        FileInputStream file = new FileInputStream(timesheet);
	        Workbook wb = WorkbookFactory.create(file);
	        Sheet sheet = wb.getSheetAt(0);
	        
	        // get month
	        Row r = sheet.getRow(1);
			Date date= r.getCell(9).getDateCellValue();
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			int month = cal.get(Calendar.MONTH)+1;
			timesheetInput = new TimesheetInputEntity(month, false) ;
	        timesheetInput.setProject(projectService.getProjectByName(selectedProject));
	        
	        
	        //int nbHours = 0 ;
	        
			//timesheet parse
	        for (int i = 1; i <= sheet.getLastRowNum() ; i++) {
		           
	        	Row row = sheet.getRow(i);
				            
		   //timesheetLine constructor
	        	Date workDate =  row.getCell(9).getDateCellValue() ; 
	        	Float hoursByDay = Float.parseFloat(formatter.formatCellValue(row.getCell(11))) ;
	        	String comment =  formatter.formatCellValue(row.getCell(13));
	        	
            TimesheetInputLineEntity line = new TimesheetInputLineEntity(workDate,comment,hoursByDay);
            
            ThirdPartyEntity thirdParty = thirdPartyService.getThirdPartyByName(row.getCell(0).getStringCellValue());
            MissionEntity m = missionService.getMissionByName(formatter.formatCellValue(row.getCell(4))) ;
            FunctionEntity f = functionService.getFunctionsByName(formatter.formatCellValue(row.getCell(8)));
            
            line.setHumanRessource(thirdParty);
	        line.setMission(m);
	        line.setFunction(f);
	        line.setTimesheetInstance(instance);
	        
	        
	        /*  	        
	        // get startDate & endDate
		        
		        Date startDate = new Date();
		        Date endDate = new Date() ;

		        for( AffectationEntity aff  :  thirdParty.getAssociation() ) {
	    			
	    			if(aff.getMission().getMissionName().equals(m.getMissionName())){
	    				startDate = aff.getStartDate() ;
	    				endDate = aff.getEndDate() ;
	    			}
	    			
	    		}
	      
	       //timesheetError Consctructor
	        		
	        	//1. affectation not exist 
	    		
	        		if (!exist(m, thirdParty.getAssociation())) {
	        			TimesheetErrorEntity error = new TimesheetErrorEntity("Mission not conform with affectation config", "affectation TP - Mission", "configure contributors ' affectations ");
	        			inputErrors.add(error);
	        		}
	        		
	        		
	        	//2. comparing period on mission to working date 	
	        		
	        		else if(workDate.compareTo(startDate) * workDate.compareTo(endDate) > 0) {
	        			TimesheetErrorEntity error = new TimesheetErrorEntity("Mission "+m+"  not allowed for thirdParty on date "+workDate, "affectation TP - Mission", "configure contributors ' affectation periods ");
	        			inputErrors.add(error);
	        		}
	        	//3. hours number comparing to 8 by mission	
	        		
	        		else if(nbHours < 8){
	        			
	        			TimesheetErrorEntity error = new TimesheetErrorEntity("Hours number on mission "+m+" is less than 8h", "Hours Per Mission", "Rework issue ");
	        			inputErrors.add(error);
	        			
	        		} 
	        		
	       //timesheetInput Constructor 
	        		else 
	        */	
	        
				    inputLines.add(line);
	          }
	       
	        //persist into database
	        	instance.setInputLines(inputLines);
	        	instance.setTimesheet(timesheetInput);
	        	timesheetInput.getTimesheetInstances().add(instance);
	        	timesheetService.addTimesheet(timesheetInput);
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
			timesheetInput= timesheetService.getTimesheetByMonth(Integer.parseInt(selectedMonth));
			
			Date latest = null ;
			timesheetLatestInstance = null;
				for (TimesheetInstanceEntity inst : timesheetInput.getTimesheetInstances()){
					if(latest == null || inst.getDateImport().compareTo(latest) > 0 ){
						latest=inst.getDateImport() ;
						timesheetLatestInstance = inst ;
					}
				}
			
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
	public boolean exist(MissionEntity m , Set<AffectationEntity> assoc) {
		
		Iterator<AffectationEntity> i = assoc.iterator() ;
		AffectationEntity aff = new AffectationEntity();

		boolean verif =false ;
		
		do
		{	
			if(i.hasNext() & !aff.getMission().getMissionName().equals(m.getMissionName())) 
			 {
				aff = i.next() ;
				verif=false ;
			 }
			else {
			 verif = true ;
			}
		}
		while(verif= false);
		
		return verif ;	
	}
	
	
		
	
}
	
	


