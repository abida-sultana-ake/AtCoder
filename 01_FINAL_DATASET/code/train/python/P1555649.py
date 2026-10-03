N = int(input())
src = [int(input()) for i in range(N)]
def solve():
    if N == 1:
        return (src[0],src[0])
    mx = sum(src)
    longest = max(src)
    mn = max(0, longest -(mx - longest))
    return (mx,mn)

result = solve()
print(result[0])
print(result[1])
