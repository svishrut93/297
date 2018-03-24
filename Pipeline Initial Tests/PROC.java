package ProcessBuilderPrograms;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class PROC {

	// file to process contains the path of the file to process
	public static void processFileWithClustal(String file_to_process, String path_of_search_folder)
			throws IOException, InterruptedException {
		File file = new File(file_to_process);
		Scanner sc = new Scanner(file);

		// while (sc.hasNextLine())
		// System.out.println(sc.nextLine());

		String outputfilename = outputFileNameCreation(file_to_process);

		String JAVA_CMD = "clustalo";
		String first_i = "-i";
		String input_file_path = file_to_process;
		String second_o = "-o";
		String output_file_path = path_of_search_folder + "\\"+outputfilename+"putter.fa";

		ProcessBuilder bp = new ProcessBuilder(JAVA_CMD, first_i, input_file_path, second_o, output_file_path);
		System.out.println(bp.command());
		Process process123 = bp.start();
		System.out.println("Process started");
		int errCode = process123.waitFor();
		System.out.println("Process waiting");
		System.out.println("Clustalo command executed, any errors? " + (errCode == 0 ? "No" : "Yes"));

	}

	// extracts name of the actual fasta file and appends character to it , in order
	// to generate the outputfile
	private static String outputFileNameCreation(String file_to_process) {
		String pattern = Pattern.quote(System.getProperty("file.separator"));
		String[] outputFileNameArray = file_to_process.split(pattern);

		System.out.println(outputFileNameArray[outputFileNameArray.length - 1]);
		String outputFileName = outputFileNameArray[outputFileNameArray.length - 1];

		outputFileName = outputFileName.substring(0, outputFileName.indexOf("."));
		

		return outputFileName;

	}

}
