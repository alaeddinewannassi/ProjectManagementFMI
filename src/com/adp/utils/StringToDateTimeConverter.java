package com.adp.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.struts2.util.StrutsTypeConverter;

import com.opensymphony.xwork2.conversion.TypeConversionException;

public class StringToDateTimeConverter extends StrutsTypeConverter {
    // WARNING not safe in multi-threaded environments
    private static final DateFormat DATETIME_FORMAT = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss");

    
	@SuppressWarnings("rawtypes")
	@Override
	public Object convertFromString(java.util.Map arg0, String[] arg1, Class arg2) {
		if (arg1 == null || arg1.length == 0 || arg1[0].trim().length() == 0) {
            return null;
        }

        try {
            return DATETIME_FORMAT.parse(arg1[0]);
        } catch (ParseException e) {
            throw new TypeConversionException("Unable to convert given object to date: " + arg1[0]);
        }
	}

	@SuppressWarnings("rawtypes")
	@Override
	public String convertToString(java.util.Map arg0, Object arg1) {
		  if (arg1 != null && arg1 instanceof Date) {         
	            return DATETIME_FORMAT.format(arg1);
	        } else {
	            return null;
	        }
	}
}