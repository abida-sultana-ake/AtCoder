def dfs(cur,pre):
    a = []
    for nex in G[cur]:
        if nex == pre:
            continue
        a.append(dfs(nex,cur))
    if len(a) == 0:
        return 1
    return min(a) + max(a) + 1


def main():
    global G,V
    V = int(input())
    G = [[] for _ in range(V)]
    for i in range(1,V,1):
        s,t = i,int(input())-1
        G[s].append(t)
        G[t].append(s)
    print(dfs(0,-1))

if __name__ == "__main__":
    main()
