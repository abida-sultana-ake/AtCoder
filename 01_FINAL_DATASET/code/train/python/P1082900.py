import sys
from collections import Counter

cin = sys.stdin

N = int(cin.readline())
A = list(map(int, cin.readline().split()))

C = Counter(A)
indi = len(C)
last = N - indi
if last % 2==1:
    ans = indi - 1
else:
    ans = indi

print(ans)
