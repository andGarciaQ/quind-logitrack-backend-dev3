--liquibase formatted sql

--changeset AndresGarcia:3

--comment: Crear tabla para control de bloqueos de tareas programadas (ShedLock)

CREATE TABLE shedlock (
  name VARCHAR(64) NOT NULL PRIMARY KEY,
  lock_until TIMESTAMPTZ NOT NULL,
  locked_at TIMESTAMPTZ NOT NULL,
  locked_by VARCHAR(255) NOT NULL
);

-- rollback DROP TABLE IF EXISTS shedlock;