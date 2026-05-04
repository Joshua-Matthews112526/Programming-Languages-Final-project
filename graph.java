import java.util.*;

public class graph
{
	private Map<String, List<String>> adj = new HashMap<>();
	
	public void addVertex(String v)
	{
		adj.putIfAbsent(v, new ArrayList<>());
	}
	
	public void addEdge(String from, String to)
	{
		addVertex(from);
		addVertex(to);
		adj.get(from).add(to);
	}
	
	public List<String> neighborsOf(String v)
	{
		return adj.getOrDefault(v, new ArrayList<>());
	}
	
	public Set<String> getVertices()
	{
		return adj.keySet();
	}
}