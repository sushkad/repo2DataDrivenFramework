package com.Finacus.PageObject;

public class Finacus_PaymentPage_PageObject {
	
	//*************************Local Host page locators *******************************************************
		public static final  String  BuyerMailId = "//input[@id='buyerEmail']";
		public static final  String  BuyerPhoneNumber = "//input[@id='buyerPhone']";
		public static final  String  BuyerFirstName = "//input[@id='buyerFirstName']";
		public static final  String  BuyerLastName = "//input[@id='buyerLastName']";
		public static final  String  BuyerPinCode = "//input[@id='buyerPinCode']";	
		public static final  String  Order_Id = "//input[@id='orderid']";
		public static final  String  Amount = "//input[@id='amount']";
		public static final  String  payHerebtn= "//button[@type='submit']";
		
	//*************************** Net Banking Page Locators ****************************
		
		public static final String SelectBank_DropDown = "//input[@name='bankName']";
		public static final String MakePaymentBtn ="(//input[@value='Make Payment' and @type='submit'])";
		public static final String Netbank_DropDown ="//select[@name='nbbank_select']";
		public static final String MakePaymentBtnForNetBankning = "(//input[@name='bankName']//following::div/input[@value='Make Payment'])[1]";
		public static final String NetbankingErrDropDropRedLine = "//*[@class='formDom form-group select-group errorvalue']";	
		
	//***************************Local Host Email Id error verify ************************************
		
		public static final String ErrverifyValidation = "//span[@class='alert alert-error']";
				
		
	//*************************** Credit Card payemtn page Locators ************************************
		public static final String CreditCardNoInput ="(//div[@class='blockMain blockCards credit-tab']//following::input[contains(@class,'form-control cardNumber')])[1]";
		public static final String CreditCardExpDate = "(//div[@class='blockMain blockCards credit-tab']//following::input[contains(@class,'form-control exp_date')])[1]";
		public static final String CreditCardCVVCode ="(//div[@class='blockMain blockCards credit-tab']//following::input[contains(@class,'form-control cvv')])[1]";
		public static final String CreditCardMakePaymtBtn = "//input[@class='btn submit-credit-dtls']";
		public static final String CreditCardHolderName = "(//div[@class='blockMain blockCards credit-tab']//following::input[contains(@class,'form-control cardname')])[1]";
		public static final String CreditCardErrField = "//div[@class='formDom form-group errorvalue']//label";
		public static final String CardInvalidErrMsgVerify = "//div[@class='generic-error']";
		
		public static final String CancelCreditPayment = "(//*[text()='CANCEL'])[1]";
					
	//******************************** Payment page ****************************************************
		
		public static final String LogoPaymentPage = "(//div[@class='logo'])[1]";
		public static final String ImgLogo = "(//img)[1]";
		public static final String airPayFavIcon = "//div[@class='paylogo']";
		public static final String AirpayChannals = "//*[@class='menu-link']";
		public static final String SummerySecOrdID = "//*[@class='odrID']/strong";
		public static final String MerchantName = "//*[@class='merName']";
		public static final String AmtValueBlock = "//div[contains(@class,'default-amount-block')]";
		public static final String footerVerifyLink = "//div[@class='tnc']/p";
		public static final String CancelpaymentPage = "//div[@class='tnc']//a";
		
    //********************************** debit card payment page locators***************************************
		
		public static final String DebitCardNoInput ="(//div[@class='blockMain blockCards debit-tab']//following::input[contains(@class,'form-control cardNumber')])[1]";
		public static final String DebitCardExpDate = "(//div[@class='blockMain blockCards debit-tab']//following::input[contains(@class,'form-control exp_date')])[1]";
		public static final String DebitCardCVVCode ="(//div[@class='blockMain blockCards debit-tab']//following::input[contains(@class,'form-control cvv')])[1]";
		public static final String DebitCardMakePaymtBtn = "//*[@class='btn submit-debit-dtls']";
		public static final String DebitCardHolderName = "(//div[@class='blockMain blockCards debit-tab']//following::input[contains(@class,'form-control cardname')])[1]";
		public static final String DebitCardErrField = "//div[@class='formDom form-group errorvalue']//label";

	//********************************** EMI Locators *********************************************
		public static final String EmiBankNameSelectDropDown = "//select[@class='form-control emiSelect']";
		public static final String EMICardHolderName = "(//div[@class='blockMain blockCards emi-tab']//following::input[contains(@class,'form-control cardname')])[1]";
		public static final String EMICardNumber = "(//div[@class='blockMain blockCards emi-tab']//following::input[contains(@class,'form-control cardNumber')])[1]";
		public static final String EMICardExpDate = "(//div[@class='blockMain blockCards emi-tab']//following::input[contains(@class,'form-control exp_date')])[1]";
		public static final String EMICardCVVCode ="(//div[@class='blockMain blockCards emi-tab']//following::input[contains(@class,'form-control cvv')])[1]";
		public static final String EMICardMakePaymtBtn = "//*[@class='btn emi-submit']";

	//************************************ MA Panel *************************************************
		
		public static final String ManangerDashBoard ="//*[@class='glyphicon glyphicon-th-list main-menu-icon']";
		public static final String MerchantMenutab = "//*[@class='glyphicon glyphicon-globe pri-menu']//preceding::a[1]";
		
		
	//********************************* Cash Test case ****************************************
		public static final String CashPinCode = "//*[@class='form-control cash_pincode']";
		public static final String CashMakePayment = "//*[@class='btn cash-submit']";

		public static final String CashSuccessTransaction = "//*[text()='Success Transaction']";	
		
	//********************************* RTGS and NEFT ****************************************
		public static final String UTRCode = "//*[@class='form-control utr-validation']";
		public static final String UTRCashMakePayment = "//*[@class='btn rtgs-form']";

		

		
		
		
		
		
		
		
		
		
	 	    
}
