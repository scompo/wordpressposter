/**
 * TestBlogInfo.java
 */
package org.scompo.wordpressposter.tests.models;

import static org.junit.Assert.*;

import java.util.List;

import it.scompo.wordpressposter.models.BlogInfo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * tests for {@link BlogInfo}.
 * 
 * @author mscomparin
 * @version 1.0
 */
public class TestBlogInfo {

	BlogInfo info;
	
	private String username = "user";
	private String password = "pass";
	private Integer blogId = 1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		info = new BlogInfo(username, password, blogId);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		info = null;
	}

	/**
	 * Test method for {@link it.scompo.wordpressposter.models.BlogInfo#getData()}.
	 */
	@Test
	public void testGetData() {
		List<Object> data = info.getData();
		assertEquals(blogId, data.get(0));
		assertEquals(username, data.get(1));
		assertEquals(password, data.get(2));
	}

}
