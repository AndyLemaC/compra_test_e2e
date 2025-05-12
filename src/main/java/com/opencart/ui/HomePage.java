package com.opencart.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePage {
    public static final Target PRODUCT = Target.the("producto").locatedBy("//div[contains(@class, 'product-layout')][{0}]//h4/a");
    public static final Target ADD_TO_CART_BUTTON = Target.the("botón de agregar al carrito")
            .locatedBy("//div[contains(@class, 'product-layout')][{0}]//button[contains(@onclick, 'cart.add')]");
    public static final Target SUCCESS_ALERT = Target.the("alerta de éxito")
            .located(By.cssSelector(".alert-success"));
    public static final Target CART_BUTTON = Target.the("botón de carrito")
            .located(By.id("cart"));
    public static final Target VIEW_CART = Target.the("ver carrito")
            .located(By.xpath("//p[@class='text-right']/a[contains(@href,'checkout/cart')]"));
}
