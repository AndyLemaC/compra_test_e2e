package com.opencart.tasks;

import com.opencart.ui.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ViewCart implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(HomePage.CART_BUTTON),
                WaitUntil.the(HomePage.VIEW_CART, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(HomePage.VIEW_CART)
        );
    }

    public static ViewCart now() {
        return instrumented(ViewCart.class);
    }
}
