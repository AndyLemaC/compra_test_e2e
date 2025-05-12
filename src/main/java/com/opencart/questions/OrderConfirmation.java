
package com.opencart.questions;

import com.opencart.ui.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.targets.Target;

public class OrderConfirmation {

    // Constructor privado para ocultar el constructor público implícito
    private OrderConfirmation() {
        // Este constructor no debe ser utilizado
    }

    @Subject("verificación del mensaje de confirmación de orden")
    public static Question<Boolean> isDisplayed() {
        return actor -> {
            Target target = CheckoutPage.ORDER_SUCCESS;
            return target.resolveFor(actor).isVisible();
        };
    }
}


