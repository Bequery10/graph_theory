import java.util.LinkedList;

import java.util.Stack;

public class DPS {
    private static int edgeTo[]; // Array to store the edgeTo information
    private static boolean visited[]; // Array to keep track of visited vertices
    private static int level[]; // Array to keep track of levels
    private static Stack<Integer> stack; // Stack to push, first-order
    private static Stack<Integer> stack1; // Stack to push post-order

    // Method to get the shortest path between two vertices in a graph
    public static void search(Graph g, int start) {
        start--;
        visited = new boolean[g.V()]; // Initialize visited array
        edgeTo = new int[g.V()]; // Initialize edgeTo array

        searchHelper(g, start);
        int nonVisited = getNonVisited();
        while (nonVisited != -1) {
            searchHelper(g, nonVisited);
        }
    }

    // Helper method for getShortestPath
    public static void searchHelper(Graph g, int v) {

        visited[v] = true; // Set the visited true to not get in an infinite loop

        for (int w : g.adj(v)) {
            if (!visited[w]) { // Check to see if the vertex is visited earlier

                edgeTo[w] = v;
                searchHelper(g, w); // Recursive call, building the path

            }
        }

    }

    public static Stack<Integer> search(DiGraph g, int start) {
        start--;
        visited = new boolean[g.V()]; // Initialize visited array
        edgeTo = new int[g.V()]; // Initialize edgeTo array
        stack = new Stack<>();

        searchHelper(g, start);
        int nonVisited = getNonVisited();
        while (nonVisited != -1) {
            searchHelper(g, nonVisited);
            nonVisited = getNonVisited();
        }
        return stack;
    }

    public static void searchHelper(DiGraph g, int v) {
        visited[v] = true; // Set the visited true to not get in an infinite loop

        // stack.push(v); // pre-order
        for (int w : g.adj(v)) {
            if (!visited[w]) { // Check to see if the vertex is visited earlier

                edgeTo[w] = v;
                searchHelper(g, w); // Recursive call, building the path

            }
        }
        stack.push(v); // post-oder
    }

    private static int getNonVisited() { // return non visited verticies

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i])
                return i;
        }
        return -1;
    }

    public static void kosarajuSearch(DiGraph g, Stack<Integer> stack) {
        visited = new boolean[g.V()]; // Initialize visited array
        edgeTo = new int[g.V()]; // Initialize edgeTo array
        level = new int[g.V()];

        boolean[] visited1 = new boolean[g.V()];
        int level = 0;
        while (!stack.isEmpty()) {
            visited1 = visited.clone();

            int v = stack.pop();
            if (!visited[v]) {
                kosarajuSearchHelper(g, v, level++);

                System.out.print((level - 1) + ".level : ");
                for (int i = 0; i < visited.length; i++)
                    if (visited[i] != visited1[i])
                        System.out.print(" " + (i + 1));

                System.out.println("");
            }
        }

    }

    // Helper method for getShortestPath
    private static void kosarajuSearchHelper(DiGraph g, int v, int level1) {

        visited[v] = true; // Set the visited true to not get in an infinite loop
        level[v] = level1;
        for (int w : g.adj(v)) {
            if (!visited[w]) { // Check to see if the vertex is visited earlier

                edgeTo[w] = v;
                searchHelper(g, w); // Recursive call, building the path

            }
        }

    }
}