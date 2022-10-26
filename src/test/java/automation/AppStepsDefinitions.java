package automation;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AppStepsDefinitions {
	
	@Given("{string} esta no portal de ofertas")
	public void esta_no_portal_de_ofertas(String username) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("User logado: " + username);
	}

	@When("clica no link {string}")
	public void clica_no_link(String link) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Clica no link: " + link);
	}

	@Then("pagina mostrada com status {string}")
	public void pagina_mostrada_com_status(String status) {
	    // Write code here that turns the phrase above into concrete actions
	    if (status.equals("OK")) {
	    	System.out.println("Pagina mostrada com sucesso");
	    	Assert.assertTrue(true);
		} else {
			Assert.fail();;
	
		}
	}

	@Given("user is logged")
	public void user_is_logged() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("user is logged");
	}

	@When("click on link")
	public void click_on_link() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("click on link");
	}

	@Then("action is started")
	public void action_is_started() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("action is started");
		Assert.assertTrue(true);
	}

}
