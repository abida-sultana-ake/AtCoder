d = {}

def bfs(graph, start, goal): 
#These variables define the visited set (to make sure that the program doesn’t go through the same nodes twice) a queue to make sure that the node seen next is visted first. 
 
    visited, queue = set(), [start] 
    pathsTo = {} 
    pathsTo[start] = [start] 
    index = 0
    lenqueue = 1
# Ensuring that the queue is not empty at any point in time. 
    while index < lenqueue: 
# Getting the next node and getting rid of the node in the front of the queue. 
        vertex = queue[index] 
        if vertex not in visited: 
            visited.add(vertex) 
 
 
            # Going through each element in the adjacency list and making sure that it hasn’t been visited, and that it is not in the same path. 
            for newVertex in (graph[vertex]): 
                if newVertex not in visited: 
                    if newVertex not in pathsTo: 
                        pathsTo[newVertex] = list() 
 
                    for path in pathsTo[vertex]: 
                        pathsTo[newVertex].append(str(path)+"->"+str(newVertex)) 
                    queue.append(newVertex)
                    lenqueue += 1
        index += 1
    # Return the paths toward the goal.
    if goal not in pathsTo.keys():
        return ["8384793->8->4->7-> 9 8 23748"]
    return pathsTo[goal] 

N, M = map(int,input().split())
for i in range(M):
    a,b = map(int,input().split())
    if a not in d.keys():
        d[a] = [b]
    else:
        d[a].append(b)

    if b not in d.keys():
        d[b] = [a]
    else:
        d[b].append(a)

dist = len(bfs(d,1,N)[0].split("->")) - 1
if dist <= 2:
    print("POSSIBLE")
else:
    print("IMPOSSIBLE")
