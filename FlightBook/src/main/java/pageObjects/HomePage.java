package pageObjects;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class HomePage {
WebDriver driver;
WebDriverWait wait = null;

public HomePage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}

@FindBy(className = "cleartripLogo") 	 
private WebElement homePageLogo;

@FindBy(id = "FromTag") 	 
private WebElement sourceCity;

@FindBy(id = "ToTag") 	 
private WebElement destinationCity;

@FindBy(css = ".row.fieldRow.tripType >ul") 	 
private WebElement journeyType;

@FindBy(id = "DepartDate") 	 
private WebElement departDate;

@FindBy(id = "ReturnDate") 	 
private WebElement returnDate;

@FindBy(id = "Adults") 	 
private WebElement adultPassenger;

@FindBy(id = "Childrens") 	 
private WebElement childPassenger;

@FindBy(id = "SearchBtn") 	 
private WebElement SearchButton;

@FindBy(xpath = "//*[@id=\"ResultContainer_1_1\"]/section[1]/div/div[2]/nav[2]/ul/li[3]")  
private WebElement nonStopTab;

@FindBy(xpath = "(//ul//li[@class='price']//a)[1]") 	 
private WebElement filterPrice;

@FindBy(xpath = "(//ul//li[@class='depart']//a)[2]") 	 
private WebElement filterDepart;

@FindBy(xpath = "(//*[@class='listView flights'])[2]//li") 	 
private WebElement sourceFlight;

@FindBy(xpath = "(//*[@class='listView flights'])[3]//li") 	 
private WebElement returnFlight;

@FindBy(xpath = "(//*[@class='booking fRight'])[2]") 	 
private WebElement bookBtn;

public void click(WebElement element)
{
	waitForElementToClickable(driver, element);
    element.click();
}

public void WaitForElementToAppear(WebDriver driver, WebElement element)
{
	 wait = new WebDriverWait(driver, 30);
	 wait.until(ExpectedConditions.visibilityOf(element));
}

public void waitForElementToClickable(WebDriver driver, WebElement element)
{
	 wait = new WebDriverWait(driver, 30);
	 wait.until(ExpectedConditions.elementToBeClickable(element));
}

public void enterValue(WebElement element, String value)
{
	click(element);
	element.sendKeys(value);	
}

public void select(WebElement element, String value)
{
	waitForElementToClickable(driver, element);
	Select select = new Select(element);
	select.selectByValue(value);	
}

public String getDesireDate(String afterDay) {
    final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    Calendar c = Calendar.getInstance();
    c.setTime(new Date()); 
    c.add(Calendar.DATE, Integer.parseInt(afterDay)); 
    return dateFormat.format(c.getTime());
}

public String getHomePageTitle(){
	return homePageLogo.getText();
}

public void enterSourceCity(String sourceAirport) {
	enterValue(sourceCity, sourceAirport);
}

public void enterDestinationCity(String destinationAirport) {
	enterValue(destinationCity, destinationAirport);		
}

public void selectJourneyType(String journeyTypePassenger) {
	List<WebElement> links = journeyType.findElements(By.tagName("li"));
	    for (WebElement element: links) {
	    	if(element.getText().equals(journeyTypePassenger))
	        click(element); 
	    }
}

public void enterDepartDate(String journeystartDate) {
	String actualStartDate = getDesireDate(journeystartDate);
	waitForElementToClickable(driver, departDate);
	enterValue(departDate, actualStartDate);
}

public void enterReturnDate(String journeyEndDate) throws InterruptedException {
	String actualEndDate = getDesireDate(journeyEndDate);
	waitForElementToClickable(driver, returnDate);
	enterValue(returnDate, actualEndDate);
}

public void enterNumOfPass(String numOfAdult, String numOfChild) {
	click(adultPassenger);
	select(adultPassenger, numOfAdult);
	select(childPassenger, numOfChild);
}

public void clickOnSearchButton() {
	click(SearchButton);	
}

public void clickOnNonStop() {
	click(nonStopTab);	
}

public String getBookButtonText(){
	return bookBtn.getText();
}

public void sortPrice() {
	String className = filterPrice.getAttribute("class");
	if (className.equals("current sortAsc")) {
		System.out.println("Desired price filter is already applied.");
	}
	else if(className.equals("current sortDes")) {
		click(filterPrice);
	}
}	

public void sortDepart() {
	click(filterDepart);
	String className = filterDepart.getAttribute("class");
	if (className.equals("current sortAsc")) {
		click(filterDepart);
	}
	else if(className.equals("current sortDes")) {
		System.out.println("Desired departure filter is already applied.");
	}
}

public void selectFlight() {
	click(sourceFlight);
	click(returnFlight);
}

public void bookFlight() {
	click(bookBtn);
}

public void waitForPageToLoad() {
	WaitForElementToAppear(driver, bookBtn);
	Assert.assertEquals(getBookButtonText(), "Book");
}
}



