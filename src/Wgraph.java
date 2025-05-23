import java.util.*;

class Wgraph {
    private Map<Vershina, List<Vershina>> adjacencyList;
    private Set<Vershina> vertices;

    public Wgraph() {
        this.adjacencyList = new HashMap<>();
        this.vertices = new HashSet<>();
    }

    public void addVershina(Vershina vertex) {
        vertices.add(vertex);
        adjacencyList.put(vertex, new ArrayList<>());
    }

    public void addKrai(Vershina source, Vershina destination, double weight) {
        if (!adjacencyList.containsKey(source) || !adjacencyList.containsKey(destination)) {
            System.out.println("Vertex not in graph");
            return;
        }
        source.addKrai(destination, weight);
        destination.addKrai(source, weight);
    }

    public Set<Vershina> getVershinas() {
        return vertices;
    }

    public Map<Vershina, Double> getNeighbors(Vershina vertex) {
        return vertex.neighbors;
    }
}