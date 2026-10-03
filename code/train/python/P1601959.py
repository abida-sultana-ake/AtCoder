N = int(input())
K = int(input())
x = list(map(int,input().split()))

total = 0
for each in x:
    A = each
    B = abs(each - K)
    if(A < B):
        total += (A * 2)
    else:
        total += (B * 2)

print(total)