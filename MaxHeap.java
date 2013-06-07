import java.util.Collections;
import java.util.Vector;

public class MaxHeap {
	
	public Vector<Node> nodes;
	public int size;
	
	public MaxHeap(){
		nodes = new Vector<Node>();
		nodes.add(null);
		size = 0;
	}

	public void insert(int id, int cost){
		Node node = new Node(id, cost);
		nodes.add(node);
		size++;
		goUp(size);
	}
	
	public void extract(){
		Node node = nodes.get(1);
		Collections.swap(nodes, 1, size);
		nodes.remove(size);
		size--;
		goDown(1);
	}
	
	public void decrease(int id, int cost){
		int index = indexOfId(id);
		nodes.get(index).cost = cost;
		goDown(index);
	}
	
	public void increase(int id, int cost){
		int index = indexOfId(id);
		nodes.get(index).cost = cost;
		goUp(index);
	}
	
	public void goUp(int index){
		int currentPos = index;
		while(currentPos > 1 && costAt(currentPos) > costAt(currentPos/2)){
			Collections.swap(nodes, currentPos, currentPos/2);
			currentPos = currentPos/2;
		}
	}
	
	public void goDown(int index){
		if(index <= size/2){
			int currentPos = index;
			int posAux;
			if(costAt(greaterChild(currentPos)) > costAt(currentPos)){
				posAux = greaterChild(currentPos);
				Collections.swap(nodes, currentPos, greaterChild(currentPos));
				goDown(posAux);
			}
		}
	}
	
	public int rightChildCost(int index){
		if(size >= index*2 +1)
			return costAt(index*2 +1);
		else
			return -Integer.MAX_VALUE;
	}
	
	public int leftChildCost(int index){
		if(size >= index*2)
			return costAt(index*2);
		else
			return -Integer.MAX_VALUE;
	}
	
	public boolean hasChild(int index){
		if(size >= index*2)
			return true;
		else
			return false;
	}
	
	public int greaterChild(int index){
		int a = rightChildCost(index);
		int b = leftChildCost(index);
		if(a > b){
			return index*2+1;}
		else{
			return index*2;}
	}
	
	public int father(int index){
		return index/2;
	}
	
	public int costAt(int index){
		return nodes.get(index).cost;
	}
	
	public void swap(int a, int b){
		Node aux = nodes.get(a);
		nodes.add(a, nodes.get(b));
		nodes.add(b, aux);
	}
	
	public int indexOfId(int id){
		int res = -1;
		for(int i = 1; i < size; i++){
			if(id == nodes.get(i).id)
				res = i;
		}
		return res;
	}
	
	public void printHeap(){
		for(int i = 1; i < size; i++){
			System.out.println(costAt(i));
			System.out.println("oi");
		}
	}
	

	
	public static void main(String[] args){
		MaxHeap hp = new MaxHeap();
		
		hp.insert(1, 100);
		hp.insert(2, 300);
		hp.insert(3, 250);
		hp.insert(4, 1000);
		hp.insert(5, 500);
		hp.insert(6, 254);
		hp.insert(7, 15);
		//hp.decrease(5, 302);
		hp.extract();
		for(int i = 1; i <= hp.size; i++){
			System.out.println(hp.nodes.get(i).cost);
		}
	}
	
}
