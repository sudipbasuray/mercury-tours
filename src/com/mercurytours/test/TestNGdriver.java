package com.mercurytours.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGdriver {
	
	methods m1 =new methods();
	
	@BeforeMethod
	public void browserapplaunch() throws InterruptedException
	{
		m1.applaunch();
	}
	
	/*
	 * validating valid credentials
	 */
	@Test
	public void verifyValidLogin() throws InterruptedException
	{
		m1.login(); /* performing login operation */
		m1.verifyValidLogin(); /* validating successful login */
	}

	@AfterMethod
	public void appclose()
	{
		m1.appclose();
	}
}
