import sys
sys.setrecursionlimit(10000000)
def search(prev, start, stop):
    global nodes, edges
    for neigh in nodes[start]:
        if neigh==prev:
            continue
        if neigh==stop:
            return [stop,start]
        res=search(start,neigh,stop)
        if res!=False:
            res.append(start)
            return res
    return False

def size(prev, curr):
    su=1
    global nodes, edges
    for neigh in nodes[curr]:
        if neigh==prev:
            continue
        su+=size(curr,neigh)
    return su

n=int(input())
nodes=[[] for i in range (n)]
edges=[]
for i in range(n-1):
    line=input().split()
    a=int(line[0])-1
    b=int(line[1])-1
    edges.append([a,b])
    nodes[b].append(a)
    nodes[a].append(b)

res=search(-1,n-1,0)

fennec=(len(res)-1)//2
snuke=fennec+1
snuke=res[snuke]
fennec=res[fennec]
fennecsize=size(snuke,fennec)
snukesize=size(fennec,snuke)

if fennecsize>snukesize:
    print ("Fennec")
else:
    print("Snuke")
