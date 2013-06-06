import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

public class GraphAsList {
	
	protected Vertex[] vertices;
	protected boolean isDirected = false;
	
	public GraphAsList(int numerOfVertices){
		this.vertices = new Vertex[numerOfVertices];
		
		for(int i = 0; i < numerOfVertices; i++){
			vertices[i] = new Vertex();
			vertices[i].index = i;
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
	
	public void unvisitAll(){
		for(int i = 0; i < vertices.length; i++){
			vertices[i].predecessor = null;
			vertices[i].visited = false;
			
		}
	}
	
	//shortest
	public void bfs(int a){
		
		Queue<Vertex> queue = new LinkedList<Vertex>();
		queue.add(vertices[a]);
		
		vertices[a].predecessor = vertices[a];
		
		while(!queue.isEmpty()){
			Vertex vertex = queue.poll();
			vertex.visited = true;
			
			for(int i = 0; i < vertex.neighbors.size(); i++){
				if( !vertex.neighbors.get(i).visited && !queue.contains(vertex.neighbors.get(i))){
					queue.offer(vertex.neighbors.get(i));
					vertex.neighbors.get(i).predecessor = vertex;
					System.out.println("BFS - vertice adicionado a fila: " + vertex.neighbors.get(i).index + " i:"+i);
				}
			}	
		}
		this.printPath(vertices[4]);
		this.unvisitAll();
	}
	
	//path
	public void dfs(int a){
		
		Stack<Vertex> stack = new Stack<Vertex>();
		stack.push(vertices[a]);
		
		vertices[a].predecessor = vertices[a];
		
		while(!stack.isEmpty()){
			Vertex vertex = stack.pop();
			vertex.visited = true;
			
			for(int i = 0; i < vertex.neighbors.size(); i++){
				if( !vertex.neighbors.get(i).visited && !stack.contains(vertex.neighbors.get(i))){
					stack.push(vertex.neighbors.get(i));
					vertex.neighbors.get(i).predecessor = vertex;
					System.out.println("DFS - vertice adicionado a pilha: " + vertex.neighbors.get(i).index + " i:"+i);
				}
			}	
		}
		this.printPath(vertices[4]);
		this.unvisitAll();
	}
	
	public void printPath(Vertex vertex){
		while(vertex.predecessor != vertex){
			System.out.println(vertex.index);
			vertex = vertex.predecessor;
		}
		System.out.println(vertex.index);
	}
	
	
	
	
	public static void main(String[] args){
		GraphAsList grafo = new GraphAsList(5);
		
		grafo.addEdge(0, 2);
		grafo.addEdge(0, 1);
		grafo.addEdge(0, 3);
		grafo.addEdge(1, 4);
		grafo.addEdge(1, 2);
		grafo.addEdge(2, 4);
		grafo.addEdge(2, 3);
		grafo.addEdge(2, 0);

		grafo.bfs(0);
		grafo.dfs(0);

	}
}
