#language: es
# Author : Ismael Carvajal

Característica: Registrar un usuario mediante usuario y contraseña
  Yo como QA Automatizador
  Quiero validar la funcionalidad para registrar un usuario
  Para garantizar que los datos del usuario se añaden correctamente

  Escenario: El analista garantiza que la respuesta del sistema sea correcta
    Dado que el analista loguea al usuario con los siguientes datos:
      | email              | password |
      | hernadez@gmail.com | ghi56    |
    Cuando el analista envie los datos del usuario mediante el 'login'
    Entonces deberia ver como respuesta un codigo 404
