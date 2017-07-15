/**
 * 
 */
package com.adp.utils;

import java.util.Collection;

/**
 * @author M.BENAMOR
 *
 */
public class CollectionsUtil {

	public static boolean isEmpty(Collection<?> col){
		if(col == null) return true;
		else return col.isEmpty();
	}
	
	public static boolean isNotEmpty(Collection<?> col){
		return !isEmpty(col);
	}
}
