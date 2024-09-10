# Flowershop Spring Boot Project

Este proyecto es una aplicación Spring Boot para una tienda de flores.

## Requisitos previos

- Java Development Kit (JDK) 21
- Maven 3.6+ (generalmente viene incluido con Spring Boot)
- IntelliJ IDEA o Visual Studio Code

## Estructura del proyecto

```
java/
└── com
    └── soa
        └── flowershop
            ├── FlowershopApplication.java
            ├── controllers
            │   ├── OrderController.java
            │   └── ProductController.java
            ├── dtos
            │   ├── CreateOrderRequest.java
            │   ├── OrderDTO.java
            │   └── OrderProductDTO.java
            ├── models
            │   ├── OrderModel.java
            │   ├── OrderProductModel.java
            │   └── ProductModel.java
            ├── repositories
            │   ├── IOrderProductRepository.java
            │   ├── IOrderRepository.java
            │   └── IProductRepository.java
            └── services
                ├── OrderService.java
                └── ProductService.java
```

## Configuración y ejecución

### IntelliJ IDEA

1. Abre IntelliJ IDEA y selecciona "File" > "Open".
2. Navega hasta el directorio del proyecto y selecciónalo.
3. IntelliJ IDEA debería detectar automáticamente que es un proyecto Maven y comenzará a indexar y descargar las dependencias.
4. Una vez finalizada la indexación, busca la clase `FlowershopApplication.java`.
5. Haz clic derecho en esta clase y selecciona "Run 'FlowershopApplication'".

### Visual Studio Code

1. Abre Visual Studio Code.
2. Selecciona "File" > "Open Folder" y navega hasta el directorio del proyecto.
3. Asegúrate de tener instalada la extensión "Extension Pack for Java" y "Spring Boot Extension Pack".
4. Abre una terminal integrada en VS Code (Terminal > New Terminal).
5. Ejecuta el siguiente comando:
   ```
   ./mvnw spring-boot:run
   ```
   O si estás en Windows:
   ```
   mvnw.cmd spring-boot:run
   ```

## Verificación de la aplicación

Una vez que la aplicación esté en ejecución, puedes verificar su funcionamiento accediendo a:

```
http://localhost:8080
```

## Personalización

- El archivo `application.properties` (o `application.yml`) en el directorio `src/main/resources` contiene la configuración de la aplicación. Ajusta los valores según sea necesario.

## Problemas comunes

- Si encuentras problemas con las dependencias, intenta ejecutar `mvn clean install` desde la línea de comandos en el directorio raíz del proyecto.
- Asegúrate de que tu JAVA_HOME esté configurado correctamente y apunte a JDK 21.

## Contribuir

Si deseas contribuir al proyecto, por favor crea un fork del repositorio y envía un pull request con tus cambios.