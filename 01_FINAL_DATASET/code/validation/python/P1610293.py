N = int(input())
src = [int(input()) for i in range(N)]

ans = [0]
for i in range(N-1):
    ans.append(ans[-1] ^ src[i])
if ans[-1] != src[-1]:
    print(-1)
else:
    for a in ans:
        print(a)
