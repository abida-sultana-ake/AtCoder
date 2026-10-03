n = int(input())
t_list = list(map(int, input().split()))
t_sum = sum(t_list)
m = int(input())
px_list = []
for i in range(m):
	px_list.append(list(map(int, input().split())))
for j in range(m):
	print(t_sum - t_list[px_list[j][0]-1] + px_list[j][1])