s = input()
base = "aiueo"
ans = []
for i in s:
    if not i in base:
        ans.append(i)
    else:
        pass

print(''.join(ans))