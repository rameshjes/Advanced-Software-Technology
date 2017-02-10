package exercise13;

/**
 * @author Ramesh Kumar
 * Data : 27.12.2016
 */
import java.util.ArrayList;

// This class contains Nodes, inside Nodes we have edges.
public class Node {
	private int nodeName;

	private ArrayList<Edges> edge = new ArrayList<Edges>();

	public int getNodeName() {
		return nodeName;
	}

	public void setNodeName(int nodeName) {
		this.nodeName = nodeName;
	}

	public void addEdge(Edges edge) {
		this.edge.add(edge);
	}

	public ArrayList<Edges> getEdge() {
		return edge;
	}

	public void setEdge(ArrayList<Edges> edge) {
		this.edge = edge;
	}

	public Edges getEdge(int edgeName) {
		for (Edges edge : edge) {
			if (edgeName == edge.getEdgesname()) {
				return edge;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return "Node [nodeName=" + nodeName + "]";
	}

}
