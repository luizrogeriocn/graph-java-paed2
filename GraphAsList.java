import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
	
	public void addEdge(int a, int b, int c){
		vertices[a].neighbors.add(vertices[b]);
		vertices[b].currentCost = c;
	}
	
	public void unvisitAll(){
		for(int i = 0; i < vertices.length; i++){
			vertices[i].predecessor = vertices[i];
			vertices[i].visited = false;	
		}
	}
	
	/*
	 * *****************************************************************************************
	 *       ****************             shortest path                  ****************
	 ******************************************************************************************* 
	 */
	public void bfs(int a, int b){	
		Queue<Vertex> queue = new LinkedList<Vertex>();
		queue.add(vertices[a]);
		
		while(!queue.isEmpty()){
			Vertex vertex = queue.poll();
			vertex.visited = true;
			
			for(int i = 0; i < vertex.neighbors.size(); i++){
				if( !vertex.getNeighbor(i).visited && !queue.contains(vertex.getNeighbor(i))){
					queue.offer(vertex.getNeighbor(i));
					vertex.getNeighbor(i).predecessor = vertex;
				}
			}	
		}
		this.unvisitAll();
	}
	
	/*
	 * *****************************************************************************************
	 *       ****************                any path                  ****************
	 ******************************************************************************************* 
	 */
	public void dfs(int a, int b){
		
		Stack<Vertex> stack = new Stack<Vertex>();
		stack.push(vertexAt(a));
		
		
		while(!stack.isEmpty()){
			Vertex vertex = stack.pop();
			vertex.visited = true;
			
			for(int i = 0; i < vertex.neighbors.size(); i++){
				if(!vertex.getNeighbor(i).visited && !stack.contains(vertex.getNeighbor(i))){
					stack.push(vertex.getNeighbor(i));
					vertex.getNeighbor(i).predecessor = vertex;	
				}
			}	
		}
		this.unvisitAll();
	}
	
	public Vertex vertexAt(int index){
		return vertices[index];
	}
	
	public void printPath(int index){
		Vertex vertex = vertexAt(index);
		while(vertex.predecessor != vertex){
			System.out.println(vertexAt(index).index+"->"+vertexAt(index).predecessor.index);
			vertex = vertex.predecessor;
		}
		System.out.println(vertex.index);
	}
	
	public void prim(){
		
	}

	public static void main(String[] args) throws IOException{
		GraphAsList grafo = new GraphAsList(5);
		grafo.addEdge(0, 1, 1);
		grafo.addEdge(1, 2, 2);
		grafo.addEdge(2, 3, 7);
		grafo.addEdge(3, 4, 4);

		//grafo.bfs(0, 4);
		grafo.dfs(0, 4);
	
	}
}
