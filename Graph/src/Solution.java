import java.util.*;
import java.io.*;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.MultiGraph;

public class Solution 
{
	
	
	
	public ArrayList<Support> read_table() throws Exception
	{
		ArrayList<Support> al=new ArrayList<Support>();
		String line="";
		BufferedReader br = new BufferedReader(new FileReader("small.tsv"));
		while((line=br.readLine())!=null)
		{
			String[] c=line.split("\t");
			al.add(new Support(c[0], c[1]));
		}
		br.close();
		return al;
		
	}
	
	//main method
	public static void main(String args[]) throws Exception
	{
		ArrayList<Support> al=new ArrayList<Support>();
		
		
		//read file call
		
		Graph graph = new MultiGraph("Tutorial 1");
		graph.setStrict(false);
		graph.setAutoCreate( true );
		Solution solution=new Solution();
		al = solution.read_table();
		
		
		for(int i=0; i<al.size(); i++)
		{
			
			graph.addEdge(al.get(i).source+""+al.get(i).target, al.get(i).source, al.get(i).target, true);
		}
		HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
		for(Node g:graph)
		{
			
			int diff=g.getOutDegree()-g.getInDegree();
			int count=0;
			boolean res=hm.containsKey(diff);
			if(!res)
			{
				for(Node f:graph)
				{
					if(diff==f.getOutDegree()-f.getInDegree())
					{
						count++;
					}
				}
				hm.put(diff, count);
				count=0;
			}
		}
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>(hm); 
		Set set2 = map.entrySet();
		Iterator iterator2 = set2.iterator();
		while(iterator2.hasNext())
		{
			Map.Entry me2=(Map.Entry)iterator2.next();
			System.out.println(me2.getKey()+"\t"+me2.getValue());
		}
		
		
		
		
	}
}

