# Reto 3 · Motor Concurrente en UDITflix

**Módulo:** 0490 · Programación de Servicios y Procesos (2º DAM)
**RA vinculado:** RA2 · Programación de aplicaciones multihilo
**Prueba realizada:** ☐ A · El Pipeline de Transcodificación de Tráilers  ☐ B · El Optimizador de Descarga Masiva de Assets
**Autor/a:** (tu nombre)
**Repositorio:** (enlace a tu GitHub)
**Vídeo de defensa técnica (< 3 min):** (enlace al vídeo)

> 💡 **Cómo usar este README:** no es un trámite que se rellena al final. Es tu cuaderno de pensamiento durante el reto. Las secciones marcadas con 🧠 sirven para pensar sobre cómo estás pensando. Si las rellenas de golpe en el último minuto pierden su valor, y se nota en el vídeo.
>
> 🗣️ Todo lo que escribas aquí debe ser algo que puedas explicar sin mirar la pantalla.

---

## 📺 1. Resumen del problema

Explica con tus palabras (sin copiar el enunciado) qué le pasa a la empresa y qué solución has construido.

(escribe aquí)

---

## 🧠 2. Antes de empezar: planifico (5 min, sin tocar el teclado)

Responde **antes** de escribir una sola línea de código. No importa si te equivocas: importa dejar escrito qué pensabas.

- **¿Qué parte de la base v0 de clase voy a reutilizar tal cual?** (escribe aquí)
- **¿Qué es nuevo y me da más respeto?** (escribe aquí)
- **Mi plan en 4-5 pasos, en orden:**
  1. (escribe aquí)
  2. (escribe aquí)
  3. (escribe aquí)
  4. (escribe aquí)

### Predicciones (comprueba al final si acertaste)

| Pregunta | Mi predicción |
|---|---|
| ¿Cuánto tardará el programa si los 4 hilos van **a la vez**? | (escribe aquí) |
| ¿Y si se ejecutaran **uno detrás de otro**? | (escribe aquí) |
| ¿Saldrán los hilos siempre en el mismo orden? ¿Por qué? | (escribe aquí) |
| *(Solo Prueba B)* ¿Terminarán antes los hilos de prioridad alta? | (escribe aquí) |
| ¿El tiempo total se parecerá a la duración del hilo más lento o a la suma? | (escribe aquí) |

---

## 🏗️ 3. Arquitectura de la solución

### 3.1 Esquema

Dibuja (en texto o con una imagen) cómo se relacionan tus clases e hilos. Ejemplo de formato:

```
main ──start()──► WORKER-1 ─┐
     ──start()──► WORKER-2 ─┤
     ──start()──► WORKER-3 ─┼──► join() ──► resumen final
     ──start()──► WORKER-4 ─┘
```

(sustituye el esquema por el tuyo)

### 3.2 Componentes y conceptos

Rellena la columna «con mis palabras» **sin mirar tus apuntes**. Después compara con ellos y corrige con un comentario: esa diferencia es lo que aún no tienes del todo claro.

| Componente / concepto | Para qué lo uso en mi programa | Con mis palabras |
|---|---|---|
| `Runnable` | Define **qué** hace el hilo | (escribe aquí) |
| `Thread` | Define **cómo** se ejecuta (un hilo real del SO) | (escribe aquí) |
| `start()` | Crea el hilo y lo pone a ejecutar `run()` | (escribe aquí) |
| `run()` | Código que ejecuta el hilo | (escribe aquí) |
| `join()` | Hace que `main` espere a que el hilo termine | (escribe aquí) |
| `getState()` | Consulta el estado del ciclo de vida del hilo | (escribe aquí) |
| `Thread.sleep()` | Simula trabajo; el hilo pasa a `TIMED_WAITING` | (escribe aquí) |
| `setPriority()` | Sugiere una prioridad al planificador | (escribe aquí) |
| `setDaemon()` | Marca un hilo como demonio *(si lo has usado)* | (escribe aquí) |

**¿Cómo se llaman mis hilos y qué hace cada uno?** (escribe aquí)

---

## 🚀 4. Cómo ejecutar el proyecto

1. Clonar el repositorio y abrirlo en IntelliJ IDEA.
2. Esperar a que el proyecto indexe.
3. Ejecutar (▶) la clase principal: (indica cuál)

- **Versión de Java (JDK):** (escribe aquí)
- **Sistema operativo y nº de núcleos de mi equipo:** (escribe aquí) ← *importante para analizar las prioridades*
- **Archivos externos necesarios (si los hay):** (escribe aquí)

---

## 🔍 5. Mientras programo: mi diario de decisiones

Cada vez que te atasques, cambies de idea o algo falle, anota una entrada. Tres líneas bastan. No se trata de quedar bien: se trata de poder reconstruir cómo pensaste.

| Qué intentaba | Qué pasó realmente | Qué hice / qué aprendí |
|---|---|---|
| *(ejemplo)* Que los 4 hilos corrieran a la vez | El programa tardaba la suma de todos | Tenía un `join()` entre dos `start()`… |
| (escribe aquí) | (escribe aquí) | (escribe aquí) |

**Mi pregunta-brújula cuando me bloqueo:**
1. ¿Qué espero que haga esta línea?
2. ¿Qué está haciendo realmente? (imprimo valores para comprobarlo)
3. ¿En qué punto exacto se separan las dos respuestas?

---

## 📊 6. Evidencias de ejecución

### 6.1 Traza de consola

Pega aquí un fragmento representativo de la salida de tu programa (o una captura).

```
(pega aquí tu traza)
```

### 6.2 Tabla de ejecuciones (mínimo 3 ejecuciones)

**Prueba A**

| Ejecución | Tiempo secuencial real | Tiempo concurrente real | Ahorro (ms y %) | Orden de finalización de los workers |
|---|---|---|---|---|
| 1 | | | | |
| 2 | | | | |
| 3 | | | | |

**Prueba B**

| Ejecución | Latencias que tocaron | Orden de finalización de los módulos | Tiempo total | Más lento | Suma |
|---|---|---|---|---|---|
| 1 | | | | | |
| 2 | | | | | |
| 3 | | | | | |

### 6.3 Solo Prueba B · Análisis breve del planificador

Con tus ejecuciones delante, escribe 5-8 líneas: ¿terminaron antes los módulos de prioridad alta? ¿Qué crees que hace el planificador de tu sistema operativo con las prioridades de Java? Si no viste diferencia, también es una conclusión válida: explícala.

(escribe aquí)

**¿Acerté en mis predicciones del apartado 2? Explica por qué sí o por qué no:** (escribe aquí)

---

## 🧠 7. Preguntas de metacognición técnica (obligatorias)

Responde **por escrito y con tus propias palabras**. Estas preguntas son la base de tu defensa. Las pistas en cursiva son para orientarte, no para copiarlas. Una respuesta vacía o copiada del enunciado se considera no entregada.

### 7.1 Preguntas comunes (Prueba A y Prueba B)

**1. ¿Por qué el tiempo total es el del hilo más lento y no la suma de todos?**
*Pistas: ¿qué hace `start()` con el hilo `main`? ¿Cuántos hilos trabajan a la vez? Compara en tu consola «Duración del más lento», «Suma de todas» y «Tiempo total real».*

(escribe aquí)

**2. ¿Qué diferencia real hay entre llamar a `start()` y llamar a `run()`?**
*Pistas: ¿en qué hilo se ejecuta el código en cada caso? ¿Qué le pasaría al tiempo total?*

(escribe aquí)

**3. ¿Qué pasaría si quitaras los `join()`? ¿Y si pusieras el `join()` justo después de cada `start()`?**
*Pistas: ¿qué imprimiría `main` y cuándo? ¿Seguiría habiendo concurrencia?*

(escribe aquí)

**4. ¿Qué diferencias hay entre trabajar con duraciones fijas y con latencias aleatorias?**
*Pistas: reproducibilidad de los resultados, comparar tiempos entre ejecuciones, qué cosas puedes predecir y cuáles no, por qué el orden de llegada cambia con duraciones aleatorias.*

(escribe aquí)

**5. El orden en que terminan los hilos puede cambiar entre ejecuciones. ¿A qué se debe? ¿Podrías garantizar un orden concreto?**
*Pistas: no-determinismo, planificador del sistema operativo. ¿Qué mecanismo usarías si necesitaras un orden fijo?*

(escribe aquí)

**6. ¿Qué problema te costó más depurar y cómo lo resolviste?**
*Cuéntalo con síntoma → causa real → cómo lo encontraste (¿apuntes? ¿documentación? ¿trazas con prints?) → cómo evitarás que te vuelva a pasar.*

(escribe aquí)

**7. Si en lugar de 4 tareas fueran 500, ¿seguiría teniendo sentido crear un `Thread` por tarea? ¿Qué problema crees que aparecería?**

(escribe aquí)

### 7.2 Solo Prueba A · Estados y espía

**8. Describe los estados que viste en tu traza y explica por qué cada hilo estaba en ese estado en ese momento.**
*Pistas: `NEW`, `RUNNABLE`, `TIMED_WAITING`, `TERMINATED`. ¿Qué línea de `run()` provoca `TIMED_WAITING`?*

(escribe aquí)

**9. ¿Cómo has resuelto que el Espía sepa cuándo dejar de espiar?**

(escribe aquí)

**10. *(Si hiciste la ampliación)* ¿Qué ocurriría si el Espía no fuera un hilo demonio?**

(escribe aquí)

### 7.3 Solo Prueba B · ArrayList y prioridades

**11. ¿Qué dificultad tuviste al gestionar el `ArrayList<Thread>`?**
*Pistas: por qué hacen falta dos bucles distintos (uno para `start()`, otro para `join()`) y qué pasaría con uno solo; cómo añadirías un quinto módulo; qué error de compilación o de lógica te encontraste.*

(escribe aquí)

**12. ¿Qué diferencias observaste al asignar prioridades distintas en tu sistema operativo?** Apóyate en tu tabla de ejecuciones y en tu análisis del apartado 6.3.

(escribe aquí)

**13. Si no viste diferencia (o fue pequeña), ¿a qué crees que se debe?**
*Pistas: número de núcleos, hilos dormidos que no compiten por la CPU, la prioridad como «sugerencia» al planificador.*

(escribe aquí)

**14. ¿Puede fiarse un programador de las prioridades de Java para garantizar que algo se ejecute antes? Justifica tu respuesta.**

(escribe aquí)

**15. *(Si hiciste la ampliación)* ¿Por qué el programa termina aunque el hilo de «Cargando…» nunca acabe por sí mismo?**

(escribe aquí)

---

## 🌍 8. Mundo real

**¿En qué sistemas profesionales (streaming, apps móviles, servicios en la nube…) se usa esta forma de trabajar con varios hilos?** Pon al menos un ejemplo concreto y explica qué parte de tu reto se parece.

(escribe aquí)

---

## 🪞 9. Autoevaluación

Marca con honestidad, no con optimismo. Nadie te califica esta sección: es para ti y para que el docente sepa dónde ayudarte.

| Puedo explicar a un compañero… | 🔴 No | 🟡 Más o menos | 🟢 Sí |
|---|:-:|:-:|:-:|
| Qué es un `Runnable` y qué es un `Thread` | ☐ | ☐ | ☐ |
| Por qué `start()` no espera a que el hilo acabe | ☐ | ☐ | ☐ |
| Qué hace `join()` y dónde lo he puesto | ☐ | ☐ | ☐ |
| Qué estados tiene un hilo y cuándo cambia | ☐ | ☐ | ☐ |
| Por qué el orden de los hilos no es siempre el mismo | ☐ | ☐ | ☐ |
| Qué son las prioridades y qué garantizan (o no) | ☐ | ☐ | ☐ |
| Qué es un hilo demonio | ☐ | ☐ | ☐ |

**Lo que haría diferente si empezara de nuevo:** (escribe aquí)

**Lo que todavía no tengo claro y quiero preguntar en clase:** (escribe aquí)

---

## 🤝 10. Declaración de autoría y aprendizaje

Este reto **no permite herramientas de IA generativa**. Consulté únicamente: los apuntes de clase, la documentación oficial de Java y la de IntelliJ IDEA.

- [ ] Confirmo que he diseñado, programado y depurado este código aplicando mi propio razonamiento, y que puedo explicarlo línea a línea.
- [ ] Confirmo que el vídeo de defensa técnica dura menos de 3 minutos y está grabado con mi propia voz.

---

## 📂 11. Estructura del proyecto

```
src/main/java/org/example/udit/flix/   → clases del motor concurrente
README.md                              → este documento
```

*(Ajusta la estructura a la de tu proyecto.)*
