import numpy as np
import sys

# 整数の入力
a = int(sys.stdin.readline())
# スペース区切りの整数の入力
n = [int(i) for i in sys.stdin.readline().split()]

avg = np.mean(n)
p = round(avg)

print(int(sum([(i-p)*(i-p) for i in n])))
