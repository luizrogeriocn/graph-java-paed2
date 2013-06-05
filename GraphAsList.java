import java.util.Vector;

public class GraphAsList {
	
	protected Vertex[] vertices;
	protected boolean isDirected = false;
	protected Vector<Vertex> ver;
	
	public GraphAsList(int noOfVertices){
		this.vertices = new Vertex[noOfVertices];
		
		for(int i = 0; i < noOfVertices; i++){
			vertices[i] = new Vertex();
		}
	}
	
	public void setDirected(){
		this.isDirected = true;
	}
	
	public void setUndirected(){
		this.isDirected = false;
	}
	
	public boolean isDirected(){
		return this.isDirected;
	}
	
	public void addEdge(int a, int b){
		vertices[a].neighbors.add(vertices[b]);
	}		
	
	
	
	
	public static void main(String[] args){
		GraphAsList grafo = new GraphAsList(5);
		grafo.addEdge(0, 2);
		grafo.addEdge(0, 1);
		grafo.addEdge(0, 3);
		Vertex[] v = grafo.vertices[0].getNeighbors();
		for(int i = 0; i < v.length; i++){
			System.out.println(v[i].data);
		}

	}
}
