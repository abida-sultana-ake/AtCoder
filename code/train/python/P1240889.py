# -*- coding: utf-8 -*-

n, m = list(map(int, input().split()))
x = list(map(int, input().split()))
y = list(map(int, input().split()))

def sum_length(x, n):
    all_sum = 0
    prev_sum = 0
    for i in range(1, n):
        cur_sum = prev_sum + (x[i] - x[i-1]) * i
        all_sum = all_sum + cur_sum
        prev_sum = cur_sum
    return all_sum

sumx = sum_length(x, n)
sumy = sum_length(y, m)
print(sumx * sumy % 1000000007)