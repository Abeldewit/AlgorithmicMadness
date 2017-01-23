# AlgorithmicMadness

IMPORTANT!

//MAIN
The Gutil.java has to be executed in order to use the algorithms. In the Gutil constructor, uncomment any instances of algorithms, debugging tools or adjust the source of the graph. It allows us to test the algorithms in any order or just 1 at a time.

//OBJECTS
Vertex.java I think its pretty obvious.
ColEdge.java is needed to read in the graph, so we dont have to place all the coding wrapped in stevens readerGraph.java

//SHARED TOOLS
SetTools.java includes some low level tools to ease working with sets. Functions as: intersection, union, remove, removeset.

GraphTools.java includes additional shared tools for the algorithms. For example, you can test if the Graph coloring is fully valid etc.

DegreeSort.java includes functions to quickly sort a graph by the vertex degree, saturation or degeneracy.

ReadGraph.java reads in the graph

ShapeDetection.java it isnt finished yet.

MIS.java Finds the maximal independent set in the graph. It works finds the set , but needs to be killed with exception handling otherwise it stucks in  a loop.

//PARITY TEST
BFS.java tests if the graph is 2-colorable.
BFST.java tests if the graph is 3-colorable.

//UPPERBOUND ALGOS
RFL.java Recursive Largest First
DSatur.java Greedy with degree saturation ordering
WelshPowell.java Greedy with degree ordering

//LOWERBOUND ALGOS
MAxClique.java Finds the maximal clique in the graph.

//DFS
Bruteforce BackTrack Works better if the starting color number is higher: It usually still does not time out with high UB and lets us to decrease our UB.
