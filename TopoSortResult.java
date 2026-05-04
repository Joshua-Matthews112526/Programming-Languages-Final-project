import java.util.*;

public class TopoSortResult
{
	List<String> order;
	List<String> cycle;
	
	public Boolean hasCycle()
	{
		return cycle != null;
	}
}