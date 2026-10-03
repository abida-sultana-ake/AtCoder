from collections import defaultdict
from itertools import product, groupby
from math import pi
from collections import deque
from bisect import bisect, bisect_left, bisect_right
INF = 10 ** 10
 
 
def main():
    n = int(input())
    a_list = list(map(int, input().split()))
    ans = []
    for i in range(1, len(a_list), 2):
        ans.append(a_list[i])
    ans = ans[::-1]
    for i in range(0, len(a_list), 2):
        ans.append(a_list[i])
 
    if n % 2 != 0:
        ans = ans[::-1]
    print(*ans)
 
 
if __name__ == '__main__':
    main()