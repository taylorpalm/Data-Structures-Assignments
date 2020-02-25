#Taylor Palm
import math
from copy import deepcopy
# Add any relevant import statements up here.


# Programming Assignment 4:

class WeightedAdjacencyMatrix :

    __slots__ = ['_W', '_P', '_S']

    # 1) 
    def __init__(self, size) :
        """Initializes a weighted adjacency matrix for a graph with size nodes.
        Graph is initialized with size nodes and 0 edges.
        
        Keyword arguments:
        size -- Number of nodes of the graph.
        """
        self._S= size
        self._W= [ [ math.inf for i in range(size) ] for j in range(size) ] 

        for i in range(size):
                self._W[i][i]=0

    # 2) Implement this method (see the provided docstring)
    def add_edge(self, u, v, weight) :
        """Adds a directed edge from u to v with the specified weight.
        Keyword arguments:
        u -- source vertex id (0-based index)
        v -- target vertex id (0-based index)
        weight -- edge weight
        """
        self._W[u][v]=weight

    # 5) Implement this method (see the provided docstring)
    def floyd_warshall(self) :
        """Floyd Warshall algorithm for all pairs shortest paths.

        Returns a matrix D consisting of the weights of the shortest paths between
        all pairs of vertices.  This method does not change the weight matrix of the graph itself.

        Extra Credit version: Returns a tuple (D, P) where D is a matrix consisting of the
        weights of the shortest paths between all pairs of vertices, and P is the predecessors matrix.
        """

        P= self.predMatrix()
        D= deepcopy(self._W)

        for k in range (self._S):
            for i in range(self._S):
                for j in range(self._S):
                    if D[i][j]>D[i][k] + D[k][j]:
                        D[i][j] = D[i][k] + D[k][j]
                        P[i][j] = P[k][j]
        return (D,P)

    def predMatrix(self):
        self._P= [ [ None for i in range(self._S) ] for j in range(self._S) ]
        for i in range(self._S):
            for j in range(self._S):
                if i!=j and self._W[i][j] != math.inf:
                    self._P[i][j] = i
        return self._P

    def printPath (self, i, j):
        if i==j:
            print(i, end= ' ')
        elif self._P[i][j]== None:
            print('No path exists')
        else:
            self.printPath(i, self._P[i][j])
            print(j, end=' ')

# 3) 
def haversine_distance(lat1, lng1, lat2, lng2) :
    """Computes haversine distance between two points in latitude, longitude.

    Keyword Arguments:
    lat1 -- latitude of point 1
    lng1 -- longitude of point 1
    lat2 -- latitude of point 2
    lng2 -- longitude of point 2

    Returns haversine distance in meters.
    """

    R = 6371000;
    latDif= math.radians(lat2-lat1)
    lngDif= math.radians(lng2-lng1)
    lat1 = math.radians(lat1)
    lat2 = math.radians(lat2)

    a = math.sin(latDif/2)**2 + math.cos(lat1) * math.cos(lat2) * math.sin(lngDif/2)**2
    c = 2 * math.atan2(math.sqrt(a), math.sqrt(1-a))
    d = R * c;
    
    return d


# 4) 
def parse_highway_graph_data(filename) :
    """Parses a highway graph file and returns a WeightedAdjacencyMatrix.

    Keyword arguments:
    filename -- name of the file.

    Returns a WeightedAdjacencyMatrix object.
    """

    with open(filename) as f:
        f.readline()
        numV,numE= f.readline().split()
        numV=int(numV)
        numE=int(numE)
        WAM=WeightedAdjacencyMatrix(numV)
        lat_lng_list=[]
        for i in range (numV):
            _,lat,lng= f.readline().split()
            lat= float(lat)
            lng= float(lng)
            lat_lng_list.append((lat, lng))
        for i in range (numE):
            p1,p2,_= f.readline().split()
            p1=int(p1)
            p2=int(p2)
            weight= haversine_distance(lat_lng_list[p1][0], lat_lng_list[p1][1],
                                       lat_lng_list[p2][0], lat_lng_list[p2][1])

            WAM.add_edge(p1,p2, weight)
            WAM.add_edge(p2,p1, weight)
        
    return WAM

# 6a) This function should construct a WeightedAdjacencyMatrix object with the vertices and edges of your choice
# (small enough that you can verify that your Floyd Warshall implementation is correct).
# After constructing the WeightedAdjacencyMatrix object, call your floyd_warshall method, and then
# output the D matrix it returns using print statements (one row of matrix per line, columns separated by tabs).
# If you also computed the predecessor matrix, then output that as well (print a blank line between the matrices).
def test_with_your_own_graphs() :

    WAM = WeightedAdjacencyMatrix(5)
    WAM.add_edge(0, 4, -4)
    WAM.add_edge(0, 2, 8)
    WAM.add_edge(0, 1, 3)
    WAM.add_edge(1, 4, 7)
    WAM.add_edge(1, 3, 1)
    WAM.add_edge(2, 1, 4)
    WAM.add_edge(3, 2, -5)
    WAM.add_edge(3, 0, 2)
    WAM.add_edge(4, 3, 6)
    
    D,_= WAM.floyd_warshall()

    print("Floyd Warshall Shortest Paths Matrix:")
    for i in range(WAM._S):
        for j in range(WAM._S):
            print(D[i][j], end= '\t')
        print('\t')

    print('\n')

    print("Floyd Warshall Predecessor Matrix:")
    for i in WAM._P:
        for j in i:
            print(j, end= '\t')
        print('\t')

# 6b) 
def test_with_highway_graph(L) :
    HG= parse_highway_graph_data('AND-region-simple.txt')
    D,P= HG.floyd_warshall()
    print("From\tTo\t D[from][to]\t\tD[to][from]\t\tpathTaken")

    print('--------------------------------------------------------------------------------')

    for (i,j) in L:
        print(i, '\t', j, '\t', D[i][j],  '\t', D[j][i], '\t', end=' ')
        HG.printPath(i,j)
        print('\n')
        


if __name__ == "__main__" :


    test_with_your_own_graphs()
    l=[(1,8), (27,23), (1, 22), (21, 25), (17,42), (8, 25), (42, 26), (16,32), (21, 23), (8, 4)]
    print('\nTest Highway Graph:\n')
    test_with_highway_graph(l)
