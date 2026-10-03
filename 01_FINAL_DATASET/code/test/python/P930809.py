n = list(map(int, input().split()))
i = 3

if n[0] == n[1] :
    i -= 1

if n[0] == n[2] :
    i -= 1

elif n[1] == n[2] :
    i -= 1

print(i)
