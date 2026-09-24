package org.example;
import java.util.ArrayList; // Herramientas nativas para listas elásticas


public class Main {
    public static void main(String[] args) {

        System.out.println("--- INICIANDO UDITVERSUM ---");
        //1. MALA PRACTICA: Toda la lógica de negocio tirada al Main.
        // los diamantes <> obligan a que la lista SOLO acepte episodios
        ArrayList<Episodio> catalogo = new ArrayList<>();

        catalogo.add(new Episodio("Diseño 3D - Intro", 45));
        catalogo.add(new Episodio("Animación", 60));
        catalogo.add(new Episodio("Texturas", 50));

        // 2. MEDICION DE TIEMPO
        // Usamos 'long' porque los milisegundos son desde 1970 forman un numero
        // tan gigantesco que no came en la memoria int normal

        long inicio = System.currentTimeMillis();

        //3. BUCLE FOR - EACH "Por cada episodio dentro del catalogo
        for(Episodio ep : catalogo) {
            ep.procesar(); // Aqui ocurre el bloqueo de 2 s
        }

        long fin = System.currentTimeMillis();

        //4 RESULTADO: Restamos fin menos inicio y dividimos entre mil (segundos)

        long totalSegundos = (fin - inicio) / 1000;

        System.out.println("Tiempo total: " + totalSegundos + " segundos de bloqueo. ");

        }
    }
