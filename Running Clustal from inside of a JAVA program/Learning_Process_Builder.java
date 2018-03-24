import java.io.*;
import java.util.*;


public class Learning_Process_Builder {
	
	
	public static void main(String[] args) throws IOException, InterruptedException 
	{
		File file = new File("C:\\cs297\\shared with vm\\genus tests\\BactroceraTR.fa");
		  
		  Scanner sc = new Scanner(file);
		  
//		    while (sc.hasNextLine())
//		      System.out.println(sc.nextLine());
//		   
		  String JAVA_CMD = "clustalo";
		  String first_i = "-i";
		  String input_file_path = "C:\\cs297\\shared with vm\\genus tests\\BactroceraTR.fa"; 
		  String second_o = "-o"; 
		  String output_file_path = "C:\\cs297\\shared with vm\\genus tests\\BactroceraTRfromJava2.fa"; 		    	    

    	ProcessBuilder pb = new ProcessBuilder(JAVA_CMD,first_i,input_file_path,second_o,output_file_path);
    	Process process = pb.start();
    	System.out.println("Process started");
    	int errCode = process.waitFor();
    	System.out.println("Process waiting");
    	System.out.println("Clustalo command executed, any errors? " + (errCode == 0 ? "No" : "Yes"));       	               
	}
}
