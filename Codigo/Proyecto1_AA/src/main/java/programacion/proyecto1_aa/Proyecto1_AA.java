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
        GrafoND grafo = new GrafoND(5,5);
        grafo.DoGrafo();
        grafo.ShowGrafo(grafo.getGrafo());
        System.out.println("");
        grafo.MinSubHeuristica();
        
    }
}
