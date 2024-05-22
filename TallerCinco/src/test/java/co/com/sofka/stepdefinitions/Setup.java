package co.com.sofka.stepdefinitions;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class Setup {

    @Managed(driver = "edge")
    protected WebDriver webDriver;


    private void setupActor(WebDriver webDriver,String nombre){
        OnStage.setTheStage(new OnlineCast());
        theActorCalled(nombre).can(BrowseTheWeb.with(webDriver));
    }

    protected void actorSetupTheBrowser(String nombre){
        setupActor(webDriver, nombre);
        maximizar(webDriver);
    }

    private static void maximizar(WebDriver webDriver) {
        webDriver.manage().window().maximize();
    }

}
