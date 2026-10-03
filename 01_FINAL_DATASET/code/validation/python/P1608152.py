n = int(input())
s = input()
tmp = 0
ans = 0

for i in range(n):
    if s[i] == "I":
        tmp += 1
    else:
        tmp -= 1
    if ans < tmp:
        ans = tmp
print(ans)