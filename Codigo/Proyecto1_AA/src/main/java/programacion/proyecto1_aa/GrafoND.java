/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programacion.proyecto1_aa;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author kenne
 */
public class GrafoND {
    private int size;
    private int aristas;
    private List<Tupla> grafo;
    private int A;
    private int C;
    private int L;
    public GrafoND(int Size, int Aristas) {
        aristas = Aristas;
        size = Size;
        grafo = new ArrayList<Tupla>();
        A = 0;
        C = 0;
        L = 0;
    }
    public int getA() {
        return A;
    }
    public int getC() {
        return C;
    }
    public int getL() {
        return L;
    }
    public List<Tupla> getGrafo() {
        return grafo;
    }
    public void DoGrafo(){
        int Aristas = aristas;
        for (int vertice1 = 0; vertice1<size;vertice1++){
            for (int vertice2 = 0; vertice2<size;vertice2++){
                if(vertice1!=vertice2){
                    if((int) (Math.random()*2) == 1 && Aristas>0){
                        grafo.add(new Tupla(vertice1,vertice2));
                        Aristas--;
                    }
                }
            }
        }
        if(CountSize()!=size){
            grafo = new ArrayList<Tupla>();
            DoGrafo();
        }else{
            System.out.println("Graph Size: " + CountSize());
            System.out.println("Graph Arista Size: " + grafo.size());
        }
    }
    private int CountSize(){
        HashSet<Integer> vertices = new HashSet<Integer>();
        for (Tupla vertice: grafo){
            vertices.add(vertice.getA());
            vertices.add(vertice.getB());
        }
        return vertices.size();
    }
    public void ShowGrafo(List<Tupla> grafoS){
        for (Tupla vertice: grafoS){
            System.out.print("( " +vertice.getA() +" , "+ vertice.getB() + " )");
            System.out.print("  ");
        }
    }
    
    public void MinSubFuerzaBruta(){
    }
    public void MinSubHeuristica(){
        A = 0;
        C = 0;
        L = 0;
        
        List<Tupla> gHeuristica = grafo; L++;A++;
        List<Integer> sHeuristica = new ArrayList<Integer>();L++;A++;
        L++;
        while(HaveArista(gHeuristica)){
            C++;
            int vMax = VMax(gHeuristica); L++;A++;
            sHeuristica.add(vMax);L++;A++;
            gHeuristica = removeVertice(vMax,gHeuristica);L++;A++;
        }
    }
    private boolean HaveArista(List<Tupla> grafoA){
        L++;
        A++;
        for (Tupla verticeI: grafoA){
            int count = 0; L++;A++;
            A++;
            for (Tupla verticeA: grafoA){
                L++;C++;
                if(verticeI.getA() == verticeA.getB()){
                    count++;L++;A++;
                }
                L++;C++;
                if(count>1){
                    L++;C++;
                    return true;
                }
            }
        }
        L++;C++;
        return false;
    }
    private int VMax(List<Tupla> grafoM){
        int vMax = 0; L++;A++;
        int countMax = 0;L++;A++;
        int vCount = 0;L++;A++;
        int count = 0;L++;A++;
        L++;A++;
        for (Tupla vertice: grafoM){
            L++;C++;
            if(vertice.getA() != vCount){
                L++;C++;
                if(count>countMax){
                    countMax=count;L++;A++;
                    vMax = vCount;L++;A++;
                }
                count =0;L++;A++;
                vCount = vertice.getA();L++;A++;
            }
            count++;L++;A++;
        }
        L++;C++;
        if(count>countMax){
            countMax=count;L++;A++;
            count=0;L++;A++;
            vMax = vCount;L++;A++;
        }
        L++;C++;
        return vMax;
    }
    private List<Tupla> removeVertice(int ver,List<Tupla> grafoR){
        List<Tupla> removeList = new ArrayList<Tupla>();
        for (Tupla vertice: grafoR){
            if(vertice.getA() == ver || vertice.getB() == ver){
                removeList.add(vertice);
            }
        }
        for (Tupla vertice: removeList){
            grafoR.remove(vertice);
        }
        return grafoR;
    }
    public void MinSubOTRO(){
    }
}