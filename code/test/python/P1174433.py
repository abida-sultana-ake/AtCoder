s = input()
k = int(input())
S = set()
n = len(s)
for i in range(n-k+1):
    S.add(s[i:i+k])
print(len(S))