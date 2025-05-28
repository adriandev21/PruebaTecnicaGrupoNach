# PruebaTecnicaGrupoNach
Repositorio creado para documentar la prueba técnica realizada para grupo nach.

## Requisitos Previos
- Java 17+
- MySQL 8+
- Maven
- Editor de codigo para el compilado de la aplicación.

## Configuración
### Base de Datos
Script de base de datos completo: [script.sql](/pruebatecnica/src/main/resources/DBExamen.sql)

Tambien es importante ejecutar los siguientes scripts para cargar los generos y los puestos:
```sql
INSERT INTO `test_nach`.`genders` (`id`, `name`) VALUES ('1', 'Masculino');
INSERT INTO `test_nach`.`genders` (`id`, `name`) VALUES ('2', 'Femenino');
INSERT INTO `test_nach`.`genders` (`id`, `name`) VALUES ('3', 'Otro');

INSERT INTO `test_nach`.`jobs` (`id`, `name`, `salary`) VALUES ('1', 'Desarrollador', '25000');
INSERT INTO `test_nach`.`jobs` (`id`, `name`, `salary`) VALUES ('2', 'Gerente', '50000');
INSERT INTO `test_nach`.`jobs` (`id`, `name`, `salary`) VALUES ('3', 'Lider Tecnico', '40000');
```

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

### Diagrama entidad relación
![image](https://github.com/user-attachments/assets/91801eff-b5e2-4d80-8fae-1f7abb2562df)

### Endpoints

- `POST /api/empleados/` - Agregar nuevo empleado
- `POST /api/empleados/horas-trabajadas` - Agregar horas trabajadas
- `POST /api/empleados/puesto` - Consultar los empleados por puesto
- `POST /api/empleados/horas-totales` - Consultar total de horas de un empleado por un rango de fechas
- `POST /api/empleados/pago` - Consultar cuanto se le pago a un empleado por un rango de fechas


### Ejemplos de uso

1.- Agregar nuevo empleado 
```json
{
    "gender_id": 1, 
    "job_id": 1, 
    "name": "Juan",
    "last_name": "Pérez", 
    "birthdate": "1983-01-01"
}
```

Salida:
<img width="1078" alt="image" src="https://github.com/user-attachments/assets/e5d672fa-d3c9-4559-8aff-65b722f153ea" />

2.- Agregar horas trabajadas
```json
{
    "employee_id": 1, 
    "worked_hours": 10, 
    "worked_date": "2019-01-01" 
}
```

Salida:
![image](https://github.com/user-attachments/assets/66a1430f-4e1b-4621-8d47-04fa1a66ebd8)

3.- Consultar los empleados por puesto
```json
{
    "job_id": 1
}
```

Salida: 
![image](https://github.com/user-attachments/assets/661cfe25-0e76-40b9-9d74-9af1ff4b9a8e)

4.- Consultar total de horas de un empleado por un rango de fechas
```json
{
    "employee_id": 1,
    "start_date": "2019-01-01",
    "end_date": "2019-06-30"
}
```
Salida:
![image](https://github.com/user-attachments/assets/732c8db5-86d7-43e0-bb58-9bcc92ea2a4f)

5.- Consultar cuanto se le pago a un empleado por un rango de fechas
```json
{
    "employee_id": 1, 
    "start_date": "2019-01-01",
    "end_date": "2019-06-30"
}
```

Salida: 
![image](https://github.com/user-attachments/assets/b443fcb5-a1ea-4d85-be92-90b3c1cc8698)

En este caso tuve que ingresar el pago por medio de la BD directo, ya que no existe algún API para realizar dicho proceso.
```sql
INSERT INTO `test_nach`.`payments` (`id`, `employee_id`, `amount`, `payment_date`) VALUES ('1', '1', '10000.00', '2019-02-01');
```
