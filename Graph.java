import java.util.Vector;


public class Graph {
	
	protected Vector<Vertex> vertices = new Vector<Vertex>();
	protected Vector<Edge> edges = new Vector<Edge>();
	protected boolean directed = false;
	
	public double [] [] getAdjacencyMatrix(){
		double [] [] adjMatrix = new double [vertices.size()] [vertices.size()];
		
		for(int i = 0; i < vertices.size(); i++)
			for(int j = 0; i < vertices.size(); j++)
				if(i == j)
					adjMatrix[i][j] = 0;
				else
					adjMatrix[i][j] = Double.POSITIVE_INFINITY;
		
		for(int i = 0; i < vertices.size(); i++){
			Vertex vertex = vertices.elementAt(i);
			for(int j = 0; i < edges.size(); j++){
				Edge edge = edges.elementAt(j);
				
				if(edge.a == vertex){
					int indexOfNeighbor = vertices.indexOf(edge.b);
					adjMatrix[i][indexOfNeighbor] = edge.weight;
				}
			}
		}
		return adjMatrix;
	}
	
}
