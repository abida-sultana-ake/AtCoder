n = int(input())
a = [int(input()) for i in range(n)]
m = {x : i for i, x in enumerate(sorted(set(a)))}
print(*[m[x] for x in a], sep='\n')