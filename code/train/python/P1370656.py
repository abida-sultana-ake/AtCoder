
n = int(input())
a = list(map(int, input().split()))
rates = [0] * 8
high = 0

for i in a:
        if i < 400:
                rates[0] += 1
        elif i < 800:
                rates[1] += 1
        elif i < 1200:
                rates[2] += 1
        elif i < 1600:
                rates[3] += 1
        elif i < 2000:
                rates[4] += 1
        elif i < 2400:
                rates[5] += 1
        elif i < 2800:
                rates[6] += 1
        elif i < 3200:
                rates[7] += 1
        else:
                high += 1

ans = 0
for i in rates:
        if i != 0:
                ans += 1

print(max(ans, 1), ans + high)