A, B, C, D = [int(i) for i in input().split()]

s1 = A*B
s2 = C*D

if s1 >= s2:
    print(s1)
else:
    print(s2)