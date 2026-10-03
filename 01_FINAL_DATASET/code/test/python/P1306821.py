n = int(input())

ans = ""
a = [n // 60 // 60, (n // 60) % 60, n % 60]
for i in a:
    if i < 10:
        ans += "0" + str(i) + ":"
    elif i < 1:
        ans += "00:"
    else:
        ans += str(i) + ":"

print(ans[:-1])
