N = int(input())
A = [int(input()) for _ in range(N)]
S = {v: i for i, v in enumerate(sorted(set(A)))}
print(*[S[a] for a in A], sep="\n")