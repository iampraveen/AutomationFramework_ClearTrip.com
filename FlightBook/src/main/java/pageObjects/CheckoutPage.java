package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {
	WebDriver driver;
	WebDriverWait wait = null;

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(className = "pageTitle") 	 
	private WebElement checkoutPageTitle;
	
	@FindBy(id = "insurance_confirm") 	 
	private WebElement acceptTerms;
	
	@FindBy(id = "itineraryBtn") 	 
	private WebElement continueBookingBtn;
	
	@FindBy(id = "username") 	 
	private WebElement userMailId;
	
	@FindBy(id = "LoginContinueBtn_1") 	 
	private WebElement continueBtn;
	
	@FindBy(xpath = "(//*[@id='AdultTitle1'])[1]") 	 
	private WebElement adultTitle;
	
	@FindBy(id = "ChildTitle1") 	 
	private WebElement childTitle;
	
	@FindBy(xpath = "(//*[@id='AdultFname1'])[1]") 	 
	private WebElement adultFirstName;
	
	@FindBy(id = "ChildFname1") 	 
	private WebElement childFirstName;
	
	@FindBy(xpath = "(//*[@id='AdultLname1'])[1]") 	 
	private WebElement adultLastName;
	
	@FindBy(id = "AdultDobDay1") 	 
	private WebElement adultDOBDay;
	
	@FindBy(id = "AdultDobMonth1") 	 
	private WebElement adultDOBMonth;
	
	@FindBy(id = "AdultDobYear1") 	 
	private WebElement adultDOBYear;
	
	@FindBy(xpath = "(//*[@class='countryAutoCompleteHolder'])[1]//input[1]") 	 
	private WebElement adultNationality;
	
	@FindBy(id = "ChildLname1") 	 
	private WebElement childLastName;
	
	@FindBy(id = "ChildDobDay1") 	 
	private WebElement childDOBDay;
	
	@FindBy(id = "ChildDobMonth1") 	 
	private WebElement childDOBMonth;
	
	@FindBy(id = "ChildDobYear1") 	 
	private WebElement childDOBYear;
	
	@FindBy(xpath = "(//*[@class='countryAutoCompleteHolder'])[2]//input[1]") 	 
	private WebElement childNationality;
	
	@FindBy(css = ".required.mb.span.span8") 	 
	private WebElement mobileNum;
	
	@FindBy(id = "travellerBtn") 	 
	private WebElement continuePaymentBtn;
	
	@FindBy(xpath = "//ul//li[@id='UPTab']//a") 	 
	private WebElement upiTab;
	
	@FindBy(id = "vpaBox") 	 
	private WebElement upiTextBox;

	@FindBy(id = "paymentSubmit") 	 
	private WebElement paymentSubmit;
	
	
	
	public void click(WebElement element)
	{
		waitForElementToAppear(driver,element);
	    element.click();
	}
	
	public void waitForElementToAppear(WebDriver driver, WebElement element)
	{
		 wait = new WebDriverWait(driver, 30);
		 wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForElementToClickable(WebDriver driver, WebElement element)
	{
		 wait = new WebDriverWait(driver, 30);
		 wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void select(WebElement element, String value)
	{
		waitForElementToClickable(driver, element);
		Select select = new Select(element);
		select.selectByValue(value);	
	}
	
	public void enterValue(WebElement element, String value)
	{
		element.sendKeys(value);	
	}
	
	public String getCheckoutPagePageTitle(){
		return checkoutPageTitle.getText();
	}
	
	public void acceptTerms() {
		click(acceptTerms);
	}
	
	public void clickOnBooking() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", continueBookingBtn);
		click(continueBookingBtn);		
	}
	
	public void enterMailID() {
		waitForElementToClickable(driver, userMailId);
		waitForElementToAppear(driver, userMailId);
		enterValue(userMailId, "test.simplot@simplot.com");
	}
	
	public void clickOnContinueBtn() {
		click(continueBtn);
	}
	
	public void selectAdultTitle() {
		select(adultTitle,"Mr");
	}
	
	public void enterFirstName() {
		enterValue(adultFirstName, "Praveen");
	}
	
	public void enterLastName() {
		enterValue(adultLastName, "Jaiswal");
	}
	
	public void enterAdultDOB() {
		select(adultDOBDay, "1");
		select(adultDOBMonth, "4");
		select(adultDOBYear, "1993");
	}
	
	public void enterAdultNationality() {
		enterValue(adultNationality, "Indian");
	}	
	
	public void selectChildTitle() {
		select(childTitle,"Miss");
	}
	
	public void enterChildFirstName() {
		enterValue(childFirstName, "Sonam");
	}
	
	public void enterChildLastName() {
		enterValue(childLastName, "Jaiswal");
	}
	
	public void enterChildDOB() {
		select(childDOBDay, "1");
		select(childDOBMonth, "4");
		select(childDOBYear, "2010");
	}
	
	public void enterChildNationality() {
		enterValue(childNationality, "Indian");
	}	
	
	public void enterMobileNum() {
		enterValue(mobileNum, "8960415441");
	}
	
	public void enterTravellerDetail() {
		/**********************************************
		  Commented below method would be useful if  
		  we hit this section of page numerous time.
		  When I cleared cache memory, I was not getting
		  this textbox.
		 **********************************************/
		selectAdultTitle();
		enterFirstName();
		enterLastName();
		//enterAdultDOB();      
		//enterAdultNationality();
		selectChildTitle();
		enterChildFirstName();
		enterChildLastName();
		enterChildDOB();
		//enterChildNationality();
		enterMobileNum();
	}
	
	public void clickOnContinuePayment() {
		click(continuePaymentBtn);
	}
	
	public void clickOnUPIPaymentGateway() {
		click(upiTab);
	}
	
	public void enterUPI() {
		waitForElementToAppear(driver, upiTextBox);
		enterValue(upiTextBox, "praveen9319@paytm");
	}
	
	public void clickOnMakePayment() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", paymentSubmit);
		click(paymentSubmit);		
	}

}
