# Handmade Shop – Backend

Backend REST de una plataforma e-commerce para productos artesanales desarrollado con **Java 21** y **Spring Boot**, siguiendo una **Arquitectura Hexagonal** y aplicando principios de Clean Architecture.

Este proyecto forma parte de mi portfolio como desarrolladora **Backend / Full Stack Junior**, con el objetivo de demostrar conocimientos en diseño de APIs REST, arquitectura de software, seguridad mediante JWT y desarrollo de aplicaciones con Spring Boot.

> **Frontend del proyecto:** https://github.com/manuela217/handmade-shop-frontend

---

## Características

- Registro y autenticación de usuarios
- Autenticación mediante JWT
- Autorización basada en roles (ADMIN / USER)
- Gestión de categorías
- Gestión de productos
- Gestión de pedidos
- API REST
- Arquitectura Hexagonal
- Persistencia con PostgreSQL

---

## Tecnologías

| Tecnología | Uso |
|-----|-----|
| Java 21 | Lenguaje principal |
| Spring Boot | Framework backend |
| Spring Security | Seguridad y autorización |
| JWT | Autenticación |
| Spring Data JPA | Persistencia |
| PostgreSQL | Base de datos |
| Maven | Gestión de dependencias |
| MapStruct | Conversión entre entidades y DTOs |
| Lombok | Reducción de código repetitivo |

---

El proyecto sigue una **Arquitectura Hexagonal**, separando claramente la lógica de negocio de la infraestructura.

```
src/main/java
└── com.handmade.ecommerce.backend
    ├── application
    │   └── service
    ├── domain
    │   ├── model
    │   └── port
    └── infrastructure
        ├── adapter
        ├── config
        ├── dto
        ├── entity
        ├── jwt
        ├── mapper
        ├── rest
        └── service
```

### Capas

**Domain**

Contiene el modelo de dominio y las interfaces (Ports). No depende de Spring ni de ninguna tecnología externa.

**Application**

Implementa la lógica de negocio mediante casos de uso y servicios.

**Infrastructure**

Contiene la implementación técnica del proyecto:

- Controladores REST
- Persistencia con Spring Data JPA
- Seguridad
- Configuración
- JWT
- Mappers
- DTOs

---

## Seguridad

La autenticación está implementada mediante **Spring Security** y **JWT (JSON Web Token)**.

### Flujo de autenticación

1. El usuario inicia sesión.
2. Spring Security valida las credenciales.
3. Se genera un JWT firmado.
4. El cliente envía el token como **Bearer Token**.
5. Los endpoints protegidos validan el token antes de procesar la petición.

### Roles

| Rol   | Permisos                          |
|-------|-----------------------------------|
| ADMIN | Gestión de productos y categorías |
| USER  | Gestión de sus propios pedidos    |

---

## Endpoints principales

### Autenticación

| Método | Endpoint                    | Descripción |
|--------|-----------------------------|-------------|
| POST   | `/api/v1/security/register` | Registro    |
| POST   | `/api/v1/security/login`    | Login       |

---

### Usuarios

| Método | Endpoint             | Descripción            |
|--------|----------------------|------------------------|
| POST   | `/api/v1/users`      | Crear usuario          |
| GET    | `/api/v1/users/{id}` | Obtener usuario por ID |

---

### Categorías

| Método | Endpoint                        | Descripción                  |
|--------|---------------------------------|------------------------------|
| POST   | `/api/v1/admin/categories`      | Crear nueva categoría        |
| GET    | `/api/v1/admin/categories`      | Obtener todas las categorías |
| GET    | `/api/v1/admin/categories/{id}` | Obtener categoría por ID     |
| DELETE | `/api/v1/admin/categories/{id}` | Eliminar categoría por ID    |

---

### Productos

| Método | Endpoint                      | Descripción                 |
|--------|-------------------------------|-----------------------------|
| POST   | `/api/v1/admin/products`      | Crear nuevo producto        |
| GET    | `/api/v1/admin/products`      | Obtener todos los productos |
| GET    | `/api/v1/admin/products/{id}` | Obtener producto por ID     |
| DELETE | `/api/v1/admin/products/{id}` | Eliminar producto por ID    |

---

### Pedidos

| Método | Endpoint | Descripción                        |
|---------|----------|------------------------------------|
| POST | `/api/v1/orders` | Crear nuevo pedido                 |
| GET | `/api/v1/orders` | Obtener todos los pedidos          |
| GET | `/api/v1/orders/{id}` | Obtener pedido por ID              |
| GET | `/api/v1/orders/by-user/{userId}` | Obtener pedido por ID de usuario   |
| PUT | `/api/v1/orders/{id}/state` | Actualizar estado de pedido por ID |

---

## Configuración

### Requisitos

- Java 21
- Maven
- PostgreSQL

### Clonar el proyecto

```bash
git clone git@github.com:manuela217/handmade-shop-backend.git

cd handmade-shop-backend
```

---

### Base de datos

Crear una base de datos llamada:

```
handmade_shop
```

Configurar las credenciales en:

```
application-dev.properties
```

Ejemplo:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/handmade_shop
spring.datasource.username=postgres
spring.datasource.password=postgres
```

---

### JWT

La aplicación utiliza una variable de entorno para configurar el secreto del JWT.

```bash
JWT_SECRET=your-very-long-secret-key
```

En desarrollo existe una clave por defecto definida en `application.properties` únicamente para facilitar la ejecución del proyecto.

---

### Ejecutar la aplicación

```bash
mvn clean install

mvn spring-boot:run
```

La API estará disponible en:

```
http://localhost:8080
```

---

## Pruebas

Los endpoints pueden probarse mediante **Postman** utilizando:

- Registro de usuario
- Login
- Bearer Token
- Endpoints protegidos

---

## Próximas mejoras

- Tests unitarios
- Tests de integración
- Docker Compose

---

## Objetivos de aprendizaje

Durante el desarrollo de este proyecto se han aplicado conceptos como:

- Arquitectura Hexagonal
- Diseño de APIs REST
- Spring Security
- Autenticación JWT
- Persistencia con Spring Data JPA
- Principios SOLID
- Separación de responsabilidades
- Mapeo entre entidades y DTOs
- Gestión de perfiles de Spring

---

## 👩‍💻 Autor

Desarrollado por Manuela Mendoza Barba

Proyecto de portfolio como desarrolladora backend/fullstack junior

- GitHub: https://github.com/manuela217
- LinkedIn: https://www.linkedin.com/in/manuela-mendoza-barba/

---

> Este proyecto forma parte de mi portfolio personal y tiene un propósito educativo y demostrativo. Su desarrollo continúa con nuevas funcionalidades y mejoras conforme avanzo en mi aprendizaje de Java y Spring Boot.