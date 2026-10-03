N, K = list(map(int, input().split()))
l_list = list(map(int, input().split()))

l_list.sort(reverse=True)
print(sum(l_list[:K]))

