import java.util.*;

public class main 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        graph g = new graph();

        // Read input
        while (sc.hasNextLine())
        {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) break;

            String[] parts = line.split(" ");
            g.addEdge(parts[0], parts[1]);
        }

        // Run algorithm
        TopoSorter sorter = new TopoSorter(g);
        TopoSortResult result = sorter.sort();

        if (result.hasCycle())
        {
            System.out.println("Cycle detected: " + String.join(" -> ", result.cycle));
        }
        
        else
        {
            System.out.println("Topological order: " + String.join(" -> ", result.order));
        }
    }
}