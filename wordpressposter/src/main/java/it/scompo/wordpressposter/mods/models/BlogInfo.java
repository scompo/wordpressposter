/**
 * BlogInfo.java
 */
package it.scompo.wordpressposter.mods.models;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Implements a wordpress {@link BlogInfo}.
 * 
 * @author mscomparin
 * @version 1.0
 */
public class BlogInfo{

	private static final Logger logger = LogManager.getLogger(BlogInfo.class);
	
	/**
	 * The blog username. 
	 */
	private String username;
	
	/**
	 * The blog password. 
	 */
	private String password;
	
	/**
	 * The blog id. 
	 */
	private Integer blogId;
	
	/**
	 * Creates a {@link BlogInfo}.
	 * 
	 * @param username
	 * @param password
	 * @param blogId
	 */
	public BlogInfo(String username, String password, Integer blogId) {
		this.username = username;
		this.password = password;
		this.blogId = blogId;
	}
	
	/**
	 * Gets the username.
	 *
	 * @return the username.
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * Sets username.
	 *
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * Gets the password.
	 *
	 * @return the password.
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Sets password.
	 *
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Gets the blogId.
	 *
	 * @return the blogId.
	 */
	public Integer getBlogId() {
		return blogId;
	}
	
	/**
	 * Sets blogId.
	 *
	 * @param blogId the blogId to set
	 */
	public void setBlogId(Integer blogId) {
		this.blogId = blogId;
	}

	/**
	 * Get the data ready to be sendt.
	 * 
	 * @return the data ready to be sendt.
	 */
	public List<Object> getData(){
		List<Object> data = new ArrayList<Object>();
		data.add(blogId);
		data.add(username);
		data.add(password);
		//logger.debug("Returning :" + data);
		return data;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BlogInfo [username=" + username + ", password=" + password
				+ ", blogId=" + blogId + "]";
	}
}
