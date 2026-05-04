use "graph.sml";
use "topo.sml";

val g1 = [
  ("A", ["C"]),
  ("C", ["B"]),
  ("B", ["D"]),
  ("D", [])
];

val g2 = [
  ("A", ["B"]),
  ("B", ["C"]),
  ("C", ["A"])
];

fun printResult res =
  case res of
      ("ok", order) =>
        print ("Topological order: " ^ String.concatWith " -> " order ^ "\n")
    | ("cycle", cycle) =>
        print ("Cycle detected: " ^ String.concatWith " -> " cycle ^ "\n")

val _ = printResult (topo g1);
val _ = printResult (topo g2);