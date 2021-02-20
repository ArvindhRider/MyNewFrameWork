package stepDefinitions;

import org.junit.runner.RunWith;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
public class stepDefinition 
{
	@Given("^Initialize browser with chrome$")
	public void initialize_browser_with_chrome() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}


    @And("^navigate to \"([^\"]*)\" pages$")
    public void navigate_to_something_pages(String fburl) throws Throwable {
    	System.out.println(fburl);
       
    }

	@When("^user enters \"([^\"]*)\" and \"([^\"]*)\" in the fields$")
	public void user_enters_and_in_the_fields(String mailid, String pwd) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println(mailid +" "+ pwd);
	}

	@Then("^he should be able to login fb$")
	public void he_should_be_able_to_login_fb() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}



}
