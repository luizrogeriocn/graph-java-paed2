public class MinHeap {
	MaxHeap heapster;

	public MinHeap() {
		heapster = new MaxHeap();
	}

	public void insert(int id, int cost) {
		heapster.insert(id, -cost);
	}

	public void extract() {
		heapster.extract();
	}

	public void decrease(int id, int cost) {
		heapster.decrease(id, -cost);
	}

	public void increase(int id, int cost) {
		heapster.increase(id, -cost);
	}
	
	public int getSize(){
		return heapster.size;
	}
	public int getNode(int index){
		return heapster.nodes.get(index).cost;
	}

	public static void main(String[] args) {
		MinHeap hp = new MinHeap();

		hp.insert(1, 100);
		hp.insert(2, 300);
		hp.insert(3, 250);
		hp.insert(4, 1000);
		hp.insert(5, 500);
		hp.insert(6, 254);
		hp.insert(7, 15);
		// hp.decrease(5, 302);
		hp.extract();
		for (int i = 1; i <= hp.getSize(); i++) {
			System.out.println(-hp.getNode(i));
		}
	}
}
