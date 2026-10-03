###入力
n, m = map(int, input().split())

###到達しているか否かのサイン
sign = []
for i in range(n):
    sign.append("o")

###グラフ
graph = []
for i in range(n):
    graph.append([])

###隣接行列
for i in range(m):
    a, b = map(int, input().split())
    a -= 1
    b -= 1
    for j in range(n):
        if a == j:
            graph[j].append(b)
        if b == j:
            graph[j].append(a)

###深さ優先探索
###dfsはxからスタートしてoの箇所を全て回収する場合の数
def dfs(x, i=0):
    sign[x] = "x"
    
    ###すべてのノードが到達済みなら終了
    if sign == ["x" for k in range(n)]:
        return i + 1
    
    ###隣接するすべての点に対して、未到達ならdfsを適用
    for j in graph[x]:
        if sign[j] == "o":
            
            ###一旦xにする（後で戻す）
            sign[j] = "x"
            
            ###重要重要重要重要重要重要重要重要重要重要重要重要重要重要重要重要重要重要
            ###右辺のiにはこれまでの場合の数が蓄積されている
            ###そのiの上にjスタートの場合の数が加算される
            ###それを新たなiとする
            ###つまり、足し算の操作は右辺で完結している
            ###iはここでしか動かないことに注意
            ###重要重要重要重要重要重要重要重要重要重要重要重要重要重要重要重要重要重要
            
            i = dfs(j, i)
            
            ###戻した
            sign[j] = "o"
    return i

print(dfs(0))
