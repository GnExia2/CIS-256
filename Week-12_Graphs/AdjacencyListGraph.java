import java.util.*;

public class AdjacencyListGraph extends DirectedGraph {
    protected ArrayList<AdjacencyListVertex> vertices = new ArrayList<AdjacencyListVertex>();

    @Override
    public Vertex addVertex(String newVertexLabel) {
        // Check if a vertex with the same label already exists
        for (AdjacencyListVertex vertex : vertices) {
            if (vertex.getLabel().equals(newVertexLabel)) {
                return null; // Vertex with the same label already exists
            }
        }

        // Create a new vertex and add it to the list of vertices
        AdjacencyListVertex newVertex = new AdjacencyListVertex(newVertexLabel);
        vertices.add(newVertex);
        return newVertex;
    }

    @Override
    public boolean addDirectedEdge(Vertex fromVertex, Vertex toVertex) {
        // Check if both fromVertex and toVertex exist
        if (fromVertex == null || toVertex == null) {
            return false;
        }

        // Cast vertices to AdjacencyListVertex to access the 'adjacent' list
        AdjacencyListVertex from = (AdjacencyListVertex) fromVertex;
        AdjacencyListVertex to = (AdjacencyListVertex) toVertex;

        // Check if the edge already exists
        if (from.adjacent.contains(to)) {
            return false; // Edge already exists
        }

        // Add 'to' to the list of adjacent vertices for 'from'
        from.adjacent.add(to);
        return true;
    }

    @Override
    public ArrayList<Edge> getEdgesFrom(Vertex fromVertex) {
        // Check if 'fromVertex' is an instance of AdjacencyListVertex
        if (fromVertex instanceof AdjacencyListVertex) {
            AdjacencyListVertex from = (AdjacencyListVertex) fromVertex;
            ArrayList<Edge> edges = new ArrayList<>();

            for (Vertex to : from.adjacent) {
                edges.add(new Edge(from, to));
            }
            return edges;
        }
        return new ArrayList<Edge>();
    }

    @Override
    public ArrayList<Edge> getEdgesTo(Vertex toVertex) {
        ArrayList<Edge> edges = new ArrayList<>();

        for (AdjacencyListVertex from : vertices) {
            if (from.adjacent.contains(toVertex)) {
                edges.add(new Edge(from, toVertex));
            }
        }
        return edges;
    }

    @Override
    public Vertex getVertex(String vertexLabel) {
        for (AdjacencyListVertex vertex : vertices) {
            if (vertex.getLabel().equals(vertexLabel)) {
                return vertex;
            }
        }
        return null;
    }

    @Override
    public boolean hasEdge(Vertex fromVertex, Vertex toVertex) {
        // Check if 'fromVertex' is an instance of AdjacencyListVertex
        if (fromVertex instanceof AdjacencyListVertex) {
            AdjacencyListVertex from = (AdjacencyListVertex) fromVertex;
            return from.adjacent.contains(toVertex);
        }
        return false;
    }
}
