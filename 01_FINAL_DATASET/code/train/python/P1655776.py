s = list(input())
n = int(input())
for _ in range(n):
    a,b = map(int,input().split())
    s[a-1:b] = reversed(s[a-1:b])
print("".join(s))
