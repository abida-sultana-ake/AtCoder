s = list(input())
s.append("")
a = list(map(int,input().split()))

j = 0
if a[0] == 0:
    print('"', end = "")
    j += 1

for i in range(len(s)):
    if j < 4 and a[j] == i:
        print('"', end = "")
        j += 1
    print(s[i], end = "")
print()
