package com.Finacus.Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.Finacus.BusinessLogic.Finacus_BusinessLogicIMPS;
import com.Finacus.InitialSetup.Driver_Setup;
import com.Finacus.Utilities.Log;


/**
 * Test case developed for Verifying the Modules Title.
 * @author parmeshwar sakole
 * 
 */
public class TC_PP_NetBanking_errorValidtion extends Driver_Setup{
	public static WebDriver webDriver = null;
	public static String tcID = null;
	
	//Business Logic Class Object list	
	@Test(priority=1)
	public void setup()
	{
		Log.info("Setup the variable for Test");
		webDriver = driver; 
		tcID = TC_ID;
		Log.info("Setup completed for the variable");
	}
	@Test(priority = 2)
	public void TC_TestCaseName() throws Throwable {
		try {
			Log.info("Script Starts..");
			Finacus_BusinessLogicIMPS AirPay_Local = new Finacus_BusinessLogicIMPS(driver, TC_ID);
				AirPay_Local.LocalHostDetailPage();	
				AirPay_Local.Card_Details_Options();
				//AirPay_Local.Select_Bank_DropDown_Selection();
				AirPay_Local.NetBanking_Makepaymentbtn();
				AirPay_Local.NetbankingErrDropDropRedLine();
			Log.info("Scripts Ends....");
		} catch (Exception e) {
			Log.error(e.getMessage());
			System.out.println(e);
		}
	}
	@AfterTest
	public void tearDown()
	{
		if(webDriver != null)
			webDriver.close();
	}
}