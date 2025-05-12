package com.opencart.questions;

import com.opencart.ui.CartPage;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class CartItems {

    // Constructor privado para ocultar el constructor público implícito
    private CartItems() {
        // Este constructor no debe ser utilizado
    }

    public static Question<Integer> count() {
        return actor -> {
            ListOfWebElementFacades items = BrowseTheWeb.as(actor).findAll(CartPage.CART_ITEMS);
            return items.size();
        };
    }
}