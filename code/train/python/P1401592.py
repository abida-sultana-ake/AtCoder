numbers=[int(x) for x in input().split()]
N,H=numbers[0],numbers[1]
 
nums=[int(x) for x in input().split()]
A,B,C,D,E=nums[0],nums[1],nums[2],nums[3],nums[4]
 
costs=[]
for x in range(N):
	minY = max(0,(((N-x)*E - H - B*x) // (D+E)) + 1)
	costs.append(A*x + C*minY)
print(min(costs))