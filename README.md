# Handmade Shop – Backend

Backend de una plataforma e-commerce para productos artesanales.

## Tecnologías
- Java 21
- Spring Boot
- Maven
- PostgreSQL

## Arquitectura
- Arquitectura Hexagonal
    - domain
    - application
    - infrastructure

## Perfiles
- dev (desarrollo)
- prod (producción)

Proyecto en desarrollo.



# Handmade Shop – Backend

Backend de una plataforma e-commerce para productos artesanales (handmade), desarrollado con Java y Spring Boot inspirado en una arquitectura hexagonal.

---

## Descripción

Este proyecto implementa el backend de una tienda online de productos artesanales.

La aplicación permite gestionar un catálogo de productos y procesar pedidos de usuarios, diferenciando conceptualmente entre:

* Usuarios: pueden registrarse y realizar pedidos
* Admins: encargados de crear y gestionar productos y categorías

Funcionalidades principales:

* Registro de usuarios
* Gestión de productos y categorías
* Creación de pedidos con múltiples productos
* Actualización del estado de los pedidos

El objetivo del proyecto es aplicar buenas prácticas de desarrollo backend y arquitectura limpia, separando claramente dominio, lógica de negocio e infraestructura.

⚠️ Nota: La gestión de roles y seguridad (autenticación/autorización) está planteada para llevarse a cabo más adelante.

---

## Tecnologías utilizadas

* Java 21
* Spring Boot
* Spring Data JPA
* Maven
* PostgreSQL
* MapStruct
* Lombok

---

## Arquitectura

El proyecto sigue una arquitectura hexagonal:

```
domain        → modelos y ports (interfaces)
application   → lógica de negocio (servicios)
infrastructure→ persistencia, controladores REST y configuración
```

### Principios aplicados:

* Separación de responsabilidades
* Bajo acoplamiento entre capas
* Independencia del framework en el dominio

---

## Funcionalidades principales

### Usuarios

* Crear usuario
* Obtener usuario por id

### Categorías

* Crear categoría
* Listar categorías
* Eliminar categoría

### Productos

* Crear producto
* Listar productos
* Eliminar producto

### Pedidos (Orders)

* Crear pedido con múltiples productos
* Obtener pedidos
* Obtener pedidos por usuario
* Actualizar estado del pedido (CONFIRMED / CANCELLED)

---

## Endpoints principales

### Orders

```http
POST   /api/v1/orders
GET    /api/v1/orders
GET    /api/v1/orders/{id}
GET    /api/v1/orders/by-user/{userId}
PUT    /api/v1/orders/{id}/state?state=CONFIRMED
```

---

## Configuración y ejecución

### 1. Clonar el repositorio

```bash
git clone https://github.com/TU_USUARIO/handmade-shop-backend.git
cd handmade-shop-backend
```

### 2. Configurar base de datos

Crear una base de datos en PostgreSQL:

```text
handmade_shop
```

Configurar en `application-dev.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/handmade_shop
spring.datasource.username=postgres
spring.datasource.password=postgres
```

---

### 3. Ejecutar la aplicación

```bash
mvn spring-boot:run
```

La aplicación estará disponible en:

```
http://localhost:8080
```

---

## Pruebas con Postman

Se recomienda crear una colección con:

* Users
* Categories
* Products
* Orders
* Update orders

---

## Estado del proyecto

Proyecto en desarrollo.

### Próximos pasos:

* Implementación de DTOs
* Manejo global de excepciones
* Seguridad (Spring Security + JWT)
* Desarrollo del frontend en Angular

---

## 👩‍💻 Autor

Desarrollado por Manuela Mendoza Barba
Proyecto de portfolio como desarrolladora backend/fullstack junior
