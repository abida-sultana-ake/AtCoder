nums = [int(x) for x in input().split()]
N,D,K = nums[0],nums[1],nums[2]
line = []
for i in range(D):
	nums = [int(x) for x in input().split()]
	line.append(tuple(nums))

for i in range(K):
	nums = [int(x) for x in input().split()]
	S,T = nums[0],nums[1]
	ans = 1

	for elem in line:
		if not (elem[0] <= S <= elem[1]): ans += 1; continue  # 動けない

		if S < T: # 目的地が前方方向

			if S <= T <= elem[1]: break
			else:
				S = elem[1]; ans += 1

		else:  # 目的地は逆方向
			if elem[0] <= T <= S: break
			else:
				S = elem[0]; ans += 1

	print(ans)