package com.opencart.runners;

import io.cucumber.junit.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.opencart.stepdefinitions",
        plugin = {"pretty"}

)
public class TestRunner {
    @BeforeClass
    public static void setup() {
        // Configurar WebDriverManager para usar la versión correcta de ChromeDriver
        WebDriverManager.chromedriver().browserVersion("136").setup();

        // Establecer propiedades del sistema para Serenity
        System.setProperty("webdriver.chrome.silentOutput", "true");
        System.setProperty("serenity.take.screenshots", "AFTER_EACH_STEP");
    }
}

