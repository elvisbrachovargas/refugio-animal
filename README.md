# 🐾 Animal Shelter Manager - Sistema de Gestión de Refugio de Animales

¡Bienvenido a **Animal Shelter Manager**! Este es un sistema desarrollado en Java diseñado para administrar un refugio de animales, permitiendo el registro de mascotas (perros y gatos), la gestión de posibles adoptantes y el control de los procesos de adopción y entrenamiento.

---

## 🚀 Características Principales

* **🐱 Gestión de Mascotas:** Registro detallado de animales alojados en el refugio, clasificándolos de forma específica (Perros y Gatos) con sus respectivos atributos individuales.
* **👤 Registro de Clientes y Personas:** Control de los usuarios del sistema, diferenciando entre los datos generales de una persona y el perfil específico de un cliente/adoptante.
* **🤝 Sistema de Adopción y Entrenamiento:** Implementación de reglas de negocio para determinar qué mascotas están listas para ser adoptadas o entrenadas a través de contratos de comportamiento (interfaces).
* **⌨️ Interfaz de Consola Interactiva:** Flujo intuitivo controlado por menús en consola con validación robusta de entrada de datos.

---

## 🛠️ Tecnologías Utilizadas

* **Lenguaje:** Java (JDK 11 o superior recomendado)
* **Paradigma:** Programación Orientada a Objetos (POO) avanzada
* **IDE Recomendado:** IntelliJ IDEA / Eclipse / VS Code

---

## 📦 Arquitectura del Proyecto

Basado en la estructura visible en `image_b3c95b.png`, el proyecto se organiza de la siguiente manera:

```text
└── src/
    ├── App/
    │   └── Main.java             # Punto de entrada de la aplicación y ciclo principal del menú
    ├── Interfaces/
    │   ├── Adoptable.java        # Contrato/Interfaz para definir si un animal cumple requisitos de adopción
    │   └── Entrenable.java       # Contrato/Interfaz para comportamientos de entrenamiento
    ├── Package/
    │   ├── Cliente.java          # Clase que extiende de Persona, enfocada en el perfil del adoptante
    │   ├── Gato.java             # Clase específica para felinos (hereda de Mascota)
    │   ├── Mascota.java          # Clase base abstracta que define los atributos comunes de un animal
    │   ├── Perro.java            # Clase específica para caninos (hereda de Mascota)
    │   └── Persona.java          # Clase base que contiene la información general de los individuos
    ├── Service/
    │   └── RefugioService.java   # Lógica de negocio (adopciones, registros y control del refugio)
    └── Util/
        └── InputUtil.java        # Utilidad para capturar y validar las entradas por teclado (Scanner)
