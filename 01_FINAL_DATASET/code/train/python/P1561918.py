#coding:utf-8

from collections import defaultdict

N = int(input())
a = map(int, input().split(" "))
a_list = list(a)

dic = defaultdict(int)
for n in a_list:
    dic[n] += 1

max_count = 0
res = 0
for n in set(a_list):
    val = dic[n-1] + dic[n] + dic[n+1]

    if val > max_count:
        max_count = val

print (max_count)
