# Integrador_DNRPA

RESUMEN DEL TRABAJO: 
El sistema trata de responder a través del menú ppal a las consignas obligatorias y opcionales del TP (se puede hacer más funcional, implementando ligeros cambios) --> 
xejemplo, poder listar el automotor que se quiera y no solo los autos, o poder listar los propietarios del automotor que sea (primeras 2 consignas del TP)

El sistema cuenta con una rudimentaria DB de automotores y personas para poder jugar un poco. Estos automotores tienen fecha de registro con más de un año para poder cambiar de propietario.


CONSIGNA DE TRABAJO:
La DNRPA (Dirección Nac. Reg. Propiedad del Automotor) necesita un sistema para anotar todos los vehículos registrados en el país.
La DNRPA tiene Registrosseccionales.Cada Registro tiene automotores registrados.
Los automotores pueden ser de uso particular o profesional.
Se registran motos eléctricas, autos eléctricos, motocicletas y automóviles a combustión, colectivos, utilitarios y camiones.
Todos losvehículos tienen un único propietario y autorizados a conducir.De los propietarios y autorizados se sabe el nombre, DNI y dirección.
Herramientas de java obligatorias:
Enums, excepciones, random, listas, interfaces, herencia, Date o LocalDate.
Consignas obligatorias:
1)Se desea poder listar todos los autos registrados en todas las seccionales.
2)Se desea poder listar a todos los propietarios (en orden alfabético) de camiones.
3)Los automotores pueden cambiar de propietario.
4)Se debe registrar la fecha de cambio de propietario.
5)Se debe poder dar de alta un nuevo automotor. Registrar esa fecha también.
6)No se puede cambiar de propietario si pasó menos de 1 año desde la fecha del último cambio de propietario.
Consignas opcionales:
1)Cada automotor tiene una PATENTE única que se asigna automáticamente al realizar el alta o registro.Formatos de patente: AA123BB o ABC123.
2)Se puede consultar si pasó un año o más desde el registro o cambio de titular, para un auto en particular (se consulta por patente).
