/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;
import java.io.*;
import java.util.*;
import java.util.LinkedList;


/**
 *
 * @author lenovo
 */
public class Graph {
    private int V;   // No. of vertices
    private LinkedList<Integer> adjacentM[]; //Adjacency List
 
    //Constructor
    Graph(int v)
    {
        V = v;
        adjacentM = new LinkedList[v];
        for (int i=0; i<v; ++i)
             adjacentM[i] = new LinkedList();
    }
    void addedE(int v,int w) {  adjacentM[v].add(w); }
 
    // A recursive function to print DFS starting from v
    void  SrchUtil(int v,Boolean visitedE[])
    {
        // Mark the current node as visited and print it
        visitedE[v] = true;
 
        int n;
 
        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> i =  adjacentM[v].iterator();
        while (i.hasNext())
        {
            n = i.next();
            if (!visitedE[n])
                 SrchUtil(n,visitedE);
        }
        
    }
    Graph getTranspose()
    {
        Graph g = new Graph(V);
        for (int v = 0; v < V; v++)
        {
            // Recur for all the vertices adjacent to this vertex
            Iterator<Integer> i = adjacentM[v].listIterator();
            while (i.hasNext())
                g.adjacentM[i.next()].add(v);
        }
        return g;
    }
 
    
    Boolean isConnect()
    {
        
        Boolean visitedE[] = new Boolean[V];
        for (int i = 0; i < V; i++)
            visitedE[i] = false;
 
        // Step 2: Do DFS traversal starting from first vertex.
         SrchUtil(0, visitedE);
 
       
        for (int i = 0; i < V; i++)
            if (visitedE[i] == false)
                return false;
 
        // Step 3: Create a reversed graph
        Graph gr = getTranspose();
 
        
        for (int i = 0; i < V; i++)
            visitedE[i] = false;
 
        
        gr.SrchUtil(0, visitedE);
 
        
        for (int i = 0; i < V; i++)
            if (visitedE[i] == false)
                return false;
 
        return true;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Graph g1 = new Graph(5);
        //g1.addedE(0, 1);
        //g1.addedE(1, 2);
        ///g1.addedE(2, 3);
        //g1.addedE(3, 0);
        //g1.addedE(2, 4);
        //g1.addedE(4, 2);
        //if (g1. isConnect())
            //System.out.println("Yes");
        //else
           // System.out.println("No");
 
        Graph g2 = new Graph(4);
        g2.addedE(0, 1);
        g2. addedE(1, 2);
        g2. addedE(2, 3);
        if (g2. isConnect())
            System.out.println("The provided graph is connected");
        else
           System.out.println("This graph is not connected ");
         //TODO code application logic here
    }
    
}
