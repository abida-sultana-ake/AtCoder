N = int(input())
As = [int(x) for x in input().split()]
S = sum(As)

ans = None
subsum = 0
for i in range(1,N):
    subsum += As[i-1]
    temp = abs(2 * subsum - S)
    if ans is None or temp < ans:
        ans = temp
print(ans)
