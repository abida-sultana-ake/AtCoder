s = input()
k = int(input())
S = set()
n = len(s)
for i in range(n):
    if i+k-1 < n:
        S.add(s[i:i+k])
print(len(S))