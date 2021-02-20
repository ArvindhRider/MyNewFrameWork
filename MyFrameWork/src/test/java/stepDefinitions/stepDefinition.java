package stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import PageObjects.FacebookPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import resources.DriverClass;
import org.apache.logging.log4j.*;



@RunWith(Cucumber.class)
public class stepDefinition extends DriverClass 
{
	//general elements
	public static Logger log = LogManager.getLogger(stepDefinition.class.getName());
	
	WebDriver driver;
	
	
	
	
	
	@Given("^Initialize browser with chrome$")
	public void initialize_browser_with_chrome() throws Throwable 
	{
		driver = initdriver();
		log.info("driver is started in facebook page");
	   
	   
	}


    @And("^navigate to \"([^\"]*)\" pages$")
    public void navigate_to_something_pages(String fburl) throws Throwable {
    	System.out.println(fburl);
    	driver.get(fburl);
		log.info("url is started for fb");
       
    }

    @When("^user enters (.+) and (.+) in the fields$")
    public void user_enters_and_in_the_fields(String username, String password) throws Throwable {
	  
	    System.out.println(username +" "+ password);
	    
	    FacebookPage fbp = new FacebookPage(driver);
	    
	    fbp.email().sendKeys(username);
	    fbp.pass().sendKeys(password);
	    fbp.login().click();
	    
	    
	}

	@Then("^he should be able to login fb$")
	public void he_should_be_able_to_login_fb() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}



}
