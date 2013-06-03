
public class Edge {

	protected Vertex a, b;
	protected double weight;
	
	public Edge(Vertex a, Vertex b, double weight){
		this.a = a;
		this.b = b;
		this.weight = weight;
	}
	
	public double getWeight(){
		return weight;
	}
	
	public String print(){
		return a + "==> " + b;
	}
}
