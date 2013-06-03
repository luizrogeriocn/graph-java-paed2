
public class Vertex {
	protected int data;
	protected boolean visited;
	public Integer index = null;
	public double distance = Double.POSITIVE_INFINITY;
	public Vertex predecessor = null;
	
	public Vertex(int data){
		this.data = data;
	}
	
	public boolean isVisited(){
		return this.visited;
	}
	
	public void visit(){
		this.visited = true;
	}
	
	public void unvisit(){
		this.visited = false;
	}
	
	
	
	
}
