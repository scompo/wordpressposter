package org.scompo.wordpressposter.tests.models;

import static org.junit.Assert.*;
import it.scompo.wordpressposter.mods.PageCreator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestIterator {

	PageCreator c;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		c= new PageCreator("/home/mscomparin/Desktop/Senza nome 1.html");
	}

}
