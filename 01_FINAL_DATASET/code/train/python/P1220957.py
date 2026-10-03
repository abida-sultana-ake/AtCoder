n, k = map(int, input().split())
r = list(map(int, input().split()))
r.sort()
r.reverse()
x = [(2**(k-i-1))*r[i] for i in range(k)]
x.insert(0, 0)
ans = sum(x)/(2**k)
#print(ans)

print("{0:.6f}".format(ans))
