N = int(input())
S = input()
x = 0
ret = 0
for s in S:
    x += 1 if s == 'I' else -1
    ret = max(ret, x)
print(ret)
