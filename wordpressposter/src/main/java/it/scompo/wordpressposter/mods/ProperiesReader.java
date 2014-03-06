/**
 * ProperiesReader.java
 */
package it.scompo.wordpressposter.mods;

import java.util.ResourceBundle;

/**
 * Read Properies from a file.
 * 
 * @author mscomparin
 * @version 1.0
 */
public class ProperiesReader {
	
	/**
	 * private resource bounde. 
	 */
	private static ResourceBundle rb;
		
	/**
	 * Empty constructor.
	 * 
	 * @param name The name of the properties file to open.
	 */
	public ProperiesReader(String name) {
		rb = ResourceBundle.getBundle(name);
	}
	
	/**
	 * Get the resource from key.
	 * 
	 * @param key
	 * @return
	 */
	public String getValue(String key){
		return rb.getString(key);
	}
}
