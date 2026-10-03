n,k = map(int,input().split())
baai = 6 * (n-k) * (k-1) + 3 * (k-1) + 3 * (n-k) + 1
print(baai/n**3)
