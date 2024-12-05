package co.com.demo.stepdefinitions;

import co.com.demo.questions.ResponseCode;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.jetbrains.annotations.NotNull;

import static co.com.demo.questions.ResponseSoap.responseSoap;
import static co.com.demo.tasks.DoPost.doPost;
import static co.com.demo.utils.ArchivosUtil.readFile;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

public class HelloStepDefinitions extends SetupService {

    String name;

    @Given("the Hello service is available")
    public void theHelloServiceIsAvailable() {
        super.setupService("https://apps.learnwebservices.com:443");
        name=name;

    }
    @When("the user sends a request with {string}")
    public void theUserSendsARequestWith(String name) {
        actor.attemptsTo(
                doPost().withTheResource("/services/hello")
                        .andHeaders(headers())
                        .andTheBody(getBody(name))
        );

    }

    private static @NotNull String getBody(String name) {
        String body = String.format(readFile("src/test/resources/xml_files/hello.xml"),name);
        return body;
    }

    @Then("I should receive a greeting with the name {string}")
    public void i_should_receive_a_greeting_with_the_name(String name) {
        actor.should(
                seeThat("Code", ResponseCode.was(), equalTo(200))
        );

        actor.should(
                seeThat("Should appears a name",
                        responseSoap() , containsString(name) )
        );

    }

}
