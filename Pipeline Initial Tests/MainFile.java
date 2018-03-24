package ProcessBuilderPrograms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.*;

public class MainFile {

	public static void main(String[] args) throws IOException, InterruptedException {

		Scanner s = new Scanner(System.in);

		FindFile ff = new FindFile();
		String path_of_search_folder = "C:\\cs297\\shared with vm\\genus tests";

		System.out.println("Enter the file name you are looking for ");
		String search_file = s.nextLine();
		//
		String search_file_path = ff.findFile(search_file, new File(path_of_search_folder));
		if (search_file_path != null) {
			System.out.println("Do you want clustal to process the file ? (y/n)");
			String choice = s.next();

			switch (choice) {
			case "y":
				String file_to_process = search_file_path;
				PROC.processFileWithClustal(file_to_process, path_of_search_folder);
				break;

			case "n":
				System.out.println("Thank you for using the service");
				end();
				break;

			default:
				System.out.println("Invalid Response");
				break;
			}
		}
	}

	private static void end() {
		// TODO Auto-generated method stub
		System.exit(0);

	}
}
