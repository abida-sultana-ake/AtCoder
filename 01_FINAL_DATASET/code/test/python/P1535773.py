S=str(input())
K=int(input())

s=set()
for i in range(len(S)+1-K):
  s.add(S[i:i+K])
print(len(s))