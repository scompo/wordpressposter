/**
 * TestPost.java
 */
package org.scompo.wordpressposter.tests.models;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import it.scompo.wordpressposter.mods.models.BlogInfo;
import it.scompo.wordpressposter.mods.models.Constants;
import it.scompo.wordpressposter.mods.models.Post;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * tests for {@link Post}.
 * 
 * @author mscomparin
 * @version 1.0
 */
public class TestPost {
	
	private static final Integer postAuthor = 1;
	private static final String postTitle = "title";
	private static final String postStatus = "published";
	private static final String postContent = "testContent";
	
	private String username = "user";
	private String password = "pass";
	private Integer blogId = 1;
	
	private BlogInfo blogInfo;
	private Post post;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		blogInfo = new BlogInfo(username, password, blogId);
		post = new Post(blogInfo, postAuthor, postTitle, postStatus, postContent);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		blogInfo = null;
		post = null;
	}

	/**
	 * Test method for {@link it.scompo.wordpressposter.mods.models.Post#getData()}.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testGetData() {
		List<Object> data = post.getData();
		Map<Object, Object> postData = (Map<Object, Object>) data.get(3);
		assertEquals(postAuthor,postData.get(Constants.NAME_POST_AUTHOR));
		assertEquals(postTitle, postData.get(Constants.NAME_POST_TITLE));
		assertEquals(postStatus, postData.get(Constants.NAME_POST_STATUS));
		assertEquals(postContent, postData.get(Constants.NAME_POST_CONTENT));
	}

}
