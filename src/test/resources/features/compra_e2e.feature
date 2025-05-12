Feature: Proceso de compra E2E
  Como un cliente
  Quiero poder agregar productos al carrito y completar la compra
  Para obtener los productos que deseo

  Scenario: Completar un proceso de compra como invitado
    Given que el usuario está en la página de inicio
    When el usuario agrega 2 productos diferentes al carrito
    And el usuario visualiza el contenido del carrito
    And el usuario completa el proceso de checkout como invitado
    Then el usuario debería ver el mensaje "Your order has been placed!"
