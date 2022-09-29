#language: es
# Author : Ismael Carvajal

Característica: Registrar un usuario mediante nombre de usuario, email y contraseña
  Yo como QA Automatizador
  Quiero validar la funcionalidad para registrar un usuario
  Para garantizar que los datos del usuario se añaden correctamente

  Escenario: El analista garantiza que la respuesta del sistema sea correcta
    Dado que el analista envia una peticion con los siguientes datos:
      | username | email           | password |
      | Maria    | maria@gmail.com | jkl5678  |
    Cuando el analista agregue los datos del usuario mediante el 'register'
    Entonces deberia ver como respuesta un codigo 200
