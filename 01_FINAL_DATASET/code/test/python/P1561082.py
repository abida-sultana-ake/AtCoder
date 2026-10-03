N = int(input())
P = list(map(int, input().split()))

ans = 0

i = 0

while i < len(P):
    if i+1 == P[i]:
        if i+1 != len(P):
            if i+2 == P[i+1]:
                ans += 1
                i += 1
            else:
                ans += 1
        else:
            ans += 1
    i += 1
    
print(ans)