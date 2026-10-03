N = int(input())
a = [int(input()) for i in range(N)]
dic = dict(zip(sorted(set(a)), range(N)))
print(*list(map(lambda x: dic[x], a)), sep="\n")
