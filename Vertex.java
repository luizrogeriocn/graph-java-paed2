import java.util.LinkedList;


public class Vertex{
	public int data;
	public LinkedList<Vertex> neighbors;
	
	public Vertex(){
		this.data = 1;
		this.neighbors = new LinkedList<Vertex>();
	}
	
	public Vertex[] getNeighbors(){
		Vertex[] neighbors = new Vertex[this.neighbors.size()];
		for( int i = 0; i < this.neighbors.size(); i++ ){
			neighbors[i] = this.neighbors.get(i);
		}
		return neighbors;
	}
}
