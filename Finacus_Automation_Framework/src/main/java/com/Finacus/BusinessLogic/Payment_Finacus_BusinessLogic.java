package com.Finacus.BusinessLogic;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.Finacus.PageObject.Finacus_PaymentPage_PageObject;
import com.Finacus.Reporting.Extent_Reporting;
import com.Finacus.TestData.Excel_Handling;
import com.Finacus.Utilities.ElementAction;
import com.Finacus.Utilities.Log;

public class Payment_Finacus_BusinessLogic extends Finacus_PaymentPage_PageObject {
	

	public WebDriver driver;
	public String TC_ID = "";
	ElementAction Assert = new ElementAction();
	Log log = new Log();	
	public Payment_Finacus_BusinessLogic(WebDriver driver, String TC_ID)
	{
		this.driver = driver;
		this.TC_ID=TC_ID;
		log = new Log();
	}
	
	
	
	public void Debit_cardholderNameCopyPaste() throws Throwable{
		try
		{		   		   
			Assert.inputText(driver, DebitCardNoInput, Excel_Handling.Get_Data(TC_ID, "InvalidCardNumber").trim(), "Debit card Number input field");
			WebElement HolderName=driver.findElement(By.xpath(DebitCardHolderName));
			HolderName.click();			
			Robot robot = new Robot();
			String str = "par()>>";
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			Clipboard clipboard = toolkit.getSystemClipboard();
			StringSelection strSel = new StringSelection(str);
			clipboard.setContents(strSel, null);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			
			

			//Assert.inputTextPaste(driver, DebitCardHolderName, "Debit card Holder Name Field");		   
			Assert.inputText(driver, DebitCardExpDate,Excel_Handling.Get_Data(TC_ID, "CardExpDate").trim(), "Debit card Number Exp Date");
			Assert.inputText(driver, DebitCardCVVCode,Excel_Handling.Get_Data(TC_ID, "CardCVVCode").trim(), "Debit card Number CVVCode");
			Assert.Clickbtn(driver, DebitCardMakePaymtBtn, "Debit Card make payment button");
			Extent_Reporting.Log_report_img("Details has been Entered", "Passed", driver);

		}
		
			catch(Exception e)	
		{
			Extent_Reporting.Log_Fail("Some fields are not disp", "Failed", driver);   
			Log.error("Test failed due to page is navigating to payment page");
			e.printStackTrace();
			throw new Exception("Test failed due to local host page not displayed");
		}
	}
	
	
	public void Debit_cardProvidingValues() throws Exception{
		try{		   		   
			Assert.inputText(driver, DebitCardNoInput, Excel_Handling.Get_Data(TC_ID, "InvalidCardNumber").trim(), "Debit card Number input field");
			//Assert.inputText(driver, DebitCardNoInput, "9809808!13", "Debit card Number input field");

			Assert.inputText(driver, DebitCardHolderName,Excel_Handling.Get_Data(TC_ID, "CardHolderName").trim(), "Debit card Holder Name Field");		   
			Assert.inputText(driver, DebitCardExpDate,Excel_Handling.Get_Data(TC_ID, "CardExpDate").trim(), "Debit card Number Exp Date");
			Assert.inputText(driver, DebitCardCVVCode,Excel_Handling.Get_Data(TC_ID, "CardCVVCode").trim(), "Debit card Number CVVCode");
			Assert.Clickbtn(driver, DebitCardMakePaymtBtn, "Debit Card make payment button");		   

		}catch(Exception e)	
		{
			Extent_Reporting.Log_Fail("Some fields are not disp", "Failed", driver);   
			Log.error("Test failed due to page is navigating to payment page");
			e.printStackTrace();
			throw new Exception("Test failed due to local host page not displayed");
		}
	}


	public void Debit_cardProvidingValues_withHolderName() throws Exception{
		try{		   		   
			Assert.inputText(driver, DebitCardNoInput, Excel_Handling.Get_Data(TC_ID, "ValidCardNumber").trim(), "Debit card Number input field");
			Assert.inputText(driver, DebitCardHolderName,Excel_Handling.Get_Data(TC_ID, "CardHolderName").trim(), "Debit card Holder Name Field");		   
			Assert.inputText(driver, DebitCardExpDate,Excel_Handling.Get_Data(TC_ID, "CardExpDate").trim(), "Debit card Number Exp Date");
			Assert.inputText(driver, DebitCardCVVCode,Excel_Handling.Get_Data(TC_ID, "CardCVVCode").trim(), "Debit card Number CVVCode");
			Assert.Clickbtn(driver, DebitCardMakePaymtBtn, "Debit Card make payment button");		   
		}catch(Exception e)	
		{
			Extent_Reporting.Log_Fail("Some fields are not disp", "Failed", driver);   
			Log.error("Test failed due to page is navigating to payment page");
			e.printStackTrace();
			throw new Exception("Test failed due to local host page not displayed");
		}
	}
	
	public void Debit_cardProvidingValuesWithValidData() throws Exception{
		try{		   		   
			Assert.inputText(driver, DebitCardNoInput, Excel_Handling.Get_Data(TC_ID, "ValidCardNumber").trim(), "Debit card Number input field");
			Assert.inputText(driver, DebitCardExpDate,Excel_Handling.Get_Data(TC_ID, "CardExpDate").trim(), "Debit card Number Exp Date");
			Assert.inputText(driver, DebitCardCVVCode,Excel_Handling.Get_Data(TC_ID, "CardCVVCode").trim(), "Debit card Number CVVCode");
			Assert.Clickbtn(driver, DebitCardMakePaymtBtn, "Debit Card make payment button");		   
		}catch(Exception e)	
		{
			Extent_Reporting.Log_Fail("Some fields are not disp", "Failed", driver);   
			Log.error("Test failed due to page is navigating to payment page");
			e.printStackTrace();
			throw new Exception("Test failed due to local host page not displayed");
		}
	}
}
