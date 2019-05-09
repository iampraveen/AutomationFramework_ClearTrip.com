package stepDefinitions;

import org.openqa.selenium.WebDriver;

import cucumber.TestContext;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import managers.FileReaderManager;

public class Hooks {
	 TestContext testContext;
	 WebDriver driver;
	 
	 public Hooks(TestContext context) {
	 testContext = context;
	 driver = testContext.getWebDriverManager().getDriver();
	 }
	 
	 @Before
	 public void BeforeSteps() {
	 driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
	 }
	 
	 @After
	 public void AfterSteps() {
	 testContext.getWebDriverManager().closeDriver();
	 }
}
