package acmicpc.sort.topological;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Vector;

/**
 * https://gmlwjd9405.github.io/2018/08/27/algorithm-topological-sort.html
 * 위상 정렬
 * 어떤 일을 하는 순서를 찾는 알고리즘이다.
 * 대표적인 예로 Library 간의 의존성 관계가 있다.
 * - DAG (Directed Acyclic Graph)
 * - 방향성이 있다
 * - 사이클이 없다
 * - 위상 정렬의 과정에서 그래프에 남아 있는 정점 중에 진입 차수가 0인 정점이 없다면,
 * 위상 정렬 알고리즘은 중단되고 이러한 그래프로 표현된 문제는 실행이 불가능한 문제가 된다.
 * <p>
 * 1. 진입 차수가 0인 정점(즉, 들어오는 간선의 수가 0)을 선택
 * * 진입 차수가 0인 정점이 여러 개 존재할 경우 어느 정점을 선택해도 무방하다.
 * * 초기에 간선의 수가 0인 모든 정점을 큐에 삽입
 * <p>
 * 2. 선택된 정점과 여기에 부속된 모든 간선을 삭제
 * * 선택된 정점을 큐에서 삭제
 * * 선택된 정점에 부속된 모든 간선에 대해 간선의 수를 감소
 * <p>
 * 3. 위의 과정을 반복해서 모든 정점이 선택, 삭제되면 알고리즘 종료
 */
public class TopologicalSort2 {

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
        g.topologicalSort();
    }

    private static class Graph {
        int V;// No. of vertices

        //An Array of List which contains
        //references to the Adjacency List of
        //each vertex
        List<Integer> adj[];

        public Graph(int V)// Constructor
        {
            this.V = V;
            adj = new ArrayList[V];
            for (int i = 0; i < V; i++)
                adj[i] = new ArrayList<>();
        }

        // function to add an edge to graph
        public void addEdge(int u, int v) {
            adj[u].add(v);
        }

        // prints a Topological Sort of the complete graph
        public void topologicalSort() {
            // Create a array to store indegrees of all
            // vertices. Initialize all indegrees as 0.
            int indegree[] = new int[V];

            // Traverse adjacency lists to fill indegrees of
            // vertices. This step takes O(V+E) time
            for (int i = 0; i < V; i++) {
                ArrayList<Integer> temp = (ArrayList<Integer>) adj[i];
                for (int node : temp) {
                    indegree[node]++;
                }
            }

            // Create a queue and enqueue all vertices with
            // indegree 0
            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < V; i++) {
                if (indegree[i] == 0)
                    q.add(i);
            }

            // Initialize count of visited vertices
            int cnt = 0;

            // Create a vector to store result (A topological
            // ordering of the vertices)
            Vector<Integer> topOrder = new Vector<>();
            while (!q.isEmpty()) {
                // Extract front of queue (or perform dequeue)
                // and add it to topological order
                int u = q.poll();
                topOrder.add(u);

                // Iterate through all its neighbouring nodes
                // of dequeued node u and decrease their in-degree
                // by 1
                for (int node : adj[u]) {
                    // If in-degree becomes zero, add it to queue
                    if (--indegree[node] == 0)
                        q.add(node);
                }
                cnt++;
            }

            // Check if there was a cycle
            if (cnt != V) {
                System.out.println("There exists a cycle in the graph");
                return;
            }

            // Print topological order
            for (int i : topOrder) {
                System.out.print(i + " ");
            }
        }
    }
}