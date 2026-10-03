n, a, b = map(int, input().split())
now = 0
for i in range(n):
    s, d = map(str, input().split())
    if int(d) < a:
        d = a
    elif int(d) > b:
        d = b
    if s == 'East':
        now += int(d)
    else:
        now -= int(d)
if now > 0:
    print('East ' + str(abs(now)))
elif now < 0:
    print('West ' + str(abs(now)))
else:
    print(0)
