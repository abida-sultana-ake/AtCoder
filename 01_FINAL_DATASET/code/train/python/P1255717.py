n = [int(s) for s in input().split()]
print(n[4]+n[3]+n[0] if n[3]-n[2] > n[1]-n[0] else n[4]+n[2]+n[1])