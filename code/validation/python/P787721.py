import heapq
n = int(input())
a = list(map(int, input().split()))
h = [(-a[i],i+1) for i in range(len(a))]
heapq.heapify(h)
while h:
    print(heapq.heappop(h)[1])