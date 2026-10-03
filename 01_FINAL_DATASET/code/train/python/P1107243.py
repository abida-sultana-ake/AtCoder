import numpy as np

class Node:
    def __init__(self, id):
        self.id = id
        self.nexts = []
        self.visited = False

    def add_next(self, node):
        self.nexts.append(node)

def saiki(node, count, judge):
    node.visited = True
    judge[node.id] = True
    if(all(judge)):
        count[0]+=1

    for next in node.nexts:
        if(not next.visited):
            saiki(next, count, judge)
    node.visited = False
    judge[node.id] = False

if __name__=="__main__":
    inputs = lambda : input().replace("\n", "").split(" ")
    N, M = [int(number) for number in inputs()]

    nodes = [Node(i) for i in range(N)]
    for i in range(M):
        x, y = [int(number)-1 for number in inputs()]
        nodes[x].add_next(nodes[y])
        nodes[y].add_next(nodes[x])

    judge = [False]*N
    count = [0]
    saiki(nodes[0], count , judge)
    print(count[0])
