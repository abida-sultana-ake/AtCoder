n = int(raw_input())
a = map(int, raw_input().split())

result = [0] * n
for i in range(n):
    if n % 2 == 1:
        result[int(n / 2)] = a[0]
        if i % 2 == 1:
            result[int(n / 2) + int((i + 1) / 2)] = a[i]
        else:
            result[int(n / 2) - int((i + 1) / 2)] = a[i]
    else:
        if i % 2 == 1:
            result[int(n / 2) - int((i + 1) / 2)] = a[i]
        else:
            result[int(n / 2) + int((i + 1) / 2)] = a[i]

import sys
for i in range(n):
    sys.stdout.write(str(result[i]) + ' ')