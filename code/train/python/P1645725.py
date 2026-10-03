_ = int(input())
A = list(map(int, input().split()))
ret = 0
for a in A:
    while a % 2 == 0 or a % 3 == 2:
        ret += 1
        a -= 1
print(ret)