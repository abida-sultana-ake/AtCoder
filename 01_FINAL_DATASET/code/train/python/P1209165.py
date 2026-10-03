o = list(input())
e = list(input())
j = 0
k = 0
ans = ""
for i in range(0, len(o) + len(e)):
    if i%2 == 0:
        ans += o[j]
        j += 1
    else:
        ans += e[k]
        k += 1
print(ans)