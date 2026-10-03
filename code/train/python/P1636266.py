# coding: utf-8
# Here your code !
A = int(input())
B = int(input())
C = int(input())

ABC = [A, B, C]
ans_a, ans_b, ans_c = 3, 3, 3
for i in ABC:
    if A > i:
        ans_a -= 1
    if B > i:
        ans_b -= 1
    if C > i:
        ans_c -= 1

print(ans_a)
print(ans_b)
print(ans_c)