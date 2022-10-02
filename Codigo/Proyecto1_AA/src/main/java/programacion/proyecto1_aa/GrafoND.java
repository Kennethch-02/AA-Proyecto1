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
    public GrafoND(int Size, int Aristas) {
        aristas = Aristas;
        size = Size;
        grafo = new ArrayList<Tupla>();
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
        
        if (this.grafo.size() < 1) {    //Valida que haya un grafo por revisar
            System.out.println("No hay grafos por revisar.");
            return;
        }
        
        ArrayList verticesNecesitados = new ArrayList();
        ArrayList verticesRelacionados = new ArrayList();
        
        for (Tupla vertices: this.grafo){
            //Valida el primer vertice
            if(verticesNecesitados.contains(vertices.getA())== false & 
                verticesRelacionados.contains(vertices.getA()) == false){
                verticesNecesitados.add(vertices.getA());
            }
            //Valida el primer vertice
            if (verticesRelacionados.contains(vertices.getA()) == true &
                verticesNecesitados.contains(vertices.getA())== false) {
                verticesNecesitados.add(vertices.getA());
            }
            if (verticesRelacionados.contains(vertices.getB()) == false &
                verticesNecesitados.contains(vertices.getB())== false) {
                verticesRelacionados.add(vertices.getB());
            }
        }//end for
        System.out.println("\nSe necesitaron los siguientes vertices:");
        for (Object vertice : verticesNecesitados) {
            System.out.println(vertice);
        }
    }
    
    public void MinSubHeuristica(){
        List<Tupla> gHeuristica = grafo;
        List<Integer> sHeuristica = new ArrayList<Integer>();
        while(HaveArista(gHeuristica)){
            int vMax = VMax(gHeuristica);
            sHeuristica.add(vMax);
            gHeuristica = removeVertice(vMax,gHeuristica);
        }
        System.out.print("Solucion Heuristica : ");
        for (int solucion: sHeuristica){
            System.out.print(solucion + "  ");
        }
        System.out.println("");
    }
    private boolean HaveArista(List<Tupla> grafoA){
        for (Tupla verticeI: grafoA){
            int count = 0;
            for (Tupla verticeA: grafoA){
                if(verticeI.getA() == verticeA.getB()){
                    count++;
                }
                if(count>1){
                    return true;
                }
            }
        }
        return false;
    }
    private int VMax(List<Tupla> grafoM){
        int vMax = 0;
        int countMax = 0;
        int vCount = 0;
        int count = 0;
        for (Tupla vertice: grafoM){
            if(vertice.getA() != vCount){
                if(count>countMax){
                    countMax=count;
                    vMax = vCount;
                }
                count =0;
                vCount = vertice.getA();
            }
            count++;
        }
        if(count>countMax){
            countMax=count;
            count=0;
            vMax = vCount;
        }
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
    public void MinKruskal(){
        
        
	static int padre[] = new int[ MAX ];  //Este arreglo contiene el padre del i-esimo nodo

	//Método de inicialización
	static void MakeSet( int n ){
	    for( int i = 1 ; i <= n ; ++i ) padre[ i ] = i;
	}

	//Método para encontrar la raiz del vértice actual X
	static int Find( int x ){
	    return ( x == padre[ x ] ) ? x : ( padre[ x ] = Find( padre[ x ] ) );
	}

	//Método para unir 2 componentes conexas
	static void Union( int x , int y ){
	    padre[ Find( x ) ] = Find( y );
	}

	//Método que me determina si 2 vértices estan o no en la misma componente conexa
	static boolean sameComponent( int x , int y ){
	    if( Find( x ) == Find( y ) ) return true;
	    return false;
	}

	static int V , E;      //numero de vertices y aristas
	//Estructura arista( edge )
	static class Edge implements Comparator<Edge>{
	    int origen;     //Vértice origen
	    int destino;    //Vértice destino
	    int peso;       //Peso entre el vértice origen y destino
	    Edge(){}
	    //Comparador por peso, me servira al momento de ordenar lo realizara en orden ascendente
	    //Ordenar de forma descendente para obtener el arbol de expansion maxima
		@Override
		public int compare(Edge e1 , Edge e2 ) {
			//return e2.peso - e1.peso; //Arbol de expansion maxima
			return e1.peso - e2.peso;   //Arbol de expansion minima
		}
	};
	
	static Edge arista[] = new Edge[ MAX ];      //Arreglo de aristas para el uso en kruskal
	static Edge algoritmo[] = new Edge[ MAX ];     //Arreglo de aristas del algoritmo encontrado

	static void Kruskal(){
	    int origen , destino , peso;
	    int total = 0;          //Peso total del algoritmo
	    int numAristas = 0;     //Numero de Aristas del algoritmo
	    
	    MakeSet( V );           //Inicializamos cada componente
	    Arrays.sort( arista , 0 , E , new Edge() );    //Ordenamos las aristas por su comparador

	    for( int i = 0 ; i < E ; ++i ){     //Recorremos las aristas ya ordenadas por peso
	        origen = arista[ i ].origen;    //Vértice origen de la arista actual
	        destino = arista[ i ].destino;  //Vértice destino de la arista actual
	        peso = arista[ i ].peso;        //Peso de la arista actual

	        //Verificamos si estan o no en la misma componente conexa
	        if( !sameComponent( origen , destino ) ){  //Evito ciclos
	            total += peso;              //Incremento el peso total del algoritmo
	            algoritmo[ numAristas++ ] = arista[ i ];  //Agrego al algoritmo la arista actual
	            Union( origen , destino );  //Union de ambas componentes en una sola
	        }
	    }

        
        
    }
    }
}
