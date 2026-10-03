S=str(input())
N=int(input())
for i in range(N):
  S="0"+S
  l,r=map(int,input().split())
  S=S[1:l]+S[r:l-1:-1]+S[r+1:]
print(S)