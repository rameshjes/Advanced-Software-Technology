package exercise13;
/**
 * @author Ramesh Kumar
 * Data : 27.12.2016
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;
// This class reads and write adjacency matrix from and to the external file.

public class ReadWriteAdjacencyMatrix {

	// Read the matrix from file.
	
	public AdjacencyMatrix readMatrix(String filename) throws FileNotFoundException {

		int numberofcols = getNodeSize(filename);
		Scanner input = new Scanner(new File(filename));
		AdjacencyMatrix matrix = new AdjacencyMatrix(numberofcols);
		int i = 0;
		int temp = 0;
		while (input.hasNextLine()) {
			
			for (int j = 0; j < numberofcols; j++) {
				temp = input.nextInt();
				if (temp == 1) {
					matrix.addEdge(i, j,temp);
					
				}
			}
			i++;
		}
		return matrix;
	}

	// This method writes adjacency matrix to file.

	public void writeMatrix(String fileName, AdjacencyMatrix adjMatrix) throws FileNotFoundException {
		PrintStream output = new PrintStream(new File(fileName));
		int[][] matrix = adjMatrix.getMatrix();

		for (int i = 0; i < matrix[0].length; i++) {
			String sc = "";
			for (int j = 0; j < matrix[0].length; j++) {
				sc += matrix[i][j] + " ";
			}
			output.println(sc);
		}
		output.close();

	}

	// Read file and return node size
	// Number of lines in file is size of nodes
	public int getNodeSize(String filename) {

		int size = 0;
		try {
			File f = new File(filename);
			Scanner s = new Scanner(f);
			while (s.hasNext()) {
				size++;
				s.nextLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return size;
	}

}
