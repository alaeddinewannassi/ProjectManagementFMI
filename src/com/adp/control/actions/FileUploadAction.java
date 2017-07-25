package com.adp.control.actions;


import java.io.File;
import java.io.FileInputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
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
import com.adp.business.services.ThirdPartyService;
import com.adp.business.services.TimesheetService;
import com.adp.entities.TimesheetInputEntity;
import com.adp.entities.TimesheetInputLineEntity;
import com.opensymphony.xwork2.ActionSupport;

public class FileUploadAction extends ActionSupport implements ServletContextAware{

	private static final long serialVersionUID = -4748500436762141116L;
	
	@Autowired
	ThirdPartyService thirdPartyService;
	
	@Autowired
	MissionService missionService ;
	
	@Autowired
	FunctionService functionService ;
	
	@Autowired
	TimesheetService timesheetService ;

	private File timesheet;
	

	

	public File getTimesheet() {
		return timesheet;
	}
	public void setTimesheet(File timesheet) {
		this.timesheet = timesheet;
	}

	public String upload(){
		
		return SUCCESS ;
	}
	public String doUpload(){
		try 
	       {
			//DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			DataFormatter formatter = new DataFormatter();
			Date date= new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			int month = cal.get(Calendar.MONTH);
			TimesheetInputEntity bdt = new TimesheetInputEntity(month,false) ;
			Set<TimesheetInputLineEntity> inputLines = new HashSet<TimesheetInputLineEntity>();
	        FileInputStream file = new FileInputStream(timesheet);
	        Workbook wb = WorkbookFactory.create(file);
	        Sheet sheet = wb.getSheetAt(0);
	        for (int i = 1; i <= sheet.getLastRowNum() ; i++) {
		           
	        	Row row = sheet.getRow(i);
				            
		            //timesheetLine constructor
			            TimesheetInputLineEntity line = new TimesheetInputLineEntity(
			            row.getCell(9).getDateCellValue(),
				        formatter.formatCellValue(row.getCell(13)),
				        Float.parseFloat(formatter.formatCellValue(row.getCell(11)))
				        );
			            
			            line.setHumanRessource(thirdPartyService.getThirdParty(Long.parseLong(formatter.formatCellValue(row.getCell(0)))));
				        line.setMission(missionService.getMissionByName(formatter.formatCellValue(row.getCell(4))));
				        line.setFunction(functionService.getFunctionsByName(formatter.formatCellValue(row.getCell(8))));
				        line.setTimesheet(bdt);
				        
			        //timesheetInput Constructor
				        inputLines.add(line);
	          }
	       
	        //persist into database
	        	bdt.setInputLines(inputLines);	
	        	timesheetService.addTimesheet(bdt);
		         addActionMessage("timesheet persisted into database succefully ! ");   
		        } catch (Exception e) {
		            e.printStackTrace();
		            addActionError("you have a problem with you upload !");
		            return "timesheetUpload";
		        }
			
			return SUCCESS ;
		
	}
	
	
	@Override
	public void setServletContext(ServletContext arg0) {
		// TODO Auto-generated method stub
		
	}

	

}
	
	


