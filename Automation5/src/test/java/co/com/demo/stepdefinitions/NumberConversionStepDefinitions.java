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

public class NumberConversionStepDefinitions extends SetupService {

    String number;

    @Given("the Number Conversion service is available")
    public void theNumberConversionServiceIsAvailable() {
        super.setupService("https://www.dataaccess.com/webservicesserver/");
       number=number;

    }
    @When("the user sends a request to convert {string}")
    public void theUserSendsARequestToConvert(String number) {
        actor.attemptsTo(
                doPost().withTheResource("numberconversion.wso")
                        .andHeaders(headers())
                        .andTheBody(getBody(number))
        );

    }

    private static @NotNull String getBody(String number) {
        String body = String.format(readFile("src/test/resources/xml_files/number_conversion.xml"),number);
        return body;
    }

    @Then("I should receive the number in words {string}")
    public void iShouldReceiveTheNumberInWords(String number) {
        actor.should(
                seeThat("Code", ResponseCode.was(), equalTo(200))
        );

        actor.should(
                seeThat("Should appears a name",
                        responseSoap() , containsString(number) )
        );

    }

    }


