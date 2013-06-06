
public class DisjointSet {
	
	protected Vertex[] vertices;
	
	public DisjointSet(int n){
		this.vertices = new Vertex[n];
		
		for(int i = 0; i < vertices.length; i++){
			vertices[i] = new Vertex();
			vertices[i].predecessor = vertices[i];
			vertices[i].currentCost = 1;
		}
		System.out.println("-");
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
	
	//uniao por ordenação e compressao de caminhos
	public void union(int a, int b){
		if(vertices[a].currentCost > vertices[b].currentCost){
			vertices[b].predecessor = vertices[a].predecessor;
			vertices[b].currentCost++;
			for(int i = 0; i < vertices.length; i++){
				if(vertices[i].predecessor == vertices[b].predecessor){
					vertices[i].predecessor = vertices[a].predecessor;
					vertices[i].currentCost++;
				}
			}
			System.out.println("-");
		}
		else{
			vertices[a].predecessor = vertices[b].predecessor;
			vertices[a].currentCost++;
			for(int i = 0; i < vertices.length; i++){
				if(vertices[i].predecessor == vertices[a].predecessor){
					vertices[i].predecessor = vertices[b].predecessor;
					vertices[i].currentCost++;
				}
			}
			System.out.println("-");
		}
			
	}
	
	public static void main(String[] args){
		DisjointSet set = new DisjointSet(10);
		set.union(0, 6);
		set.compare(8, 7);
		set.union(1, 8);
		set.union(2, 2);
		set.compare(2, 6);
		set.compare(9, 3);
		set.compare(4, 2);
		set.union (1, 9);
		set.compare(9, 5);
		set.compare(4, 6);
		set.union(5, 8);
		set.union(6, 6);
		set.union(7, 9);
		set.union(0, 1);
		set.compare(1, 5);
		set.compare(0, 5);
		set.compare(5, 1);
		set.compare(1, 3);
		set.union(2, 2);
		set.compare(1, 8);
		set.compare(5, 4);
		set.compare(0, 2);
		set.compare(0, 9);
	}
	
}
