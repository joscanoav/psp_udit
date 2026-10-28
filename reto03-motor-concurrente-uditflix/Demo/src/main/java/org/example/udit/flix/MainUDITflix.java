package org.example.udit.flix;

import java.util.Random;

/**
 * BASE DEL JUEVES (versión que se da al alumnado): 4 hilos creados "a mano".
 *
 * Pasos que se explican en la píldora:
 *   1) Crear las tareas (Runnable).
 *   2) Envolver cada tarea en un Thread con nombre propio.
 *   3) Lanzar con start()   (NUNCA run()).
 *   4) Esperar con join()   (para que main no dé el resultado antes de tiempo).
 *
 * Después de la píldora, el alumnado resuelve los mini-retos A, B y C sobre esta base.
 */
public class MainUDITflix {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("==================================================");
        System.out.println("   UDITflix BACKEND · MOTOR DE TRANSCODIFICACIÓN  ");
        System.out.println("==================================================");

        Random azar = new Random();
        // Duración aleatoria entre 1000 y 4000 ms: así el orden de llegada cambia cada vez.
        int d1 = 1000 + azar.nextInt(3001);
        int d2 = 1000 + azar.nextInt(3001);
        int d3 = 1000 + azar.nextInt(3001);
        int d4 = 1000 + azar.nextInt(3001);

        long inicio = System.currentTimeMillis();

        // 1) Tareas
        Runnable tarea1 = new TareaTranscodificacion("intro.mp4", d1);
        Runnable tarea2 = new TareaTranscodificacion("episodio-1.mp4", d2);
        Runnable tarea3 = new TareaTranscodificacion("episodio-2.mp4", d3);
        Runnable tarea4 = new TareaTranscodificacion("extras.mp4", d4);

        // 2) Hilos con nombre
        Thread hilo1 = new Thread(tarea1, "WORKER-1");
        Thread hilo2 = new Thread(tarea2, "WORKER-2");
        Thread hilo3 = new Thread(tarea3, "WORKER-3");
        Thread hilo4 = new Thread(tarea4, "WORKER-4");

        // 3) Lanzamiento concurrente
        System.out.println("[MAIN] Lanzando workers...\n");
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();

        // 4) Espera: main se bloquea hasta que cada hilo termina
        hilo1.join();
        hilo2.join();
        hilo3.join();
        hilo4.join();

        long total = System.currentTimeMillis() - inicio;
        int masLento = Math.max(Math.max(d1, d2), Math.max(d3, d4));
        int suma = d1 + d2 + d3 + d4;

        System.out.println("\n==================================================");
        System.out.println(" CATÁLOGO LISTO");
        System.out.println(" Tiempo total real:          " + total + " ms");
        System.out.println(" Duración del más lento:     " + masLento + " ms");
        System.out.println(" Suma de todas (secuencial): " + suma + " ms");
        System.out.println("==================================================");
    }
}
