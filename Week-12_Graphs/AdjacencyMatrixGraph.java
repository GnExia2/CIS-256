import java.util.*;

public class AdjacencyMatrixGraph extends DirectedGraph {
    protected ArrayList<Vertex> vertices = new ArrayList<Vertex>();
    protected ArrayList<ArrayList<Boolean>> matrixRows = new ArrayList<ArrayList<Boolean>>();

    @Override
    public Vertex addVertex(String newVertexLabel) {
        // Check if a vertex with the same label already exists
        for (Vertex vertex : vertices) {
            if (vertex.getLabel().equals(newVertexLabel)) {
                return null; // Vertex with the same label already exists
            }
        }

        // Create a new vertex and add it to the list of vertices
        Vertex newVertex = new Vertex(newVertexLabel);
        vertices.add(newVertex);

        // Add a new row to the matrixRows with all values set to false
        ArrayList<Boolean> newRow = new ArrayList<>(Collections.nCopies(vertices.size(), false));
        matrixRows.add(newRow);

        // Add a new column to each existing row with the value set to false
        for (ArrayList<Boolean> row : matrixRows) {
            row.add(false);
        }

        return newVertex;
    }

    @Override
    public boolean addDirectedEdge(Vertex fromVertex, Vertex toVertex) {
        // Check if both fromVertex and toVertex exist
        if (fromVertex == null || toVertex == null) {
            return false;
        }

        int fromIndex = vertices.indexOf(fromVertex);
        int toIndex = vertices.indexOf(toVertex);

        // Check if the edge already exists
        if (matrixRows.get(fromIndex).get(toIndex)) {
            return false; // Edge already exists
        }

        // Set the value at (fromIndex, toIndex) to true
        matrixRows.get(fromIndex).set(toIndex, true);
        return true;
    }

    @Override
    public ArrayList<Edge> getEdgesFrom(Vertex fromVertex) {
        ArrayList<Edge> edges = new ArrayList<>();
        int fromIndex = vertices.indexOf(fromVertex);

        for (int toIndex = 0; toIndex < vertices.size(); toIndex++) {
            if (matrixRows.get(fromIndex).get(toIndex)) {
                edges.add(new Edge(fromVertex, vertices.get(toIndex)));
            }
        }

        return edges;
    }

    @Override
    public ArrayList<Edge> getEdgesTo(Vertex toVertex) {
        ArrayList<Edge> edges = new ArrayList<>();
        int toIndex = vertices.indexOf(toVertex);

        for (int fromIndex = 0; fromIndex < vertices.size(); fromIndex++) {
            if (matrixRows.get(fromIndex).get(toIndex)) {
                edges.add(new Edge(vertices.get(fromIndex), toVertex));
            }
        }

        return edges;
    }

    @Override
    public Vertex getVertex(String vertexLabel) {
        for (Vertex vertex : vertices) {
            if (vertex.getLabel().equals(vertexLabel)) {
                return vertex;
            }
        }
        return null;
    }

    @Override
    public boolean hasEdge(Vertex fromVertex, Vertex toVertex) {
        if (fromVertex == null || toVertex == null) {
            return false;
        }

        int fromIndex = vertices.indexOf(fromVertex);
        int toIndex = vertices.indexOf(toVertex);

        if (fromIndex == -1 || toIndex == -1) {
            return false;
        }

        return matrixRows.get(fromIndex).get(toIndex);
    }
}
