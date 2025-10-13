# Ejercicio: Esperas en Selenium (Implícita, Explícita y Fluida)

## Páginas de prueba utilizadas

1. https://the-internet.herokuapp.com/dynamic_controls → (Para Espera Implícita)  
2. https://the-internet.herokuapp.com/dynamic_loading/1 → (Para Espera Explícita)  
3. https://the-internet.herokuapp.com/dynamic_loading/2 → (Para Espera Fluida / Fluent Wait)  

---

## Objetivo General

Automatizar distintos escenarios de carga dinámica en Selenium utilizando:
- Espera Implícita (Implicit Wait) → comportamiento global del driver.  
- Espera Explícita (Explicit Wait) → condiciones concretas para elementos específicos.  
- Espera Fluida (Fluent Wait) → condiciones personalizadas con reintentos configurables.

---

## Parte 1 – Espera Implícita

### Página:
https://the-internet.herokuapp.com/dynamic_controls

### Objetivo:
Practicar el uso de esperas implícitas para manejar elementos que aparecen o desaparecen dinámicamente sin usar condiciones explícitas.

### Pasos:

1. Inicializar el navegador y configurar la espera implícita.  
2. Dirigirse a la página Dynamic Controls.  
3. Caso 1 – Eliminar un elemento:  
   - Hacer clic en el botón "Remove".  
   - Esperar a que aparezca el texto "It's gone!" sin usar esperas explícitas.  
   - Verificar que el texto sea correcto.  
4. Caso 2 – Agregar nuevamente el elemento:  
   - Hacer clic en "Add".  
   - Verificar que reaparezca el checkbox.  
   - Marcar el checkbox si está visible.  
5. Caso 3 – Campo de texto dinámico:  
   - Hacer clic en "Enable".  
   - Esperar a que el campo de texto sea editable.  
   - Escribir un texto de prueba.  
   - Hacer clic en "Disable" y comprobar que el campo se bloquee otra vez.

**Nota:**  
La espera implícita se aplica globalmente, por lo que Selenium esperará automáticamente cada vez que un elemento tarde en aparecer.

---

## Parte 2 – Espera Explícita

### Página:
https://the-internet.herokuapp.com/dynamic_loading/1

### Objetivo:
Usar esperas explícitas (WebDriverWait) con condiciones específicas.

### Pasos:

1. Abrir la URL.  
2. Hacer clic en el botón "Start".  
3. Utilizar una espera explícita hasta que el texto "Hello World!" sea visible.  
4. Verificar que el texto sea exactamente "Hello World!".  
5. Imprimir en consola un mensaje confirmando que el texto fue encontrado.

**Nota:**  
La espera explícita permite definir condiciones concretas, como visibilidad, clicabilidad o presencia, sin afectar el resto del flujo.

---

## Parte 3 – Espera Fluida (Fluent Wait)

### Página:
https://the-internet.herokuapp.com/dynamic_loading/2

### Objetivo:
Implementar una Fluent Wait controlando el intervalo de sondeo y las excepciones ignoradas.

### Pasos:

1. Abrir la URL.  
2. Hacer clic en el botón "Start".  
3. Implementar una espera fluida de hasta 15 segundos, con:
   - Intervalo de sondeo (polling): 500 milisegundos.  
   - Excepciones ignoradas: NoSuchElementException y StaleElementReferenceException.  
   - Condición: el texto "Hello World!" debe ser visible.  
4. Imprimir en consola un mensaje confirmando que el texto fue encontrado.

---

## Requisitos Técnicos

- Lenguaje sugerido: Python (Selenium 4) o Java.  
- Framework: Selenium WebDriver.  
- Estructura recomendada:
  - setup() → inicializa el driver y la espera implícita.  
  - test_implicit_wait() → maneja dynamic_controls.  
  - test_explicit_wait() → maneja dynamic_loading/1.  
  - test_fluent_wait() → maneja dynamic_loading/2.  
  - teardown() → cierra el navegador.

---

## Desafíos Extra

1. Medir el tiempo que tarda cada tipo de espera (usando mediciones de tiempo).  
2. Manejar los casos en los que el texto no aparezca dentro del tiempo máximo.  
3. Implementar un método reutilizable wait_for_text(locator, text, timeout, mode) que pueda trabajar con los tres tipos de espera.  
4. Crear un reporte en consola mostrando qué tipo de espera fue más eficiente.
