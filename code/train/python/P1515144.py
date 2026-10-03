a,b,c,d = map(int, input().split())
Al = list(range(a,b))
Bo = list(range(c,d))
print(len(set(Al) & set(Bo)))