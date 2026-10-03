s = input()
ret = 0
for i in range(len(s)-1):
    ret += s[i] != s[i+1]
print(ret)
