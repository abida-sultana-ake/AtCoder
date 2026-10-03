a = int(input())
cnt = 0
while a:
    cnt += 1
    a >>= 1
print(1 << (cnt - 1))
