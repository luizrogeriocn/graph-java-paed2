import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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
	
	public static void fwriter(String arg) {
		try {
 
			String content = arg;
 
			File file = new File("teste.out");
 
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
 
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();
 
			System.out.println("Done");
 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]) throws IOException{
		Main.freader();
	}
}
