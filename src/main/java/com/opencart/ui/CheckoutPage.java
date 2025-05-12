package com.opencart.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CheckoutPage {

    // Constructor privado para ocultar el constructor público implícito
    private CheckoutPage() {
        // Este constructor no debe ser utilizado
    }

    // Opciones de checkout
    public static final Target GUEST_CHECKOUT = Target.the("checkout como invitado")
            .located(By.xpath("//input[@value='guest']"));
    public static final Target CONTINUE_BUTTON = Target.the("botón continuar")
            .located(By.id("button-account"));

    // Formulario de información personal
    public static final Target FIRST_NAME = Target.the("nombre")
            .located(By.id("input-payment-firstname"));
    public static final Target LAST_NAME = Target.the("apellido")
            .located(By.id("input-payment-lastname"));
    public static final Target EMAIL = Target.the("email")
            .located(By.id("input-payment-email"));
    public static final Target TELEPHONE = Target.the("teléfono")
            .located(By.id("input-payment-telephone"));
    public static final Target ADDRESS = Target.the("dirección")
            .located(By.id("input-payment-address-1"));
    public static final Target CITY = Target.the("ciudad")
            .located(By.id("input-payment-city"));
    public static final Target POSTCODE = Target.the("código postal")
            .located(By.id("input-payment-postcode"));
    public static final Target COUNTRY = Target.the("país")
            .located(By.id("input-payment-country"));
    public static final Target REGION = Target.the("región")
            .located(By.id("input-payment-zone"));
    public static final Target GUEST_CONTINUE = Target.the("continuar guest checkout")
            .located(By.id("button-guest"));

    // Formulario de envío
    public static final Target TERMS_CHECKBOX = Target.the("términos y condiciones")
            .located(By.name("agree"));
    public static final Target SHIPPING_METHOD_CONTINUE = Target.the("continuar método de envío")
            .located(By.id("button-shipping-method"));
    public static final Target PAYMENT_METHOD_CONTINUE = Target.the("continuar método de pago")
            .located(By.id("button-payment-method"));

    // Confirmación y pago
    public static final Target CONFIRM_ORDER = Target.the("confirmar orden")
            .located(By.id("button-confirm"));

    // Orden completa
    public static final Target ORDER_SUCCESS = Target.the("mensaje de éxito de la orden")
            .located(By.xpath("//h1[contains(text(), 'Your order has been placed!')]"));
}
