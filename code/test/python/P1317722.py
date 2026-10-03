N = int(input())
array = [int(n) for n in input().split()]
import copy
import heapq
lst = [None for i in range(N + 1)]
left_lst = copy.deepcopy(lst)
right_lst = copy.deepcopy(lst)
left_array = array[:N]
right_array= [-n for n in array[-N:]]
l_sum = sum(left_array)
r_sum = sum(right_array)
heapq.heapify(left_array)
heapq.heapify(right_array)
left_lst[0] = l_sum
right_lst[0] = r_sum

for k in range(N, 2 * N):
    new_a, new_b = array[k], array[-k - 1]*-1
    heapq.heappush(left_array,new_a)
    heapq.heappush(right_array,new_b)
    old_a = heapq.heappop(left_array)
    l_sum += (new_a - old_a)
    left_lst[k - N + 1] = l_sum
    old_b = heapq.heappop(right_array)
    r_sum += (new_b - old_b)
    right_lst[k - N + 1] = r_sum
lst = [ a + b for a, b in zip(left_lst, list(reversed(right_lst)))]
print(max(lst))