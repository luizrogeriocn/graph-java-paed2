
public class DisjointSet {
	
	protected Vertex[] vertices;
	
	public DisjointSet(int n){
		this.vertices = new Vertex[n];
		
		for(int i = 0; i < vertices.length; i++){
			vertices[i] = new Vertex();
			vertices[i].predecessor = vertices[i];
		}		
	}
	
	public boolean compare(Vertex a, Vertex b){
		if(a.predecessor == b.predecessor)
			return true;
		else
			return false;
	}
	
	public void union(Vertex a, Vertex b){
		if(getOrder(a) < getOrder(b))
			b.predecessor = a.predecessor;
		else
			a.predecessor = b.predecessor;
	}
	
	public int getOrder(Vertex vertex){
		int order = 1;
		while(vertex.predecessor != vertex){
			order = order+1;
			vertex = vertex.predecessor;
		}
		return order;
	}

	
}
