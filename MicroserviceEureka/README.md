# Microservicio Eureka Server

Este microservicio representa el servidor de descubrimiento de servicios dentro de la arquitectura de microservicios.

Eureka permite que los microservicios se registren automáticamente y puedan encontrarse entre ellos usando el nombre del servicio, sin depender directamente de direcciones IP o puertos fijos.

---

## Objetivo

El objetivo del microservicio Eureka Server es centralizar el registro de los microservicios disponibles dentro del sistema de adopciones.

Cada microservicio se registra en Eureka para que pueda ser localizado por otros servicios.

---

## Responsabilidades del microservicio

- Registrar los microservicios disponibles.
- Mostrar el estado de los microservicios registrados.
- Permitir que los microservicios se comuniquen usando el nombre del servicio.
- Facilitar la integración con API Gateway.
- Facilitar la integración con OpenFeign.

---

## Dependencia requerida

Para crear este microservicio en Spring Initializr se debe agregar:

- Eureka Server

---

## Configuración principal

Para este proyecto, Eureka Server usará el puerto `9999`.

---