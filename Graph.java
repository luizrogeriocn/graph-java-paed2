import java.util.Vector;


public class Graph {
	
	protected Vector<Vertex> vertices = new Vector<Vertex>();
	protected Vector<Edge> edges = new Vector<Edge>();
	protected boolean directed = false;
	protected boolean sortedNeighbors = false;
	
	public double [] [] getAdjacencyMatrix(){
		double [] [] adjMatrix = new double [vertices.size()] [vertices.size()];
		
		for(int i = 0; i < vertices.size(); i++){
			for(int j = 0; i < vertices.size(); j++){
				if(i == j)
					adjMatrix[i][j] = 0;
				else
					adjMatrix[i][j] = Double.POSITIVE_INFINITY;
			}
		}
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
	
	public void setDirected(){
		this.directed = true;
	}
	
	public void setUndirected(){
		this.directed = false;
	}
	
	public boolean isDirected(){
		return this.directed;
	}
	
	public boolean isSortedNeighbors(){
		return this.sortedNeighbors;
	}
	
	public void SetSortedNeighbors(boolean flag){
		this.sortedNeighbors = flag;
	}
	
	public int indexOf(Vertex a){
		for(int i = 0; i < vertices.size(); i++){
			if(vertices.elementAt (i).data == a.data)
				return i;
		}
		return -1;
		
	}
		
	public Vector<Vertex> getVertices(){
		return this.vertices;
	}	
	
	public Vector<Edge> getEdges(){
		return this.edges;
	}
	
	public Vertex getVertexAt(int i){
		return vertices.elementAt(i);
	}
	
	public void unvisitAllNodes(){
		for(int i = 0; i < vertices.size(); i++){
			vertices.elementAt(i).unvisit();
		}
	}
	
	public Vector<Vertex> getNeighbors(Vertex vertex){
		Vector<Vertex> neighbors = new Vector<Vertex>();
		
		for(int i = 0; i < edges.size(); i++){
			Edge edge = edges.elementAt(i);
			
			if(edge.a == vertex)
				neighbors.add(edge.b);
			if(!directed && edge.b == vertex)
				neighbors.add(edge.a);
		}
		
		return neighbors;
	}
	
	public int addNode(Vertex a){
		vertices.add(a);
		return vertices.size() -1;
	}
	
	public void addEdge(Edge a){
		edges.add(a);
		if(!directed)
			edges.add(new Edge(a.b, a.a, a.weight));
	}
	
	public void printVertices(){
		System.out.println(vertices);
	}
	
	public void printEdges(){
		System.out.println(edges);
	}
		
}
