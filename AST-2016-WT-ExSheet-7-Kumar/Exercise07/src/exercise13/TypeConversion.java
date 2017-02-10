package exercise13;
/**
 * @author Ramesh Kumar
 * Data : 27.12.2016
 */
public class TypeConversion {

	public Graph convertMatrixToGraph(AdjacencyMatrix matrix) {
		Graph newgraph = new Graph();

		int[][] givenMatrix = matrix.getMatrix();

		for (int i = 0; i < givenMatrix[0].length; i++) {
			Node newnode = new Node();
			newnode.setNodeName(i);

			for (int j = 0; j < givenMatrix[0].length; j++) {

				if (givenMatrix[i][j] == 1) {
					Edges newedge = new Edges();
					newedge.setEdgesname(j);
					newedge.setWeight(givenMatrix[i][j]);
					newnode.addEdge(newedge);
				}
				newgraph.addNode(newnode);
			}
		}
		return newgraph;
	}

	public AdjacencyMatrix convertGraphtoMatrix(Graph newgraph) {

		int nodesize = newgraph.graphSize();
		AdjacencyMatrix matrix = new AdjacencyMatrix(nodesize);

		// for node
		for (Node node : newgraph.getNodes()) {

			// for edges 
			for (Edges edge : node.getEdge()) {
				matrix.addEdge(node.getNodeName(), edge.getEdgesname(),edge.getWeight());

			}
		}
		return matrix;
	}

	
}
