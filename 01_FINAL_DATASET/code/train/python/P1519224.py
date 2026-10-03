N = int(input())

n = N // 9
num = N % 9

if n == 0:
    ans = num
else:
    if num == 0:
        num = 9
        n -= 1
    ans = str(num) * (n+1)
    ans = int(ans)

print(ans)
