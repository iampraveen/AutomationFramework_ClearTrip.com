package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import pageObjects.CheckoutPage;
import pageObjects.HomePage;

public class BookSteps {
	HomePage homePage;
	CheckoutPage checkOutPage;
	TestContext testContext;
	
	public BookSteps(TestContext context) {
		 testContext = context;
		 homePage = testContext.getPageObjectManager().getHomePage();
		 checkOutPage = testContext.getPageObjectManager().getCheckoutPage();
		 }

	
	@Given("I am on clearTrip homepage")
	public void i_am_on_clearTrip_homepage() {
		Assert.assertEquals(homePage.getHomePageTitle(), "Home");			
	}

	@When("I enter \"([^\"]*)\" and \"([^\"]*)\"")
	public void i_enter_and(String sourceCity, String destinationCity) {
		homePage.enterSourceCity(sourceCity);
		homePage.enterDestinationCity(destinationCity);
	}

	@When("I select \"([^\"]*)\" journey type")
	public void i_select_One_way_journey_type(String journeyType) {
		homePage.selectJourneyType(journeyType);
	}

	@When("I enter \"([^\"]*)\" and \"([^\"]*)\" date interval from today")
	public void i_enter_date(String departDate, String returnDate) throws InterruptedException {
	    homePage.enterDepartDate(departDate);
	    homePage.enterReturnDate(returnDate);
	}

	@When("I add number of \"([^\"]*)\" and \"([^\"]*)\" passenger")
	public void i_add_number_of_and_passenger(String numOfAdult, String numOfChild) {
		homePage.enterNumOfPass(numOfAdult, numOfChild);
	}

	@When("I click on search flights")
	public void i_click_on_search_flights() {
		homePage.clickOnSearchButton();
	}

	@Then("I see flight list")
	public void i_see_flight_list() {
		homePage.waitForPageToLoad();
	}
	
	@When("I choose non-stop flight")
	public void i_choose_non_stop_flight() {
		homePage.clickOnNonStop();
	}
	
	@When("I apply price and departure time filter")
	public void i_click_on_Price() throws InterruptedException {		
	   homePage.sortPrice();
	   homePage.sortDepart();
	   homePage.selectFlight();
	}
	
	@When("I click on Book button")
	public void i_click_on_Book_button() {
		homePage.bookFlight();
	}

	@Then("I land on checkout page")
	public void i_land_on_checkout_page() {
		Assert.assertEquals(checkOutPage.getCheckoutPagePageTitle(), "Book in four simple steps");		
	}

	@When("I check accept terms")
	public void i_check_accept_terms() {
		checkOutPage.acceptTerms();	
	}

	@When("I click on book button")
	public void i_click_on_book_button() {
		checkOutPage.clickOnBooking();
	}

	@When("I enter mail ID")
	public void i_enter_mail_ID() {
		checkOutPage.enterMailID();
	}

	@When("I click on continue button")
	public void i_click_on_continue_button() {		   
		checkOutPage.clickOnContinueBtn();
	}

	@Then("I enter passenger detail")
	public void i_enter_passenger_detail() {
		checkOutPage.enterTravellerDetail();
	}

	@When("I click on continue payment")
	public void i_click_on_continue_payment() {
		checkOutPage.clickOnContinuePayment();
	}

	@When("I choose payment gateway")
	public void i_choose_payment_gateway() {
		checkOutPage.clickOnUPIPaymentGateway();
	}

	@Then("I enter UPI ID")
	public void i_enter_UPI_ID() {
		checkOutPage.enterUPI();
	}

	@Then("I make payment")
	public void i_make_payment() {
		checkOutPage.clickOnMakePayment();
	}

}
