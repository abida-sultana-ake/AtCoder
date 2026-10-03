S = input().strip()
N = len(S)
gn = len([1 for i in range(N) if S[i]=='g'])
gm = int((N+1)/2)
print(gn-gm)

