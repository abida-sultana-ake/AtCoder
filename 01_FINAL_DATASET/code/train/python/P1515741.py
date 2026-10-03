N, A, B = map(int, input().split())

if N <= 5:
    ans = N * B
else:
    ans = (5 * B) + ((N-5) * A)

print(ans)
