package exercise13;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ramesh Kumar Data : 27.12.2016
 */
public class TopologicalSort {

	public Graph sortGraph(Graph graph) {

		AdjacencyMatrix matrix = new TypeConversion().convertGraphtoMatrix(graph); // Convert
																					// graph
																					// to
																					// A.matrix

		List<Integer> visited = new ArrayList<Integer>();

		Graph sortedGraph = new Graph();

		int nodeSize = matrix.getNodeSize();
		int count = 0;

		while (visited.size() != nodeSize) {
			// outerloop is identifier to break the loop
			// System.out.println("inside while ");
			outerloop: for (int i = 0; i < nodeSize; i++) {
				for (int j = 0; j < nodeSize; j++) {
					if (!visited.contains(i) && !visited.contains(j)) {
						if (matrix.hasEdge(i, j) == 0) {
							count++;
						}
					}
				}
				if (count == nodeSize - visited.size()) {
					visited.add(i);
					count = 0;
					break outerloop;
				}
				count = 0;
			}
		}
		for (int i : visited) {
			sortedGraph.addNode(graph.getOneNode(i));
		}
		return sortedGraph;
	}

}
