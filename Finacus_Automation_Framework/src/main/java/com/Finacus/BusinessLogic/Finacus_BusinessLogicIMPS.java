package com.Finacus.BusinessLogic;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.Finacus.PageObject.Finacus_PaymentPage_PageObject;
import com.Finacus.Reporting.Extent_Reporting;
import com.Finacus.TestData.Excel_Handling;
import com.Finacus.Utilities.ElementAction;
import com.Finacus.Utilities.Log;


public class Finacus_BusinessLogicIMPS extends Finacus_PaymentPage_PageObject {
	public WebDriver driver;
	public String TC_ID = "";
	ElementAction Assert = new ElementAction();
	Log log = new Log();	
	public Finacus_BusinessLogicIMPS(WebDriver driver, String TC_ID)
	{
		this.driver = driver;
		this.TC_ID=TC_ID;
		log = new Log();
	}
	/**
	 * @author parmeshwar Sakole
	 * Following method is used for Filling up the local host details page.
	 * @throws Throwable
	 */
	public void LocalHostDetailPage() throws Exception {
		try{ 
			Log.info("Navigating To Local Host page of Payment");	   
			if(Assert.isElementDisplay(driver, BuyerMailId))
			{ 
				Log.debug("Local Host page");
				Assert.inputText(driver, BuyerMailId, Excel_Handling.Get_Data(TC_ID, "BuyerMailID"), "Buyer Mail ID");
				Assert.inputText(driver, BuyerPhoneNumber, Excel_Handling.Get_Data(TC_ID, "BuyerPhoneNumber"), "Buyer Phone Number");
				Assert.inputText(driver, BuyerFirstName, Excel_Handling.Get_Data(TC_ID, "BuyerFirstName"), "Buyer First Name");
				Assert.inputText(driver, BuyerLastName, Excel_Handling.Get_Data(TC_ID, "BuyerLastName"), "Buyer Last Name");
				Assert.inputText(driver, Order_Id, Excel_Handling.Get_Data(TC_ID, "Order_Id"), "Order_Id");
				Assert.inputText(driver, Amount, Excel_Handling.Get_Data(TC_ID, "Amount"), "Amount");
				Extent_Reporting.Log_report_img("Local Host page required field filled", "Passed", driver);
				Assert.Clickbtn(driver, payHerebtn, "Pay Here");
				Assert.waitForPageToLoad(driver);
			}
			else{
				Extent_Reporting.Log_Fail("Local Host page not exist ", "Local Host page not displayed", driver);   
				Log.error("Local Host page not successfully displayed");
				throw new Exception(" Test failed due to local host page not displayed");
			}
		}                     
		catch(Exception e)	
		{
			Log.error("Test failed due to local host page not displayed");
			e.printStackTrace();
			throw new Exception("Test failed due to local host page not displayed");
		}
	}
	/**
	 * @author parmeshwar Sakole
	 * Following method is used for Filling up the local host details page.
	 * @throws Throwable
	 */
	public void LocalHostDetailPage_ErrorVerify() throws Exception {
		try{ 
			Log.info("Navigating To Local Host page of Payment");	   
			if(Assert.isElementDisplay(driver, BuyerMailId))
			{ 
				Log.debug("Local Host page");
				Assert.inputText(driver, BuyerMailId, Excel_Handling.Get_Data(TC_ID, "BuyerMailID"), "Buyer Mail ID");
				Assert.inputText(driver, BuyerPhoneNumber, Excel_Handling.Get_Data(TC_ID, "BuyerPhoneNumber"), "Buyer Phone Number");
				Assert.inputText(driver, Order_Id, Excel_Handling.Get_Data(TC_ID, "Order_Id"), "Order_Id");
				Assert.inputText(driver, Amount, Excel_Handling.Get_Data(TC_ID, "Amount"), "Amount");
				Extent_Reporting.Log_report_img("Local Host page required field filled", "Passed", driver);
				Assert.Clickbtn(driver, payHerebtn, "Pay Here");
				Assert.waitForPageToLoad(driver);
			}
			else{
				Extent_Reporting.Log_Fail("Local Host page not exist ", "Local Host page not displayed", driver);   
				Log.error("Local Host page not successfully displayed");
				throw new Exception(" Test failed due to local host page not displayed");
			}
		}                     
		catch(Exception e)	
		{
			Log.error("Test failed due to local host page not displayed");
			e.printStackTrace();
			throw new Exception("Test failed due to local host page not displayed");
		}
	}
	/**
	 * @author parmeshwar Sakole
	 * @Method Name: Card Selection method.
	 * Following method is used Handling Multiple Card options
	 * @throws Exception
	 */
	public void Card_Details_Options() throws Exception {
		try{ 
			Assert.waitForPageToLoad(driver);
			Thread.sleep(2000);
			Log.info("Navigating To Payment Page");	 
			String Card = Excel_Handling.Get_Data(TC_ID, "Payment_Mode").trim();
			Assert.waitForPageToLoad(driver);		
			List<WebElement> Channels = driver.findElements(By.xpath(AirpayChannals));
			int ChannelsCnt = Channels.size();
			System.out.println("Channels count is:"+ChannelsCnt);
			for(int i=0; i<ChannelsCnt;i++)
			{
				WebElement ChannelsName = Channels.get(i);
				String name = ChannelsName.getText();				
				if(name.equalsIgnoreCase(Card)){					
						ChannelsName.click();
						Extent_Reporting.Log_report_img(" payment mode option choosen as: "+name, "Passed", driver);
						break;					
				}								
			}
			Extent_Reporting.Log_report_img("All channels are exist as expected", "Passed", driver);  
		}                     
		catch(Exception e)	
		{
			Log.error("Test failed due to card does not exist");
			e.printStackTrace();
			throw new Exception("Test failed due to local host page not displayed");
		}
	}
	/**
	 * @author parmeshwar Sakole
	 * @Method Name: Card Selection method.
	 * Following method is used Handling Multiple Card options
	 * @throws Exception
	 */
	public static String bankName = null;
	public void Select_Bank_DropDown_Selection() throws Exception {
		try{ 
			Log.info("Navigating To Net Banking Page");	 
			if(Assert.isElementDisplayed(driver, SelectBank_DropDown, "Select Bank Drop Down" ))
			{         	
				WebElement selectDropBox = driver.findElement(By.xpath(Netbank_DropDown));
				Select select =new Select(selectDropBox);
				List<WebElement> optionValue = select.getOptions();
				for(int i =1;i<optionValue.size()-1;i++)
				//for(int i =1;i<2;i++)
				{				
					WebElement selectDropBox1 = driver.findElement(By.xpath(Netbank_DropDown));
					Select select1 =new Select(selectDropBox1);
					//Assert.selectDropBoxValue(driver, Netbank_DropDown, i, " Bank Name");//(driver, Netbank_DropDown, value[i], value[i+1]+" Bank ");			
					Assert.selectDropBoxValuebyVisibleTextwithoutClick(driver, Netbank_DropDown, "LAXMI VILAS BANK", " Bank Name");//(driver, Netbank_DropDown, value[i], value[i+1]+" Bank ");			

					bankName =  select1.getFirstSelectedOption().getText();
					Extent_Reporting.Log_report_img(bankName+"Bank Selected", "Passed", driver);
					/*URL obj = new URL("http://mkyong.com");
					URLConnection conn = obj.openConnection();
					
					//get all headers
					Map<String, List<String>> map = conn.getHeaderFields();
					for (Map.Entry<String, List<String>> entry : map.entrySet()) {
						System.out.println("Key : " + entry.getKey() + 
				                 " ,Value : " + entry.getValue());
					}
					
					
					//get header by 'key'
					String server = conn.getHeaderField("Server");
					System.out.println("server: "+server);*/
					NetBanking_Makepaymentbtn();
					BankPage_validation();
					NavigateToLocalHostPage();	
					
				}   		
				Assert.waitForPageToLoad(driver);
			}
			else{
				Extent_Reporting.Log_Fail(" option does not exis",	"Failed",driver);
				Log.error("Local Host page not successfully displayed");
				throw new Exception("option does not exist displayed");
			}
		}                     
		catch(Exception e)	
		{
			Extent_Reporting.Log_Fail(" option does not exis",	"Failed",driver);
			Log.error("Test failed due to card does not exist");
			e.printStackTrace();
			throw new Exception("Test failed due to local host page not displayed");
		}
	}
	
	public void NetbankingErrDropDropRedLine() throws Exception {
		try{ 
			Log.info("Navigating To Net Banking Page");	 
			if(Assert.isElementDisplay(driver, NetbankingErrDropDropRedLine))
			{         				
				Assert.isElementDisplayed(driver, NetbankingErrDropDropRedLine, "Net banking ErrDropDrop Red Line");
				Extent_Reporting.Log_report_img("Error drop down is exist", "Passed", driver);
			}
			else{
				Extent_Reporting.Log_Fail("Net Banking Error Drop down red line is not exist",	"Failed",driver);
				Log.error("Local Host page not successfully displayed");
				throw new Exception("option does not exist displayed");
			}
		}                     
		catch(Exception e)	
		{
			Extent_Reporting.Log_Fail("Net Banking Error Drop down red line is not exist",	"Failed",driver);
			Log.error("Test failed due to card does not exist");
			e.printStackTrace();
			throw new Exception("Test failed due to local host page not displayed");
		}
	}
	public void NetBanking_Makepaymentbtn() throws Exception {
		try{ 
			Log.info("Navigating To Net Banking Page");	 
			if(Assert.isElementDisplayed(driver, MakePaymentBtnForNetBankning, "Make Payment" ))
			{         				
				Assert.Clickbtn(driver, MakePaymentBtnForNetBankning, "Make Payment");
				Thread.sleep(10000);			  		
				Assert.waitForPageToLoad(driver);
				
			}
			else{
				Extent_Reporting.Log_Fail(" Make payment button does not exist for net banking",	"Failed",driver);
				Log.error("Local Host page not successfully displayed");
				throw new Exception("option does not exist displayed");
			}
		}                     
		catch(Exception e)	
		{
			Extent_Reporting.Log_Fail(" Make payment button does not exist for net banking",	"Failed",driver);
			Log.error("Test failed due to card does not exist");
			e.printStackTrace();
			throw new Exception("Test failed due to local host page not displayed");
		}
	}
	public void Verify_PaymentPageFields() throws Exception {
		try{ 
			Log.info("Navigating To Payment Page");	
			Assert.waitForPageToLoad(driver);
			Thread.sleep(2000);
			if(Assert.isElementDisplayed(driver, LogoPaymentPage, "Logo payment page" ))
			{         	
				Assert.Verify_Image(driver, ImgLogo, "Airpay Logo");
				Assert.isElementDisplayed(driver, airPayFavIcon, "Airpay Fav icon");
				Extent_Reporting.Log_report_img("Respective Details is exist", "Passed", driver);
			}else{
				Extent_Reporting.Log_Fail("Logo payment page does not exis",	"Failed",driver);
				Log.error("Local Host page not successfully displayed");
				throw new Exception("option does not exist displayed");
			}
		}                     
		catch(Exception e)	
		{
			Extent_Reporting.Log_Fail("Airpay Logo does not exist",	"Failed",driver);
			Log.error("Airpay Logo does not exist does not exist");
			e.printStackTrace();
			throw new Exception("Test failed due to Airpay Logo does not displayed");
		}
	}
	public void Verify_All_Channels() throws Exception {
		try{ 
			Log.info("Navigating To Payment Page");	
			Assert.waitForPageToLoad(driver);		
			List<WebElement> Channels = driver.findElements(By.xpath(AirpayChannals));
			int ChannelsCnt = Channels.size();
			System.out.println("Channels count is:"+ChannelsCnt);
			for(int i=0; i<ChannelsCnt;i++)
			{
				WebElement ChannelsName = Channels.get(i);
				String name = ChannelsName.getText();
				Extent_Reporting.Log_Pass("Channel Name is :" +name, "Passed");			
			}
			Extent_Reporting.Log_report_img("All channels are exist as expected", "Passed", driver);        
		}                     
		catch(Exception e)	
		{
			Extent_Reporting.Log_Fail("Channenls does not exist",	"Failed",driver);
			Log.error("Channenls does not exist");
			e.printStackTrace();
			throw new Exception("Channenls does not exist");
		}
	}
	/**
	 * @author parmeshwar.sakole
	 * @throws Exception
	 * Method use: verify the Channels fields.
	 */
	public void SummerSectionVerify_indianCurrency() throws Exception {
		try{ 
			if(Assert.isElementDisplayed(driver, SummerySecOrdID, "Summery section"))
			{			
				String OrderID = driver.findElement(By.xpath(SummerySecOrdID)).getText();
				String Amt = driver.findElement(By.xpath(AmtValueBlock)).getText();
				System.out.println("amtone:"+ Amt);
				String Amtval[] = Amt.split("₹");
				//String MerchanName = driver.findElement(By.xpath(MerchantName)).getText();			
				System.out.println("Amount Value:"+ Amtval[1]);				
				if(OrderID.trim().equalsIgnoreCase(Excel_Handling.Get_Data(TC_ID, "Order_Id").trim())
						&& Amtval[1].trim().equalsIgnoreCase(Excel_Handling.Get_Data(TC_ID, "Amount").trim())){

					Extent_Reporting.Log_Pass("Actual Order id is:"+OrderID, "Expected Order ID Is :"+Excel_Handling.Get_Data(TC_ID, "Order_Id"));
					Extent_Reporting.Log_Pass("Actual Amount is :"+Amtval[1], "Expected Amount Is :"+Excel_Handling.Get_Data(TC_ID, "Amount"));				
					//Assert.isElementDisplayed(driver, MerchantName, "Merchant name is exist as :"+MerchanName); //Removed this functionality
					Extent_Reporting.Log_report_img("Summery Section is exist as expected", "Passed", driver);        
				}else{				
					Extent_Reporting.Log_Fail("Actual Order id is:"+OrderID, "Expected Order ID Is :"+Excel_Handling.Get_Data(TC_ID, "Order_Id"),driver);
					Extent_Reporting.Log_Fail("Actual Amount is :"+Amtval[1], "Expected Amount Is :"+Excel_Handling.Get_Data(TC_ID, "Amount"),driver);
					throw new Exception("There is an something issue with order id and amount summery");
				}						
			}else{			
				Extent_Reporting.Log_Fail("Summery sectioin does not exist", "Failed",driver);
				throw new Exception("There is an something issue with order id and amount summery");
			}			
		}                     
		catch(Exception e)	
		{
			Extent_Reporting.Log_Fail("Summery sectioin does not exist", "Failed",driver);
			Log.error("Channenls does not exist");
			e.printStackTrace();
			throw new Exception("Channenls does not exist");
		}
	}



	public void FooterVerify() throws Exception {
		try{ 
			Log.info("Navigating To Payment Page");	
			Assert.waitForPageToLoad(driver);
			if(Assert.isElementDisplayed(driver, footerVerifyLink, "Footer text" ))
			{ 
				Assert.isElementDisplayed(driver, airPayFavIcon, "Airpay Fav icon");
				String textFooter = Assert.getInputTextValue(driver, footerVerifyLink, "");
				Extent_Reporting.Log_Pass("Footer Message is :"+textFooter, "Passed");
				Assert.isElementDisplayed(driver, CancelpaymentPage, "Cancel link");
				Assert.Clickbtn(driver, CancelpaymentPage, "Cancel link");
			}else{
				Extent_Reporting.Log_Fail(" option does not exis",	"Failed",driver);
				Log.error("Local Host page not successfully displayed");
				throw new Exception("option does not exist displayed");
			}
		}                     
		catch(Exception e)	
		{
			Extent_Reporting.Log_Fail("Airpay Logo does not exist",	"Failed",driver);
			Log.error("Airpay Logo does not exist does not exist");
			e.printStackTrace();
			throw new Exception("Test failed due to Airpay Logo does not displayed");
		}
	}


	public void BankPage_validation() throws Exception {
		try{ 
			Log.info("Navigating To Net Banking Page");	
			JavascriptExecutor js = (JavascriptExecutor) driver;
			  String domain = (String) js.executeScript("return document.domain");
			  driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);			 			 
			  if(domain.equals("") || domain.equals("payments.airpay.co.in")||(driver.getPageSource().contains("Error Page Exception"))==true
					  ||(driver.getPageSource().contains("Internal Server Error"))==true|| driver.getTitle().contains("HTTP Status - 400"))
			  {			 
				  Extent_Reporting.Log_Fail("Its not navigated to Respective Bank as", "Error Snap", driver);
				  Log.error("Its not navigated to Respective Bank as :"+bankName);
				//throw new Exception("Net Banking page issue");
			  }else{
				  Extent_Reporting.Log_Pass("Its Navigated to :"+bankName, "Passed");
				  Extent_Reporting.Log_report_img("Its Navigated to respective bank" , "Passed", driver);
				  Thread.sleep(2000);
			}
		}catch(Exception e)	
			{
				Extent_Reporting.Log_Fail(" Make payment button does not exist for net banking",	"Failed",driver);
				Log.error("Test failed due to card does not exist");
				e.printStackTrace();
				//throw new Exception("Test failed due to local host page not displayed");
			}
		} 
		
		public void NavigateToLocalHostPage() throws Exception {
		try{ 
				Log.info("Navigating To Net Banking Page");	
				Assert.waitForPageToLoad(driver);
				driver.get(Excel_Handling.Get_Data(TC_ID, "URL").trim());
				Assert.waitForPageToLoad(driver);
				LocalHostDetailPage();	
				Card_Details_Options();
		}catch(Exception e){
			Extent_Reporting.Log_Fail(" Make payment button does not exist for net banking",	"Failed",driver);
			Log.error("Test failed due to card does not exist");
			e.printStackTrace();
			throw new Exception("Test failed due to local host page not displayed");
		}
	}
	
}