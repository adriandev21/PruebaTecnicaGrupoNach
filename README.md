# PruebaTecnicaGrupoNach
Repositorio creado para documentar la prueba técnica realizada para grupo nach.

## Requisitos Previos
- Java 17+
- MySQL 8+
- Maven
- Editor de codigo para el compilado de la aplicación.

## Configuración
### Base de Datos
Script de base de datos completo:
Ver script completo: [script.sql](/pruebatecnica/src/main/resources/DBExamen.sql)

## Configurar application-local.properties:
```config
spring.datasource.url=jdbc:mysql://localhost:tu_puerto/test_nach
spring.datasource.username=tu_usuario
spring.datasource.password=tu_password

```

Ejecución

```code
mvn spring-boot:run
```
