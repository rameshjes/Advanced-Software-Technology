package exercise14;

/**
 * @author Ramesh Kumar
 * Data : 27.12.2016
 */
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import exercise13.Edges;
import exercise13.Graph;
import exercise13.Node;

public class ShortestPath {

	public ArrayList<Node> findShortestPath(Graph graph, Node startNode, Node endNode) {

		List<Integer> visited = new ArrayList<Integer>();

		visited.add(startNode.getNodeName());

		List<String> shortespaths = new ArrayList<String>();
		shortespaths = depthFirstSearch(startNode, endNode, visited, graph, shortespaths);

		ArrayList<Node> traversalpaths = new ArrayList<>();

		String shortest_path = computeShortestPath(shortespaths, graph, startNode, endNode);
		for (String node : shortest_path.split(" ")) {
			traversalpaths.add(graph.getOneNode(Integer.parseInt(node)));
		}
		return traversalpaths;

	}

	private List<String> depthFirstSearch(Node startNode, Node endNode, List<Integer> visited, Graph graph,
			List<String> shortespaths) {

		// List<String> currentMin = new ArrayList<String>();
		for (Edges edge : startNode.getEdge()) {
			if (edge.getEdgesname() == endNode.getNodeName()) {
				String result = "";
				for (int i : visited) {
					result += i + " ";
				}

				result += endNode.getNodeName();
				shortespaths.add(result);

				return shortespaths;
			}

			if (!visited.contains(edge.getEdgesname())) {
				visited.add(edge.getEdgesname());
				shortespaths = depthFirstSearch(graph.getOneNode(edge.getEdgesname()), endNode, visited, graph,
						shortespaths);
				visited.remove(visited.size() - 1);
			}
		}
		return shortespaths;
	}

	private String computeShortestPath(List<String> paths, Graph graph, Node startNode, Node endNode) {

		int shortestdistance = Integer.MAX_VALUE;
		String shortestpath = paths.get(0);
		int[] nodes;
		int length;

		for (String path : paths) {
			nodes = Stream.of(path.split(" ")).mapToInt(Integer::parseInt).toArray();
			// nodes = Stream.of(path.split("
			// ")).mapToInt(Integer::parseInt).toArray();

			length = 0;
			for (int i = 0; i < nodes.length - 1; i++) {
				length += graph.getOneNode(nodes[i]).getEdge(nodes[i + 1]).getWeight();
			}

			if (length < shortestdistance) {
				shortestdistance = length;
				shortestpath = path;
			}
		}

		System.out.println("Shortest path b/w " + startNode.getNodeName() + " to " + endNode.getNodeName() + " is :"
				+ shortestpath + " and the distance is " + shortestdistance);

		return shortestpath;
	}
}
