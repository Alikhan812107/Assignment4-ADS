import java.util.Map;
import java.util.HashMap;

public class Vershina {
    private V data;
    private Map<Vershina<V>, Double> AdjacentVertices;

    public Vershina(V data) {
        this.data = data;
        this.AdjacentVertices = new HashMap<>();
    }

    public void addAdjacentVertex(Vertex<V> destination, double weight){
        this.AdjacentVertices.put(destination, weight);
    }

    public V getData(){
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vershina<?> other = (Vershina<?>) o;
        return Objects.equals(data, other.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    @Override
    public String toString() {
        return "Vertex{" + data + '}';
    }

}
