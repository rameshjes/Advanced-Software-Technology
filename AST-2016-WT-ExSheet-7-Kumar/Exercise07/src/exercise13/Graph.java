package exercise13;
/**
 * @author Ramesh Kumar
 * Data : 27.12.2016
 */

import java.util.LinkedHashSet;

public class Graph {
	private LinkedHashSet<Node> nodes;

	public Graph() {
		nodes = new LinkedHashSet<Node>();
	}

	public void addNode(Node node) {
		nodes.add(node);
	}

	public int graphSize() {
		return nodes.size();
	}

	@Override
	public String toString() {
		String NEWLINE = System.getProperty("line.separator");
		StringBuilder s = new StringBuilder();

		for (Node node : nodes) {

			s.append(node.getNodeName() + ": ");
			for (Edges edge : node.getEdge()) {
				s.append(edge.getEdgesname() + " ");
			}
			s.append(NEWLINE);
		}
		return s.toString();

	}

	public Node getOneNode(int index) {
		for (Node node : nodes) {
			if (node.getNodeName() == index) {
				return node;
			}
		}
		return null;
	}

	public LinkedHashSet<Node> getNodes() {
		return nodes;
	}

	public void setNodes(LinkedHashSet<Node> nodes) {
		this.nodes = nodes;
	}

}