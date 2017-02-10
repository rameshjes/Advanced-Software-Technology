package exercise13;

/**
 * @author Ramesh Kumar
 * Data : 27.12.2016
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdjacencyMatrix {

	private int[][] matrix; // Create 2D matrix

	// Constructor
	public AdjacencyMatrix(int nodeSize) {
		matrix = new int[nodeSize][nodeSize];
		for (int[] row : matrix) {
			Arrays.fill(row, 0);
		}

	}

	public int getNodeSize() {
		return matrix[0].length;
	}

	public int[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}

	public void addEdge(int i, int j, int weight) {
		matrix[i][j] = weight;
	}

	public void removeEdge(int i, int j) {
		matrix[i][j] = 0;

	}

	public int hasEdge(int i, int j) {
		return matrix[i][j];
	}

	// Display
	@Override
	public String toString() {
		String result = "";
		for (int[] row : matrix) {

			for (int col : row) {

				result += col + " ";
			}
			result += "\n";
		}

		return result;

	}

	// Check if directed
	/*
	 * A directed cycle graph is a directed version of a cycle graph, with all
	 * the edges being oriented in the same direction.
	 */
	public boolean checkDirected(AdjacencyMatrix matrix) {
		boolean directed = true;
		int[][] givenmatrix = matrix.getMatrix();
		for (int i = 0; i < givenmatrix[0].length; i++) {
			for (int j = 0; j < givenmatrix[0].length; j++) {
				if ((givenmatrix[i][j] == 1) && (givenmatrix[j][i] == 1)) {
					directed = false;
				}
			}
		}
		return directed;
	}

	// Check cyclic, directed graph
	public boolean checkCyclic() {

		TypeConversion matrixtoGraph = new TypeConversion();

		AdjacencyMatrix adjacencyMatrices = new AdjacencyMatrix(getNodeSize());
		adjacencyMatrices.setMatrix(matrix);

		Graph graph = matrixtoGraph.convertMatrixToGraph(adjacencyMatrices);

		for (Node node : graph.getNodes()) {
			List<Integer> visited = new ArrayList<Integer>();
			visited.add(node.getNodeName());
			if (depthFirstSearch(node, visited, graph)) {
				return true;
			}
		}
		return false;
	}

	public boolean depthFirstSearch(Node node, List<Integer> visited, Graph graph) {

		for (Edges edge : node.getEdge()) {
			if (visited.contains(edge.getEdgesname())) {
				return true;
			}
			visited.add(edge.getEdgesname());
			if (depthFirstSearch(graph.getOneNode(edge.getEdgesname()), visited, graph)) {
				return true;
			}
			visited.remove(visited.size() - 1);

		}
		return false;

	}
}