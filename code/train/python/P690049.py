from Queue import * # Queue, LifoQueue, PriorityQueue
from bisect import * #bisect, insort
from collections import * #deque, Counter,OrderedDict,defaultdict
#set([]) 
import math
import copy
import itertools
import string
import sys
myread = lambda : map(int,raw_input().split())
edge = []
memo = []
MOD = 10**9 + 7
def dp_go(now, c, p):
    global memo
    if memo[now][c] >= 0:
        return memo[now][c]
    ret = 1
    ncs = [False]
    if not(c):
        ncs.append(True)
    for x in edge[now]:
        if x != p:
            cur = 0
            for nc in ncs:
                cur += dp_go(x, nc, now)
            ret *= cur
    memo[now][c] = ret
    return ret

def solver():
    global edge, memo
    N = int(raw_input())
    edge = [[] for _ in xrange(N)]
    memo = [[-1,-1] for _ in xrange(N)]
    for _ in xrange(N-1):
        a,b = myread()
        a -= 1
        b -= 1
        edge[a].append(b)
        edge[b].append(a)
    print (dp_go(0,False,-1) + dp_go(0,True,-1)) % MOD

if __name__ == "__main__":
    solver()
    
