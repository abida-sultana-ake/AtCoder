r = input().split()
ans = int(r[0]) * 100 + int(r[1]) *10 + int(r[2])
if ans%4 == 0:
    print("YES")
else:
    print("NO")