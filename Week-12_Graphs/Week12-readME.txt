12.22 LAB: Graph representations

Step 1: Inspect Vertex.java, Edge.java, and DirectedGraph.java
    Inspect the Vertex class declaration in the Vertex.java file. Access Vertex.java by clicking on the orange arrow next to LabProgram.java at the top of the coding window. The Vertex class represents a graph vertex and has a string for the vertex label.
    Inspect the Edge class declaration in the Edge.java file. The edge class represents a directed graph edge and has references to a from-vertex and a to-vertex.
    Inspect the DirectedGraph abstract class declaration in the DirectedGraph.java file. DirectedGraph is an abstract base class for a directed, unweighted graph.


Step 2: Inspect AdjacencyListGraph.java and AdjacencyListVertex.java
    The AdjacencyListGraph class inherits from DirectedGraph and is declared in AdjacencyListGraph.java. The vertices field is an ArrayList of AdjacencyListVertex references. The ArrayList contains all the graph's vertices.
    The AdjacencyListVertex class inherits from Vertex and is declared in the read only AdjacencyListVertex.java file. The adjacent field is an ArrayList of references to adjacent vertices.


Step 3: Inspect AdjacencyMatrixGraph.java
    The AdjacencyMatrixGraph class inherits from DirectedGraph and is declared in AdjacencyMatrixGraph.java. The vertices field is an ArrayList of Vertex references. The ArrayList contains all the graph's vertices. The matrixRows field is an ArrayList of matrix rows. Each row itself is an ArrayList of boolean values. If matrixRows[X][Y] is true, then an edge exists from vertices[X] to vertices[Y].
    Indices in vertices correspond to indices in matrixRows. So if vertex "C" exists at index 2 in vertices, then row 2 and column 2 in the matrix correspond to vertex "C".


Step 4: Implement the AdjacencyListGraph class
    Implement the required methods in AdjacencyListGraph. Each method has a comment indicating the required functionality. The vertices ArrayList must be used to store the graph's vertices and must not be removed. New methods can be added, if needed, but existing method signatures must not change.


Step 5: Implement the AdjacencyMatrixGraph class
    Implement the required methods in AdjacencyMatrixGraph. Each method has a comment indicating the required functionality. The vertices and matrixRows ArrayLists must be used to store the graph's vertices and adjacency matrix, respectively. Both must not be removed. New methods can be added, if needed, but existing method signatures must not change.


Step 6: Test in develop mode, then submit
    File LabProgram.java contains test cases for each graph operation. The test operations are first run on an AdjacencyListGraph. Then the same test operations are run on an AdjacencyMatrixGraph. Running code in develop mode displays the test results.
    After each method is implemented and all tests pass in develop mode, submit the code. The unit tests run on submitted code are similar, but use different graphs and perform direct verification of the graphs internal data fields.