
public class DisjointSet {
	
	protected Vertex[] vertices;
	
	public DisjointSet(int n){
		this.vertices = new Vertex[n];
		
		for(int i = 0; i < vertices.length; i++){
			vertices[i] = new Vertex();
			vertices[i].predecessor = vertices[i];
		}		
	}
	
	public boolean compare(int a, int b){
		if(vertices[a].predecessor == vertices[b].predecessor){
			System.out.println("true");
			return true;
		}
		else{
			System.out.println("false");
			return false;
		}
	}
	
	public void union(int a, int b){
		if(getOrder(vertices[a]) < getOrder(vertices[b]))
			vertices[b].predecessor = vertices[a].predecessor;
		else
			vertices[a].predecessor = vertices[b].predecessor;
	}
	
	public int getOrder(Vertex vertex){
		int order = 1;
		while(vertex.predecessor != vertex){
			order = order+1;
			vertex = vertex.predecessor;
		}
		return order;
	}
	
	public static void main(String[] args){
		DisjointSet set = new DisjointSet(4);
		set.compare(0, 1);
		set.compare(1, 2);
		set.compare(0, 3);
		set.union(1, 2);
		set.compare(1, 2);
	}

	
}
