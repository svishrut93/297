package Extracting_children;


import java.util.ArrayList;
import java.util.HashSet;

public class Tree {
	
	
	ArrayList <Treesnode> nodelist = new ArrayList();
	
	
	public void add(Treesnode node)
	{
		nodelist.add(node); 
	}

	public void displayAllNodes ()
	{
		for (Treesnode node : nodelist)
			System.out.println(node.data);
	}
	
	public void node_count ()
	{
		System.out.println(nodelist.size());
	}

	public HashSet findkids(String parent) {
		 
		for (Treesnode node : nodelist)
		{
			if(node.data.equals(parent))
			{
				return node.kids;
			}
		}
		System.out.println("Node dosent exist ion tree");	
		return null;
		
	}

}
