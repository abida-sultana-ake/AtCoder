
nums = [int(x) for x in input().split()]

diff = abs(nums[0]-nums[1])
cnt = 0
R = [0,1,2,3,2,1,2,3,3,2]

cnt += (diff - diff % 10) / 10
diff = diff % 10
cnt += R[diff]

print(int(cnt))