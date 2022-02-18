package com.rmgyantra.genericUtility;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

public class BaseAPIClass {
	
	public DataBaseUtility dUtil=new DataBaseUtility();
	
	@BeforeTest
	
	public void connectDB() throws Throwable {
		dUtil.connectToDataBase();
		
	}
	
	@AfterClass
	
	public void closeDB() throws Throwable {
		
		dUtil.closeConnection();
	}

}
