import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DisjointSet {

	protected Node[] sets;

	public DisjointSet(int n) {
		sets = new Node[n];
		for(int i = 0; i < n; i++){
			this.sets[i] = new Node(i);
		}
		System.out.println("-");
	}

	public void union(int a, int b){
		a = findPredecessor(a);
		b = findPredecessor(b);
		
		if(sets[a].cost > sets[b].cost){
			sets[b].predecessor = a;
			System.out.println("-");
		}
		else if(sets[a].cost < sets[b].cost){
			sets[a].predecessor = b;	
			System.out.println("-");
		}
		else{
			sets[a].predecessor = b;
			sets[b].cost++;
			System.out.println("-");
		}
	}
	
	public boolean compare(int a, int b) {
		a = findPredecessor(a);
		b = findPredecessor(b);
		
		if(a == b){
			System.out.println("true");
			return true;
		}
		else{
			System.out.println("false");
			return false;
		}
	}
	
	private int findPredecessor(int index){
		while(index != sets[index].predecessor){
			index = sets[index].predecessor;
		}
		return index;
	}

	

	public static void main(String[] args) throws IOException {
		FileReader file = new FileReader("conjuntos2.in");
		BufferedReader br = new BufferedReader(file);
		String valores = br.readLine();
		DisjointSet set = new DisjointSet(Integer.parseInt(valores));
		while (br.ready()) {
			valores = br.readLine();
			String[] vSplited = valores.split(" ");
			String type = vSplited[0];
			String v1 = vSplited[1];
			String v2 = vSplited[2];
			if (type.equals("union")) {
				set.union(Integer.parseInt(v1), Integer.parseInt(v2));
			} else if (type.equals("compare")) {
				set.compare(Integer.parseInt(v1), Integer.parseInt(v2));
			}
		}
		file.close();
	}

}
