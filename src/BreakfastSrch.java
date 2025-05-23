import java.util.*;

class BreakfastSrch extends Srch {
    public BreakfastSrch(Wgraph graph, Vershina startNode) {
        super(graph, startNode);
    }

    @Override
    public List<Vershina> findPath(Vershina targetNode) {
        Queue<Vershina> queue = new LinkedList<>();
        Set<Vershina> visited = new HashSet<>();

        queue.offer(startNode);
        visited.add(startNode);
        parentMap.put(startNode, null);

        while (!queue.isEmpty()) {
            Vershina current = queue.poll();

            if (current.equals(targetNode)) {
                return reconstructPath(targetNode);
            }

            for (Vershina neighbor : graph.getNeighbors(current).keySet()) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    parentMap.put(neighbor, current);
                    queue.offer(neighbor);
                }
            }
        }
        return new ArrayList<>(); // No path found
    }
}