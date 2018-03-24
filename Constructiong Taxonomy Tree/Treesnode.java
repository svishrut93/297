package Extracting_children;

import java.util.HashSet;

public class Treesnode {
	
	String data ; 
	//int node_no ; 
	
	
	HashSet <Treesnode> kids = new HashSet();
	
	
	
	public boolean hasKidWithName(String tn)
	{
		
		for(Treesnode f : kids )
		{
			if (f.data.equals(tn) )
					{
					return true;
					}
			
		}
		return false;
		
//		if (kids.contains(tn))
//		{
//			return true; 
//		}
		
	}
	
	public Treesnode addKidWithName (Treesnode tn)
	{
		
			this.kids.add(tn);
			return tn;
		
	}
	
	public Treesnode(String data)
	{
		super();
		this.data = data;
		//this.node_no = node_no;
	}

	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}

	public Treesnode getNode(String s) {
		
		
		for(Treesnode f : kids )
		{
			if (f.data.equals(s) )
					{
						return f ;
					}			
		}

		
//		for (String ss : kids)
//		{
//			if (ss.equals(s))
//			{
//				Treesnode n = new Treesnode(ss) ;
//				return n; 
//			}
//		}
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public  HashSet <Treesnode> getAllkids ()
	{
		return this.kids; 
	}

}
