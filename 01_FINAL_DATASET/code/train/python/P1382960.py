n = int(input())
ans = 0
ans += (n // 11) * 2
n %= 11

if n == 0:
  ()
elif n <= 6:
  ans += 1
else:
  ans += 2

print(ans)