package com.opencart.tasks;

import com.opencart.models.Customer;
import com.opencart.ui.CartPage;
import com.opencart.ui.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CompleteCheckout implements Task {

    private final Customer customer;

    public CompleteCheckout(Customer customer) {
        this.customer = customer;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                // Iniciar checkout
                Click.on(CartPage.CHECKOUT_BUTTON),

                // Seleccionar guest checkout
                WaitUntil.the(CheckoutPage.GUEST_CHECKOUT, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(CheckoutPage.GUEST_CHECKOUT),
                Click.on(CheckoutPage.CONTINUE_BUTTON),

                // Completar información personal
                WaitUntil.the(CheckoutPage.FIRST_NAME, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(customer.getFirstName()).into(CheckoutPage.FIRST_NAME),
                Enter.theValue(customer.getLastName()).into(CheckoutPage.LAST_NAME),
                Enter.theValue(customer.getEmail()).into(CheckoutPage.EMAIL),
                Enter.theValue(customer.getTelephone()).into(CheckoutPage.TELEPHONE),
                Enter.theValue(customer.getAddress()).into(CheckoutPage.ADDRESS),
                Enter.theValue(customer.getCity()).into(CheckoutPage.CITY),
                Enter.theValue(customer.getPostcode()).into(CheckoutPage.POSTCODE),
                SelectFromOptions.byVisibleText(customer.getCountry()).from(CheckoutPage.COUNTRY),
                WaitUntil.the(CheckoutPage.REGION, isVisible()).forNoMoreThan(10).seconds(),
                SelectFromOptions.byVisibleText(customer.getRegion()).from(CheckoutPage.REGION),
                Click.on(CheckoutPage.GUEST_CONTINUE),

                // Métodos de envío y pago
                WaitUntil.the(CheckoutPage.SHIPPING_METHOD_CONTINUE, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(CheckoutPage.SHIPPING_METHOD_CONTINUE),

                WaitUntil.the(CheckoutPage.TERMS_CHECKBOX, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(CheckoutPage.TERMS_CHECKBOX),
                Click.on(CheckoutPage.PAYMENT_METHOD_CONTINUE),

                // Confirmar orden
                WaitUntil.the(CheckoutPage.CONFIRM_ORDER, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(CheckoutPage.CONFIRM_ORDER)
        );
    }

    public static CompleteCheckout asGuest(Customer customer) {
        return instrumented(CompleteCheckout.class, customer);
    }
}