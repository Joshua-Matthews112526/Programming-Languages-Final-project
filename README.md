# Programming-Languages-Final-project
Topological Sorting (Java & SML)
Overview

This project implements topological sorting on a directed graph. Given vertices and dependencies (A → B means A must occur before B), the program outputs either a valid topological order or detects and reports a cycle.

Features
Detects cycles in directed graphs
Produces valid topological ordering if acyclic
Implemented in:
Java (object-oriented design)
SML (functional, recursive approach)
Structure
Java: Uses classes (Graph, TopoSorter, TopoSortResult, Main) to separate data, logic, and I/O
SML: Uses functional decomposition across files (graph.sml, topo.sml, main.sml)
Example Output
Topological order: A -> C -> B -> D
Cycle detected: B -> D -> F -> B
Notes
Java emphasizes encapsulation and modular design
SML emphasizes recursion and immutable data structures

How to Run SML:
1. must install SML of New Jersey for this specific SML functional decomposition style
2. open cmd
3. cd into project folder
4. open sml with typing "sml" , should tell you version of SML N.J. installed
5. start the program by typing use then the file name and a semicolon, exactly like: use "main.sml";
6. ctrl z to exit or close cmd window
