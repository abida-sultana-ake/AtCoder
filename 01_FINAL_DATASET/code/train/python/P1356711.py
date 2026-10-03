n, l = map(int, input().split())

s = input()

p = 1
ans = 0

for i in range(n):
    if s[i] == '+':
        p+=1
    else:
        p-=1

    if p > l:
        ans+=1
        p = 1

print(ans)
