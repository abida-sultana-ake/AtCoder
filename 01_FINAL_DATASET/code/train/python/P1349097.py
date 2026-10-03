N = input()
nums = [int(x) for x in input()]

accum = [0,0,0,0]
for num in nums:
	accum[num-1] += 1

print(max(accum),min(accum))