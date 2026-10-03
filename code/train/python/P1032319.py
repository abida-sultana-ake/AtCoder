import sys

n = int(input())
a_lst = [int(x) for x in input().split()]

dic = {}

for i in range(1, n + 1, 2):
    j = n - i
    dic[j] = 1 if j == 0 else 2

for i in a_lst:
    if i not in dic:
        print(0)
        sys.exit()

    dic[i] -= 1

    if dic[i] < 0:
        print(0)
        sys.exit()

print(pow(2, n // 2) % (pow(10, 9) + 7))