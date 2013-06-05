import java.util.LinkedList;


public class Vertex{
	public int index;
	public int data;
	public Vertex predecessor;
	public int currentCost;
	public boolean visited;
	public LinkedList<Vertex> neighbors;
	
	public Vertex(){
		this.predecessor = null;
		this.currentCost = 0;
		this.neighbors = new LinkedList<Vertex>();
	}
	
	public Vertex(int id, int chave){
		this.index = id;
		this.currentCost = chave;
	}
	
	public Vertex[] getNeighbors(){
		Vertex[] neighbors = new Vertex[this.neighbors.size()];
		for( int i = 0; i < this.neighbors.size(); i++ ){
			neighbors[i] = this.neighbors.get(i);
		}
		return neighbors;
	}
}
