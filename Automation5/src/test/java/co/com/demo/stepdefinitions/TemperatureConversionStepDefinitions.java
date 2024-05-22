package co.com.demo.stepdefinitions;

import co.com.demo.questions.ResponseCode;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

import static co.com.demo.questions.ResponseSoap.responseSoap;
import static co.com.demo.tasks.DoPost.doPost;
import static co.com.demo.utils.ArchivosUtil.readFile;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

public class TemperatureConversionStepDefinitions extends SetupService {

    String number;

    @Given("the Temperature Conversion service is available")
    public void theTemperatureConversionServiceIsAvailable() {
        super.setupService(" https://www.w3schools.com:443/xml/");
        number=number;

    }
    @When("the user sends a request to convert Celsius to Fahrenheit with {string}")
    public void theUserSendsARequestToConvertCelsiusToFahrenheitWith(String number) {
        actor.attemptsTo(
                doPost().withTheResource("tempconvert.asmx")
                        .andHeaders(headers())
                        .andTheBody(getBody(number))
        );

    }

    private static @NotNull String getBody(String number) {
        String body = String.format(readFile("src/test/resources/xml_files/temperature_conversion.xml"),number);
        return body;
    }

    @Then("I should receive the temperature in Fahrenheit {string}")
    public void iShouldReceiveTheTemperatureInFahrenheit(String number) {
        actor.should(
                seeThat("Code", ResponseCode.was(), equalTo(200))
        );

        actor.should(
                seeThat("Should contains the number",
                        responseSoap() , containsString(number) )
        );


    }
}
