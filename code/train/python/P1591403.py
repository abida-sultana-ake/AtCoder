n = int(input())

l = []
for i in range(n):
    l.append(input())

l_sorted = sorted(list(set(l[0])))
ans =''

for ch in l_sorted:
    cnt = min(l[i].count(ch) for i in range(n))
    ans += ch * cnt

print(ans)