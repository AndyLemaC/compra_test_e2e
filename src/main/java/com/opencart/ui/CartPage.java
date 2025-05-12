package com.opencart.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CartPage {

    private CartPage() {
        // Este constructor no debe ser utilizado
    }
    public static final Target CART_ITEMS = Target.the("productos en el carrito")
            .located(By.cssSelector(".table-responsive tbody tr"));
    public static final Target CHECKOUT_BUTTON = Target.the("botón de checkout")
            .located(By.linkText("Checkout"));
}
