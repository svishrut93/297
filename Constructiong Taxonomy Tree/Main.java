package Extracting_children;

import java.io.BufferedReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {

		// Counting the number of lines in file : use this to pass as V into the Graph
		BufferedReader liner;
		String Reader;
		int line_counter = 0;

		try {

			liner = new BufferedReader(new FileReader("C:\\cs297\\experiments\\testerlist2.txt"));

			while ((Reader = liner.readLine()) != null) {
				line_counter++;
			}
			liner.close();

			System.out.println("No. of lines in the file are:" + line_counter);
		} catch (IOException e) {

			System.out.println("There was a problem reading lines :" + e);
		}

		BufferedReader in;
		String Read;
		long startTime = System.nanoTime();

		int node_counter = 0;
		Treesnode root = new Treesnode("" + "" + "");

		Tree fulltree = new Tree();
		fulltree.add(root);
		try {

			in = new BufferedReader(new FileReader("C:\\cs297\\experiments\\testerlist2.txt"));

			int node_id = 0;
			while ((Read = in.readLine()) != null) {
				Treesnode trav = root;
				for (String s : Read.split("_")) {

					if (trav.hasKidWithName(s) == true) {
						trav = trav.getNode(s);

					} else {
						Treesnode nnn = new Treesnode(s);
						fulltree.add(nnn);
						trav = trav.addKidWithName(nnn);

						node_counter++;
					}
				}
			}

			System.out.println("Tree is built and contains " + node_counter + " number of nodes.");
			long endTime = System.nanoTime();
			long totalTime = (endTime - startTime) / 1000000000;
			System.out.println("time taken to construct the tree is " + totalTime + " seconds");

			System.out.println("All nodes of tree are ..");
			// fulltree.displayAllNodes();
			fulltree.node_count();

			System.out.println("Enter the node of whose children you want to extract..");
			Scanner s = new Scanner(System.in);

			String parent = s.next();

			System.out.println("Finding children of  " + parent);
			System.out.println();

			HashSet<Treesnode> kidsOfGenus = fulltree.findkids(parent);
			kidprinter(kidsOfGenus);
		} catch (Exception e) {
			System.out.println("There was a problem:" + e);
		}

	}

	public static void kidprinter(HashSet<Treesnode> kidsOfGenus) {
		for (Treesnode f : kidsOfGenus) {
			System.out.println(f.data);
		}
	}

}
