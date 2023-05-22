# <h1 align="center">Project Management Group</h1>

<p align="center">
  <img src="https://img.shields.io/badge/version-1.0-green">
  <img src="https://img.shields.io/badge/test-✓-green">
  <img src="https://img.shields.io/badge/code-java-blueviolet">
  <img src="https://img.shields.io/badge/database-MySQL-informational">
  <img src="https://img.shields.io/badge/rating-⭐⭐⭐⭐⭐-blueviolet">
</p>

***

#### Gracias por visitar el repositorio de nuestro proyecto en GitHub. Nos complace presentarte nuestra aplicación, la cual ha sido desarrollada con el objetivo de brindar una solución práctica y eficiente para la gestión de proyectos integradores.

***

## Manual de usuario 📒

### **Ventana de login**

> Para iniciar sesión en la aplicación, el administrador, iniciará sesión con el usuario **root** y la contraseña **root**. Esta acción establecerá conexión con la base de datos existente y nos dará paso al menú (ventana principal) de nuestra aplicación.

<p align="center">
  <img src="Documentación%20Prog/imagenes/ventanaLogin.png" width="45%">
</p>

### **Ventana principal del menú**

> Una vez hayamos iniciado sesión de manera correcta, nos aparecerá la ventana principal del programa que es con la que nos moveremos a través de las pantallas. Esta ventana principal está compuesta por el menú, tiene distintas opciones como podemos ver en la siguiente imagen.

<p align="center">
  <img src="Documentación%20Prog/imagenes/ventanaPrincipal.png" width="45%">
</p>

***

Lo primero que nos encontramos sería las siguientes opciones para los proyectos integradores:
* dar de alta.
* dar de baja. 
* editar.
* consultar. 

_Para la parte del alta, una vez introduzcamos todos los datos, nos generará el código del proyecto automáticamente, que es el que nos valdrá para dar de baja, editar y consultarlo en un futuro._

### **Ventana de alta de proyectos integradores**

> Aquí asociaremos el nombre del grupo, la URL del proyecto, el curso, la nota, el año y el área al que corresponde el proyecto. Una vez finalizado, le daremos al botón de ALTA y nos aparecerá un mensaje de aviso como que se ha realizado correctamente. En caso contrario nos mostrará un mensaje de error.

<p align="center">
  <img src="Documentación%20Prog/imagenes/ventanaAltaPI.png" width="45%">
</p>

### **Ventana de baja de proyectos integradores**

> Para dar de baja un proyecto, solo nos bastaría con el código generado en el alta, lo introduciríamos y haríamos clic en el botón de borrar. En caso de que no nos acordemos del código del proyecto, en la parte inferior de la ventana, hay un botón de consulta que nos llevaría a la ventana de consulta de proyectos integradores.

<p align="center">
  <img src="Documentación%20Prog/imagenes/ventanaBajaPI.png" width="45%">
</p>

### **Ventana de edición de proyectos integradores**

> Como ya sabemos el código del proyecto integrador que vamos a querer editar, nos posicionamos donde pone introduce el código del proyecto, acto seguido le damos al botón de editar, y nos aparecerá los campos rellenados con los datos del PI asociados a ese código. Solo cambiaremos los datos que queramos y le damos a guardar, y ya se habrán efectuado los cambios correctamente.

<p align="center">
  <img src="Documentación%20Prog/imagenes/ventanaEdicionPI.png" width="45%">
</p>

### **Ventana de consulta de proyectos integradores**

> Se podrá filtrar por áreas y nos mostrará todos los proyectos existentes, una vez hayamos terminado, le daremos al botón atrás que nos llevará a la ventana principal del menú. Este botón está implementado en todas las ventanas disponibles.

<p align="center">
  <img src="Documentación%20Prog/imagenes/ventanaConsultaPI.png" width="45%">
</p>

***

Ahora pasamos a la parte que engloba a los alumnos de la base de datos, con las siguientes opciones:
* dar de alta.
* dar de baja. 
* editar.
* consultar. 

_Son prácticamente iguales a las anteriores mencionadas con mínimas diferencias._

### **Ventana de alta de alumnos**

> Podemos ver que ahora hay que introducir también el número de expediente y el código del proyecto. Como pasaba en la anterior de alta de PI, ahora una vez demos de alta al alumno, nos generará un código alfanumérico de 6 cifras asociado al alumno.

<p align="center">
  <img src="Documentación%20Prog/imagenes/ventanaAlumnosAlta.png" width="45%">
</p>

### **Ventana de baja de alumnos**

> Se borran introduciendo el código del alumno generado dándole al botón de borrar. Si se ha borrado correctamente nos aparecerá un mensaje de aviso, y sino, un mensaje de error. También existe un botón por si no nos acordamos del alumno, ir directamente a la consulta de todos los alumnos existentes en la base de datos.

<p align="center">
  <img src="Documentación%20Prog/imagenes/ventanaALumnosBaja.png" width="45%">
</p>

### **Ventana de edición de alumnos**

> Funcionan de la misma manera que en la parte de proyectos integradores. Introducimos el código del alumno y se nos rellenará los datos de dicho alumno para poder modificarlos a nuestro gusto. Una vez introducido el código, dicha etiqueta se bloqueará para no poder cambiarlo.

<p align="center">
  <img src="Documentación%20Prog/imagenes/ventanaEdicionAlumnos.png" width="45%">
</p>

### **Ventana de consulta de alumnos**

> Filtramos por el área que queremos consultar y nos aparecerán todos los alumnos asociados a la base de datos.

<p align="center">
  <img src="Documentación%20Prog/imagenes/ventanaConsultaAlumnos.png" width="45%">
</p>

***

Damos paso a la penúltima opción de nuestro menú, que constaria de todo lo relacionado con las áreas con las opciones:
* dar de alta.
* dar de baja. 
* editar.

### **Ventana de alta de áreas**

> Para dar de alta a un área, solo nos hará falta dar el nombre corto de la misma, como podría ser por ejemplo DAW (Desarrollo de Aplicaciones Web), y una breve descripción del mismo.

<p align="center">
  <img src="Documentación%20Prog/imagenes/ventanaAreasAlta.png" width="45%">
</p>

### **Ventana de baja de áreas**

> Para borrar un área, a diferencia de las otras ventanas de borrado, ahora lo que introduciremos será el nombre corto de dicha área.

<p align="center">
  <img src="Documentación%20Prog/imagenes/ventanaBajaAreas.png" width="45%">
</p>

### **Ventana de edición de áreas**

> A la hora de editar un área, introduciremos el nombre y nos aparecerá la breve descripción y la podremos cambiar a nuestro gusto. Para reflejar los cambios le daremos al botón GUARDAR.

<p align="center">
  <img src="Documentación%20Prog/imagenes/ventanaEdicionAreas.png" width="45%">
</p>

***

### **Ventana de ayuda**

> Por último, disponemos de una ventana de ayuda, la cual mostrará un pequeño mensaje y al terminar el párrafo, nuestro e-mail para que se pongan en contacto con nosotros si tienen alguna duda que les quede por resolver.

<p align="center">
  <img src="Documentación%20Prog/imagenes/ventanaAyudaBuena.png" width="45%">
</p>


## Autores ✒️

* **Juan Pablo Motta** - *Desarrollador* - [JuanDiegoMotta](https://github.com/JuanDiegoMotta)
* **Pablo Naranjo Cid** - *Desarrollador* - [AlPablo14](https://github.com/AlPablo14)
* **Jorge Burgos Barrera** - *Desarrollador* - [jorgeBurgosBr](https://github.com/jorgeBurgosBr)
