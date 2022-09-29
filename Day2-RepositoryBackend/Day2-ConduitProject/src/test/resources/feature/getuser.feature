#language: es
# Author : Ismael Carvajal

Característica: Obtener la información de un usuario registrado
  Yo como QA Automatizador
  Quiero conseguir la información de los usuarios registrados
  Para validar los datos del usuario

  Escenario: El analista garantiza que la respuesta del sistema sea correcta
    Dado que el analista registró al usuario
    Cuando el analista solicite los usuarios registrados mediante el 'obtener'
    Entonces el sistema deberá devolver la información de dichos usuarios con el codigo 404
