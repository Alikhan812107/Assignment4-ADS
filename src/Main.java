import java.util.*;

class Main {
    public static void main(String[] args) {
        Wgraph graph = new Wgraph();

        Vershina A = new Vershina("A");
        Vershina B = new Vershina("B");
        Vershina C = new Vershina("C");
        Vershina D = new Vershina("D");
        Vershina E = new Vershina("E");

        graph.addVershina(A);
        graph.addVershina(B);
        graph.addVershina(C);
        graph.addVershina(D);
        graph.addVershina(E);

        graph.addKrai(A, B, 3.5);
        graph.addKrai(A, C, 1.8);
        graph.addKrai(B, D, 2.1);
        graph.addKrai(C, D, 0.9);
        graph.addKrai(D, E, 4.2);

        System.out.println("BFS from A to E:");
        BreakfastSrch bfs = new BreakfastSrch(graph, A);
        List<Vershina> bfsPath = bfs.findPath(E);
        System.out.println(bfsPath);

        System.out.println("Dijkstra from A to E:");
        DzzzhickDzzhickSearch dijkstra = new DzzzhickDzzhickSearch(graph, A);
        List<Vershina> dijkstraPath = dijkstra.findPath(E);
        System.out.println(dijkstraPath);

        System.out.println("Graph has " + graph.getVershinas().size() + " vertices");
    }
}