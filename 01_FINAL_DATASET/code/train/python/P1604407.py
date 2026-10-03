A = input()
N = len(A)
diff = 0
for i in range(N//2):
    if A[i] != A[-i-1] : diff += 1

ans = N * 25
if diff == 0 and N%2 == 1:
    ans -= 25
elif diff == 1:
    ans -= 2
print(ans)
