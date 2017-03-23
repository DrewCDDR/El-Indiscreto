package discretas_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Discretas_1 {
    
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Graph G = new Graph(n);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            G.agregar_Arista(a, b);
        }   
        
        /*for (int i = 1; i <= n; i++) {
            System.out.println("grado " +i +": " +G.get_grado(i));
        }*/
        
//        System.out.println(G.isRelative());
//        System.out.println(G.dist(1, 7));
        System.out.println("El diametro de G es: " +G.diam());
    }
    
}
