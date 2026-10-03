h, m = map(int, input().split())

hour = (17-h) * 60
minute = 60 - m
ans = hour + minute
print(ans)
