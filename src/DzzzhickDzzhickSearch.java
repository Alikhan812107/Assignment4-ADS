import java.util.*;

class DzzzhickDzzhickSearch extends Srch {

    public DzzzhickDzzhickSearch(Wgraph graph, Vershina startNode) {
        super(graph, startNode);
        initializeDistances();
    }

    private void initializeDistances() {
        for (Vershina vertex : graph.getVershinas()) {
            vertex.distance = Double.POSITIVE_INFINITY;
            vertex.previous = null;
        }
        startNode.distance = 0;
    }

    @Override
    public List<Vershina> findPath(Vershina targetNode) {
        PriorityQueue<Vershina> priorityQueue = new PriorityQueue<>(Comparator.comparingDouble(v -> v.distance));
        Set<Vershina> visited = new HashSet<>();

        priorityQueue.offer(startNode);

        while (!priorityQueue.isEmpty()) {
            Vershina current = priorityQueue.poll();

            if (visited.contains(current)) {
                continue;
            }
            visited.add(current);

            if (current.equals(targetNode)) {
                return reconstructPath(targetNode);
            }

            for (Map.Entry<Vershina, Double> entry : graph.getNeighbors(current).entrySet()) {
                Vershina neighbor = entry.getKey();
                double weight = entry.getValue();
                double newDistance = current.distance + weight;

                if (newDistance < neighbor.distance) {
                    neighbor.distance = newDistance;
                    neighbor.previous = current;
                    parentMap.put(neighbor, current);
                    priorityQueue.offer(neighbor);
                }
            }
        }
        return new ArrayList<>(); // No path found
    }
}