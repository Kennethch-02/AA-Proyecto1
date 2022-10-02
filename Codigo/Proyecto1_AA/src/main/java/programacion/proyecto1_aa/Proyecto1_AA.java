/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package programacion.proyecto1_aa;

/**
 *
 * @author kenne
 */
public class Proyecto1_AA {

    public static void main(String[] args) {
        
                    // Heuristica Voraz
        // 5 - 4
        GrafoND grafo = new GrafoND(5,4);
        grafo.DoGrafo();
        grafo.ShowGrafo(grafo.getGrafo());
        System.out.println("");
        long startTime = System.nanoTime();;
        grafo.MinSubHeuristica();
        long endTime = System.nanoTime() - startTime;
        System.out.println("Asignaciones: " + grafo.getA());
        System.out.println("Comparacions: " + grafo.getC());
        System.out.println("Lineas Ejecutadas : " + grafo.getL());
        System.out.println("Tiempo de ejecucion: " + endTime/1e6);
        
        // 5 - 9
        grafo = new GrafoND(5,8);
        grafo.DoGrafo();
        grafo.ShowGrafo(grafo.getGrafo());
        System.out.println("");
        startTime = System.nanoTime();;
        grafo.MinSubHeuristica();
        endTime = System.nanoTime() - startTime;
        System.out.println("Asignaciones: " + grafo.getA());
        System.out.println("Comparacions: " + grafo.getC());
        System.out.println("Lineas Ejecutadas : " + grafo.getL());
        System.out.println("Tiempo de ejecucion: " + endTime/1e6);
        // 10 - 9
        grafo = new GrafoND(10,9);
        grafo.DoGrafo();
        grafo.ShowGrafo(grafo.getGrafo());
        System.out.println("");
        startTime = System.nanoTime();;
        grafo.MinSubHeuristica();
        endTime = System.nanoTime() - startTime;
        System.out.println("Asignaciones: " + grafo.getA());
        System.out.println("Comparacions: " + grafo.getC());
        System.out.println("Lineas Ejecutadas : " + grafo.getL());
        System.out.println("Tiempo de ejecucion: " + endTime/1e6);
        // 10 - 18
        grafo = new GrafoND(10,18);
        grafo.DoGrafo();
        grafo.ShowGrafo(grafo.getGrafo());
        System.out.println("");
        startTime = System.nanoTime();;
        grafo.MinSubHeuristica();
        endTime = System.nanoTime() - startTime;
        System.out.println("Asignaciones: " + grafo.getA());
        System.out.println("Comparacions: " + grafo.getC());
        System.out.println("Lineas Ejecutadas : " + grafo.getL());
        System.out.println("Tiempo de ejecucion: " + endTime/1e6);
        // 20 - 19
        grafo = new GrafoND(20,19);
        grafo.DoGrafo();
        grafo.ShowGrafo(grafo.getGrafo());
        System.out.println("");
        startTime = System.nanoTime();;
        grafo.MinSubHeuristica();
        endTime = System.nanoTime() - startTime;
        System.out.println("Asignaciones: " + grafo.getA());
        System.out.println("Comparacions: " + grafo.getC());
        System.out.println("Lineas Ejecutadas : " + grafo.getL());
        System.out.println("Tiempo de ejecucion: " + endTime/1e6);
        // 20 - 38
        grafo = new GrafoND(20,38);
        grafo.DoGrafo();
        grafo.ShowGrafo(grafo.getGrafo());
        System.out.println("");
        startTime = System.nanoTime();;
        grafo.MinSubHeuristica();
        endTime = System.nanoTime() - startTime;
        System.out.println("Asignaciones: " + grafo.getA());
        System.out.println("Comparacions: " + grafo.getC());
        System.out.println("Lineas Ejecutadas : " + grafo.getL());
        System.out.println("Tiempo de ejecucion: " + endTime/1e6);
        // 40 - 80
        grafo = new GrafoND(40,80);
        grafo.DoGrafo();
        grafo.ShowGrafo(grafo.getGrafo());
        System.out.println("");
        startTime = System.nanoTime();;
        grafo.MinSubHeuristica();
        endTime = System.nanoTime() - startTime;
        System.out.println("Asignaciones: " + grafo.getA());
        System.out.println("Comparacions: " + grafo.getC());
        System.out.println("Lineas Ejecutadas : " + grafo.getL());
        System.out.println("Tiempo de ejecucion: " + endTime/1e6);
        // 50 - 120
        grafo = new GrafoND(50,120);
        grafo.DoGrafo();
        grafo.ShowGrafo(grafo.getGrafo());
        System.out.println("");
        startTime = System.nanoTime();;
        grafo.MinSubHeuristica();
        endTime = System.nanoTime() - startTime;
        System.out.println("Asignaciones: " + grafo.getA());
        System.out.println("Comparacions: " + grafo.getC());
        System.out.println("Lineas Ejecutadas : " + grafo.getL());
        System.out.println("Tiempo de ejecucion: " + endTime/1e6);
        // 50 - 150
        grafo = new GrafoND(50,150);
        grafo.DoGrafo();
        grafo.ShowGrafo(grafo.getGrafo());
        System.out.println("");
        startTime = System.nanoTime();;
        grafo.MinSubHeuristica();
        endTime = System.nanoTime() - startTime;
        System.out.println("Asignaciones: " + grafo.getA());
        System.out.println("Comparacions: " + grafo.getC());
        System.out.println("Lineas Ejecutadas : " + grafo.getL());
        System.out.println("Tiempo de ejecucion: " + endTime/1e6);
    }
}
