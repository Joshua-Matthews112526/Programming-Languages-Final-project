import java.util.*;

public class TopoSorter
{
	private graph graph;
	private Map<String, Integer> state;
	private List<String> order;
	private List<String> cycle;
	private Map<String, String> parent = new HashMap<>();
	
	public TopoSorter(graph g)
	{
		this.graph = g;
		state = new HashMap<>();
		order = new ArrayList<>();
	}
	
	public TopoSortResult sort()
	{
		for(String v : graph.getVertices())
		{
			if(!state.containsKey(v))
			{
				if(dfs(v))
				{
					break;
				}
			}
		}
		
		TopoSortResult result = new TopoSortResult();
		
		if(cycle != null)
		{
			result.cycle = cycle;
		}
		
		else
		{
			Collections.reverse(order);
			result.order = order;
		}
		
		return result;
	}
	
	private boolean dfs(String node)
	{
        state.put(node, 1); // VISITING

        for (String neighbor : graph.neighborsOf(node))
        {
        	if (state.getOrDefault(neighbor, 0) == 0)
        	{
        	    parent.put(neighbor, node);
        	    if (dfs(neighbor))
        	    	{
        	    		return true;
        	    	}
        	}
            // found a cycle
        	if (state.getOrDefault(neighbor, 0) == 1)
        	{
        	    cycle = new ArrayList<>();

        	    String current = node;
        	    cycle.add(neighbor);

        	    while (!current.equals(neighbor))
        	    {
        	        cycle.add(current);
        	        current = parent.get(current);
        	    }

        	    cycle.add(neighbor); // close the loop
        	    Collections.reverse(cycle);

        	    return true;
        	}
        }

        state.put(node, 2); // VISITED
        order.add(node);

        return false;
    }
}
