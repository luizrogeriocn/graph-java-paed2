import java.util.Vector;


public class MaxHeap {
	
	protected Vector<Vertex> vertices;
	
	public MaxHeap(){
		this.vertices = new Vector<Vertex>();
		this.vertices.add(null);
	}

	public void insert(int id, int chave){
		Vertex vertex = new Vertex(id, chave);
		this.vertices.add(vertex);
		insertHelper();
	}
	
	public void extract(){
		
	}
	
	public void decrease(){
		
	}
	
	public void increase(){
		
	}
	
	public void maxHeapfy(){
		
	}
	
	public void insertHelper(){
		int currentPosition = vertices.size();
		Vertex auxVertex;
		
		while( (vertices.get(currentPosition).currentCost > vertices.get(currentPosition/2).currentCost) &&
				currentPosition != 1)
		{
			auxVertex = vertices.get(currentPosition);
			vertices.set(currentPosition, vertices.get(currentPosition/2));
			vertices.set(currentPosition/2, auxVertex);
		}
	}
	
	public static void main(String[] args){
		//MaxHeap hp = new MaxHeap();
		//hp.insert(1, 100)

	}
	
}
