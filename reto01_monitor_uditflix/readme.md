# Reto 1 · Monitor del catálogo de UDITflix

**Módulo:** 0490 · Programación de Servicios y Procesos
**Autor/a:** *(tu nombre)*
**Reto:** *(marca el tuyo)* ☐ Reto A (vídeos) · ☐ Reto B (contenidos)
**Tecnología:** Java + `ProcessBuilder` (procesos del sistema operativo)
**RA vinculado:** RA1 · Programación de aplicaciones compuestas por varios procesos

> 💡 **Cómo usar este README:** no es un trámite que se rellena al final. Es tu cuaderno de pensamiento durante el reto. Las secciones marcadas con 🧠 sirven para que **pienses sobre cómo estás pensando**. Si las rellenas de golpe en el último minuto, pierden todo su valor (y se nota).

---

## 📺 Qué es esta app

Un programa de consola que simula el monitor interno de UDITflix: comprueba si cada elemento del catálogo (vídeos o contenidos) está **ACTIVO** o **CAÍDO**. Para cada uno lanza un proceso externo (`ping`), muestra su PID, lee lo que responde y espera a que termine.

> *Sustituye la captura de abajo por la de tu propia ejecución antes de entregar.*

<!-- ![Captura de la consola](captura.png) -->

---

## 🧠 Antes de empezar: planifico (5 min, sin tocar el teclado)

Responde **antes** de escribir una sola línea de código. No importa si te equivocas: lo importante es dejar escrito qué pensabas.

1. **Con mis palabras, ¿qué me pide el reto?** *(sin copiar el enunciado)*
   *(escribe aquí)*

2. **¿Qué parte de la píldora de clase creo que voy a reutilizar?**
   *(escribe aquí)*

3. **¿Qué parte me da más respeto o no sé por dónde empezar?**
   *(escribe aquí)*

4. **Mi plan en 3-4 pasos, en orden:**
   *(escribe aquí)*

5. **Predicción:** si todas las direcciones fueran `127.0.0.1`, ¿qué estado saldría en los cinco elementos? ¿Y si todas fueran direcciones inexistentes?
   *(escribe aquí, y comprueba al final si acertaste)*

---

## 🎯 Objetivo del reto

Partir de lo aprendido en la píldora (lanzar **un** proceso) y dar el salto a **gestionar varios procesos con una estructura de datos y un bucle**, aplicando: creación de procesos con `ProcessBuilder`, identificación por PID, lectura de su salida, espera con `waitFor()` e interpretación de su resultado.

---

## 🛠️ Componentes y conceptos utilizados

Rellena la columna "con mis palabras" **sin mirar tus apuntes**. Después compara con ellos y corrige en otro color o con un comentario. Esa diferencia es exactamente lo que aún no tienes del todo claro.

| Componente / concepto | Para qué se usa en esta app | Con mis palabras |
|---|---|---|
| `ProcessBuilder` | Prepara la orden (`ping ...`) que se enviará al sistema operativo | |
| `start()` | Lanza de verdad el proceso; devuelve un `Process` sin esperarle | |
| `Process` | Objeto con el que controlo el proceso que ya está en marcha | |
| `pid()` | Número que identifica al proceso en el sistema operativo | |
| `getInputStream()` | Canal por el que **recibo** lo que escribe el proceso | |
| `BufferedReader` + `readLine()` | Leer esa salida línea a línea | |
| `waitFor()` | Bloquea mi programa hasta que el proceso termina y devuelve su código de salida | |
| Matriz `String[][]` | Guarda, para cada elemento, su nombre y su dirección de comprobación | |
| Bucle `for` | Repite el mismo proceso de comprobación para cada fila de la matriz | |

**¿Qué contiene cada posición de mi matriz?**

```
matriz[i][0] →  (completa)
matriz[i][1] →  (completa)
```

---

## 🚀 Cómo ejecutar el proyecto

1. Clonar o abrir el proyecto en IntelliJ IDEA.
2. Esperar a que indexe el proyecto.
3. Ejecutar (▶) la clase principal.

> ⚠️ El comando `ping` usa `-n` en Windows y `-c` en Linux/Mac para el número de intentos. Indica aquí con qué sistema lo has probado: *(escribe aquí)*

---

## 🔍 Mientras programo: mi diario de decisiones

Cada vez que **te atasques, cambies de idea o algo falle**, anota una entrada. Tres líneas bastan. No se trata de quedar bien: se trata de que dentro de un mes puedas reconstruir cómo pensaste.

| Qué intentaba | Qué pasó realmente | Qué hice / qué aprendí |
|---|---|---|
| *(ejemplo)* Mostrar el estado de cada elemento | Todos salían ACTIVO, incluso los que debían estar caídos | Revisé qué devolvía `waitFor()` para una dirección inexistente y vi que... |
| | | |
| | | |
| | | |

**Mi pregunta-brújula cuando me bloqueo:**
1. ¿Qué espero que haga esta línea?
2. ¿Qué está haciendo realmente? (imprimo valores para comprobarlo)
3. ¿En qué punto exacto se separan las dos respuestas?

---

## 🧭 De la píldora al reto: cómo di el salto

La píldora lanzaba **un** proceso. El reto lanza **cinco**. Explica ese salto con tus palabras:

- **¿Qué tenía la píldora que ya no me sirve tal cual?**
  *(escribe aquí)*

- **¿Qué he tenido que añadir para repetirlo cinco veces? ¿Por qué esa estructura y no otra?**
  *(escribe aquí)*

- **¿Qué parte del código es exactamente igual en todas las vueltas del bucle y qué parte cambia?**
  *(escribe aquí)*

- **Si mañana UDITflix tuviera 500 elementos en lugar de 5, ¿qué tendría que cambiar en mi código?**
  *(escribe aquí)*

---

## 🧠 Qué he aprendido

*(Completar al terminar. Redacta con tus palabras, no con las del enunciado.)*

- **Hilo vs. proceso:** la diferencia entre ambos es...
- **PID:** lo que representa y por qué cambia en cada ejecución es...
- **`start()` vs. `waitFor()`:** lanzar un proceso y esperarle son cosas distintas porque...
- **Código de salida:** lo que significa que sea `0` o distinto de `0` es...
- **Lo que mi programa decide sobre ACTIVO / CAÍDO se basa en...** *(¿es fiable? ¿en qué casos podría equivocarse?)*

---

## 🐞 Dificultades y cómo las resolví

*(Completar antes de entregar. Reúne lo más importante de tu diario de decisiones.)*

- **Dificultad 1:**
  - Qué síntoma vi:
  - Cuál era la causa real:
  - Cómo la encontré:
  - Cómo evitaré que me vuelva a pasar:

- **Dificultad 2:** *(opcional)*

---

## 🪞 Autoevaluación

Marca con honestidad, no con optimismo. Nadie te califica esta sección: es para ti y para que el profesor sepa dónde ayudarte.

| Puedo explicar a un compañero... | 🔴 No | 🟡 Más o menos | 🟢 Sí |
|---|:-:|:-:|:-:|
| Qué hace `ProcessBuilder` | ☐ | ☐ | ☐ |
| Qué hace `start()` y por qué no espera | ☐ | ☐ | ☐ |
| Qué representa el PID | ☐ | ☐ | ☐ |
| Para qué sirve `getInputStream()` | ☐ | ☐ | ☐ |
| Qué hace `waitFor()` y qué devuelve | ☐ | ☐ | ☐ |
| Qué hay en cada posición de la matriz | ☐ | ☐ | ☐ |
| Qué hace el `for` en mi programa | ☐ | ☐ | ☐ |

**Mi predicción del principio, ¿acerté?** *(escribe aquí y explica por qué sí o por qué no)*

**Lo que haría diferente si empezara de nuevo:**
*(escribe aquí)*

**Lo que todavía no tengo claro y quiero preguntar en clase:**
*(escribe aquí)*

---

## 🤝 Declaración de autoría

Este reto no permite herramientas de generación de código mediante IA. Consulté únicamente: la píldora de clase, mis apuntes, la documentación de Java e IntelliJ IDEA.

☐ Confirmo que el código es mío y que puedo explicarlo línea a línea.

---

## 📂 Estructura del proyecto

```
src/main/java/org/example/   → clase con el main (el monitor de UDITflix)
README.md                    → este documento
```

*(Ajusta la estructura a la de tu proyecto.)*

## 🔗 Enlace

- GitHub: *(tu repositorio)*
