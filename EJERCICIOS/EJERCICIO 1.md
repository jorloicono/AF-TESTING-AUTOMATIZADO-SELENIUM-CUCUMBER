# Ejercicio: Automatización Completa de un Formulario Dinámico con Selenium en Java

## Objetivo

Desarrollar un **script de automatización de pruebas con Selenium y Java** para validar un **formulario web con elementos dinámicos y múltiples interacciones**.
El flujo debe simular una experiencia de usuario realista y contemplar diferentes tipos de elementos HTML y validaciones automáticas.

---

## Pasos del Ejercicio

### 1. Acceso y verificación de la página

1. Descarga `index.html` y `submitted-form.html` y guárdalos en la **misma carpeta**.
2. Abre `index.html` en tu navegador (doble clic).
3. Rellena el formulario y pulsa **Submit** — la página redirigirá a `submitted-form.html` donde verás los datos enviados.
4. Usa este formulario para ejecutar tus tests de Selenium (la URL local será `file:///.../index.html` o puedes servirlo con un servidor local como `python -m http.server` para obtener `http://localhost:8000/index.html`).

---

### 2. Interacción con los campos de texto

* Rellena el campo de texto con un **nombre generado aleatoriamente**.
* Ingresa una **contraseña segura** (mínimo 8 caracteres, con números y letras).
* Escribe un **mensaje de prueba** en el área de texto.

---

### 3. Selección en listas desplegables

* Selecciona la **segunda opción** en el elemento `<select>`.
* Escribe en el campo **datalist** y elige la opción `"Seattle"`.

---

### 4. Carga de archivos

* Carga un **archivo de imagen o texto** desde tu equipo local.
* Verifica que el archivo **ha sido subido correctamente**.

---

### 5. Manejo de elementos deshabilitados y de solo lectura

* Intenta escribir en el campo de entrada **deshabilitado** y valida que **no es posible**.
* Lee y almacena el valor del campo **solo lectura**, verificando que **no puede modificarse**.

---

### 6. Interacción con checkboxes y radio buttons

* **Desmarca** el checkbox que estaba marcado por defecto y **marca el otro**.
* **Selecciona** el segundo radio button.
* Verifica que **solo un radio button** puede estar seleccionado a la vez.

---

### 7. Interacción con el selector de colores y la barra de rango

* Cambia el color seleccionado a **#ff0000 (rojo)** y verifica que el cambio se ha aplicado.
* Mueve el **slider** del input range a **9** y comprueba que el valor ha cambiado correctamente.

---

### 8. Manejo de fechas con DatePicker

* Escribe manualmente la fecha **"12/31/2024"** en el campo de fecha.
* Si el datepicker es interactivo, selecciona la fecha desde el **calendario emergente**.

---

### 9. Verificación de elementos ocultos

* Confirma que el campo `input[type=hidden]` está **presente en la página** pero **no visible para el usuario**.

---

### 10. Simulación de envíos y navegación

* Haz clic en el botón **Submit** y valida que la URL cambia a `"submitted-form.html"`.
* Verifica que los **datos enviados** aparecen en la nueva página.
* Navega de regreso a la página principal con el enlace **"Return to index"**.

---

### 11. Captura de pantalla y generación de logs

* Si ocurre un **error en cualquier paso**, captura una **captura de pantalla** y guarda un **log con el nombre del error**.

---

### 12. Cierre del navegador

* Al finalizar la ejecución de los tests, **cierra el navegador correctamente**.

---

## Recursos útiles

* [Documentación oficial de Selenium Java](https://www.selenium.dev/documentation/webdriver/)
* [Repositorio de ejemplos con Selenium + Java](https://github.com/SeleniumHQ/selenium)
* [Formulario de práctica para automatización](https://example.com/formulario-prueba) ← *(reemplaza este enlace con el real)*


¿Quieres que haga eso?
