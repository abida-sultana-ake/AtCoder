import heapq
from math import ceil

n = int(input())
arr = list(map(int,input().split()))
arr = [-x for x in arr]
heapq.heapify(arr)
limit = -n+1

act = 0
while arr[0] < limit:
    x = arr[0]
    req = ceil((limit-x)/n)
    x+= req*(n+1)
    limit+= req
    act+= req
    heapq.heapreplace(arr, x)
print(act)