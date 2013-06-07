
public class Node {
	public int predecessor;
	public int cost;
	public int id;
	
	public Node(int i) {
		this.predecessor = i ;
		this.cost = 0;
	}
	
	public Node(int id, int cost) {
		this.id = id ;
		this.cost = cost;
	}
}
