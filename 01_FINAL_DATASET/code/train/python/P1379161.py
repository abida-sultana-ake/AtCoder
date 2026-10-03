# D
import numpy as np
N = int(input())
X = []
Y = []

for i in range(N):
    x, y = map(int, input().split())
    X.append(x)
    Y.append(y)

# edges
X_s = np.argsort(np.array(X))
Y_s = np.argsort(np.array(Y))

edge_list = []
edge_weight = []
for i in range(N-1):
    edge_list.append([X_s[i], X_s[i+1]])
    edge_weight.append(X[X_s[i+1]] - X[X_s[i]])
    edge_list.append([Y_s[i], Y_s[i+1]])
    edge_weight.append(Y[Y_s[i+1]] - Y[Y_s[i]])
    
# sort edges
sel = np.argsort(np.array(edge_weight))

# union find tree
uf = np.arange(N)


res = 0
flg = np.zeros(N)

for s in sel:
    m, n = edge_list[s]
    # find union
    gr_m = m
    gr_m_list = []
    gr_n = n
    gr_n_list = []
    while gr_m != uf[gr_m]:
        gr_m_list.append(gr_m)
        gr_m = uf[gr_m]
    for m_ in gr_m_list:
        uf[m_] = gr_m
        
    while gr_n != uf[gr_n]:
        gr_n_list.append(gr_n)
        gr_n = uf[gr_n]
    for n_ in gr_n_list:
        uf[n_] = gr_n
        
    if gr_m == gr_n:
        pass
    else:
        res += edge_weight[s]
        uf[gr_n] = gr_m
print(res)