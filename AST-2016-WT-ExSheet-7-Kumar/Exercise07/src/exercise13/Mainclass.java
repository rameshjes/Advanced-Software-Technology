package exercise13;

/**
 * @author Ramesh Kumar
 * Data : 27.12.2016
 */
import java.io.FileNotFoundException;
import java.util.List;

import exercise14.ShortestPath;

public class Mainclass {

	public static void main(String[] args) throws FileNotFoundException {

		ReadWriteAdjacencyMatrix object = new ReadWriteAdjacencyMatrix();
		int sizeofnode = object.getNodeSize("matrix_file_1.txt");

		AdjacencyMatrix objectofAdjacencyMatrix = new AdjacencyMatrix(sizeofnode);

		AdjacencyMatrix matrix = object.readMatrix("matrix_file_1.txt");
		TypeConversion objectOfTypeConversion = new TypeConversion();

		Graph newgraph = objectOfTypeConversion.convertMatrixToGraph(matrix);
		System.out.println("The graph from adjacency matrix is :");
		System.out.println(newgraph);
		System.out.println("------------------------------------------------");
		AdjacencyMatrix matrix1 = objectOfTypeConversion.convertGraphtoMatrix(newgraph);
		System.out.println("The adjacency matrix converted from graph is :");
		System.out.println(matrix1);

		// Check whether graph is directed
		System.out.println("------------------------------------------------");
		boolean directed = objectofAdjacencyMatrix.checkDirected(matrix1);
		System.out.println("If graph is directed it returns true else false");
		System.out.println(directed);

		// check whether graph is cyclic
		// boolean isCyclic = objectofAdjacencyMatrix.checkCyclic(newgraph);
		// System.out.println("If graph is cyclic, it returns true else false");
		// System.out.println(isCyclic);

		// Topological Sort
		TopologicalSort objectoftopologicalsort = new TopologicalSort();
		Graph graph = objectoftopologicalsort.sortGraph(newgraph);
		System.out.println("------------------------------------------------");
		System.out.println("topological sort : ");
		System.out.println(graph);

		// Exercise 14

		AdjacencyMatrix matrix_2 = object.readMatrix("matrix_file_2.txt");
		Graph graph_2 = objectOfTypeConversion.convertMatrixToGraph(matrix_2);
		System.out.println("-------------------------------------------------");
		// AdjacencyMatrix matrix_new = object.readMatrix("matrix_file.txt");

		ShortestPath shortestpath = new ShortestPath();

		Node startNode = graph_2.getOneNode(1);
		Node endNode = graph_2.getOneNode(6);

		List<Node> traversalList = shortestpath.findShortestPath(graph_2, startNode, endNode);

		for (Node node : traversalList) {
			System.out.println(node.getNodeName());
		}


	}
}
