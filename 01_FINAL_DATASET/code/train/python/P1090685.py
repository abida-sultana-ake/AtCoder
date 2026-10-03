n = int(input())

times = 0

times += n // 11 * 2
rest = n % 11

if rest == 0:
    next
elif rest < 7:
    times += 1
else:
    times += 2

print(times)
