package ProcessBuilderPrograms;

import java.io.File;

public class FindFile {

	public String findFile(String search_file, File folder) {
		File[] list_of_files_in_folder = folder.listFiles();
		int found = 0;

		if (list_of_files_in_folder != null)
			for (File fil : list_of_files_in_folder) {
				String path = null;
				if (fil.isDirectory()) {
					findFile(search_file, fil);
				} else if (search_file.equalsIgnoreCase(fil.getName())) {
					System.out.println("File " + search_file + "exists inside " + folder);
					path = fil.getAbsolutePath();
					found = 1;
					return path;
				}
			}
		if (found == 0) {
			System.out.println("Sorry , No such file exists");
		}
		return null;
	}

}
