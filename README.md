# Actividad 2: Spring MVC - Vistas con Thymeleaf, DTOs y Manejo de Peticiones

> **Institución:** Instituto Tecnológico de Oaxaca  
> **Carrera:** Ingeniería en Sistemas Computacionales  
> **Materia:** Programación Web  
> **Docente:** Mtra. Adelina Martínez Nieto  
> **Alumno:** Francisco Elías Bautista Centeno  
> **Semestre:** 7°  

---

## 📋 Descripción de la Actividad
Desarrollo y despliegue de una aplicación web basada en **Spring Boot** y **Spring MVC**, 
construida como una evolución de la Actividad 1. Implementa el motor de plantillas **Thymeleaf**, 
transferencia de datos mediante la clase `ProductoDTO`, controladores MVC (`@Controller`) con 
inyección de propiedades personalizadas (`@Value`), y validación de endpoints mediante peticiones 
`GET`, `POST` y parámetros dinámicos.

---

## 🛠️ Tecnologías y Componentes Utilizados
* **Java 21** / **Spring Boot (v4.1.2)**
* **Spring Web / Spring MVC**
* **Thymeleaf** (Motor de plantillas HTML5)
* **Maven** (Gestor de dependencias y empaquetado)
* **Postman** (Pruebas de endpoints REST/POST)
* **GitHub** (Control de versiones)

---

## 📂 Estructura del Proyecto y Endpoints Principales

| Método HTTP | Ruta URL | Controlador / Acción | Descripción |
| :--- | :--- | :--- | :--- |
| **GET** | `/app/productos` | `listarProductos()` | Muestra el catálogo completo de productos en una tabla HTML utilizando `th:each`. |
| **GET** | `/app/productos?categoria=X` | `listarProductos()` | Filtra el catálogo de productos dinámicamente mediante `@RequestParam`. |
| **GET** | `/app/productos/{id}` | `detalleProducto()` | Muestra la vista detallada de un producto específico usando `@PathVariable`. |
| **GET** | `/app/form` | `mostrarFormulario()` | Renderiza el formulario de registro vinculado a un objeto con `@ModelAttribute`. |
| **POST** | `/app/form` | `procesarFormulario()` | Recibe los datos enviados por el formulario, los almacena en la lista global en memoria y redirige a la vista de éxito. |
| **POST** | `/app/api/productos` | `crearProductoRest()` | Endpoint REST que procesa solicitudes JSON (probado en Postman/Bruno). |

---

## 🖼️ Evidencias y Capturas de Pantalla

### 1. Vista Principal / Catálogo de Productos (`/app/productos`)
*Aquí se visualiza la variable leída desde `application.properties` con `@Value` y la tabla generada con Thymeleaf.*
> *[<img width="1360" height="681" alt="Captura de pantalla 2026-11-08 184134" src="https://github.com/user-attachments/assets/1c5cdf63-9411-4ee7-b3f5-da45d6fed73b" />
]*

---

### 2. Vista de Detalle de Producto (`/app/productos/{id}`)
*Visualización de los atributos de un producto específico utilizando `@PathVariable`.*
> *[<img width="1363" height="689" alt="Captura de pantalla 2026-11-08 184225" src="https://github.com/user-attachments/assets/3c7f2e8e-d958-4e20-8d9e-c22db6305ac4" />
]*

---

### 3. Formulario de Registro (`/app/form`)
*Interfaz de captura para dar de alta nuevos productos.*
> *[<img width="1365" height="639" alt="Captura de pantalla 2026-11-08 185132" src="https://github.com/user-attachments/assets/7d0f9436-41e0-478b-85ca-62794a2d2f90" />
]*

---

### 4. Vista de Resultado Exitoso (`/app/form` - POST)
*Pantalla de confirmación tras registrar un producto exitosamente.*
> *[<img width="1365" height="642" alt="Captura de pantalla 2026-11-08 185146" src="https://github.com/user-attachments/assets/e534c34e-7b45-4806-ba02-6247cecfcab8" />
]*

---

### 5. Prueba de Endpoint POST en Postman / Bruno (`/app/api/productos`)
*Verificación del envío de un objeto JSON mediante una petición POST con respuesta exitosa 200 OK.*
> *[<img width="1365" height="721" alt="Captura de pantalla 2026-11-08 185719" src="https://github.com/user-attachments/assets/b964fc0f-9107-4d42-8b9a-4ef070be35b7" />
]*

---

