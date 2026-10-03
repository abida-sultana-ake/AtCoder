N = int(input())
a, b = [int(i) for i in input().split()]
K = int(input())
P = [int(i) for i in input().split()]
Q = set(P)
if a in P or b in P or len(Q) != len(P):
    print('NO')
else:
    print('YES')
