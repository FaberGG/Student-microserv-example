# Student API REST

Una API REST simple desarrollada con Spring Boot que proporciona operaciones CRUD completas para la gestión de estudiantes.

## 🚀 Características

- **CRUD completo** para la entidad Student
- **Arquitectura en capas** (Controller, Service, Repository, Entity)
- **Persistencia con JPA** y PostgreSQL
- **Docker Compose** para la base de datos

## 🛠️ Tecnologías

- **Java** con Spring Boot
- **Spring Data JPA** para persistencia
- **PostgreSQL** como base de datos
- **Docker & Docker Compose** para contenedores
- **Maven** como gestor de dependencias

## 📋 Prerrequisitos

- Java 17 o superior
- Maven 3.6+
- Docker y Docker Compose

## 🔧 Instalación y Configuración

### 1. Clonar el repositorio
```bash
git clone <url-del-repositorio>
cd student-api-rest
```

### 2. Levantar la base de datos
```bash
docker-compose up -d
```

Esto creará:
- **PostgreSQL** en el puerto `5432`
- **pgAdmin** en el puerto `5050` (admin@admin.com / admin123)

### 3. Ejecutar la aplicación
```bash
mvn spring-boot:run
```

La API estará disponible en: `http://localhost:8080`

## 📚 Endpoints de la API

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| `GET` | `/api/v1/students` | Obtener todos los estudiantes |
| `GET` | `/api/v1/students/{id}` | Obtener estudiante por ID |
| `POST` | `/api/v1/students` | Crear nuevo estudiante |
| `PUT` | `/api/v1/students/{id}` | Actualizar estudiante existente |
| `DELETE` | `/api/v1/students/{id}` | Eliminar estudiante |



## 🔍 Acceso a la Base de Datos

### Conexión directa
- **Host**: localhost
- **Puerto**: 5432
- **Base de datos**: studentdb
- **Usuario**: dev
- **Contraseña**: postgres

### pgAdmin (Interfaz web)
- **URL**: http://localhost:5050
- **Usuario**: admin@admin.com
- **Contraseña**: admin123

## 🏗️ Arquitectura

```
┌─────────────────┐
│   Controllers   │  ← Maneja peticiones HTTP
├─────────────────┤
│    Services     │  ← Lógica de negocio
├─────────────────┤
│  Repositories   │  ← Acceso a datos (JPA)
├─────────────────┤
│    Entities     │  ← Modelos de datos
└─────────────────┘
```


**Desarrollado por**: John Faber Navia Narváez  
**Materia**: Laboratorio Ingeniería de Software II  
**Universidad del Cauca** - Septiembre 2025
