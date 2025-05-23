import java.util.*;

class Vershina {
    String name;
    Map<Vershina, Double> neighbors;
    boolean visited;
    double distance;
    Vershina previous;

    public Vershina(String name) {
        this.name = name;
        this.neighbors = new HashMap<>();
        this.visited = false;
        this.distance = Double.POSITIVE_INFINITY;
        this.previous = null;
    }

    public void addKrai(Vershina neighbor, double weight) {
        neighbors.put(neighbor, weight);
    }

    @Override
    public String toString() {
        return name;
    }
}