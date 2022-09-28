#language: es
# Author : Ismael Carvajal

Característica: Registrar un usuario mediante usuario y contraseña
  Yo como QA Automatizador
  Quiero validar la funcionalidad para registrar un usuario
  Para garantizar que los datos del usuario se añaden correctamente

  Escenario: El analista garantiza que la respuesta del sistema sea correcta
    Dado que el analista envia una peticion con los siguientes datos:
      | username | email              | password |
      | Himelda  | fernanda@gmail.com | abc456   |
    Cuando el analista agregue los datos del usuario mediante el 'register'
    Entonces deberia ver como respuesta un codigo 200
