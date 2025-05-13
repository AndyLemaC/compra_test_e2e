# 🛒 Proyecto de Automatización E2E con Serenity BDD y Screenplay - OpenCart

Este proyecto implementa pruebas automatizadas de extremo a extremo (E2E) sobre el sitio demo de [OpenCart](http://opencart.abstracta.us/), utilizando **Serenity BDD** con el patrón **Screenplay**.

---

## ✅ Requisitos Previos

- Java JDK 11 o superior
- Maven 3.6.3 o superior
- IntelliJ IDEA (recomendado)
- Google Chrome actualizado

---

## ⚙️ Configuración del Entorno

### 1️⃣ Clonar el Repositorio

```bash
git clone https://github.com/AndyLemaC/compra_test_e2e.git
cd compra_test_e2e
```

### 2️⃣ Configurar IntelliJ IDEA

Instalar los siguientes plugins:

- Maven Integration
- Cucumber for Java
- Gherkin

### 3️⃣ Importar el Proyecto

1. Abrir IntelliJ IDEA
2. Seleccionar **"Open"** y elegir el archivo `pom.xml`
3. Elegir la opción **"Open as Project"**

---

## ▶️ Ejecución de Pruebas

### Desde IntelliJ IDEA

1. Ir a `src/test/java/com/opencart/runners/TestRunner.java`
2. Click derecho → **Run TestRunner**

### Desde línea de comandos

```bash
# Ejecutar todas las pruebas
mvn clean verify

# Ejecutar pruebas con un tag específico
mvn clean verify -Dtags="@compra"
```

---

## 🗂️ Estructura del Proyecto

```
compra_test_e2e/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/opencart/
│   │           ├── config/                    # Configuración del WebDriver
│   │           ├── models/                    # Modelo de datos Customer
│   │           ├── questions/                 # Validaciones (Screenplay Questions)
│   │           ├── tasks/                     # Acciones del usuario (Screenplay Tasks)
│   │           ├── ui/                        # PageObjects con Targets
│   │           └── Main.java
│   ├── test/
│   │   ├── java/com/opencart/
│   │   │   ├── runners/                       # Runner principal de pruebas
│   │   │   └── stepdefinitions/               # Definiciones de pasos
│   │   └── resources/
│   │       ├── drivers/                       # Driver de Chrome
│   │       ├── features/                      # Archivo feature de Cucumber
│   │       └── typesafe.properties            # Configuración de Serenity
├── target/                                    # Archivos generados por Maven
├── pom.xml                                    # Configuración de dependencias
├── serenity.properties                        # Configuración global de Serenity
├── .gitignore
├── conclusiones.txt
└── README.md
```

---

## 🧠 Patrón Screenplay

Se aplicó el patrón **Screenplay**, que favorece la escalabilidad, legibilidad y mantenibilidad de las pruebas.

### Componentes clave:

- 🎭 **Actors**: representan usuarios que interactúan con la aplicación
- 🧩 **Tasks**: acciones que realizan los actores (agregar producto, finalizar compra)
- ❓ **Questions**: validan resultados esperados (confirmación de compra, items en el carrito)
- 🗺️ **PageObjects**: encapsulan los elementos de la UI con Targets

---

## ❗ Resolución de Problemas

- **Error `getCssOrXPathSelector()`** → Usa `resolveAllFor(actor)` correctamente sobre el `Target`.
- **Incompatibilidad de ChromeDriver** → Asegúrate de usar `WebDriverManager.chromedriver().setup();`
- **Problemas de origen remoto** → En `serenity.properties`, añade:

```properties
chrome.switches=--start-maximized;--disable-notifications;--remote-allow-origins=*
```

---

## 📊 Reportes de Pruebas

Los reportes generados se ubican en:

```
target/site/serenity/
```

Abre el archivo:

```
target/site/serenity/index.html
```

Para visualizar el resultado completo con capturas y pasos ejecutados.

---
