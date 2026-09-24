# Microservicio API Gateway

Este microservicio representa la puerta de entrada principal hacia los demás microservicios del sistema de adopciones.

El API Gateway permite centralizar las peticiones de los clientes y redirigirlas hacia el microservicio correspondiente.

---

## Objetivo

El objetivo del microservicio API Gateway es recibir las peticiones externas y enviarlas al microservicio correcto usando Eureka como servidor de descubrimiento.

De esta forma, el cliente no necesita conocer el puerto de cada microservicio.

---

## Responsabilidades del microservicio

- Recibir las peticiones externas.
- Redirigir las peticiones al microservicio correspondiente.
- Usar Eureka para localizar los microservicios registrados.
- Centralizar el acceso a la arquitectura.
- Facilitar la comunicación entre cliente y microservicios.

---

## Dependencias requeridas

Para crear este microservicio en Spring Initializr se deben agregar:

- Spring Cloud Reactive Gateway
- Eureka Discovery Client
- Spring Boot DevTools

---

## Configuración principal

Para este proyecto, el API Gateway usará el puerto `8888`.