#language: es
  Característica: Automatizar el proceso de compras en la tienda online de Advantage
  Agregando diferentes productos de las distintas categorías y validando el cálculo del total de la compra

  Escenario: Agregar diferentes productos al carrito y validar el total de la compra
    Dado que el cliente se encuentra en la página de inicio
    Cuando el cliente selecciona los siguientes productos y los agrega al carrito
      | categoría | producto                    |
      | TABLETS   | HP Pro Tablet 608 G1        |
      | MICE      | HP Z4000 Wireless Mouse     |
    Y el cliente navega al carrito de compras
    Entonces se valida que el total de la compra sea igual a la suma del precio de los productos seleccionados