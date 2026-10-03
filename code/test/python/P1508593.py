
class Node:
    def __init__(self):
        pass

class Edge:
    def __init__(self,edge,cost=1):
        self.node_from=edge[0]
        self.node_to=edge[1]
        self.cost=cost

    def add_node(self,node):
        self.nodes.append(node)

class myGraph:

    def __init__(self):
        self.adj={}
        self.nodes={}

    def add_edge(self,edge,cost):
        if len(edge)==1:
            edge=list(edge)

        u,v=edge[0],edge[1]

        if u not in self.nodes:
            self.adj[u] = {}
            self.nodes[u] = {}

        if v not in self.nodes:
            self.adj[v] = {}
            self.nodes[v] = {}

        # add the edge
        self.adj[u][v] = cost
        self.adj[v][u] = cost

    def add_directed_edge(self,edge,cost):
        if len(edge)==1:
            edge=list(edge)


        u,v=edge[0],edge[1]

        if u not in self.nodes:
            self.adj[u] = {}
            self.nodes[u] = {}

        if v not in self.nodes:
            self.adj[v] = {}
            self.nodes[v] = {}

        self.adj[u][v] = cost

    def get_edges_from(self,node):
        return [(self.adj[node][nn],node,nn) for nn in self.adj[node]]


    def makeEdgeobj(self):
        edges=[]
        for sn in self.nodes:
            for e in self.get_edges_from(sn):
                edges.append(Edge([e[1],e[2]],e[0]))

        return edges

    def _add(self,edges,add_edges):
        for e in add_edges:
            hq.heappush(edges,e)
        return edges

    def bermn_ford(self,start,init=0):

        nodes=self.nodes
        dists={}
        for n in nodes:
            dists[n]=float("inf")

        dists[start]=init
        edges=self.makeEdgeobj()

        for i in range(len(nodes)):
            update=False
            for k in range(len(edges)):
                e=edges[k]
                if  dists[e.node_from]!=float("inf") and dists[e.node_to]>dists[e.node_from]+e.cost:
                    dists[e.node_to]=dists[e.node_from]+e.cost
                    update=True

            if i==len(nodes)-1:
                return False

            if not update:
                break

        return dists


    def dijkstra(self,start, goal=None):
        import heapq
        '''
            get minimum cost
        '''

        N = len(self.adj)          # グラフのノード数
        #dist = [float('inf') for i in range(N)] # 始点から各頂点までの最短距離を格納する
        dist = {k:float('inf') for k in self.nodes}
        #prev = [float('inf') for i in range(N)]

        dist[start] = 0
        visited = []

        koho=[]
        heapq.heappush(koho,(0,start))

        vtx=list(self.nodes)
        vtx.remove(start)

        while len(koho)!=0:
            d,mini=heapq.heappop(koho)
            if dist[mini]<d:
                continue


            for k in list(self.adj[mini]):
                cost=self.adj[mini][k]
                if cost != float('inf') and dist[k]>dist[mini]+cost:# and not(k in visited):
                    dist[k]=dist[mini]+cost
                    heapq.heappush(koho,(dist[k],k))
                    #prev[k]=mini

        return dist

    def prim(self):

        import heapq

        nodes=list(self.nodes.keys())
        N=len(nodes)

        X=[nodes[0]]
        unused=[]
        for u in self.adj[X[0]]:
            heapq.heappush(unused,(self.adj[X[0]][u],X[0],u))

        total_cost=0
        used={n:False for n in nodes}
        used[X[0]]=True
        while True:
            #print(unused)
            #print(X,total_cost)
            cost,u,v=heapq.heappop(unused)
            if used[v]:
                continue
            X.append(v)
            used[v]=True
            total_cost+=cost
            if len(X)==N:
                break

            for u in self.adj[v]:
                if used[u]:
                    continue
                heapq.heappush(unused,(self.adj[u][v],v,u))

        return total_cost




    def show(self):

        import networkx as nx
        import matplotlib.pyplot as plt
        G=nx.Graph()

        for u in self.adj:
            for v in self.adj[u]:

                #G.add_edge(e.node_from,e.node_to,weight=e.cost)
                G.add_edge(u,v,weight=self.adj[u][v])
                #print(e.node_from,e.node_to,e.cost)

        pos=nx.spring_layout(G)
        #nx.draw_networkx_edges(G,pos=pos,edgelist=G.edges())
        edge_weight=dict([((u,v,),int(d['weight'])) for u,v,d in G.edges(data=True)])

        nx.draw_networkx_edge_labels(G,pos,edge_labels=edge_weight)
        #nx.draw_networkx_labels(G, pos)
        nx.draw_networkx_nodes(G,pos)
        nx.draw_networkx_edges(G,pos)
        nx.draw_networkx_labels(G,pos)
        #plt.axis('off')
        #nx.draw(G,with_labels=True)
        plt.show()



def spaceinput():
    s=input()
    if len(s)==0:
        return False

    return list(map(int,s.split(" ")))

if __name__=="__main__":

    N=int(input())

    g=myGraph()


    for i in range(N-1):
        try:
            ss=spaceinput()
            if not ss:
                break
        except:
            break
        g.add_edge((ss[0],ss[1]),ss[2])
        #g.add_directed_edge((ss[0],ss[1]),ss[2])

    Q,K=spaceinput()

    res=g.dijkstra(K)
    xx=[]
    for k in range(Q):
        xx.append(spaceinput())



    for x,y in xx:
        print(int(res[x]+res[y]))
