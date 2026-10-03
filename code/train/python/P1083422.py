import sys
X = int(input())
if (X <= 6):
    print('1')
    sys.exit()
else:
    n = X // 11
    m = X % 11

if (m == 0):
    print(str(n * 2))
elif (m <= 6):
    print(str(n * 2 + 1))
else:
    print(str(n * 2 + 2))
