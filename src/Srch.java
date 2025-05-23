import java.util.*;

abstract class Srch {
    protected Wgraph graph;
    protected Vershina startNode;
    protected Map<Vershina, Vershina> parentMap;

    public Srch(Wgraph graph, Vershina startNode) {
        this.graph = graph;
        this.startNode = startNode;
        this.parentMap = new HashMap<>();
    }

    public abstract List<Vershina> findPath(Vershina targetNode);

    protected List<Vershina> reconstructPath(Vershina targetNode) {
        List<Vershina> path = new LinkedList<>();
        Vershina current = targetNode;
        while (current != null) {
            path.add(0, current);
            current = parentMap.get(current);
        }
        return path;
    }
}