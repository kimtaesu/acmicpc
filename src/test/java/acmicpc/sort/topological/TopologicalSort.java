package acmicpc.sort.topological;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;


public class TopologicalSort {

    @Test
    public void test() {
        Object[] expect = new Object[]{5, 4, 2, 3, 1, 0};

        Graph g = new Graph(6);
        g.addEdge(4, 0);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        Object[] actual = g.topologicalSort();

        Assert.assertArrayEquals(expect, actual);
    }

    private static class Graph {
        private int V;   // No. of vertices
        private LinkedList<Integer> adj[]; // Adjacency List

        Graph(int v) {
            V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; ++i)
                adj[i] = new LinkedList();
        }

        // Function to add an edge into the graph
        void addEdge(int v, int w) {
            adj[v].add(w);
        }

        // A recursive function used by topologicalSort
        void topologicalSortUtil(int v, boolean visited[], Stack stack) {
            // Mark the current node as visited.
            visited[v] = true;
            Integer i;

            // Recur for all the vertices adjacent to this
            // vertex
            Iterator<Integer> it = adj[v].iterator();
            while (it.hasNext()) {
                i = it.next();
                if (!visited[i]) {
                    topologicalSortUtil(i, visited, stack);
                }
            }

            // Push current vertex to stack which stores result

            stack.push(new Integer(v));
        }

        // The function to do Topological Sort. It uses
        // recursive topologicalSortUtil()
        Object[] topologicalSort() {
            Stack stack = new Stack();

            // Mark all the vertices as not visited
            boolean visited[] = new boolean[V];
            for (int i = 0; i < V; i++)
                visited[i] = false;

            // Call the recursive helper function to store
            // Topological Sort starting from all vertices
            // one by one
            for (int i = 0; i < V; i++)
                if (visited[i] == false)
                    topologicalSortUtil(i, visited, stack);

            Object[] result = new Object[V];
            // Print contents of stack
            for (int i = 0; i < V; i++) {
                Object value = stack.pop();
                result[i] = value;
                System.out.print(value + " ");
            }

            return result;
        }
    }
}