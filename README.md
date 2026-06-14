# Tarea_Clase11 - Sistema de Gestión de Tienda Deportiva

## Descripción

Aplicación de escritorio desarrollada en JavaFX para la gestión básica de una tienda deportiva. El sistema permite la autenticación de usuarios mediante un inicio de sesión y el acceso a un dashboard principal con las funcionalidades implementadas para la administración de información.

El proyecto fue desarrollado aplicando Programación Orientada a Objetos (POO), JavaFX para la interfaz gráfica y CSS para la personalización visual.

## Captura del Dashboard

Agregar aquí la captura del dashboard principal.

```markdown
![Dashboard](img/dashboard.png)
```

## Tecnologías Utilizadas

* Java 26 (OpenJDK 26.0.1)
* JavaFX 21.0.6
* CSS3
* Maven 3.9.16
* IntelliJ IDEA

## Funcionalidades Implementadas

### Inicio de Sesión

* Validación de usuario y contraseña.
* Control de acceso al sistema.
* Mensajes de error para credenciales incorrectas.

### Dashboard Principal

* Interfaz principal del sistema.
* Navegación entre las diferentes opciones.
* Visualización de información relevante.

### Gestión de Productos

* Registro de productos.
* Consulta de productos disponibles.
* Administración de información utilizando Programación Orientada a Objetos.

### Diseño de Interfaz

* Aplicación de estilos mediante CSS.
* Diseño visual organizado y amigable.
* Uso de componentes JavaFX.

## Estructura de Carpetas

```text
Tarea_Clase11
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── example
│   │   │           └── tarea_clase11
│   │   │               ├── Main.java
│   │   │               ├── LoginController.java
│   │   │               ├── DashboardController.java
│   │   │               ├── Producto.java
│   │   │               └── Usuario.java
│   │   │
│   │   └── resources
│   │       └── com
│   │           └── example
│   │               └── tarea_clase11
│   │                   ├── login.fxml
│   │                   ├── dashboard.fxml
│   │                   └── estilos.css
│
├── pom.xml
└── README.md
```

## Instrucciones para Ejecutar el Proyecto

### Requisitos

* Java 26 o superior.
* Maven 3.9 o superior.
* IntelliJ IDEA (recomendado).

### Ejecución desde IntelliJ IDEA

1. Abrir el proyecto Maven.
2. Esperar a que Maven descargue las dependencias.
3. Seleccionar la configuración Maven:

   ```text
   clean javafx:run
   ```
4. Ejecutar la configuración desde IntelliJ IDEA.

### Ejecución desde Terminal

Ubicarse en la carpeta donde se encuentra el archivo `pom.xml` y ejecutar:

```bash
mvn clean javafx:run
```

La aplicación iniciará mostrando la pantalla de inicio de sesión.
