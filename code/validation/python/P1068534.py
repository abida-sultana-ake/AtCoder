def read(): return list(map(int,input().split()))

a,b,c,d = read()
print(max(a * b, c * d))