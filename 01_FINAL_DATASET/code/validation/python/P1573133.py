def read(): return list(map(int, input().split()))

x, t = read()
print(max(0, x - t))