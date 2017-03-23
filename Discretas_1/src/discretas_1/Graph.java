package discretas_1;

import java.util.Arrays;
import java.util.LinkedList;

public class Graph {
    
    public static int TRUE = 1;
    public static int FALSE = 0;
    
    int orden;
    int tamaño;
    boolean[] visitados;
    boolean[][] A;

    public Graph(int orden) {
        this.orden = orden;
        A = new boolean [orden +1][orden +1];
        for (int i = 0; i < orden; i++) {
            Arrays.fill(A[i], false);
        }
        tamaño = 0;
    }
    
    public void agregar_Arista(int a, int b){
        A[a][b] = A[b][a] = true;
        tamaño++;
    }
    
    public void eliminar_Arista(int a, int b){
        A[a][b] = A[b][a] = false;
        tamaño--;
    }
    
    public int getGrado(int v){
        int g = 0;
        for (int i = 1; i <= orden; i++) {
            //g += A[v][i]?1:0
            if (A[v][i]) {
                g++;
            }
        }
        return g;
    }
    
    public int Delta(){
        int may = 0;
        for (int i = 1; i <= orden; i++) {
            may = Math.max(may, getGrado(i));
        }
        return may;
    }
    
    public int delta(){
        int men = Integer.MAX_VALUE;
        for (int i = 1; i <= orden; i++) {
            men = Math.min(men, getGrado(i));
        }
        return men;
    }
    
    public boolean isRegular(){
        return delta() == Delta();
    }
       
    public boolean isRelative(){
        visitados = new boolean[orden +1];
        Arrays.fill(visitados, false);
        DFS(1);
        for (int i = 1; i <= orden; i++) {
            if (!visitados[i]) {
                return false;
            }
        }
        return true;
    }
    
    public void DFS(int v){
        if (visitados[v]) {
            return;
        }
        visitados[v] = true;
        System.out.println("Estoy en el vertice " +v);
        for (int i = 1; i <= orden; i++) {
            if (A[v][i]) {
                DFS(i);
            }
        }
    }
    
    public boolean isTree(){
        return isRelative() && orden -1 == tamaño;
    }
    
    public boolean isEulerian(){
        for (int i = 1; i <= orden; i++) {
            if (getGrado(i)%2 == 1) {
                return false;
            }
        }
        return true;
    }
 
    int[] distance;
    public void BFS(int v){
        visitados = new boolean[orden +1];
        distance = new int[orden +1];
        LinkedList<Integer> cola = new LinkedList<Integer>();
        cola.add(v);
        distance[v] = 0;
        while (!cola.isEmpty()) {            
            int w = cola.pop();
            for (int i = 1; i <= orden; i++) {
                if (A[w][i] && !visitados[i]) {
                    distance[i] = distance[w] +1;
                    visitados[i] = true;
                    cola.add(i);
                }
            }
        }
    }
    
    public int dist(int a, int b){
        BFS(a);
        return distance[b];
    }
    
    public int diam(){
        int max = 0;
        for (int i = 1; i <= orden; i++) {
            for (int j = i +1; j <= orden; j++) {
                max = Math.max(max, dist(i,j));
            }
        }
        return max;
    }
}
