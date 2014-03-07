/**
 * Post.java
 */
package it.scompo.wordpressposter.mods.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Implement a wordpress {@link Post}.
 * 
 * @author mscomparin
 * @version 1.0
 */
public class Post {
	
	private static final Logger logger = LogManager.getLogger(Post.class);
	
	/**
	 * Blog info to send.
	 */
	private BlogInfo info;
	
	/**
	 * The post author. 
	 */
	private Integer postAuthor;
	
	/**
	 * The post title. 
	 */
	private String postTitle;
	
	/**
	 * The status 
	 */
	private String postStatus;
	
	/**
	 * The Content.
	 */
	private String postContent;
	
	/**
	 * Creates a new {@link Post}. 
	 */
	public Post() {
	}

	/**
	 * Creates a new {@link Post}. 
	 * 
	 * @param info
	 * @param postAuthor
	 * @param postTitle
	 * @param postStatus
	 * @param postContent
	 */
	public Post(BlogInfo info, Integer postAuthor, String postTitle,
			String postStatus, String postContent) {
		super();
		this.info = info;
		this.postAuthor = postAuthor;
		this.postTitle = postTitle;
		this.postStatus = postStatus;
		this.postContent = postContent;
	}
	
	public List<Object> getData(){
		//logger.info("Called getData");
		List<Object> res = info.getData();
		Map<Object, Object> data = new HashMap<Object, Object>();
		data.put(Constants.NAME_POST_AUTHOR, postAuthor);
		data.put(Constants.NAME_POST_STATUS, postStatus);
		data.put(Constants.NAME_POST_TITLE, postTitle);
		data.put(Constants.NAME_POST_CONTENT, postContent);
		res.add(data);
		//logger.debug("returning " +res);
		return res;
	}

	/**
	 * Gets the postAuthor.
	 *
	 * @return the postAuthor.
	 */
	public Integer getPostAuthor() {
		return postAuthor;
	}

	/**
	 * Gets the info.
	 *
	 * @return the info.
	 */
	public BlogInfo getInfo() {
		return info;
	}

	/**
	 * Sets info.
	 *
	 * @param info the info to set
	 */
	public void setInfo(BlogInfo info) {
		this.info = info;
	}

	/**
	 * Sets postAuthor.
	 *
	 * @param postAuthor the postAuthor to set
	 */
	public void setPostAuthor(Integer postAuthor) {
		this.postAuthor = postAuthor;
	}

	/**
	 * Gets the postTitle.
	 *
	 * @return the postTitle.
	 */
	public String getPostTitle() {
		return postTitle;
	}

	/**
	 * Sets postTitle.
	 *
	 * @param postTitle the postTitle to set
	 */
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	/**
	 * Gets the postStatus.
	 *
	 * @return the postStatus.
	 */
	public String getPostStatus() {
		return postStatus;
	}

	/**
	 * Sets postStatus.
	 *
	 * @param postStatus the postStatus to set
	 */
	public void setPostStatus(String postStatus) {
		this.postStatus = postStatus;
	}

	/**
	 * Gets the postContent.
	 *
	 * @return the postContent.
	 */
	public String getPostContent() {
		return postContent;
	}

	/**
	 * Sets postContent.
	 *
	 * @param postContent the postContent to set
	 */
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Post [info=" + info + ", postAuthor=" + postAuthor
				+ ", postTitle=" + postTitle + ", postStatus=" + postStatus
				+ ", postContent=" + postContent + "]";
	}

}
