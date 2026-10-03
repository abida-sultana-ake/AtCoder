s = list(input())
n = int(input())
lst = []
for i in range(len(s)):
    for j in range(len(s)):
        lst.append(s[i] + s[j])
print(lst[n-1])

