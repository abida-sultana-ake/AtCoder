#############################################################################
# -*- coding: utf-8 -*-
nums = list(map(int, input().split()))
a = nums[0]
b = nums[1]
c = nums[2]
count_a = nums.count(a)
count_b = nums.count(b)
count_c = nums.count(c)

list = [count_a, count_b, count_c]
ans = 4 - max(list)
print(ans)