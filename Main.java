import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Main {
	
	public static void freader() throws IOException{
		
		BufferedReader br = new BufferedReader(new FileReader("teste.in"));
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = "";
	        while (line != null) {
	            sb.append(line);
	            sb.append("\n");
	            line = br.readLine();
	            if(line == null)
	            	break;
	            System.out.println(line);
	        }
	    } finally {
	        br.close();
	    }
	}
	
	public static void main(String args[]) throws IOException{
		Main.freader();
	}
}
