package com.opencart.stepdefinitions;

import com.opencart.models.Customer;
import com.opencart.questions.CartItems;
import com.opencart.questions.OrderConfirmation;
import com.opencart.tasks.AddProductToCart;
import com.opencart.tasks.CompleteCheckout;
import com.opencart.tasks.ViewCart;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CompraE2EStepDefinitions {

    @Managed(driver = "chrome")
    private WebDriver driver;

    private Actor usuario = Actor.named("Usuario");

    @Before
    public void setupActor() {
        // Asegúrate de que WebDriverManager descargue la versión compatible con tu Chrome
        WebDriverManager.chromedriver().browserVersion("136").setup();

        // Configurar opciones adicionales para Chrome si es necesario
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");

        // Opcional: si es necesario, configurar las opciones manualmente
        System.setProperty("chrome.switches", "--start-maximized;--disable-notifications");

        // Asignar el WebDriver al actor
        usuario.can(BrowseTheWeb.with(driver));
    }

    @Given("que el usuario está en la página de inicio")
    public void elUsuarioEstaEnLaPaginaDeInicio() {
        usuario.attemptsTo(Open.url("http://opencart.abstracta.us/"));
    }

    @When("el usuario agrega {int} productos diferentes al carrito")
    public void elUsuarioAgregaProductosAlCarrito(Integer cantidadProductos) {
        for (int i = 1; i <= cantidadProductos; i++) {
            usuario.attemptsTo(AddProductToCart.atIndex(i));
        }
    }

    @When("el usuario visualiza el contenido del carrito")
    public void elUsuarioVisualizaElContenidoDelCarrito() {
        usuario.attemptsTo(ViewCart.now());
        usuario.attemptsTo(
                Ensure.that(CartItems.count()).isGreaterThanOrEqualTo(2)
        );
    }

    @When("el usuario completa el proceso de checkout como invitado")
    public void elUsuarioCompletaElProcesoDeCheckoutComoInvitado() {
        Customer customer = Customer.builder()
                .firstName("Andy")
                .lastName("Lema")
                .email("andy.lema" + System.currentTimeMillis() + "@example.com")
                .telephone("0978743389")
                .address("Calle Principal Juan de Velasco")
                .city("Ciudad")
                .postcode("12345")
                .country("Ecuador")
                .region("Chimborazo")
                .build();

        usuario.attemptsTo(CompleteCheckout.asGuest(customer));
    }

    @Then("el usuario debería ver el mensaje {string}")
    public void elUsuarioDeberiaVerElMensaje(String mensaje) {
        usuario.attemptsTo(
                Ensure.that(OrderConfirmation.isDisplayed()).isTrue()
        );
    }
}
