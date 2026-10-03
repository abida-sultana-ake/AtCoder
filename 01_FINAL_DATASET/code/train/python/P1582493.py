n = int(input())
a = [int(num) for num in input().split()]
cnt = 0
for num in a:
    while num % 2 == 0\
    or num == 5:
        cnt += 1
        num -= 1
print(cnt)
