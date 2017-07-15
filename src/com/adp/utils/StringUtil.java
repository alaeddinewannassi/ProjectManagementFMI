package com.adp.utils;

import java.io.UnsupportedEncodingException;

import org.apache.commons.lang.StringUtils;

public class StringUtil {
	
	 public static String convertEncoding(String pText, String pFromEncoding, String pToEncoding) {
	        if (StringUtils.isBlank(pText)) {
	            return pText;
	        }

	        if (StringUtils.isBlank(pFromEncoding)) {
	        	pFromEncoding = "UTF-8";
	        }

	        if (StringUtils.isBlank(pToEncoding)) {
	        	pToEncoding = "UTF-8";
	        }

	        try {
	        	pText = new String(pText.getBytes(pFromEncoding), pToEncoding);
	        } catch (UnsupportedEncodingException e) {
	        }

	        return pText;
	}
	 
	 public static boolean isEmpty(String pString){
		 return pString == null || pString.length() == 0;
	 }
	 
	 public static boolean isNotEmpty(String pString){
		 return !isEmpty(pString);
	 }

	 public static String getHTMLStringFromString(String pString){
		 if(pString==null)
			 return new String();
		 pString = pString.replace("\n", "<BR/>");
		 pString = pString.replace("é", "&eacute;");
		 pString = pString.replace("è", "&egrave;");
		 pString = pString.replace("ê", "&ecirc;");
		 pString = pString.replace("ç", "&ccedil;");
		 pString = pString.replace("à", "&agrave;");
		 pString = pString.replace("ô", "&ocirc;");
		 pString = pString.replace("É", "&Eacute;");
		 pString = pString.replace("î", "&icirc;");
		 return pString;
	 }
	 
	 public static String getStringFromHTMLString(String pHTMLString){
		 if(pHTMLString==null)
			 return new String();
		 pHTMLString = pHTMLString.replace("<BR/>", "");
		 pHTMLString = pHTMLString.replace("&eacute;","é");
		 pHTMLString = pHTMLString.replace("&egrave;","è");
		 pHTMLString = pHTMLString.replace("&ecirc;","ê");
		 pHTMLString = pHTMLString.replace("&ccedil;","ç");
		 pHTMLString = pHTMLString.replace("&agrave;","à");
		 pHTMLString = pHTMLString.replace("&ocirc;","ô");
		 pHTMLString = pHTMLString.replace("&Eacute;","É");
		 pHTMLString = pHTMLString.replace("&icirc;", "î");
		 return pHTMLString;
	 }
}
