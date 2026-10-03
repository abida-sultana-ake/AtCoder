S = input()

lst = ['A','B','C','D','E','F']
ans = []
for i in lst:
    num = S.count(i)
    ans.append(num)

print(ans[0], ans[1], ans[2], ans[3], ans[4], ans[5])
