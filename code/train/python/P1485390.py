s = input()

length = len(s)
ans = s[0] + str(length - 2) + s[-1]
print(ans)