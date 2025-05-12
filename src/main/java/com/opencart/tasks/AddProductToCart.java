package com.opencart.tasks;

import com.opencart.ui.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AddProductToCart implements Task {

    private final int productIndex;

    public AddProductToCart(int productIndex) {
        this.productIndex = productIndex;
    }

    @Override
    @Step("{0} agrega el producto #productIndex al carrito")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(HomePage.ADD_TO_CART_BUTTON.of(String.valueOf(productIndex))),
                WaitUntil.the(HomePage.SUCCESS_ALERT, isVisible()).forNoMoreThan(10).seconds()
        );
    }

    public static AddProductToCart atIndex(int productIndex) {
        return instrumented(AddProductToCart.class, productIndex);
    }
}