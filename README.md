# 🍏 S04T02N02 - Fruits CRUD API (Spring Boot + MySQL + Flyway + Docker)

Este proyecto es una **API REST** para gestionar frutas.  
Se ha desarrollado con **Spring Boot 3**, **Spring Data JPA**, **Flyway**, **MySQL** y **Docker**.

---

## 🚀 Tecnologías usadas
- Java 17
- Spring Boot (Web, Data JPA, Validation)
- Flyway (migraciones de base de datos)
- MySQL 8
- Docker + Docker Compose
- Maven

---

## 📂 Estructura del proyecto
```
S04T02N02/
├─ src/
│  ├─ main/java/cat/itacademy/s04/t02/n02/s04t02n02/
│  │  ├─ controller/     # Controladores REST
│  │  ├─ dto/            # Objetos de transferencia (Request/Response)
│  │  ├─ exception/      # Manejo de excepciones globales
│  │  ├─ model/          # Entidades JPA
│  │  ├─ repository/     # Repositorios JPA
│  │  └─ service/        # Lógica de negocio
│  └─ resources/
│     ├─ application.properties
│     └─ db/migration/   # Migraciones Flyway (V1__init.sql, V2__...)
├─ pom.xml
├─ .env.example
├─ Dockerfile
└─ docker-compose.yml
```

---

## ⚙️ Configuración

### 1. Variables de entorno
La aplicación usa **variables de entorno** para configurarse.  
Ejemplo de archivo `.env` (se incluye un `.env.example` de referencia):

```dotenv
SPRING_DATASOURCE_URL=jdbc:mysql://mysql:3306/fruitsdb?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
SPRING_DATASOURCE_USERNAME=root
SPRING_DATASOURCE_PASSWORD=root

MYSQL_ROOT_PASSWORD=root
MYSQL_DATABASE=fruitsdb
```

> ⚠️ Copia `.env.example` a `.env` y edita los valores según tu entorno.

---

### 2. Construir el proyecto
```bash
mvn clean package -DskipTests
```

### 3. Levantar con Docker Compose
```bash
docker-compose up --build
```

Esto levantará:
- **MySQL** en `localhost:3306`
- **API** en `http://localhost:8080`

Flyway aplicará automáticamente las migraciones (`db/migration`) al arrancar.

---

## 📌 Endpoints principales

| Método | Endpoint           | Descripción               |
|--------|--------------------|---------------------------|
| GET    | `/api/fruits`      | Listar todas las frutas   |
| GET    | `/api/fruits/{id}` | Obtener fruta por ID      |
| POST   | `/api/fruits`      | Crear nueva fruta         |
| PUT    | `/api/fruits/{id}` | Actualizar fruta por ID   |
| DELETE | `/api/fruits/{id}` | Eliminar fruta por ID     |

Ejemplo de **JSON** para `POST` y `PUT`:
```json
{
  "name": "Mango",
  "quantityKilos": 12
}
```

---

## 🐳 Ejecutar con Docker

```bash
# Compilar y levantar contenedores
docker-compose up --build

# Ver logs de la aplicación
docker logs s04t02n02-app -f
```

---

## 📚 Migraciones con Flyway
- Los scripts SQL se encuentran en `src/main/resources/db/migration/`.
- Cada archivo sigue el formato `V<version>__<descripcion>.sql`.
    - Ejemplo: `V1__init.sql` crea la tabla `fruits` e inserta datos iniciales.
- Flyway asegura que cada migración se ejecute **solo una vez** y lleva un registro en la tabla `flyway_schema_history`.

---

## ✅ Recursos adicionales
- [Spring Boot Reference Documentation](https://docs.spring.io/spring-boot/docs/current/reference/html/)
- [Flyway Documentation](https://flywaydb.org/documentation/)
- [Docker Compose Documentation](https://docs.docker.com/compose/)  
