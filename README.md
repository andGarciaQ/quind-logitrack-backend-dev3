# LogiTrack - Sistema de Trazabilidad de Paquetes

LogiTrack es un microservicio diseñado bajo los principios de Arquitectura Hexagonal (Puertos y Adaptadores). Su objetivo principal es gestionar el ciclo de vida logístico de paqueteria, permitiendo el registro y seguimiento de estados, integrando persistencia relacional optimizada con tipos JSONB y comunicacion asincrona.

## Tecnologias

* **Lenguaje:** Java 24
* **Framework:** Spring Boot 3.5.4
* **Persistencia:** PostgreSQL (con soporte de columnas JSONB)
* **Migraciones:** Liquibase
* **Mapeo:** MapStruct & Lombok
* **Mensajeria:** Apache Kafka
* **Contenedores:** Docker & Docker Compose

## Arquitectura

El proyecto sigue una estructura estricta de Arquitectura Hexagonal, desacoplando el nucleo del dominio de las tecnologias externas.

### Estructura del Proyecto

```text
src/main/java/co/com/quind/logitrack
├── config/                  # Configuraciones de Spring
├── domain/                  
│   ├── model/               # Entidades del Dominio (Package, DeliveryAddress)
│   ├── ports/               # Interfaces (Contratos)
│   │   ├── inbound/         # Puertos de entrada (Casos de uso)
│   │   └── outbound/        # Puertos de salida (Repositorios)
│   └── usecase/             # Implementacion de casos de uso
├── infrastructure/          
│   ├── drivenadapters/      # Adaptadores de Salida
│   │   ├── kafkaproducer/   # Publicacion de eventos
│   │   └── sqlrepository/   # Implementacion JPA/Hibernate
│   │       ├── adapters/    # Implementacion de puertos outbound
│   │       ├── entities/    # Entidades JPA
│   │       ├── mappers/     # MapStruct
│   │       └── repositories/# Interfaces JpaRepository
│   └── entrypoints/         # Adaptadores de Entrada
│       └── apirest/         # Controladores REST y DTOs
└── MainApplication.java
```

### Modelo de Datos

Se utiliza un enfoque híbrido SQL/NoSQL en PostgreSQL para optimizar el rendimiento y la flexibilidad:

Tabla packages: Almacena la información vital. Los objetos de valor `dimensions` y `address` se persisten como columnas JSONB. Esto evita JOINS costosos para datos que siempre se consultan junto al paquete.

Tabla locations: Relación 1:N. Almacena el historial geográfico del paquete.

Tabla status_history: Relación 1:N. Almacena la auditoría de cambios de estado con fecha UTC.


### Referencia de API
El microservicio expone los siguientes recursos REST bajo el prefijo /api/packages.

1. Crear Paquete
   Registra un nuevo paquete. El ID de seguimiento es generado por el sistema.

```
URL: /api/packages

Método: POST

Content-Type: application/json
```

```json
{
  "address": {
    "name": "Andres garcia",
    "address": "Av. El Dorado #68B-31",
    "cityName": "Bogotá",
    "countryName": "Colombia",
    "neighborhood": "Airport"
  },
  "dimensions": {
    "width": 35.5,
    "height": 10.0,
    "depth": 25.0,
    "weight": 1.5
  }
}
```

```json
{
    "trackingId": "8aa90daa-c4ad-4a6f-9ff6-99b900995f3a",
    "address": {
        "name": "Andres garcia",
        "cityName": "Bogotá",
        "countryName": "Colombia",
        "address": "Av. El Dorado #68B-31",
        "neighborhood": "Airport"
    },
    "dimensions": {
        "width": 35.5,
        "height": 10.0,
        "depth": 25.0,
        "weight": 1.0
    },
    "currentStatus": "CREATED"
}
```

### Ejecución con Docker Compose
Instrucciones para desplegar el entorno completo (Base de datos, Kafka, Zookeeper y Aplicación).

Requisitos Previos
Docker Desktop o Docker Engine instalado.

Maven instalado (para el build local del JAR).

```bash
docker-compose up -d
```
