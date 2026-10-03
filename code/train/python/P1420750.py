N = int(input())
S = [int(x) for x in input().split()]
L =[]
def dfs(t,i):
    ans = - 10000
    if (t == 1):
        res = []
        for j in range(N):
            if i == j: continue
            if j < i: s= S[j:i+1]
            else: s = S[i:j+1]
            takahashi = [s[x] for x in range(len(s)) if x % 2 == 0]
            aoki = [s[x] for x in range(len(s)) if x % 2 == 1]
            res.append((sum(takahashi),sum(aoki),j))
        res = sorted(res, key=lambda x: (x[1],-x[2]),reverse=True)
        #print("AOKI",res)
        return res[0]

    for i in range(N):
        p = dfs(t+1,i)
        L.append(p)
    #print("takahashi",L)
    return max(L)

if __name__ == '__main__':
    MAX = dfs(0,0)
    print(MAX[0])